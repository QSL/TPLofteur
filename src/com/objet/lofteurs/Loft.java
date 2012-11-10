/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author QSL
 */
class Loft implements ObjetDessinable {

    protected List<Neuneu> population;
    protected List<Nourriture> alimentation;
    protected int largeur;
    protected int hauteur;
    protected Case[][] listcases;
    public void paintComponent(Graphics g)
    {
    	this.dessinerObjet(g);
    }
    public void dessinerObjet(Graphics g) {
    	System.out.print("DESSINE LOFT");
    	g.setColor(Color.YELLOW);
    	g.drawRect(0, 50, 50, 50);
    }
    public Loft(int tailleLoft, ZoneGraphique zone, float prop_nourriture) {
    	int valeurEnergieNourriture = 50;
    	this.population = new ArrayList<Neuneu>();
    	this.alimentation = new ArrayList<Nourriture>();
    	this.listcases = new Case[tailleLoft+1][tailleLoft+1];
    	this.largeur = tailleLoft;
    	this.hauteur = tailleLoft;
    	for (int i = 0; i <= tailleLoft ; i++)
    	{
    		for (int j = 0 ; j <= tailleLoft ; j++)
    		{		
    			this.listcases[j][i] = new Case(j, i, this);
    			if (prop_nourriture >= Math.random()) this.addNourriture(new Kebab(this.listcases[j][i], valeurEnergieNourriture));
    		}
    	}
    }
    
       
    public void addNeuneu(Neuneu lofteur){
        this.population.add(lofteur);
    }
    
    public void addNourriture(Nourriture Consommable){
        this.alimentation.add(Consommable);
    }
    
    public Case getContenuCase(){
        return null;
    }
    
    public void lancement(int tours){
        
    }
    
    public List<Neuneu> getPopulation(){
        return this.population;
        
    }
    
    public void setPopulation(List<Neuneu> listNeuneu){
        this.population = listNeuneu;
    }
    
    public Case[][] getListCases(){
        return this.listcases;
    }
    
    public void setListeCases(Case[][] listeCase){
        this.listcases = listeCase;
    }
    
    public List<Nourriture> getAlimentation(){
        return this.alimentation;
    }
    
    public void setAlimentation(List<Nourriture> alimentation){
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

   
    public void go(ZoneGraphique graphics_zone){
    while(this.population.size() > 1){
	    int i, k, j;
	    
	    
	    
	    /*for (i=0; i<this.population.size(); i++){
	        this.population.get(i).cycleDeVie();
	        for (j=0; j<this.population.size(); j++){
		        if (this.population.get(j).getValeurEnergie() <= 0)
		        {
		        	this.population.get(j).expulse();
		        }
	        }
	        for (k=0; k < this.alimentation.size(); k++)
	        {
	        	if (this.alimentation.get(k).getValeurEnergie() <= 0)
	        	{
	        		System.out.print("TEST ALIMENTATION :");
	        		System.out.print(this.alimentation.size());
	        		System.out.print(this.alimentation.get(k).getPosition());
	        		this.alimentation.get(k).getPosition().removeMangeable(this.alimentation.get(k));
	        	}
	        }
	    }*/
    }
}
        
    

    void remplissageAleatoire(float nb_nourriture) {
       
    }

    }