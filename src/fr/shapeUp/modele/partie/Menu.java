package fr.shapeUp.modele.partie;

import java.util.Scanner;

import fr.shapeUp.modele.partie.*;
import fr.shapeUp.modele.partie.plateau.Plateau;
import fr.shapeUp.modele.partie.plateau.genererCercle;
import fr.shapeUp.modele.partie.plateau.genererRectangle;
import fr.shapeUp.modele.partie.plateau.genererTriangle;
import fr.shapeUp.modele.partie.plateau.Plateau.formePlateau;

/**
 * Classe principale, oriente le choix du type de partie, et s'occupe du déroulement
 * @author Adrien Warnet, Vincent Diop
 * @version 1.0
 */
public class Menu {

	private int ligne = 3;
	private int colonne = 5;

	
	/**
	 * Construteur
	 */
	public Menu() {
		System.out.println("Bonjour Bienvenue dans notre jeu Shape up!");
		System.out.println("@auteur Adrien Warnet, Vicent Diop");
		System.out.println();

	}

	/**
	 * Choix du plateau, nombre de joueur physique 
	 */
	public void nbrJoueurTypePlateau(int typePartie, int typePlateau, int nbrJoueurPhysique, int nbrJoueurVirtuels) {

		System.out.println("Vous voulez jouer avec les règles classique ou avancées ? 1 = classique, 2 = avancé ");
		if (typePartie == 1) {
			System.out.println("Nous jouons donc avec les regles classiques");
		}
		else {
			System.out.println("Nous jouons donc avec les regles avancées");
		}			
		System.out.println("Quel plateau souhaité vous avoir ? 1 = rectangle, 2 = disque, 3 = triangle ");
		Partie partie;
		if (typePlateau == 1) {
			partie = new Partie(formePlateau.rectangle);
			System.out.println("Le plateau est un rectangle");
		}
		else if (typePlateau == 2) {
			partie = new Partie(formePlateau.cercle);
			System.out.println("Le plateau est un cercle");
		}
		else {
			partie = new Partie(formePlateau.triangle);
			System.out.println("Le plateau est un triangle");
		}
		
			
		
		partie.plateau.afficherPlateau();
		System.out.println("Combien de Joueur ? 1 Joueur min et 3 Joueur max ");
		if (nbrJoueurPhysique > 3) {
			System.out.println("Il ne peut y avoir que 3 joueurs max, il y aura donc 3 joueurs dans cette partie");
			nbrJoueurPhysique = 3;
		}
		if (nbrJoueurPhysique < 1) {
			nbrJoueurPhysique = 1;
			System.out.println("Il doit y avoir au moins 1 joueurs");
		}
		
		partie.lancerPartie(nbrJoueurPhysique,nbrJoueurVirtuels,typePartie);
	}
}

	/**
	 * main 
	 */
//	public static void main(String[] args) {
//		Scanner saisiUser = new Scanner(System.in);
//		Menu partie = new Menu();
//		System.out.println("Vous voulez démarrer une partie ? 1 = oui / 2 = non ");
//		int demarrage = saisiUser.nextInt();
//		if (demarrage == 1) {
//			partie.nbrJoueurTypePlateau();
//		} else {
//			System.out.println("A bientôt");
//			System.exit(0);
//		}
//
//	}
//
//}
