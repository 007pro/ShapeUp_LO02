package fr.shapeUp.partie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import fr.shapeUp.joueur.Joueur;
import fr.shapeUp.partie.Carte.*;
import fr.shapeUp.partie.plateau.Plateau;

/**
 * Classe pour compter les points à la fin du round
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Comptage implements CVisitor{
	
	private HashMap<formeCarte, Integer> scoreFormes = new HashMap<formeCarte, Integer>();
	private HashMap<contenu, Integer> scoreContenus = new HashMap<contenu, Integer>();
	private HashMap<couleurCarte, Integer> scoreCouleurs = new HashMap<couleurCarte, Integer>();
	private Partie partie;
	
	/**
	 * Constructeur
	 * @param partie partie en cours
	 */
	Comptage(Partie partie){
		this.partie = partie;
	}
	
	
	/**
	 * Méthode pour compter les points 
	 * @param plateau
	 */
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
		for(char i = '0' ; i <= cleMaxInt; i++) {
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
							scoreCouleurs.put(couleurPrec, scoreCouleurs.get(couleurPrec) + idxCouleur + 1);
						}
						idxCouleur = 1;
					}
					
					if(carte.getContenu() == contenuPrec) {
						idxContenu++;
					}else {
						if(idxContenu >= 3) {
							scoreContenus.put(contenuPrec, scoreContenus.get(contenuPrec) + idxContenu);
						}
						idxContenu = 1;
					}
					
					formePrec = carte.getForme();
					couleurPrec = carte.getCouleur();
					contenuPrec = carte.getContenu();
				}
				
			}
			if(idxForme >= 2) {
				scoreFormes.put(formePrec, scoreFormes.get(formePrec) + idxForme - 1);
			}
			if(idxCouleur >= 3) {
				scoreCouleurs.put(couleurPrec, scoreCouleurs.get(couleurPrec) + idxCouleur + 1);
			}
			if(idxContenu >= 3) {
				scoreContenus.put(contenuPrec, scoreContenus.get(contenuPrec) + idxContenu);
			}
		}
		
		
		// Par lignes
				for(char j = 'A' ; j <= cleMaxChar; j++) {
					formeCarte formePrec = null;
					couleurCarte couleurPrec = null;
					contenu contenuPrec = null;
					int idxForme = 1;
					int idxCouleur = 1;
					int idxContenu = 1;
					for(char i = '0' ; i <= cleMaxInt ; i++) {
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
									scoreCouleurs.put(couleurPrec, scoreCouleurs.get(couleurPrec) + idxCouleur + 1);
								}
								idxCouleur = 1;
							}
							
							if(carte.getContenu() == contenuPrec) {
								idxContenu++;
							}else {
								if(idxContenu >= 3) {
									scoreContenus.put(contenuPrec, scoreContenus.get(contenuPrec) + idxContenu);
								}
								idxContenu = 1;
							}
							
							formePrec = carte.getForme();
							couleurPrec = carte.getCouleur();
							contenuPrec = carte.getContenu();
						}
					}
					if(idxForme >= 2) {
						scoreFormes.put(formePrec, scoreFormes.get(formePrec) + idxForme - 1);
					}
					if(idxCouleur >= 3) {
						scoreCouleurs.put(couleurPrec, scoreCouleurs.get(couleurPrec) + idxCouleur + 1);
					}
					if(idxContenu >= 3) {
						scoreContenus.put(contenuPrec, scoreContenus.get(contenuPrec) + idxContenu);
					}
				}
	System.out.println(scoreFormes);
	System.out.println(scoreCouleurs);
	System.out.println(scoreContenus);
	
	for(Joueur joueur : partie.getJoueurs()) {
		joueur.setScore(joueur.getScore() + scoreFormes.get(joueur.getCarteVictoire().getForme()));
		joueur.setScore(joueur.getScore() + scoreCouleurs.get(joueur.getCarteVictoire().getCouleur()));
		joueur.setScore(joueur.getScore() + scoreContenus.get(joueur.getCarteVictoire().getContenu()));
		System.out.println("Score du joueur " + joueur.getScore());
	}
	
	}
	
}

