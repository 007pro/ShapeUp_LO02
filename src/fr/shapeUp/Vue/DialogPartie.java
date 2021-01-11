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
import java.util.LinkedHashMap;
import java.util.Map.Entry;
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
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import fr.shapeUp.Vue.VueTexte;
import fr.shapeUp.controleur.ControleurShapeUp;
import fr.shapeUp.modele.joueur.Joueur;
import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Carte.contenu;
import fr.shapeUp.modele.partie.Carte.couleurCarte;
import fr.shapeUp.modele.partie.Carte.formeCarte;
import fr.shapeUp.modele.partie.Comptage;
import fr.shapeUp.modele.partie.Deck;
import fr.shapeUp.modele.partie.Partie;
import fr.shapeUp.modele.partie.plateau.Plateau;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JProgressBar;

/**
 * Vue de la partie
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */
public class DialogPartie extends JDialog implements Observer{


	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup btnGrpPlateau = new ButtonGroup();
	private ArrayList<JPanel> panelJCVictoire = new ArrayList<JPanel>();
	private ArrayList<JLabel> panelImageCVictoire = new ArrayList<JLabel>();
	private LinkedHashMap<String, JToggleButton> btnPos = new LinkedHashMap<String, JToggleButton>();
	private JButton btnNextTurn;
	private JButton btnCarte1;
	private JLabel[] labelJoueurs = new JLabel[3];
	private JLabel[] labelScores = new JLabel[3];
	private Partie partie;
	private ControleurShapeUp controleur;
	private JButton btnPlacer;
	private JButton btnDeplace;
	private JProgressBar progressBar;
	private JButton btnQuitter;

	
	/**
	 * Vue de carte
	 */
	private VueCarte carteview;
	
	/**
	 * @return Le button tour suivant
	 */
	public JButton getBtnNextTurn() {
		return btnNextTurn;
	}
	/**
	 * @return Le button placer carte
	 */
	public JButton getBtnPlacer() {
		return btnPlacer;
	}
	/**
	 * @return Le button deplacer carte
	 */
	public JButton getBtnDeplace() {
		return btnDeplace;
	}
		
	/**
	 * @return Les labels de Joueurs
	 */
	public JLabel[] getLabelJoueurs() {
		return labelJoueurs;
	}

	

	/**
	 * Fenetre de dialog pour jouer la partie
	 * @param partie 
	 * @param controleur
	 */
	public DialogPartie(Partie partie, ControleurShapeUp controleur) {
		VueTexte ConsoleText = new VueTexte(partie, controleur, this);
		this.partie = partie;
		this.controleur = controleur;
		partie.getPlateau().addObserver(this);
		for(Joueur joueur : partie.getJoueurs()) {
			joueur.addObserver(this);
		}
		this.setTitle("Shape Up");		
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
	    this.setIconImage(icon);  
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.init();
		this.controleur.PartieInit(btnNextTurn, btnPlacer, btnDeplace, btnPos, this, btnQuitter);
	}

	/**
	 * Initialisation des composantes de la fenetre 
	 */
	private void init() {
				
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
		lblJ1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJ1.setForeground(Color.RED);
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ1.setBounds(10, 210, 140, 14);
		content.add(lblJ1);

		
		JLabel lblJ2 = new JLabel("JOUEUR2");
		lblJ2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ2.setBounds(10, 424, 140, 14);
		content.add(lblJ2);

		
		JLabel lblJ3 = new JLabel("JOUEUR3");
		lblJ3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJ3.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ3.setBounds(10, 641, 140, 14);
		content.add(lblJ3);
		
		labelJoueurs[0] = lblJ1;
		labelJoueurs[1] = lblJ2;
		labelJoueurs[2] = lblJ3;
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(170, 25, 2, 630);
		content.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(340, 25, 2, 630);
		content.add(separator_2);
		
		JPanel panelPlateau = new JPanel();
		panelPlateau.setBounds(350, 10, 900, 650);
		content.add(panelPlateau);
		panelPlateau.setLayout(null);
		
		JLabel lblScores = new JLabel("Scores :");
		lblScores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblScores.setBounds(0, 0, 90, 14);
		panelPlateau.add(lblScores);
		
		JLabel lblScore1 = new JLabel("J1 : 0");
		lblScore1.setBounds(120, 0, 103, 14);
		panelPlateau.add(lblScore1);
		
		JLabel lblScore2 = new JLabel("J2 : 0");
		lblScore2.setBounds(233, 0, 98, 14);
		panelPlateau.add(lblScore2);
		
		JLabel lblScore3 = new JLabel("J3 : 0");
		lblScore3.setBounds(341, 0, 113, 14);
		panelPlateau.add(lblScore3);
		
		labelScores[0] = lblScore1;
		labelScores[1] = lblScore2;
		labelScores[2] = lblScore3;
		
		
		btnNextTurn = new JButton("Tour Suivant");
		btnNextTurn.setBounds(182, 645, 148, 23);
		btnNextTurn.setEnabled(false);
		content.add(btnNextTurn);
		
		btnCarte1 = new JButton();
		btnCarte1.setBounds(212,43,84,120);
		content.add(btnCarte1);
		
		JButton btnCarte1_1 = new JButton();
		btnCarte1_1.setBounds(212, 174, 84, 120);
		content.add(btnCarte1_1);
		
		JButton btnCarte1_2 = new JButton();
		btnCarte1_2.setBounds(212, 305, 84, 120);
		content.add(btnCarte1_2);
		
		btnPlacer = new JButton("Placer");
		btnPlacer.setBounds(182, 611, 148, 23);
		content.add(btnPlacer);
		
		btnDeplace = new JButton("Deplacer");
		btnDeplace.setBounds(182, 577, 148, 23);
		content.add(btnDeplace);
		
		progressBar = new JProgressBar();
		progressBar.setToolTipText("Nombre de cartes restantes dans le deck");
		progressBar.setStringPainted(true);
		progressBar.setValue(18);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(177, 174, 25, 120);
		content.add(progressBar);
		progressBar.setMaximum(18);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(1175, 656, 89, 23);
		content.add(btnQuitter);
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, BorderLayout.NORTH);
		
		for(String pos : partie.getPlateau().getClesValides()) {
			this.btnPos.put(pos, new JToggleButton());
			this.btnPos.get(pos).setBounds(90 + (pos.charAt(1) - 48)*84, 25 + (pos.charAt(0) - 65)*120 , 84 , 120);
			btnGrpPlateau.add(btnPos.get(pos));
			panelPlateau.add(this.btnPos.get(pos));
		}
		
		
		
		
	}

	/**
	 * Méthode update de la partie
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Plateau) {
			if(arg != "reset") {
				if(partie.getPlateau().getCases().containsValue(arg)) {					
		
					carteview = new VueCarte((Carte)arg);
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
							.getScaledInstance(84, 120, Image.SCALE_SMOOTH)); // permet de redimensionner une image
					for(Entry<String, Carte> entry : partie.getPlateau().getCases().entrySet()) {
						if(entry.getValue().equals((Carte)arg)) this.btnPos.get(entry.getKey()).setIcon(imageIcon);
					}
					
				}else {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon("").getImage()
							.getScaledInstance(84, 120, Image.SCALE_SMOOTH)); // permet de redimensionner une image
					this.btnPos.get(arg).setIcon(imageIcon);
				}
			}else {
				for(String pos : partie.getPlateau().getClesValides()) {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon("").getImage()
							.getScaledInstance(84, 120, Image.SCALE_SMOOTH)); // permet de redimensionner une image
					this.btnPos.get(pos).setIcon(imageIcon);
				}
			}
		}
		if(o instanceof Joueur) {
			carteview = new VueCarte(partie.getJoueurs()[controleur.getCurrentPlayer()].getCarteCourante());
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
					.getScaledInstance(84, 120, Image.SCALE_SMOOTH)); // permet de redimensionner une image
			this.btnCarte1.setIcon(imageIcon);
		}
		if(o instanceof Comptage) {
			int idx = 0;
			for(Joueur joueur : partie.getJoueurs()) {
				labelScores[idx].setText("J" + (idx+1) + ": " + joueur.getScore());
				idx++;
			}
		}
		if(o instanceof Deck) {
			progressBar.setValue(((Deck)o).getNombreDeCartes());
		}
	}
}
