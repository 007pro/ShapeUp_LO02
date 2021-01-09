package fr.shapeUp.modele.partie.plateau;
import java.util.*;

import fr.shapeUp.modele.partie.CVisitor;
import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.VComptage;

/**
 * Classe de la cr�ation du plateau
 * 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class Plateau extends Observable implements VComptage{
	private ArrayList<String> clesValides;
	LinkedHashMap<String, Carte> cases;
	private boolean premCarte = true;
	private formePlateau formeP;
	
	/**
	 * enum des diff�rentes forme du plateau
	 * @author Adrien Warnet, Vincent Diop
	 *
	 */
	public enum formePlateau{
		rectangle,
		triangle,
		cercle
	}
	
	/**
	 * Constructeur du plateau 
	 * @param forme Forme souhait�e du plateau
	 */
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
	
	/**
	 * Pour reset le plateau
	 */
	public void resetPlateau(){
		this.cases = new LinkedHashMap<String, Carte>();
		this.premCarte = true;
		this.setChanged();
		this.notifyObservers("reset");
	}
	
	/**
	 * Permet de placer une carte sur le plateau 
	 * 
	 * @param position position de la carte
	 * @param carte la carte qui va �tre pos�e
	 * @return true ou false 
	 */
	public boolean placerCarte(String position, Carte carte) {
		if(this.clesValides.contains(position) && !this.cases.containsKey(position)) {
			String auDessus = Character.toString(position.charAt(0) - 1) + position.charAt(1) ;
			String enDessous = Character.toString(position.charAt(0) + 1) + position.charAt(1) ;
			String aDroite = position.charAt(0) + Integer.toString(position.charAt(1) - 48 + 1) ;
			String aGauche = position.charAt(0) + Integer.toString(position.charAt(1) - 48 - 1) ;
			if(this.cases.containsKey(auDessus) || this.cases.containsKey(enDessous) || this.cases.containsKey(aDroite) || this.cases.containsKey(aGauche) || this.premCarte) {
				this.premCarte = false;
				this.cases.put(position, carte);
				this.setChanged();
				this.notifyObservers(position);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retirer une carte du plateau 
	 * @param position position de la carte � retirer
	 * @return la carte 
	 */
	public Carte retirerCarte(String position) {
		if(this.clesValides.contains(position)) {
			Carte carteRetiree = this.cases.remove(position);
			this.setChanged();
			this.notifyObservers(position);
			return carteRetiree;
		}
		return null;
	}
	
	/**
	 * Permet d'afficher le plateau
	 */
	public void afficherPlateau(){
		System.out.println("Voici le plateau :");
		System.out.print("\n\n");
		System.out.println(this.cases);
	}
	
	/**
	 * permet de verifier 
	 * @return true ou false
	 */
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