/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public abstract class Mangeable implements ObjetDessinable {
    protected int valeurEnergie;
    protected Case position;
    
    public void setValeurEnergie(int valeurenergie2) {
        this.valeurEnergie=valeurenergie2;
    }
    public int getValeurEnergie() {
    	return this.valeurEnergie;
    }
    public void setPosition(Case new_position)
    {
    	this.position = new_position;
    }
    public Case getPosition()
    {
    	return this.position;
    }
    public int distance(Mangeable n){
        int a= (int) Math.round(Math.sqrt(((this.position.getAbscisse()-n.position.getAbscisse())^2)+(this.position.getOrdonnee()-n.position.getOrdonnee())^2));
        return a;
    }
    
}
