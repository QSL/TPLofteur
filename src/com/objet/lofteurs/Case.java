/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.util.*;

/*
 *
 * @author QSL
 */
public class Case {
    protected int abscisse;
    protected int ordonnee;
    
    public List<Neuneu> getNeuneu(){
        List<Neuneu> listeDeNeuneuSurLaCase = new ArrayList<>();
        for(int i=0; i<Loft.population.length; i++)
        {
            if Loft.population[i].position=this
                    { 
                        listeDeNeuneuSurLaCase.add(Loft.population[i]);
                    }
        }
        return listeDeNeuneuSurLaCase;
        
    }
    
    public Nourriture getNourriture(){
        return null;
        
    }
    
    public void addNeuneu(Neuneu n){
        n.setPosition(this);
    }
    
    public void removeNeuneu(Neuneu n){
        
    }
    
    public void addNourriture(Nourriture alimentation){
        alimentation.setPosition(this);
    }
    
    public void removeNourriture(Nourriture alimentation){
        
    }
}
