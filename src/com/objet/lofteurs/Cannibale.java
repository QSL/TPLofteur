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
		g.setColor(Color.RED);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
	}

	public void cycleDeVie() {
		System.out.print("Cannibale Cycle \n");
		int distance_neuneu;
		int distance_nourriture;
		Case nouvelleCase;
        if (!this.estExpulse){
        	System.out.print("Distaaance !! " + Math.round(Math.sqrt(this.chercheNeuneuProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2)));
        	distance_neuneu = (int) Math.round(Math.sqrt(this.chercheNeuneuProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	System.out.print("\nDistance neuneu : " + distance_neuneu);
        	distance_nourriture = (int) Math.round(Math.sqrt(this.chercheNourritureProche().abscisse^2 + this.chercheNeuneuProche().ordonnee^2));
        	System.out.print("\nDistance nourriture " + distance_nourriture);
        	if (distance_neuneu <= distance_nourriture) nouvelleCase = this.chercheNeuneuProche();
        	else nouvelleCase = this.chercheNourritureProche();
        	System.out.print("Nouvelle case : " + nouvelleCase.getAbscisse() + " ; " + nouvelleCase.getOrdonnee());
        	this.seDeplacer(this.chercheMouvementCase(nouvelleCase));
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	System.out.print("Nourriture !!");
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		System.out.print("Cannibale MANGER !! \n");
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            System.out.print("Neuneu sur la case !!\n");
            if (this.getPosition().getNeuneu().size() > 1)
            {
            	//let's eat the other neuneu
            	if (this == this.getPosition().getNeuneu().get(1)){
                    this.manger(this.getPosition().getNeuneu().get(2));
                }
                
                else
                {
                    this.manger(this.getPosition().getNeuneu().get(1));
                    this.getPosition().getLoftCorrespondant().expulse(this.getPosition().getNeuneu().get(1));
                }
                
                /*for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		System.out.print("Manger neuneu !!\n");
            		this.manger(this.getPosition().getNeuneu().get(i));
            	}*/
            }
        }  
    }
}
