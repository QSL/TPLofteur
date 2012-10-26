/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public class Neuneu extends Mangeable {
    protected boolean estExpulse;
    protected Nourriture[] nourriturePreferee;
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
        
	public void manger(Mangeable n) {
            this.valeurEnergie=this.valeurEnergie+n.valeurEnergie;
            n.position.removeNourriture(n);		
	}
        
	
        
	public Case chercheNourritureProche(){
            //index de la recherche
            int i;
            
            //on initialise la recherche
            Mangeable nourritureProche=this.position.loftCorrespondant.alimentation[0];
            
            //on lance la recherche
            for (i=0; i<this.position.loftCorrespondant.alimentation.size; i++){
                if(this.position.loftCorrespondant.alimentation[i].distance(this)<nourritureProche.distance(this)){
                    nourritureProche=this.position.loftCorrespondant.alimentation[i];                                        
                }
            }
            return nourritureProche.position;    
        }
        
	public Case chercheNeuneuProche() {
            int i;
            Mangeable neuneuProche=this.position.loftCorrespondant.population[0];
            
            for (i=0; i<this.position.loftCorrespondant.population.size; i++){
                if(this.position.loftCorrespondant.population[i].distance(this)<neuneuProche.distance(this)){
                    neuneuProche=this.position.loftCorrespondant.population[i];
                }
            }
            return neuneuProche.position;
        }
        
}
