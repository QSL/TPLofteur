/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.*;

/**
 *
 * @author QSL
 */
public class Neuneu extends Mangeable {
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
            Case nouvelleCasePossible = null;           
            
            switch (aleatoire){
                
            
                    case 0:                         
                        nouvelleCasePossible.setAbscisse(this.position.abscisse-1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee-1);                        
                        break;
                        
                    case 1:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee-1);                        
                        break;
                        
                    case 2:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse+1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee-1);                        
                        break;
                        
                    case 3:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse+1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee);                        
                        break;
                        
                    case 4:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse+1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee+1);                        
                        break;
                        
                    case 5:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee+1);                        
                        break;
                        
                    case 6:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse-1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee+1);                        
                        break;
                        
                    case 7:
                        nouvelleCasePossible.setAbscisse(this.position.abscisse-1);
                        nouvelleCasePossible.setOrdonnee(this.position.ordonnee);                        
                        break;     
            }                  
                                
        // si la case n'existe pas on relance la méthode
        if(!this.position.loftCorrespondant.contient(nouvelleCasePossible)){
            this.chercheCaseAleatoire();
        }
                                          
        return nouvelleCasePossible;
	}
    
	public Neuneu seReproduire(Neuneu Accouplement) {
		Neuneu Neuneu_bebe = new Neuneu();;
		return Neuneu_bebe;
	}
    public void expulse() {
    	this.estExpulse = true;
    	this.valeurEnergie = 0;
    	
    }
	public void manger(Mangeable n) {
            this.valeurEnergie=this.valeurEnergie+n.valeurEnergie;
            n.setValeurEnergie(0);	
	}
        
	
        
	public Case chercheNourritureProche(){
            //index de la recherche
            int i;
            //on initialise la recherche
            System.out.print(this.position.getAbscisse());
            System.out.print("test 1");            
            System.out.print("salut !");
            System.out.print(this.position.getLoftCorrespondant());
            System.out.print("test 2");
            System.out.print(this.position.getLoftCorrespondant().getAlimentation().size());

            Mangeable nourritureProche = this.position.getLoftCorrespondant().getAlimentation().get(0);
            //on lance la recherche
            System.out.print("salut !");
            System.out.print(this.position.getLoftCorrespondant().getAlimentation().size());
            for (i=0; i < 3; i++){
                if(this.position.getLoftCorrespondant().getAlimentation().get(i).distance(this) < nourritureProche.distance(this)){
                    nourritureProche=this.position.getLoftCorrespondant().getAlimentation().get(i);                                        
                }
            }
            return nourritureProche.position;    
        }
        
	public Case chercheNeuneuProche() {
            int i = 0;
            Mangeable neuneuProche=this.position.loftCorrespondant.population.get(i);
            System.out.print("Cherche neuneu !");
            System.out.print(this.position.getLoftCorrespondant().getPopulation().size());
            for (i=0; i< 3; i++){
                if(this.position.loftCorrespondant.population.get(i).distance(this)<neuneuProche.distance(this)){
                    neuneuProche=this.position.loftCorrespondant.population.get(i);
                }
            }
            return neuneuProche.position;             
        }
	public Case chercheMouvementCase(Case CaseObjectif) {
		Case nouvelleCase = CaseObjectif;
		int deplacement_X, deplacement_Y;
		deplacement_X = CaseObjectif.abscisse - this.position.abscisse;
        deplacement_Y = CaseObjectif.ordonnee - this.position.ordonnee;
        if (deplacement_X > 0) deplacement_X = 1;
        else if (deplacement_X < 0) deplacement_X = -1;
        if (deplacement_Y > 0) deplacement_Y = 1;
        else if (deplacement_Y < 0) deplacement_Y = -1;
        nouvelleCase.setAbscisse(this.position.abscisse + deplacement_X);
        nouvelleCase.setOrdonnee(this.position.ordonnee + deplacement_Y);
		return nouvelleCase;
	}
	@Override
	public void dessinerObjet(Graphics g) {
	}
        
}
