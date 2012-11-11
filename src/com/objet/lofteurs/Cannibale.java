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
public class Cannibale extends Neuneu {
    protected static final float appetit = 1f;
    protected static final float reproduction = 1f;
    
     
    public Cannibale(Loft loft, int i, int j, int k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 50;  	
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.RED);
		Image image_cannibale = this.position.getLoftCorrespondant().getGzone().getToolkit().getImage("files/cannibale.png");
		g.drawImage(image_cannibale, this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y, null);
		if (this.aGagne)
		{
			g.drawString("Gagné !", this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y);
		}
	}

	public void cycleDeVie() {
		//System.out.print("Cannibale Cycle \n");
		int distance_neuneu;
		int distance_nourriture;
		Case nouvelleCase;
        if (!this.estExpulse){
    		this.setValeurEnergie(this.valeurEnergie - 2);
        	//System.out.print("Distaaance !! " + Math.round(Math.sqrt(this.chercheNeuneuProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2)));
        	distance_neuneu = (int) Math.round(Math.sqrt(this.chercheNeuneuProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	System.out.print("\nDistance neuneu : " + distance_neuneu);
        	distance_nourriture = (int) Math.round(Math.sqrt(this.chercheNourritureProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	System.out.print("\nDistance nourriture " + distance_nourriture);
        	if (distance_neuneu <= distance_nourriture) nouvelleCase = this.chercheNeuneuProche();
        	else nouvelleCase = this.chercheNourritureProche();
        	//System.out.print("Nouvelle case : " + nouvelleCase.getAbscisse() + " ; " + nouvelleCase.getOrdonnee());
        	this.seDeplacer(this.chercheMouvementCase(nouvelleCase));
                System.out.print("Le Neuneu se deplace sur la case " + nouvelleCase.getAbscisse() + " ; " + nouvelleCase.getOrdonnee() + "\n");
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	//System.out.print("Nourriture !!");
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		System.out.print("Le Neuneu mange la nourriture sur la case \n");
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            //System.out.print("Neuneu sur la case !!\n");
            if (this.getPosition().getNeuneu().size() > 1)
            {
            	//let's eat the other neuneu
            	if (this == this.getPosition().getNeuneu().get(1)){
                    this.manger(this.getPosition().getNeuneu().get(2));
                    System.out.print("Le Neuneu mange la nourriture sur la case \n");
                }
                
                else
                {
                    this.manger(this.getPosition().getNeuneu().get(1));
                    System.out.print("Le Neuneu mange un autre Neuneu !!! sur la case \n");
                    this.getPosition().getLoftCorrespondant().expulse(this.getPosition().getNeuneu().get(1));
                }
            }
        }  
            }
}
