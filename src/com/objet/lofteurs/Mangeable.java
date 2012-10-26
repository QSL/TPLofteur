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
    protected int valeurEnergie;
    protected Case position;
    
    public void setValeurEnergie(int valeurenergie2) {
        this.valeurEnergie=valeurenergie2;
    	
    }
    public int getValeurEnergie() {
    	return this.valeurEnergie;
    }
    
}
