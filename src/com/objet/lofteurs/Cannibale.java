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
public class Cannibale extends Neuneu {
    protected static final float appetit = 1f;
    protected static final float reproduction = 1f;
    
     
    public Cannibale(Loft loft, int i, int j, int k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 100;  	
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.PINK);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
	}

	public void cycleDeVie() {    
		int distance_neuneu;
		int distance_nourriture;
		Case nouvelleCase;
        if (!this.estExpulse){
        	distance_neuneu = (int) Math.round(Math.sqrt(this.chercheNeuneuProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	distance_nourriture = (int) Math.round(Math.sqrt(this.chercheNourritureProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	if (distance_neuneu <= distance_nourriture) nouvelleCase = this.chercheNeuneuProche();
        	else nouvelleCase = this.chercheNourritureProche();
        			
        	this.seDeplacer(this.chercheMouvementCase(nouvelleCase));
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
            		this.manger(this.getPosition().getNeuneu().get(i));
            	}
            }
        }  
    }
}
