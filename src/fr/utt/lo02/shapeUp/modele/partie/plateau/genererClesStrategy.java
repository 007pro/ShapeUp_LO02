package fr.utt.lo02.shapeUp.modele.partie.plateau;

import java.util.ArrayList;

/**
 * Interface de la arraylist, permettant de génerer les clès valides pour les plateaux
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public interface genererClesStrategy {
	public ArrayList<String> generer();
}
