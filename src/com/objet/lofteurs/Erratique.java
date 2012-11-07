/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public class Erratique extends Neuneu {
    public Erratique(Loft loft, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void cycleDeVie() {
        
        if (!this.estExpulse){
            this.seDeplacer(chercheCaseAleatoire());            
        }
    	
    }
}
