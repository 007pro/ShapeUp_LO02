package fr.shapeUp.graphique;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.shapeUp.partie.Carte;

public class VueCarte {
	
	private Carte carte;
	private JLabel image;
	
	
	/**
	 * Constructeur de l'affichage graphique d'une carte
	 * @param carte Carte � repr�senter de fa�on graphique
	 */
	public VueCarte(Carte carte) {
		this.carte = carte;
		String cheminImage = "img/" + carte.getForme() + carte.getCouleur()+ carte.getContenu() + ".png";
		this.image = new JLabel(new ImageIcon(cheminImage));
	}


	/**
	 * Getter de carte
	 * @return la carte � repr�senter
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * Getter de l'image
	 * @return l'image associ�e � la carte
	 */
	public JLabel getImage() {
		return image;
	}
}

