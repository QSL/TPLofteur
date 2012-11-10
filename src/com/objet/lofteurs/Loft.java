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
    protected ZoneGraphique gzone;
    public void paintComponent(Graphics g)
    {
    	//this.dessinerObjet(g);
    }
    public final void dessinerObjet(final Graphics g) {
        for (Neuneu neuneu : this.population) {
            neuneu.dessinerObjet(g);
        }
    }
    public Loft(int tailleLoft, ZoneGraphique zone, float prop_nourriture) {
    	int valeurEnergieNourriture = 50;
    	this.population = new ArrayList<Neuneu>();
    	this.alimentation = new ArrayList<Nourriture>();
    	this.listcases = new Case[tailleLoft+1][tailleLoft+1];
    	this.largeur = tailleLoft;
    	this.hauteur = tailleLoft;
    	this.gzone = zone;
    	for (int i = 0; i <= tailleLoft ; i++)
    	{
    		for (int j = 0 ; j <= tailleLoft ; j++)
    		{		
    			this.listcases[j][i] = new Case(j, i, this);
    		}
    	}
    }
    
       
    public void addNeuneu(Neuneu lofteur){
        this.population.add(lofteur);
        this.gzone.ajouterObjet(lofteur);
    }
    
    public void addNourriture(Nourriture Consommable){
        this.alimentation.add(Consommable);
        this.gzone.ajouterObjet(Consommable);
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

    public void expulse(Neuneu neuneu_expulse) {
    	neuneu_expulse.setEstexpulse(true);
    	neuneu_expulse.setValeurEnergie(0);
    	for (int i = 0 ; i < this.population.size() ; i++) {
    		if (this.population.get(i) == neuneu_expulse) {
    			System.out.print("EXPULSION NEUNEU NUMERO " + i);
    			this.population.remove(i);
    		}
    	}
    }
   
    public void go(int nombreTours){
    int tourActuel = 0;
    Lapin new_lapin = new Lapin (this, 1, 1, 3);	

	this.addNeuneu(new_lapin);
	gzone.ajouterObjet(new_lapin);    
	
    while(this.population.size() > 1 || tourActuel < nombreTours){
	    int i, k, j;
	    try {
		    for (i=0; i<this.population.size(); i++){
		    	System.out.print("\n JOUEUR " + i + "\n");
		    	System.out.print("Energ : " + this.population.get(i).getValeurEnergie());
		    	System.out.print("Pos : " + this.population.get(i).getPosition().getAbscisse() + " ; " + this.population.get(i).getPosition().getOrdonnee());
		    	System.out.print("\n");
		        Thread.currentThread().sleep(200);
		        this.gzone.repaint();
		        this.population.get(i).cycleDeVie();
		        for (j=0; j<this.population.size(); j++){
			        if (this.population.get(j).getValeurEnergie() <= 0)
			        {
			        	this.expulse(this.population.get(j));
			        }
		        }
		        /*for (k=0; k < this.alimentation.size(); k++)
		        {
		        	if (this.alimentation.get(k).getValeurEnergie() <= 0)
		        	{
		        		this.alimentation.get(k).getPosition().removeMangeable(this.alimentation.get(k));
		        	}
		        }*/
		    }
	        Thread.currentThread().sleep(125);
		    tourActuel++;
	    }
	    catch (Exception e) {
	    	
	    }
    }
}
        
    

    void remplissageAleatoire(float nb_nourriture) {
       
    }

    }