package fr.shapeUp.Vue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.shapeUp.modele.partie.Carte;

public class VueCarte {
	
	private Carte carte;
	private JLabel image;
	private ImageIcon imageIcon;
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
	
	public String getCheminImage() {
		return cheminImage;
	}

}

