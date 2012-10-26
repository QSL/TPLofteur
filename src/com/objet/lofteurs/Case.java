/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/*
 *
 * @author QSL
 */
public class Case {
    protected int abscisse;
    protected int ordonnee;
    protected Loft loftCorrespondant;
    
    // méthode permettant de retourner la liste des neuneus qui sont sur la case
    public Neuneu[] getNeuneu(){
        Neuneu[] listeDeNeuneuSurLaCase = new Neuneu[];
        for(int i=0; i<this.loftCorrespondant.population.length; i++)
        {
            if this.loftCorrespondant.population[i].position=this
                    { 
                        listeDeNeuneuSurLaCase.add(this.loftCorrespondant.population[i]);
                    }
        }
        return listeDeNeuneuSurLaCase;
        
    }
    
    // permet de retourner la nourriture sur la case
    // non implémentée car possiblement non utile
    public Nourriture[] getNourriture(){
        Nourriture[] nourritureSurLaCase = new Nourriture[];
        for (int i=0; i<this.loftCorrespondant.population.length; i++) {
            if this.loftCorrespondant.alimentation[i].position=this
                    { 
                        nourritureSurLaCase =  this.loftCorrespondant.alimentation[i].position;
                    }
        }
        return nourritureSurLaCase;
        
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
