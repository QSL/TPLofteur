/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public class Lapin extends Neuneu {
    public Lapin(Loft loft, int i, int j, int k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 100;
	}

	public void cycleDeVie() {
        if (!this.estExpulse){
            this.seDeplacer(this.chercheMouvementCase(this.chercheNeuneuProche()));
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	for (int i = 0; i <= this.getPosition().getNourriture().size(); i++)
            	{
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            if (this.getPosition().getNeuneu().size() > 0)
            {
            	//let's have sex !
            	for (int i = 0; i <= this.getPosition().getNeuneu().size(); i++)
            	{
            		this.seReproduire(this.getPosition().getNeuneu().get(i));
            	}
            }
        }   	
    }
}
