package fr.shapeUp.Vue;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import fr.shapeUp.controleur.ControleurTest;
import fr.shapeUp.modele.partie.Menu;
import fr.shapeUp.modele.partie.Partie;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Vue du menu 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class VueMenu implements Observer {

	private JFrame frame;
	private final ButtonGroup btnGrpNbJ = new ButtonGroup();
	private final ButtonGroup btnGrpRegles = new ButtonGroup();
	private final ButtonGroup btnGrpPlateau = new ButtonGroup();
	private JRadioButton rdbtn2j;
	private JRadioButton rdbtn3j;
	private JRadioButton rdbtn1j1ia;
	private JRadioButton rdbtn1j2ia;
	private JRadioButton rdbtn2j1ia;
	private JLabel lblRegles;
	private JLabel lblPlateau;
	private JRadioButton rdbtnNormal;
	private JRadioButton rdbtnAvance;
	private JRadioButton rdbtnRectangle;
	private JRadioButton rdbtnTriangle;
	private JRadioButton rdbtnCercle;
	private JButton btnDemarrer;
	private ControleurTest controleur;
	private JButton btnQuitter;

	/**
	 * Lance l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMenu window = new VueMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Créer l'application
	 */
	public VueMenu() {
		initialize();
		this.controleur = new ControleurTest(this.btnDemarrer, this.btnGrpNbJ, this.btnGrpRegles, this.btnGrpPlateau, this, this.btnQuitter);
	}

	/**
	 * Initialisation des composantes de la fenetre 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNbJoueurs = new JLabel("Nombre de joueurs");
		lblNbJoueurs.setBounds(24, 11, 115, 14);
		frame.getContentPane().add(lblNbJoueurs);
		
		rdbtn2j = new JRadioButton("2J");
		rdbtn2j.setSelected(true);
		btnGrpNbJ.add(rdbtn2j);
		rdbtn2j.setBounds(24, 32, 109, 23);
		frame.getContentPane().add(rdbtn2j);
		
		rdbtn3j = new JRadioButton("3J");
		btnGrpNbJ.add(rdbtn3j);
		rdbtn3j.setBounds(24, 58, 109, 23);
		frame.getContentPane().add(rdbtn3j);
		
		rdbtn1j1ia = new JRadioButton("1J 1IA");
		btnGrpNbJ.add(rdbtn1j1ia);
		rdbtn1j1ia.setBounds(24, 84, 109, 23);
		frame.getContentPane().add(rdbtn1j1ia);
		
		rdbtn1j2ia = new JRadioButton("1J 2IA");
		btnGrpNbJ.add(rdbtn1j2ia);
		rdbtn1j2ia.setBounds(24, 110, 109, 23);
		frame.getContentPane().add(rdbtn1j2ia);
		
		rdbtn2j1ia = new JRadioButton("2J 1IA");
		btnGrpNbJ.add(rdbtn2j1ia);
		rdbtn2j1ia.setBounds(24, 136, 109, 23);
		frame.getContentPane().add(rdbtn2j1ia);
		
		lblRegles = new JLabel("Regles");
		lblRegles.setBounds(309, 11, 46, 14);
		frame.getContentPane().add(lblRegles);
		
		lblPlateau = new JLabel("Plateau");
		lblPlateau.setBounds(564, 11, 46, 14);
		frame.getContentPane().add(lblPlateau);
		
		rdbtnNormal = new JRadioButton("Normal");
		btnGrpRegles.add(rdbtnNormal);
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setBounds(271, 32, 109, 23);
		frame.getContentPane().add(rdbtnNormal);
		
		rdbtnAvance = new JRadioButton("Avanc\u00E9");
		btnGrpRegles.add(rdbtnAvance);
		rdbtnAvance.setBounds(271, 58, 109, 23);
		frame.getContentPane().add(rdbtnAvance);
		
		rdbtnRectangle = new JRadioButton("Rectangle");
		btnGrpPlateau.add(rdbtnRectangle);
		rdbtnRectangle.setSelected(true);
		rdbtnRectangle.setBounds(527, 32, 109, 23);
		frame.getContentPane().add(rdbtnRectangle);
		
		rdbtnTriangle = new JRadioButton("Triangle");
		btnGrpPlateau.add(rdbtnTriangle);
		rdbtnTriangle.setBounds(527, 58, 109, 23);
		frame.getContentPane().add(rdbtnTriangle);
		
		rdbtnCercle = new JRadioButton("Cercle");
		btnGrpPlateau.add(rdbtnCercle);
		rdbtnCercle.setBounds(527, 84, 109, 23);
		frame.getContentPane().add(rdbtnCercle);
		
		btnDemarrer = new JButton("Demarrer");
		btnDemarrer.setBounds(283, 325, 89, 23);
		frame.getContentPane().add(btnDemarrer);
				
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(595, 438, 89, 23);
		frame.getContentPane().add(btnQuitter);
	}
	
	/**
	 * Méthode update du menu
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof Menu) {
			frame.setVisible(false);
			Partie partie = ((Menu) arg0).getPartie();
			DialogPartie vuePartie = new DialogPartie(partie, this.controleur);
			vuePartie.setVisible(true);
		}
	}
}
