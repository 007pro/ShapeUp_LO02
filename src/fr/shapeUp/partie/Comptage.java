package fr.shapeUp.partie;

public class Comptage implements CVisitor{
	
	public void visit(Plateau plateau) {
		plateau.accept(this);
	}
}
