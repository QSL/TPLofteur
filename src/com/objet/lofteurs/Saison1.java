package com.objet.lofteurs;

import java.awt.*;

public class Saison1 {

	public static int nombreLofteurs = 3;
	public static int tailleLoft = 30;
	public static float proportionErratique = 0;
	public static float proportionVorace = 1;
	public static float proportionCannibale = 0f;
	public static float proportionLapin = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		float prop_nourriture = 0.3f;
		ZoneGraphique zone = new ZoneGraphique("Loft Story Sfeir Servais-Laval");
		Loft loft = new Loft(tailleLoft,zone, prop_nourriture);
		zone.ajouterObjet(loft);
		Neuneu nouveauNeuneu = new Neuneu();
		for (int i=0 ; i<nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				Vorace new_vorace = new Vorace(loft,
						(int)(Math.random()*29),
						(int)(Math.random()*29),
						3);
				System.out.print("Vorace !");
				loft.addNeuneu(new_vorace);
				zone.ajouterObjet(new_vorace);
			}
			else {
				x -= proportionVorace;
				if (x<proportionErratique) {
					nouveauNeuneu = new Erratique(loft,
							(int)(Math.random()*29),
							(int)(Math.random()*29));
					System.out.print("MMMMmmm... ERRATIQUE !");
					
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						nouveauNeuneu = new Cannibale(loft, (int)(Math.random() * 29), (int)(Math.random() * 29), 3);
						System.out.print("CANNIBALE !\n");
					}
					else {
						nouveauNeuneu = new Lapin (loft, (int)(Math.random() * 29), (int) (Math.random() * 29), 3);
						System.out.print("Chaud dla bite !");
					}
				}
			}
		}
		
		loft.go(zone);
	}

}