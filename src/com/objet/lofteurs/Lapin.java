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
	private float appetit_sexuel = 1;
    public Lapin(Loft loft, int i, int j, float k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 50;
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		if (this.aGagne)
		{
			g.drawString("Gagné !", this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y);
		}
	}
	public void cycleDeVie() {
		//System.out.print("Cycle de vie Lapin \n");
        if (!this.estExpulse){
    		this.setValeurEnergie(this.valeurEnergie - 2);
        	if (Math.random() <= this.appetit_sexuel) {
        		//System.out.print("Appetit : "+ this.appetit_sexuel);
        		System.out.print("Dï¿½placement SEXUEL !!" + Math.random());
                        Case deplacement = this.chercheMouvementCase(this.chercheNeuneuProche());
        		this.seDeplacer(deplacement);
                        System.out.print("Le Neuneu se deplace sur la case " + deplacement.getAbscisse() + " ; " + deplacement.getOrdonnee() + "\n");

        	} 
        	else
                {
                    Case deplacement = chercheCaseAleatoire();
                    this.seDeplacer(deplacement);
                    System.out.print("Le Neuneu se deplace sur la case " + deplacement.getAbscisse() + " ; " + deplacement.getOrdonnee() + "\n");
                }
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		System.out.print("Le neuneu mange la nourriture sur la case");
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            if (this.getPosition().getNeuneu().size() > 1)
            {
            	//let's have sex !
            	for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		if (this.getPosition().getNeuneu().get(i) != this)
            		{	
	            		System.out.print("Le Neuneu fait de la sexualite avec l'autre neuneu sur la case");
	            		this.seReproduire(this.getPosition().getNeuneu().get(i));
            		}
            	}
            }
        }   	
    }
}
