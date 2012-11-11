package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

/**
 * une classe comportant une zone graphique dans laquelle on peut dessiner ;
 * le dessin est refait automatiquement par la classe Panel associée ; tous
 * les objets de type ObjetDessinable ajoutés à la liste sont redessinés par 
 * un appel à leur méthode dessinerObjet(Graphics g)
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau
 *
 */
public class ZoneGraphique extends JFrame {

	/**
	 * la liste d'objets à dessiner
	 */
	LinkedList<ObjetDessinable> liste;
	public static final int UNITE_X = 10;
	public static final int UNITE_Y = 10;
	/**
	 * constructeur
	 *
	 * @param titre le nom de l'application
	 */
	public ZoneGraphique(String titre, int size_width, int size_height)  {
		
		
		// appel au constructeur de base
		super(titre);
		
		// ajout d'une taille par défaut
		setSize(size_width * UNITE_X,size_height * UNITE_Y);
		
		// création de la liste d'objets
		liste = new LinkedList<ObjetDessinable>();
		// ajout d'un listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0) ;
			}
	    	} ) ;
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
		// création du panneau
		LoftPanel a = new LoftPanel();
		getContentPane().add(a); 

		this.setContentPane(a);   
		this.setBackground(Color.WHITE);
		setVisible(true);
	}
	
	/**
	 * ajout d'un objet dans la zone graphique
	 */
	void ajouterObjet(ObjetDessinable o) {
		liste.add(o);
	}
	
	/**
	 * largeur de la partie dessinable
	 */
	public int getWidth() {
		return getContentPane().getWidth();
	}
   public void paint(Graphics g) {
	   try {
	       super.paint(g);
	      for( ObjetDessinable oD : liste) {
	         oD.dessinerObjet(g); // chaque objet graphique a une m�thode dessinerObjet
	      }		  
	        // Thread.currentThread().sleep(100);
	        // this.repaint();	      
	   }
	   catch (Exception  e)
	   {
		   
	   }

   }	
	/**
	 * hauteur de la partie dessinable
	 */
	public int getHeight() {
		return getContentPane().getHeight();
	}

	public LinkedList<ObjetDessinable> getListe() {
		return liste;
	}

	public void setListe(LinkedList<ObjetDessinable> liste) {
		this.liste = liste;
	}
	
}