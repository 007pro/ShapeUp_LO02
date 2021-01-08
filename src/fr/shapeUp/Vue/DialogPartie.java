package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.shapeUp.modele.joueur.Joueur;
import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Carte.contenu;
import fr.shapeUp.modele.partie.Carte.couleurCarte;
import fr.shapeUp.modele.partie.Carte.formeCarte;
import fr.shapeUp.modele.partie.Partie;
import fr.shapeUp.modele.partie.plateau.Plateau;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class DialogPartie extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VueCarte carteview;
	private ArrayList<JPanel> panelJCVictoire = new ArrayList<JPanel>();
	private ArrayList<JLabel> panelImageCVictoire = new ArrayList<JLabel>();
	Carte carteVictoire = new Carte(formeCarte.Rond, couleurCarte.Rouge, contenu.Vide);

	/**
	 * Create the dialog.
	 */
	public DialogPartie(Partie partie) {
		this.setTitle("Shape Up");		
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
	    this.setIconImage(icon);  
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.init(partie);
	}

	private void init(Partie partie) {
				
		JPanel content = new JPanel();
		content.setBackground(Color.lightGray);
		this.getContentPane().add(content, BorderLayout.CENTER);
		content.setLayout(null);
		
		int idx = 0;
		for (Joueur joueur : partie.getJoueurs()) {
			this.panelJCVictoire.add(new JPanel());
			this.panelJCVictoire.get(idx).setBounds(10, 10 + (idx * 215), 140, 200);
			content.add(this.panelJCVictoire.get(idx));
			this.panelImageCVictoire.add(new JLabel());
			carteview = new VueCarte(joueur.getCarteVictoire());
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
					.getScaledInstance(140, 200, Image.SCALE_SMOOTH)); // permet de redimensionner une image
			this.panelImageCVictoire.get(idx).setIcon(imageIcon);
			this.panelJCVictoire.get(idx).add(this.panelImageCVictoire.get(idx));
			idx++;
		}
		
		JLabel lblJ1 = new JLabel("JOUEUR1");
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ1.setBounds(10, 210, 140, 14);
		content.add(lblJ1);

		
		JLabel lblJ2 = new JLabel("JOUEUR2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ2.setBounds(10, 424, 140, 14);
		content.add(lblJ2);

		
		JLabel lblJ3 = new JLabel("JOUEUR3");
		lblJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ3.setBounds(10, 641, 140, 14);
		content.add(lblJ3);
		
		
		
		
	}
}
