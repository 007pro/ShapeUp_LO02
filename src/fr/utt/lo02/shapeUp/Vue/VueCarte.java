package fr.utt.lo02.shapeUp.Vue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.utt.lo02.shapeUp.modele.partie.Carte;

/**
 * Vue des cartes
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class VueCarte {
	
	
	/**
	 * Variable Carte qu'on va representer 
	 */
	private Carte carte;
	private JLabel image;
	private ImageIcon imageIcon;
	/**
	 * Chemin de l'img de la carte
	 */
	private String cheminImage;
	
	/**
	 * Constructeur de l'affichage graphique d'une carte
	 * @param carte Carte à représenter de façon graphique
	 */
	public VueCarte(Carte carte) {
		this.carte = carte;
		this.cheminImage = "img/" + carte.getForme() + carte.getCouleur()+ carte.getContenu() + ".jpg";
		this.image = new JLabel(new ImageIcon(cheminImage));
	}
	
	


	/**
	 * Getter de carte
	 * @return la carte à représenter
	 */
	public Carte getCarte() {
		return carte;
	}
	
	/**
	 * Getter de l'image
	 * @return l'image associée à la carte
	 */
	public JLabel getImage() {
		return image;
	}
	
	/**
	 * @return Le chemin de l'image
	 */
	public String getCheminImage() {
		return cheminImage;
	}

}

