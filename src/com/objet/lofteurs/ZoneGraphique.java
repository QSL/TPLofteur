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
	
	/**
	 * constructeur
	 *
	 * @param titre le nom de l'application
	 */
	public ZoneGraphique(String titre)  {
		
		
		// appel au constructeur de base
		super(titre);
		
		// ajout d'une taille par défaut
		setSize(600,600);
		
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
		this.setBackground(Color.RED);
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
       super.paint(g);
       System.out.print("paint affichage ; ");
      for( ObjetDessinable oD : liste) {
    	  System.out.print("Dessiner objet boucle Zone Graphique");
    	  System.out.print(oD.getClass().getName());
         oD.dessinerObjet(g); // chaque objet graphique a une m�thode dessinerObjet
         this.repaint();
      }
      //this.getContentPane().repaint();
      //this.repaint();
   }	
	/**
	 * hauteur de la partie dessinable
	 */
	public int getHeight() {
		return getContentPane().getHeight();
	}
	
}