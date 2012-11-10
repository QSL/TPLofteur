/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author QSL
 */
public class Erratique extends Neuneu {
    public Erratique(Loft loft, int i, int j) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 100;
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
	}
	public void cycleDeVie() {
        if (!this.estExpulse){
            this.seDeplacer(this.chercheCaseAleatoire());
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            if (this.getPosition().getNeuneu().size() > 0)
            {
            	//let's have sex !
            	for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		this.seReproduire(this.getPosition().getNeuneu().get(i));
            	}
            }
        }  	
    }
}
