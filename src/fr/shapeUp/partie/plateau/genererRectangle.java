package fr.shapeUp.partie.plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class genererRectangle implements genererClesStrategy {
	@Override
	public ArrayList<String> generer(){
		ArrayList<String> cles = new ArrayList<String>();
		Scanner saisiUser = new Scanner(System.in);
		System.out.println("Veuillez indiquer la largeur puis la hauteur du plateau");
		int largeur = saisiUser.nextInt();
		int hauteur = saisiUser.nextInt();
		for(char ligneChar = 'A'; ligneChar < (65 + hauteur); ligneChar++) {
			for(int colonne = 0; colonne < largeur; colonne++) {
				cles.add(ligneChar + Integer.toString(colonne));
			}
		}
		Collections.sort(cles);
		return cles;
	}
}
