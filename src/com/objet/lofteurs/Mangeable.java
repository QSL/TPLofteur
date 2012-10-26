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
    
    public int distance(Neuneu n){
        int a=(this.position.abscisse-n.position.abscisse)+(this.position.ordonnee-n.position.ordonnee);
        int b;
        if (a<0){
            b=-a;
            }
        else {b=a;}
        return b;
    }
    
}
