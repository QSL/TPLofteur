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
    protected Case position;
    protected boolean estExpulse;
    protected Nourriture[] nourriturePreferee;
    protected Loft loft;
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
	public Loft getLoft() {
		return loft;
	}
	public void setLoft(Loft loft) {
		this.loft = loft;
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
        
    @SuppressWarnings("empty-statement")
	public Case chercheCaseAleatoire() {
            // génération d'un nombre aléatoire pour choisir la case
            int aleatoire = (int) (Math.random() * (7));
            Case nouvelleCasePossible;           
            
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
                    
                                
                        // si la case existe on sort cette case
                        if this.loft.contains(nouvelleCasePossible){
                            return nouvelleCasePossible;
                        }
                        // sinon on relance la méthode
                        else { this.chercheCaseAleatoire();}
                        
                        
            
            }
	}
	public Neuneu seReproduire(Neuneu Accouplement) {
		Neuneu Neuneu_bebe = new Neuneu();;
		return Neuneu_bebe;
	}
	public void manger() {
		
	}
	public void expulse() {
		
	}
	public void chercheNourritureProche() {
		
	}
	public void chercheNeuneuProche() {
		
	}
	
}
