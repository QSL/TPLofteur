/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Graphics;

/**
 *
 * @author QSL
 */
public class Pizza extends Nourriture{
	public Pizza(Case m_case, int valeur_energie) {
		this.position = m_case;
		this.valeurEnergie = valeur_energie;
	}
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
