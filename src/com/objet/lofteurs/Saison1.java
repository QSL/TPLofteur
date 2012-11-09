package com.objet.lofteurs;

import java.awt.*;

public class Saison1 {

	public static int nombreLofteurs = 7;
	public static int tailleLoft = 30;
	public static float proportionErratique = 0.25f;
	public static float proportionVorace = 0.25f;
	public static float proportionCannibale = 0.25f;
	public static float proportionLapin = 0.25f;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		float prop_nourriture = 0.3f;
		ZoneGraphique zone = new ZoneGraphique("Loft Story Sfeir Servais-Laval");
		Canvas draw_zone = new Canvas();
		zone.add(draw_zone);
		Loft loft = new Loft(tailleLoft,zone, prop_nourriture);
		zone.ajouterObjet(loft);
		
		for (int i=0 ; i<nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				System.out.print("Vorace !");
				loft.addNeuneu(new Vorace(loft,
						(int)(Math.random()*29),
						(int)(Math.random()*29),
						3, null));
			}
			else {
				x -= proportionVorace;
				Neuneu nouveauNeuneu = new Neuneu();
				loft.addNeuneu(nouveauNeuneu);
				if (x<proportionErratique) {
					System.out.print("MMMMmmm... ERRATIQUE !");
					loft.addNeuneu(nouveauNeuneu);
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						System.out.print("CANNIBALE !\n");
						loft.addNeuneu(nouveauNeuneu);
					}
					else {
						System.out.print("Chaud dla bite !");
						loft.addNeuneu(nouveauNeuneu);
					}
				}
			}
		}
		
		loft.go(zone);
	}

}