package fr.shapeUp.partie;

import java.util.Random;



//Ceci est une carte !
public class Carte {
	
	public enum LesCartes {
		Carré,
		Rond,
		Triangle

	}

	public static LesCartes randomCarte() {
	    int pick = new Random().nextInt(LesCartes.values().length);
	    return LesCartes.values()[pick];
	}

}
