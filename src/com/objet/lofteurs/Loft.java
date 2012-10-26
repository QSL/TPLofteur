/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

/**
 *
 * @author QSL
 */
class Loft {

    protected Neuneu[] population;
    protected Nourriture[] alimentation;
    protected int largeur;
    protected int hauteur;
    protected Case[][] listcases;
    
    
    public Loft(int tailleLoft, ZoneGraphique zone) {
    }
    
    public void remplissageAleatoire(int nb_neuneu, int nb_nourr){
        
    }
    
    public void addNeuneu(Neuneu lofteur){
        
    }
    
    public void addNourriture(Nourriture Consommable){
        
    }
    
    public Case getContenuCase(){
        return null;
        
    }
    
    public void lancement(int tours){
        
    }
    
    public Neuneu[] getPopulation(){
        return null;
        
    }
    
    public void setPopulation(Neuneu[] listNeuneu){
        
    }
    
    public Case[][] getListCases(){
        return null;
        
    }
    
    public void setListeCases(Case[] listeCase){
        
    }
    
    public Nourriture[] getAlimentation(){
        return this.alimentation;
    }
    
    public void setAlimentation(Nourriture[] alimentation){
        this.alimentation= alimentation;
    }

    public boolean contient(Case nouvelleCasePossible) {
        //index de la recherche
        int i, j;
        
        //index pour le booleen
        int k=0;
        
        for(i=0; i<this.listcases.length; i++){
            for(j=0; j<this.listcases[i].length; j++){
                if(this.listcases[i][j]==nouvelleCasePossible){
                    k=k+1;
                }                
            }
        }
        
        if(k==0){
            return false;
        }
        
        else{
            return true;
        }
               
        }

   
    public void go(){
    while(this.population.size>1){
    int i;
    for (i=0; i<this.population.size; i++){
        this.population[i].cycleDeVie();
    }
}
        
    }

