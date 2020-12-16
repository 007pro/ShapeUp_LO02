package fr.shapeUp.controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import fr.shapeUp.Vue.DialogChoixDesregles;
import fr.shapeUp.Vue.VuePartie;
import fr.shapeUp.modele.partie.Partie;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;

public class ShapeControleur {
	
	private Partie partie;
	private VuePartie vuePartie;
	private JComboBox nbrJoueur, typePlateau;
	DialogChoixDesregles choixRegle;
	int joueur, typeRegle;



	formePlateau laforme;
	
	ShapeControleur (DialogChoixDesregles choixRegle, JButton okbouton){
		
		choixDesRegle(choixRegle, okbouton );
	}
	
	public void choixDesRegle(DialogChoixDesregles choixRegle, JButton okbouton) {
		this.choixRegle = choixRegle;
		
		//event 
				okbouton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						choixRegle.setVisible(false);
					}
					
				});
		
		this.joueur =  choixRegle.getNbrJoueur();
		this.typeRegle = choixRegle.getRegleint();
		this.laforme = choixRegle.getLaforme();
		
		}
	

	

	public int getJoueur() {
		return joueur;
	}

	public formePlateau getLaforme() {
		return laforme;
	}
	public int getTypeRegle() {
		return typeRegle;
	}



	public static void main(String[] args) {
		Partie partie;
		VuePartie window = new VuePartie();
		DialogChoixDesregles choixrgle;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ShapeControleur c = new ShapeControleur(choixrgle,);
		System.out.println(c.getJoueur() + c.getTypeRegle());
		partie = new Partie(c.getLaforme());
		partie.lancerPartie(c.getJoueur(), c.getTypeRegle());
		
	}
	
}



