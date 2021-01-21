package fr.utt.lo02.shapeUp.modele.joueur;

import java.util.List;
import java.util.Random;

import fr.utt.lo02.shapeUp.modele.joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.partie.Carte;
import fr.utt.lo02.shapeUp.modele.partie.Comptage;
import fr.utt.lo02.shapeUp.modele.partie.Partie;
import fr.utt.lo02.shapeUp.modele.partie.plateau.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Classe fille de Joueur, joueu automatiquement.
 * 
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */

public class JoueurVirutel extends Joueur {

	boolean tourAutreJoueurFini;
	String position;
	ArrayList<String> recupID = partie.getPlateau().getClesValides();

	/**
	 * Constructeur du Joueur Virtuel
	 * @param partie la partie en cours
	 * @param numJoueur le numéro du joueur
	 * @param typePartie le type de partie 
	 */
	public JoueurVirutel(Partie partie, int numJoueur, int typePartie) {
		super(partie, numJoueur, typePartie);
	}

	public boolean poserCarte(String position) {
		boolean cartePlacé = partie.getPlateau().placerCarte(position, this.carteCourante);

		if (cartePlacé == true) {
//			System.out.print("La carte posé est ");
//			carteCourante.afficherCarte();
//			System.out.println("\nest elle est posé en " + position);
			return true;
		} else if (cartePlacé == false) {
			return false;
		}

		return false;

	}

	@Override
	public void jouerTour() {
		if (getTypePartie() == 1) {
			jouerTourClassique();
		}
		else {
			jouerTourAvancé();
		}
		
		
	}
	
	public void modeDif() {
		LinkedHashMap<String, Carte> casespleine = partie.getPlateau().getCases();
		
	}

	@Override
	public void jouerTourAvancé() {
		int i = 0;
		boolean fonctionne;
		int numCarte = 0;
		Random random = new Random();
		afficherMain(this.mainCourante);
		if (this.mainCourante[0] != null && this.mainCourante[1] != null) {
			numCarte = random.nextInt(2);
		}
		else if (this.mainCourante[0] == null) {
			numCarte = 1;
		}
		else if (this.mainCourante[1] == null) {
			numCarte = 0;
		}
		
		do {
			fonctionne = poserCarteOfMain(partie.getPlateau().getClesValides().get(i),numCarte);
			i++;
		} while (fonctionne == false);
		
		int choix = new Random().nextInt(3);
		if(choix == 0) {
			deplacerCarte();
		}
		
		afficherMain(this.mainCourante);
	}

	@Override
	public void jouerTourClassique() {
		int i = 0;
		boolean fonctionne;
		super.piocher();
		System.out.println("\nJoueur Virtuel joue");
		position = getPosition();
		do {
			fonctionne = poserCarte(partie.getPlateau().getClesValides().get(i));
			i++;
		} while (fonctionne == false);

		int choix = new Random().nextInt(3);
		if(choix == 0) {
			deplacerCarte();
		}
			
		super.finTour();
		
	}

	@Override
	public boolean poserCarteOfMain(String position, int numCarte) {
		boolean cartePlacé = partie.getPlateau().placerCarte(position,this.mainCourante[numCarte ]);
		this.mainCourante[numCarte] = partie.getDeck().piocher();
		if (mainCourante[numCarte] == null) {
			System.out.println("Le deck est vide");
		}
		if (cartePlacé == true) {
			System.out.println("Vous avez posé votre carte en " + position);
			return true;
		} 
		
		return false;
	}

	@Override
	public void deplacerCarte() {
		Carte carteRetiré;
		boolean carteHere;
		Random rand = new Random();
		do {
//			System.out.println("La carte est à quelle position ? ");
			String positionCarteADeplacer = recupID.get(rand.nextInt(recupID.size())) ;
			carteRetiré = partie.getPlateau().retirerCarte(positionCarteADeplacer);
			if (carteRetiré == null) {
//				System.out.println("il n'y a pas de carte ici");
			}
		} while (carteRetiré == null);

		do {
//			System.out.println("Poser la carte à quelle position ? ");
			String newPosition = recupID.get(rand.nextInt(recupID.size())) ;
			carteHere = partie.getPlateau().placerCarte(newPosition, carteRetiré);
		} while (carteHere == false);
//		System.out.println("Carte déplacée par le joueur virtuel ");

		
	}
	
	
	
	}