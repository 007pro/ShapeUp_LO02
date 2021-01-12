package fr.utt.lo02.shapeUp.modele.partie;

import fr.utt.lo02.shapeUp.modele.partie.plateau.Plateau;

/**
 * interface CVisitor
 * @author Adrien Warnet, Vincent Diop
 *
 */
public interface CVisitor {
	void visitPlateau(Plateau plateau);
}
