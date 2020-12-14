package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.shapeUp.modele.partie.plateau.Plateau;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;
import javax.swing.JFormattedTextField;

public class DialogChoixDesregles extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean sendData;
	private JLabel nomLabel, nbrJoueurLabel, cheveuxLabel, ageLabel, tailleLabel, taille2Label, icon, nbrPlateauLabel;
	private JRadioButton regleClassique, regleAvance;
	private JComboBox nbrJoueur, cheveux, typePlateau;
	private JTextField taille;
	private boolean partieDemarre = false;
	private JTextField textField;

	private String joueur ;
	private String laforme;
	private String typeRegle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogChoixDesregles dialog = new DialogChoixDesregles();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogChoixDesregles() {
		this.setTitle("Choix des régles");		
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
	    this.setIconImage(icon);  
		this.setSize(550, 230);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.init();
	}

	private void init() {
		// le type de plateau
		JPanel panPlateau = new JPanel();
		panPlateau.setBackground(Color.white);
		panPlateau.setPreferredSize(new Dimension(220, 60));
		typePlateau = new JComboBox();
		typePlateau.addItem("Rectangulaire");
		typePlateau.addItem("Triangulaire");
		typePlateau.addItem("Circulaire");
		nbrPlateauLabel = new JLabel("Plateau : ");
		panPlateau.setBorder(BorderFactory.createTitledBorder("Type de plateau : "));
		nomLabel = new JLabel("Saisir un nom :");
		panPlateau.add(nbrPlateauLabel);
		panPlateau.add(typePlateau);

		// le nombre de joueurs
		JPanel panNbrJoueur = new JPanel();
		panNbrJoueur.setBackground(Color.white);
		panNbrJoueur.setPreferredSize(new Dimension(220, 60));
		panNbrJoueur.setBorder(BorderFactory.createTitledBorder("Nombre de joueurs"));
		nbrJoueur = new JComboBox();
		nbrJoueur.addItem("1");
		nbrJoueur.addItem("2");
		nbrJoueur.addItem("3");
		nbrJoueurLabel = new JLabel(" Joueurs");
		panNbrJoueur.add(nbrJoueur); 
		panNbrJoueur.add(nbrJoueurLabel);
		
		//les regles
		JPanel panRegles = new JPanel();
		panRegles.setBackground(Color.white);
		panRegles.setBorder(BorderFactory.createTitledBorder("Type de règles"));
		panRegles.setPreferredSize(new Dimension(440, 60));
		regleClassique = new JRadioButton("Classique");
		regleClassique.setSelected(true);
		regleAvance = new JRadioButton("Avancée");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(regleClassique);
		bg.add(regleAvance);
		
		panRegles.add(regleClassique);
		panRegles.add(regleAvance);
		
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panNbrJoueur);
		content.add(panPlateau);
		content.add(panRegles);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");
		
		JButton cancelBouton;
		cancelBouton = new JButton("Annuler");
		
		
		
		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);

		
		
	
		
		//event 
		okBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				joueur = (String)nbrJoueur.getSelectedItem(); //recupérer la valeur d'une combot box
				laforme = (String) typePlateau.getSelectedItem();
				typeRegle = getRegle();
				partieDemarre = true;
			}
			
		});

		cancelBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		
		
		
	}
	
	public String getRegle(){
        return (regleClassique.isSelected()) ? regleClassique.getText(): 
               (regleAvance.isSelected()) ? regleAvance.getText() : 
            	   regleClassique.getText();  
      }
	
	public int getNbrJoueur() {
		return Integer.parseInt(joueur);
	}
	
	public formePlateau getLaforme() {
		if (laforme == "Rectangulaire")
		{
			return formePlateau.rectangle;
		}
			
		else if(laforme =="Triangulaire")
		{
			return formePlateau.triangle;
		}
			
		else if (laforme == "Circulaire")
		{
			return formePlateau.cercle;
		}
		 return null;
	}
	
	public int getRegleint() {
		return Integer.parseInt(typeRegle);
	}
	


}
