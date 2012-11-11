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
	protected static final int coutEnergieSexe = 40;
	protected boolean aGagne;
    protected boolean estExpulse;
    protected Nourriture[] nourriturePreferee;
    public void cycleDeVie() {
    	
    }
	public boolean getEstExpulse() {
		return estExpulse;
	}
	public void setEstExpulse(boolean estexpulse) {
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
            Case nouvelleCasePossible = new Case(-50, -50, this.position.getLoftCorrespondant());  
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
        while (nouvelleCasePossible.getAbscisse()<0 || nouvelleCasePossible.getAbscisse()> nouvelleCasePossible.getLoftCorrespondant().hauteur || nouvelleCasePossible.getOrdonnee() < 0 || nouvelleCasePossible.getOrdonnee()>nouvelleCasePossible.getLoftCorrespondant().largeur ){
            nouvelleCasePossible = this.chercheCaseAleatoire();
        }                                
        return nouvelleCasePossible;
	}
    
	public Neuneu seReproduire(Neuneu Accouplement) {
		this.valeurEnergie -= this.coutEnergieSexe;
		Vorace Neuneu_bebe = new Vorace(this.position.getLoftCorrespondant(),
				(int)(this.position.getAbscisse() + 1),
				(int)(this.position.getOrdonnee() + 1),
				3);
		this.position.getLoftCorrespondant().addNeuneu(Neuneu_bebe);
		return Neuneu_bebe;
	}
	public void manger(Mangeable n) {
		int nindex = 0;
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
                else {}
            }
            return nourritureProche.position;    
        }
        
	public Case chercheNeuneuProche() {
            int i = 0;
            //System.out.print("cherche Neuneu proche \n");
            Neuneu NeuneuProche = null;
            
            if (this.position.getLoftCorrespondant().getPopulation().get(0) == this)
            {
                NeuneuProche = this.position.getLoftCorrespondant().getPopulation().get(1);
            }
            else
            {
                NeuneuProche = this.position.getLoftCorrespondant().getPopulation().get(0);
            }
            
            for(i=0; i<this.position.getLoftCorrespondant().getPopulation().size(); i++){
                if (this.position.getLoftCorrespondant().getPopulation().get(i) == this) {}
                else
                {
                    if (this.distance(this.position.getLoftCorrespondant().getPopulation().get(i)) < this.distance(NeuneuProche))
                    {
                        NeuneuProche = this.position.getLoftCorrespondant().getPopulation().get(i);                        
                    }
                }
                
            
            }
            
            return NeuneuProche.getPosition();
        }  
            
	public Case chercheMouvementCase(Case CaseObjectif) {
		Case nouvelleCase = new Case(0, 0, null);
		int deplacement_X, deplacement_Y;
                int deplacement_effectif_X = 0, deplacement_effectif_Y = 0;
		deplacement_X = CaseObjectif.getAbscisse() - this.position.getAbscisse();
        deplacement_Y = CaseObjectif.getOrdonnee() - this.position.getOrdonnee();
        if (deplacement_X > 0) deplacement_effectif_X = 1;
        else if (deplacement_X < 0) deplacement_effectif_X = -1;
        else if (deplacement_X == 0) deplacement_effectif_X = 0;
        if (deplacement_Y > 0) deplacement_effectif_Y = 1;
        else if (deplacement_Y < 0) deplacement_effectif_Y = -1;
        else if (deplacement_Y == 0) deplacement_effectif_Y = 0;
        nouvelleCase.setAbscisse(this.position.getAbscisse() + deplacement_effectif_X);
        nouvelleCase.setOrdonnee(this.position.getOrdonnee() + deplacement_effectif_Y);
		return nouvelleCase;
	}
	@Override
	public void dessinerObjet(Graphics g) {
	}
	public boolean isaGagne() {
		return aGagne;
	}
	public void setaGagne(boolean aGagne) {
		this.aGagne = aGagne;
	}
	public Nourriture[] getNourriturePreferee() {
		return nourriturePreferee;
	}
	public void setNourriturePreferee(Nourriture[] nourriturePreferee) {
		this.nourriturePreferee = nourriturePreferee;
	}
        
}
