package fr.shapeUp.partie.plateau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe permettant de générer un plateau circulaire 
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class genererCercle implements genererClesStrategy {
	
	/**
	 * Génère la liste représentant le plateau
	 */
	@Override
	public ArrayList<String> generer(){
		ArrayList<String> cles = new ArrayList<String>();
		Scanner saisiUser = new Scanner(System.in);
		System.out.println("Veuillez indiquer le rayon du cercle (multiples de 0,5 acceptés)");
		double rayon = saisiUser.nextDouble();
		for(int i=0;i<rayon*2;i++) {
	        for(int j=0;j<rayon*2;j++){
	        	double x = (2*(double)i + 1)/2;
	        	double y = (2*(double)j + 1)/2;
	            double d = Math.sqrt((x-rayon)*(x-rayon)+(y-rayon)*(y-rayon));
	                if(d < rayon) {
	                	cles.add((char)(j + 65) + Integer.toString(i));
	                }           
	        }
		}
		Collections.sort(cles);
		return cles;
	}
}
