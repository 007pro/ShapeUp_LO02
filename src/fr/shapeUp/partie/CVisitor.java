package fr.shapeUp.partie;

import fr.shapeUp.partie.plateau.Plateau;

public interface CVisitor {
	void visitPlateau(Plateau plateau);
}
