package fr.shapeUp.partie.plateau;

import java.util.ArrayList;
import java.util.Scanner;

public class genererTriangle implements genererClesStrategy {
	@Override
	public ArrayList<String> generer(){
		ArrayList<String> cles = new ArrayList<String>();
		Scanner saisiUser = new Scanner(System.in);
		System.out.println("Veuillez indiquer la hauteur du triangle");
		int hauteur = saisiUser.nextInt();
		int charDepart  = 64 + hauteur;
		int j = 1 + (2*(hauteur-1));
		int i = 0;
		for(char ligneChar = (char)charDepart; ligneChar >= 'A'; ligneChar--) {
			for(int colonne = i; colonne<j ; colonne++) {
				cles.add(ligneChar + Integer.toString(colonne));
			}
			i++;
			j--;
		}
		return cles;
	}
}
