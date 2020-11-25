package fr.shapeUp.partie;

import fr.shapeUp.partie.plateau.Plateau;

/**
 * interface CVisitor
 * @author Adrien Warnet, Vincent Diop
 *
 */
public interface CVisitor {
	void visitPlateau(Plateau plateau);
}
