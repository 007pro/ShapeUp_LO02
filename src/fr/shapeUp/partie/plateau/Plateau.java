package fr.shapeUp.partie.plateau;
import java.util.*;

import fr.shapeUp.partie.CVisitor;
import fr.shapeUp.partie.Carte;
import fr.shapeUp.partie.VComptage;

public class Plateau implements VComptage{
	private ArrayList<String> clesValides;
	LinkedHashMap<String, Carte> cases;
	private boolean premCarte = true;
	private formePlateau formeP;
	
	
	public enum formePlateau{
		rectangle,
		triangle,
		cercle
	}
	
	public Plateau(formePlateau forme){
		genererClesStrategy strategy;
		this.formeP = forme;
		this.cases = new LinkedHashMap<String, Carte>();
		
		switch(forme) {
		case rectangle :
			strategy = new genererRectangle(); 
			this.clesValides = strategy.generer();
			break;
		case triangle :
			strategy = new genererTriangle(); 
			this.clesValides = strategy.generer();
			break;
		case cercle :
			strategy = new genererCercle(); 
			this.clesValides = strategy.generer();
			break;
		}
		
		
	}
	
	public void resetPlateau(){
		this.cases = new LinkedHashMap<String, Carte>();
		this.premCarte = true;
	}
	
	public boolean placerCarte(String position, Carte carte) {
		if(this.clesValides.contains(position) && !this.cases.containsKey(position)) {
			String auDessus = Character.toString(position.charAt(0) - 1) + position.charAt(1) ;
			String enDessous = Character.toString(position.charAt(0) + 1) + position.charAt(1) ;
			String aDroite = position.charAt(0) + Integer.toString(position.charAt(1) - 48 + 1) ;
			String aGauche = position.charAt(0) + Integer.toString(position.charAt(1) - 48 - 1) ;
			if(this.cases.containsKey(auDessus) || this.cases.containsKey(enDessous) || this.cases.containsKey(aDroite) || this.cases.containsKey(aGauche) || this.premCarte) {
				this.premCarte = false;
				this.cases.put(position, carte);
				return true;
			}
		}
		return false;
	}
	
	public Carte retirerCarte(String position) {
		if(this.clesValides.contains(position)) {
			Carte carteRetiree = this.cases.remove(position);
			return carteRetiree;
		}
		return null;
	}
	
	public void afficherPlateau(){
		System.out.println("Voici le plateau :");
		System.out.print("\n\n");
		System.out.println(this.cases);
	}
	
	public boolean rempli() {
		if(this.cases.size() == this.clesValides.size()) {
			return true;
		}
		return false;
	}
	
	public void accept(CVisitor visitor) {
		visitor.visitPlateau(this);
	}
	
	public ArrayList<String> getClesValides() {
		return this.clesValides;
	}

	public LinkedHashMap<String, Carte> getCases(){
		return this.cases;
	}
}
