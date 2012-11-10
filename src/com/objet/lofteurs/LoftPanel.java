package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class LoftPanel extends JPanel { 
  public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
    System.out.println("PAINT Loft Panel"); 
  }               
}