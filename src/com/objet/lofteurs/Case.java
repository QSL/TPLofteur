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
    
    // méthode permettant de retourner la liste des neuneus qui sont sur la case
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
    
    // permet de retourner la nourriture sur la case
    // non implémentée car possiblement non utile
    public Nourriture getNourriture(){
        return null;
        
    }
    
    // ajouter un neuneu sur la case
    public void addNeuneu(Neuneu n){
        n.setPosition(this);
    }
    
    // enlever un neuneu de la case
    // non implémentée car possiblement non utile
    public void removeNeuneu(Neuneu n){
        
    }
    
    // ajouter de la nourriture sur la case
    public void addNourriture(Nourriture alimentation){
        alimentation.setPosition(this);
    }
    
    // enlever de la nourriture de la case
    // non implémentée car possiblement non utile
    public void removeNourriture(Nourriture alimentation){
        
    }
}
