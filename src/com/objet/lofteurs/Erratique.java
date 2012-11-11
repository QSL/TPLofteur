/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

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
		if (!this.estExpulse) {
			g.setColor(Color.BLACK);
			Image image_erratique = this.position.getLoftCorrespondant().getGzone().getToolkit().getImage("files/erratique.png");
			g.drawImage(image_erratique, this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y, null);
			if (this.aGagne)
			{
				g.drawString("Gagné !", this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y);
			}
		}
	}
	public void cycleDeVie() {
		//System.out.print("Erratique Cycle \n");
        if (!this.estExpulse){
    		this.setValeurEnergie(this.valeurEnergie - 2);
            Case deplacement = this.chercheCaseAleatoire();
            this.seDeplacer(deplacement);
            System.out.print("Le Neuneu se deplace sur la case " + deplacement.getAbscisse() + " ; " + deplacement.getOrdonnee() + "\n");
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		this.manger(this.getPosition().getNourriture().get(i));
                        System.out.print("Le Neuneu mange la nourriture sur la case \n");
            	}
            }
            if (this.getPosition().getNeuneu().size() > 1)
            {
            	//let's have sex !
            	for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		if (this.getPosition().getNeuneu().get(i) != (this))
            		{
            			this.seReproduire(this.getPosition().getNeuneu().get(i));
                        System.out.print("Le Neuneu fait de la sexualite avec l'autre neuneu sur la case \n");
            		}
            		else System.out.print("C'est le même neuneu, il ne fait rien avec lui-même.");
            	}
            }
        }  	
    }
}
