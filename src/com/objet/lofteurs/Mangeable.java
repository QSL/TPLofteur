/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public abstract class Mangeable {
    protected int valeurenergie;
    public void setValeurEnergie(int valeurenergie2) {
        this.valeurenergie=valeurenergie2;
    	
    }
    public int getValeurEnergie() {
    	return this.valeurenergie;
    }
}
