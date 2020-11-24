package fr.shapeUp.partie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import fr.shapeUp.partie.Carte.*;
import fr.shapeUp.partie.plateau.Plateau;

public class Comptage implements CVisitor{
	
	private HashMap<formeCarte, Integer> scoreFormes = new HashMap<formeCarte, Integer>();
	private HashMap<contenu, Integer> scoreContenus = new HashMap<contenu, Integer>();
	private HashMap<couleurCarte, Integer> scoreCouleurs = new HashMap<couleurCarte, Integer>();
	
	public void visitPlateau(Plateau plateau) {
		System.out.println("je compte");
		
		
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
		
		
		
		for(int i = 0; i < couleurCarte.values().length; i++) {
			scoreCouleurs.put(couleurCarte.values()[i], 0);
		}
		for(int i = 0; i < formeCarte.values().length; i++) {
			scoreFormes.put(formeCarte.values()[i], 0);
		}
		for(int i = 0; i < contenu.values().length; i++) {
			scoreContenus.put(contenu.values()[i], 0);
		}
		
		
		
		// Par colonnes
		for(char i = '0' ; i <= cleMaxInt - 48 ; i++) {
			formeCarte formePrec = null;
			couleurCarte couleurPrec = null;
			contenu contenuPrec = null;
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
						if(idxForme >= 2) {
							scoreFormes.put(formePrec, scoreFormes.get(formePrec) + idxForme - 1);
						}
						idxForme = 1;
					}
					
					if(carte.getCouleur() == couleurPrec) {
						idxCouleur++;
					}else {
						if(idxCouleur >= 3) {
							scoreCouleurs.put(couleurPrec, scoreCouleurs.get(couleurPrec) + idxForme + 1);
						}
						idxCouleur = 1;
					}
					
					if(carte.getContenu() == contenuPrec) {
						idxContenu++;
					}else {
						if(idxContenu >= 3) {
							scoreContenus.put(contenuPrec, scoreContenus.get(contenuPrec) + idxForme);
						}
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

