package fr.shapeUp.partie;

import fr.shapeUp.partie.plateau.Plateau;

public class Comptage implements CVisitor{
	
	public void visit(Plateau plateau) {
		plateau.accept(this);
	}
}
