package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class LoftPanel extends JPanel { 
  public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la m�thode sera invoqu�e
    System.out.println("PAINT Loft Panel"); 
  }               
}