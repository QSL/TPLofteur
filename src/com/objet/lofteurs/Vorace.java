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
public class Vorace extends Neuneu {
	public Vorace(Loft loft, int i, int j, int k) {
    	this.position = loft.getListCases()[i][j];
    	this.estExpulse = false;
    	this.valeurEnergie = 10;
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		if (this.aGagne)
		{
			g.drawString("Gagné !", this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y);
		}
	}
	public void cycleDeVie() {
		this.setValeurEnergie(this.valeurEnergie - 2);
		//System.out.print("Cycle de Vie Vorace !\n");
        if (!this.estExpulse){
        	//System.out.print("Bouffe proche : " + this.chercheNourritureProche().getAbscisse() + " ; " + this.chercheNourritureProche().getOrdonnee());
        	Case deplacement = this.chercheNourritureProche();
                this.chercheMouvementCase(deplacement);
        	//System.out.print("\nNouveau mouvement : " + this.chercheMouvementCase(this.chercheNourritureProche()).getAbscisse() + " ; " + this.chercheMouvementCase(this.chercheNourritureProche()).getOrdonnee());
            this.seDeplacer(this.chercheMouvementCase(deplacement));
            System.out.print("Le Neuneu se deplace sur la case " + this.chercheMouvementCase(deplacement).getAbscisse() + " ; " + this.chercheMouvementCase(deplacement).getOrdonnee() + "\n");
            if (this.getPosition().getNourriture().size() > 0)
            {
            	//let's eat what's on it !
            	//System.out.print("Food find : " + this.getPosition().getNourriture() + ", " + this.getPosition().getNourriture().size());
            	for (int i = 0; i < this.getPosition().getNourriture().size(); i++)
            	{
            		System.out.print("Le Neuneu mange la nourriture sur la case \n");
            		this.manger(this.getPosition().getNourriture().get(i));
            	}
            }
            /*if (this.getPosition().getNeuneu().size() > 0)
            {
            	//let's have sex !
            	for (int i = 0; i < this.getPosition().getNeuneu().size(); i++)
            	{
            		this.seReproduire(this.getPosition().getNeuneu().get(i));
            	}
            }*/
        }     	
    }
}
