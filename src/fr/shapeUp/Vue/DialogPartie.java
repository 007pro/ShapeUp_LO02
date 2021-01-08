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

import fr.shapeUp.controleur.ControleurTest;
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
import javax.swing.JSeparator;

public class DialogPartie extends JDialog implements Observer{


	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup btnGrpPlateau = new ButtonGroup();
	private VueCarte carteview;
	private ArrayList<JPanel> panelJCVictoire = new ArrayList<JPanel>();
	private ArrayList<JLabel> panelImageCVictoire = new ArrayList<JLabel>();
	private LinkedHashMap<String, JToggleButton> btnPos = new LinkedHashMap<String, JToggleButton>();
	private JButton btnNextTurn;
	private JButton btnCarte1;
	private JLabel[] labelJoueurs = new JLabel[3];
	public JLabel[] getLabelJoueurs() {
		return labelJoueurs;
	}

	private Partie partie;
	private ControleurTest controleur;
	private JButton btnPlacer;

	/**
	 * Create the dialog.
	 */
	public DialogPartie(Partie partie, ControleurTest controleur) {
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
		this.controleur.PartieInit(btnNextTurn, btnPlacer, btnPos, this);
	}

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
		lblJ1.setForeground(Color.RED);
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
		
		JButton btnDeplace = new JButton("Deplacer");
		btnDeplace.setBounds(182, 577, 148, 23);
		content.add(btnDeplace);
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, BorderLayout.NORTH);
		
		for(String pos : partie.getPlateau().getClesValides()) {
			this.btnPos.put(pos, new JToggleButton());
			this.btnPos.get(pos).setBounds(90 + (pos.charAt(1) - 48)*84, 25 + (pos.charAt(0) - 65)*120 , 84 , 120);
			btnGrpPlateau.add(btnPos.get(pos));
			panelPlateau.add(this.btnPos.get(pos));
		}
		
		
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof Plateau) {
			if(arg != "reset") {
				if(partie.getPlateau().getCases().containsKey(arg)) {
					System.out.println(partie.getJoueurs()[0].getCarteCourante());
					System.out.println(partie.getJoueurs()[1].getCarteCourante());
					System.out.println(partie.getJoueurs()[1]);
					System.out.println(this.controleur.getCurrentPlayer());
					carteview = new VueCarte(partie.getJoueurs()[this.controleur.getCurrentPlayer()].getCarteCourante());
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
							.getScaledInstance(84, 120, Image.SCALE_SMOOTH)); // permet de redimensionner une image
					this.btnPos.get(arg).setIcon(imageIcon);
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
	}
}
