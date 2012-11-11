package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la m�thode sera invoqu�e
    System.out.println("Je suis ex�cut�e !"); 
    g.setColor(Color.WHITE);
    g.fillRect(0,  0,  this.getWidth() + 500,  this.getHeight() + 500);
    g.setColor(Color.GREEN);
    g.fillOval(this.getWidth() / 4, this.getHeight() / 4, this.getWidth() / 2, this.getHeight() / 2);
  }               
}