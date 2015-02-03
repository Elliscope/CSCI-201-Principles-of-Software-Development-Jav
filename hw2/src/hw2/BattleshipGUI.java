package hw2;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BattleshipGUI extends JFrame{
	public static final long serialVersionUID= 1;
	
	public BattleshipGUI(){
		
		
		super("Battleship");
    	setSize(600,400);
    	setLocation(100,50);
    	setVisible(true);
    	//set up close window button
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	}
	
	 public void showToUser(){
	    	setVisible(true);
	    }
}
