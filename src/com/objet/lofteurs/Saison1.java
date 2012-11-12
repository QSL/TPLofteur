package com.objet.lofteurs;

import java.awt.*;

public class Saison1 {

	public static int nombreLofteurs = 5;
	public static int tailleLoft = 40;
	public static final int nombreTours = 1000;
	public static double proportionErratique = 0.25f;
	public static double proportionVorace = 0.25f;
	public static double proportionCannibale = 0.25f;
	public static double proportionLapin = 0.25f;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		float prop_nourriture = 0.02f;
		int valeurEnergieNourriture = 20;
		ZoneGraphique zone = new ZoneGraphique("Loft Story Sfeir Servais-Laval", tailleLoft, tailleLoft);
		Loft loft = new Loft(tailleLoft,zone, prop_nourriture);
		zone.ajouterObjet(loft);
		Neuneu nouveauNeuneu = new Neuneu();
		//Add Food management

    	for (int i = 0; i <= tailleLoft ; i++)
    	{
    		for (int j = 0 ; j <= tailleLoft ; j++)
    		{		
    			if (prop_nourriture >= Math.random()) {
    				Kebab new_kebab = new Kebab(loft.getListCases()[j][i], valeurEnergieNourriture);
    				loft.addNourriture(new_kebab);
    			}
    		}
    	}
		
		for (int i=0 ; i < nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				Vorace new_vorace = new Vorace(loft,
						(int)(Math.random()*tailleLoft),
						(int)(Math.random()*tailleLoft),
						3);
				loft.addNeuneu(new_vorace);
			}
			else {
				x -= proportionVorace;
				if (x<proportionErratique) {
					Erratique new_erratique = new Erratique(loft,(int)(Math.random()*tailleLoft),(int)(Math.random()*tailleLoft));
					loft.addNeuneu(new_erratique);
					
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						Cannibale new_cannibale = new Cannibale(loft, (int)(Math.random() * tailleLoft), (int)(Math.random() * tailleLoft), 3);	

						loft.addNeuneu(new_cannibale);
					}
					else {
						Lapin new_lapin = new Lapin (loft, (int)(Math.random() * tailleLoft), (int) (Math.random() * tailleLoft), 0.3f);	

						loft.addNeuneu(new_lapin);
					}
				}
			}
		}
		
		loft.go(this.nombreTours);
	}

}