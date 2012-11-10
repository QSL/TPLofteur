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
    protected Loft loftCorrespondant;
    
    public Case(int x, int y, Loft loft)
    {
    	this.abscisse = x;
    	this.ordonnee = y;
    	this.loftCorrespondant = loft;
    }
    public int getAbscisse() {
        return this.abscisse;
    }
    
    public void setAbscisse(int abscisse){
        this.abscisse=abscisse;
    }
    
    public int getOrdonnee(){
        return this.ordonnee;
        }
    
    public void setOrdonnee(int ordonnee){
        this.ordonnee=ordonnee;
    }
    
    // méthode permettant de retourner la liste des neuneus qui sont sur la case
    public List<Neuneu> getNeuneu(){
    	List<Neuneu> listeDeNeuneuSurLaCase = new ArrayList<Neuneu>(); //new Neuneu[this.loftCorrespondant.population.length];
        for(int i=0; i < this.loftCorrespondant.getPopulation().size(); i++)
        {
            if (this.loftCorrespondant.getPopulation().get(i).getPosition() == this)
            { 
                listeDeNeuneuSurLaCase.add(this.loftCorrespondant.getPopulation().get(i));
            }
        }
        return listeDeNeuneuSurLaCase;
        
    }
    
    // permet de retourner la nourriture sur la case
    // non implémentée car possiblement non utile
    public List<Nourriture> getNourriture(){
    	System.out.print("get nourriture !");
    	List<Nourriture> nourritureSurLaCase = new ArrayList<Nourriture>();
        for (int i=0; i < this.loftCorrespondant.getAlimentation().size(); i++) {
        	if (this.loftCorrespondant.getAlimentation().get(i).getPosition().getAbscisse() == this.getAbscisse() && this.loftCorrespondant.getAlimentation().get(i).getPosition().getOrdonnee() == this.getOrdonnee())
            { 
            	System.out.print("Nourriture OK !!");
                nourritureSurLaCase.add(this.loftCorrespondant.getAlimentation().get(i));
            }
        }
        return nourritureSurLaCase;
        
    }
    
    // ajouter un Neuneu sur la case
    public void addNeuneu(Neuneu n){
        n.setPosition(this);
    }
    
    
    // ajouter de la Nourriture sur la case
    public void addNourriture(Nourriture alimentation){
        alimentation.setPosition(this);
    }
    
    public void removeMangeable(Mangeable alimentation){
    	List<Nourriture> alimentationLoft = new ArrayList<Nourriture>();
    	alimentation.setValeurEnergie(0);
    	alimentationLoft = this.getLoftCorrespondant().getAlimentation();
    	for (int i = 0; i < alimentationLoft.size() ; i++)
    	{
    		if (alimentationLoft.get(i).getPosition().getAbscisse() == alimentation.getPosition().getAbscisse() && alimentationLoft.get(i).getPosition().getOrdonnee() == alimentation.getPosition().getOrdonnee())
    		{
    			System.out.print("\n REMOVE \n");
    			alimentationLoft.remove(i);
    		}
    	}
    }
    
    public Loft getLoftCorrespondant(){
        return this.loftCorrespondant;
    }
    
    public void setLoftCorrespondant(Loft loft){
        this.loftCorrespondant=loft;
    }

    
}
