package fr.shapeUp.graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowInit extends JDialog {

	JTextField nbrJoueur;
	
	/**
	 * Construit le JDialog
	 * @param parent Jframe qui detient le Jdialog 
	 * @param title titre
	 * @param modal vrai ou faux
	 */
	WindowInit(JFrame parent, String title, boolean modal){
		super(parent, title,modal);
		this.setSize(550,270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		//On définit le layout à utiliser sur le content pane
	    //Trois lignes sur deux colonnes
	    this.setLayout(new GridLayout(2, 2));
		this.init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
	    
		JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(220, 60));
	    nbrJoueur = new JTextField();
	    nbrJoueur.setPreferredSize(new Dimension(100, 25));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
	    JLabel nomLabel = new JLabel("Saisir un nom :");
	    panNom.add(nomLabel);
	    panNom.add(nbrJoueur);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mainwin= new MainWindow();
		//WindowInit win = WindowInit(null, "choix",true);
		
	}
	
}

