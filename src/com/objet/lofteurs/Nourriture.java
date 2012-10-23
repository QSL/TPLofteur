/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
public abstract class Nourriture extends Mangeable {
    protected Case position;
    
    /**
     *Getter de la position de la Nourriture
     */
    public Case getPosition(){
        return this.position;        
    }
    
    /**
     *Setter de la position de la Nourriture
     */
    public void setPosition(Case newCase){
        this.position=newCase;
    }
    
}
