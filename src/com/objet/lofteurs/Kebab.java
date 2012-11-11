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
public class Kebab extends Nourriture {
	public Kebab(Case m_case, int valeur_energie) {
		System.out.print("Kebab gen " + m_case.getAbscisse() + " ; " + m_case.getOrdonnee());
		
		this.position = m_case;
		this.valeurEnergie = valeur_energie;
	}
	public void dessinerObjet(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
		g.fillRect(this.getPosition().getAbscisse() * UNITE_X, this.getPosition().getOrdonnee() * UNITE_Y, UNITE_X, UNITE_Y);
	}
}
