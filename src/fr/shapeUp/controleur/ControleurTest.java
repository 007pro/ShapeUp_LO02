package fr.shapeUp.controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import fr.shapeUp.Vue.DialogPartie;
import fr.shapeUp.Vue.VueMenu;
import fr.shapeUp.modele.joueur.JoueurVirutel;
import fr.shapeUp.modele.partie.Comptage;
import fr.shapeUp.modele.partie.Menu;
import fr.shapeUp.modele.partie.Partie;

public class ControleurTest {

	private int currentPlayer = 0;
	private Partie partie;
	
	public ControleurTest(JButton btnDemarrer, ButtonGroup btnGrpNbJ, ButtonGroup btnGrpRegles, ButtonGroup btnGrpPlateau, VueMenu vueGraphique) {
		btnDemarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nbJP ;
				int nbJV ;
				int typePartie;
				int typePlateau;
				Menu menu = new Menu();
				menu.addObserver(vueGraphique);
				String nbJs = getSelectedButtonText(btnGrpNbJ);
				switch(nbJs) {
				case "2J":
					nbJP = 2;
					nbJV = 0;
					break;
				case "3J":
					nbJP = 3;
					nbJV = 0;
					break;
				case "1J 2IA":
					nbJP = 1;
					nbJV = 2;
					break;
				case "2J 1IA":
					nbJP = 2;
					nbJV = 1;
					break;
				case "1J 1IA":
					nbJP = 1;
					nbJV = 1;
					break;
				default:
					nbJP = 1;
					nbJV = 1;
				}
				
				String Regles = getSelectedButtonText(btnGrpRegles);
				switch(Regles) {
				case "Normal":
					typePartie = 1;
					break;
				case "Avanc\u00E9":
					typePartie = 2;
					break;
				default:
					typePartie = 1;
				}
				
				String Plateau = getSelectedButtonText(btnGrpPlateau);
				switch(Plateau) {
				case "Rectangle":
					typePlateau = 1;
					break;
				case "Triangle":
					typePlateau = 3;
					break;
				case "Cercle":
					typePlateau = 2;
					break;
				default:
					typePlateau = 1;
				}
				menu.nbrJoueurTypePlateau(typePartie, typePlateau, nbJP, nbJV);
				partie = menu.getPartie();
			}
		});
	}
	
	public void PartieInit(JButton btnNextTurn, DialogPartie vuePartie) {	
		btnNextTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(partie.getDeck().getNombreDeCartes() != 0 && !partie.getPlateau().rempli()) {
					if(partie.getJoueurs()[currentPlayer] instanceof JoueurVirutel) {
						partie.getJoueurs()[currentPlayer].jouerTour();
					}
					vuePartie.getLabelJoueurs()[currentPlayer].setForeground(Color.BLACK);
					currentPlayer = (currentPlayer + 1) % partie.getJoueurs().length;
					vuePartie.getLabelJoueurs()[currentPlayer].setForeground(Color.RED);
				}else {
					partie.getPlateau().accept(new Comptage(partie));	
					partie.nouveauTour();
				}
			}
		});
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
