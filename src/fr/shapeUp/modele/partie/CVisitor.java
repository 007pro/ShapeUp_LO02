package fr.shapeUp.modele.partie;

import fr.shapeUp.modele.partie.plateau.Plateau;

/**
 * interface CVisitor
 * @author Adrien Warnet, Vincent Diop
 *
 */
public interface CVisitor {
	void visitPlateau(Plateau plateau);
}
