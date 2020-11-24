package fr.shapeUp.partie;

import fr.shapeUp.partie.plateau.Plateau;

public class Comptage implements CVisitor{
	
	public void visitPlateau(Plateau plateau) {
		System.out.println("je compte");
		
		
		//Comptage couleurs
		for(String cle : plateau.getClesValides()) {
			
		}
	}
}
