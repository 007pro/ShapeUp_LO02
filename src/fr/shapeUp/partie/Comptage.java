package fr.shapeUp.partie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import fr.shapeUp.partie.Carte.*;
import fr.shapeUp.partie.plateau.Plateau;

public class Comptage implements CVisitor{
	
	private HashMap<formeCarte, Integer> scoreFormes = new HashMap<formeCarte, Integer>();
	private HashMap<contenu, Integer> scoreContenu = new HashMap<contenu, Integer>();
	private HashMap<couleurCarte, Integer> scoreCouleur = new HashMap<couleurCarte, Integer>();
	
	public void visitPlateau(Plateau plateau) {
		System.out.println("je compte");
		
		
		//Comptage couleurs
		LinkedHashMap<String, Carte> cases = plateau.getCases();
		char cleMaxChar = 'A';
		char cleMaxInt = '0';
		for(String cle : plateau.getClesValides()) {
			if(cle.charAt(0) > cleMaxChar) {
				cleMaxChar = cle.charAt(0);
			}
			if(cle.charAt(1) > cleMaxInt) {
				cleMaxInt = cle.charAt(1);
			}
		}
		// Par colonnes
		for(char i = '0' ; i <= cleMaxInt - 48 ; i++) {
			formeCarte formePrec = null;
			couleurCarte couleurPrec = null;
			contenu contenuPrec = null;
			ArrayList<Integer> combosForme = new ArrayList<Integer>();
			ArrayList<Integer> combosCouleur = new ArrayList<Integer>();
			ArrayList<Integer> combosContenu = new ArrayList<Integer>();
			int idxForme = 1;
			int idxCouleur = 1;
			int idxContenu = 1;
			for(char j = 'A' ; j <= cleMaxChar ; j++) {
				String cle = j + Character.toString(i);
				if(cases.containsKey(cle)) {
					Carte carte = cases.get(cle);
					if(carte.getForme() == formePrec) {
						idxForme++;
					}else {
						combosForme.add(idxForme);
						idxForme = 1;
					}
					
					if(carte.getCouleur() == couleurPrec) {
						idxCouleur++;
					}else {
						combosCouleur.add(idxCouleur);
						idxCouleur = 1;
					}
					
					if(carte.getContenu() == contenuPrec) {
						idxContenu++;
					}else {
						combosContenu.add(idxContenu);
						idxContenu = 1;
					}
					
					formePrec = carte.getForme();
					couleurPrec = carte.getCouleur();
					contenuPrec = carte.getContenu();
				}
			}
		}
		
	}
}
