package fr.shapeUp.partie;

import java.util.Scanner;

import fr.shapeUp.partie.*;
import fr.shapeUp.partie.Partie;

public class Menu {

	Scanner saisiUseur = new Scanner(System.in);
	private int ligne = 3;
	private int colonne = 5;

	Menu() {
		System.out.println("Bonjour Bienvenue dans notre jeu Shape up!");
		System.out.println("@auteur Adrien Warnet, Vicent Diop");
		System.out.println();

	}

	public void nbrJoueurTypePlateau() {

		System.out.println("Quel plateau souhaité vous avoir ? 1 = rectangle, 2 = disque, 3 = triangle ");
		int typePlateau = saisiUseur.nextInt();
		if (typePlateau == 1) {
			ligne = 3;
			colonne = 5;
		} else {
			System.out.println("Vous avez le plateau rectangle par defaut");
		}
		Partie partie = new Partie(colonne, ligne);
		partie.plateau.afficherPlateau();
		System.out.println("Combien de Joueur ? 1 Joueur min et 3 Joueur max ");
		int nbrJoueurPhysique = saisiUseur.nextInt();
		if (nbrJoueurPhysique > 3) {
			System.out.println("Il ne peut y avoir que 3 joueurs max, il y aura donc 3 joueurs dans cette partie");
			nbrJoueurPhysique = 3;
		}
		if (nbrJoueurPhysique < 1) {
			nbrJoueurPhysique = 1;
			System.out.println("Il doit y avoir au moins 1 joueurs");
		}
		partie.lancerPartie(nbrJoueurPhysique);

	}

	public static void main(String[] args) {
		Scanner saisiUser = new Scanner(System.in);
		Menu partie = new Menu();
		System.out.println("Vous voulez démarrer une partie ? 1 = oui / 2 = non ");
		int demarrage = saisiUser.nextInt();
		if (demarrage == 1) {
			partie.nbrJoueurTypePlateau();
		} else {
			System.out.println("A bientôt");
			System.exit(0);
		}

	}

}
