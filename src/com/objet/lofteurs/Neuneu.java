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
    protected boolean estexpulse;
    protected Nourriture[] nourriturepreferee;
    protected Loft loft;
	public boolean isEstexpulse() {
		return estexpulse;
	}
	public void setEstexpulse(boolean estexpulse) {
		this.estexpulse = estexpulse;
	}
	public Nourriture[] getNourriturepreferee() {
		return nourriturepreferee;
	}
	public void setNourriturepreferee(Nourriture[] nourriturepreferee) {
		this.nourriturepreferee = nourriturepreferee;
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
	public void sedeplacer(Case NouvelleCase) {
		
	}
	public Neuneu sereproduire(Neuneu Accouplement) {
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
	public void chercheCaseAleatoire() {
		
	}
}
