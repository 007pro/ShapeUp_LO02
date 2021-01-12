package fr.utt.lo02.shapeUp.modele.partie.plateau;

import java.util.ArrayList;

/**
 * Interface de la arraylist, permettant de g�nerer les cl�s valides pour les plateaux
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public interface genererClesStrategy {
	public ArrayList<String> generer();
}
