/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Graphics;
import java.util.*;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 *
 * @author QSL
 */
public class Neuneu extends Mangeable {
	protected static final int coutEnergieSexe = 50;
    protected boolean estExpulse;
    protected Nourriture[] nourriturePreferee;
    public void cycleDeVie() {
    	
    }
	public boolean getEstExpulse() {
		return estExpulse;
	}
	public void setEstexpulse(boolean estexpulse) {
		this.estExpulse = estexpulse;
	}
	public Nourriture[] getNourriturepreferee() {
		return nourriturePreferee;
	}
	public void setNourriturepreferee(Nourriture[] nourriturepreferee) {
		this.nourriturePreferee = nourriturepreferee;
	}
	
	public void setPosition(Case position) {
		this.position = position;
	}
	public Case getPosition() {
		return this.position;
	}
        
        public void seDeplacer(Case nouvelleCase){
            this.position.setAbscisse(nouvelleCase.abscisse);
            this.position.setOrdonnee(nouvelleCase.ordonnee);
        }
        
   
	public Case chercheCaseAleatoire() {
            // génération d'un nombre aléatoire pour choisir la case
            int aleatoire = (int) (Math.random() * (7));
            Case nouvelleCasePossible = new Case(0, 0, this.position.getLoftCorrespondant());  
            switch (aleatoire){
                
            
                    case 0:                         
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()-1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()-1);                        
                        break;
                        
                    case 1:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse());
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()-1);                        
                        break;
                        
                    case 2:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()+1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()-1);                        
                        break;
                        
                    case 3:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()+1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee());                        
                        break;
                        
                    case 4:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()+1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()+1);                        
                        break;
                        
                    case 5:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse());
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()+1);                        
                        break;
                        
                    case 6:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()-1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee()+1);                        
                        break;
                        
                    case 7:
                        nouvelleCasePossible.setAbscisse(this.position.getAbscisse()-1);
                        nouvelleCasePossible.setOrdonnee(this.position.getOrdonnee());                        
                        break;     
            }                  
                                
        // si la case n'existe pas on relance la méthode
        /*if(!this.position.loftCorrespondant.contient(nouvelleCasePossible)){
            this.chercheCaseAleatoire();
        }*/
                                          
        return nouvelleCasePossible;
	}
    
	public Neuneu seReproduire(Neuneu Accouplement) {
		if (this.valeurEnergie > this.coutEnergieSexe) {
			this.valeurEnergie -= this.coutEnergieSexe;
			Neuneu Neuneu_bebe = new Neuneu();
			return Neuneu_bebe;
		}
		else return null;
	}
	public void manger(Mangeable n) {
		int nindex = 0;
		System.out.print("MANGEEER !");
        this.valeurEnergie=this.valeurEnergie+n.valeurEnergie;
        n.setValeurEnergie(0);	
        this.getPosition().getLoftCorrespondant().getListCases()[n.position.getAbscisse()][n.position.getOrdonnee()].removeMangeable(n);
	}
        
	
        
	public Case chercheNourritureProche(){
            //index de la recherche
            int i;
            //on initialise la recherche

            Mangeable nourritureProche = this.position.getLoftCorrespondant().getAlimentation().get(0);
            //on lance la recherche
            for (i=0; i < this.position.getLoftCorrespondant().getAlimentation().size() ; i++){
                if(this.position.getLoftCorrespondant().getAlimentation().get(i).distance(this) < nourritureProche.distance(this)){
                	nourritureProche = this.position.getLoftCorrespondant().getAlimentation().get(i);                                        
                }
            }
            return nourritureProche.position;    
        }
        
	public Case chercheNeuneuProche() {
            int i = 0;
            Mangeable neuneuProche=this.position.loftCorrespondant.population.get(i);
            System.out.print(this.position.getLoftCorrespondant().getPopulation().size());
            for (i=0; i< 3; i++){
                if(this.position.loftCorrespondant.population.get(i).distance(this)<neuneuProche.distance(this)){
                    neuneuProche=this.position.loftCorrespondant.population.get(i);
                }
            }
            return neuneuProche.position;             
        }
	public Case chercheMouvementCase(Case CaseObjectif) {
		Case nouvelleCase = new Case(0, 0, null);
		int deplacement_X, deplacement_Y;
		deplacement_X = CaseObjectif.getAbscisse() - this.position.getAbscisse();
        deplacement_Y = CaseObjectif.getOrdonnee() - this.position.getOrdonnee();
        if (deplacement_X > 0) deplacement_X = 1;
        else if (deplacement_X < 0) deplacement_X = -1;
        if (deplacement_Y > 0) deplacement_Y = 1;
        else if (deplacement_Y < 0) deplacement_Y = -1;
        nouvelleCase.setAbscisse(this.position.getAbscisse() + deplacement_X);
        nouvelleCase.setOrdonnee(this.position.getOrdonnee() + deplacement_Y);
		return nouvelleCase;
	}
	@Override
	public void dessinerObjet(Graphics g) {
	}
        
}
