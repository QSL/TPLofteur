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
    public double distance(Mangeable n){
    	double t1 = Math.pow(this.position.getAbscisse()-n.position.getAbscisse(), 2);
        double t2 = Math.pow(this.position.getOrdonnee()-n.position.getOrdonnee(), 2);
        double a= (double) (Math.sqrt(t1+t2));
        return a;
    }
    
}
