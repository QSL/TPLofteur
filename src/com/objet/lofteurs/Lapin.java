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
public class Lapin extends Neuneu {
	private float appetit_sexuel = 0.3f;
    public Lapin(Loft loft, int i, int j, float k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 100;
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
	}
	public void cycleDeVie() {
		System.out.print("Cycle de vie Lapin \n");
        if (!this.estExpulse){
        	if (Math.random() <= this.appetit_sexuel) {
        		System.out.print("Appetit : "+ this.appetit_sexuel);
        		System.out.print("Déplacement SEXUEL !!" + Math.random());
        		this.seDeplacer(this.chercheMouvementCase(this.chercheNeuneuProche()));
        	} 
        	else this.seDeplacer(this.chercheCaseAleatoire());
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		System.out.print("Nourriture !! " + i);
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            if (this.getPosition().getNeuneu().size() > 0)
            {
            	//let's have sex !
            	for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		System.out.print("SEEXX" + i);
            		this.seReproduire(this.getPosition().getNeuneu().get(i));
            	}
            }
        }   	
    }
}
