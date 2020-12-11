package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowInit extends JDialog {


	private boolean sendData;
	private JLabel nomLabel, nbrJoueurLabel, cheveuxLabel, ageLabel, tailleLabel, taille2Label, icon, nbrPlateauLabel;
	private JRadioButton regleClassique, regleAvance;
	private JComboBox nbrJoueur, cheveux, typePlateau;
	private JTextField taille;
	private boolean partieDemarre = false;
	
	/**
	 * Construit le JDialog
	 * 
	 * @param parent Jframe qui detient le Jdialog
	 * @param title  titre
	 * @param modal  vrai ou faux
	 */
	WindowInit(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(550, 230);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.init();
		this.setVisible(true);

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

		okBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(),
				// getAge(), (String)cheveux.getSelectedItem() ,getTaille());
				setVisible(false);
				partieDemarre = true;
			}
			
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
	
	public boolean isPartieDemarre() {
		return partieDemarre;
	}



}
