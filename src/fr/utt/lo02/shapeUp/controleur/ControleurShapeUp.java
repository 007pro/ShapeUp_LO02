package fr.utt.lo02.shapeUp.controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import fr.utt.lo02.shapeUp.Vue.DialogPartie;
import fr.utt.lo02.shapeUp.Vue.VueMenu;
import fr.utt.lo02.shapeUp.modele.joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.joueur.JoueurVirutel;
import fr.utt.lo02.shapeUp.modele.partie.Carte;
import fr.utt.lo02.shapeUp.modele.partie.Comptage;
import fr.utt.lo02.shapeUp.modele.partie.Menu;
import fr.utt.lo02.shapeUp.modele.partie.Partie;


/**
 * Controleur du jeu 
 * @author Adrien Warnet, Vincent Diop
 *
 */
public class ControleurShapeUp {

	/**
	 * Le num�ro du joueur
	 */
	private int currentPlayer = 0;
	/**
	 * La phase de d�placement
	 */
	private int phaseDeplacement = 1;
	/**
	 * Carte deplac�e
	 */
	private Carte carteDepl;
	
	
	/**
	 * @return La phase de deplacement
	 */
	public int getPhaseDeplacement() {
		return phaseDeplacement;
	}

	/**
	 * @return La carte d�plac�e
	 */
	public Carte getCarteDepl() {
		return carteDepl;
	}

	/**
	 * @return Le numero du joueur
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * La partie 
	 */
	private Partie partie;
	
	/**
	 * Constructeur du controleur
	 * @param btnDemarrer
	 * @param btnGrpNbJ
	 * @param btnGrpRegles
	 * @param btnGrpPlateau
	 * @param vueGraphique
	 * @param btnQuitter
	 */
	public ControleurShapeUp(JButton btnDemarrer, ButtonGroup btnGrpNbJ, ButtonGroup btnGrpRegles, ButtonGroup btnGrpPlateau, VueMenu vueGraphique, JButton btnQuitter) {
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
				partie.getJoueurs()[currentPlayer].piocher();
			}
		});
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Initialisation de la partie
	 * @param btnNextTurn
	 * @param btnPlacer
	 * @param btnDeplace
	 * @param btnPos
	 * @param vuePartie
	 * @param btnQuitter
	 */
	public void PartieInit(JButton btnNextTurn,JButton btnPlacer, JButton btnDeplace, LinkedHashMap<String, JToggleButton> btnPos , DialogPartie vuePartie, JButton btnQuitter) {	
		btnNextTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(partie.getNumTour() < 5) {
					phaseDeplacement = 1;
					partie.getDeck().addObserver(vuePartie);
					btnPlacer.setVisible(true);
					btnDeplace.setVisible(true);
					btnNextTurn.setEnabled(false);
					btnPlacer.setEnabled(true);
					btnDeplace.setEnabled(true);
					vuePartie.getLabelJoueurs()[currentPlayer].setForeground(Color.BLACK);
					currentPlayer = (currentPlayer + 1) % partie.getJoueurs().length;
					vuePartie.getLabelJoueurs()[currentPlayer].setForeground(Color.RED);
					if(partie.getDeck().getNombreDeCartes() != 0 && !partie.getPlateau().rempli()) {
						if(partie.getJoueurs()[currentPlayer] instanceof JoueurVirutel) {
							btnPlacer.setVisible(false);
							btnDeplace.setVisible(false);
							btnNextTurn.setEnabled(true);
							partie.getJoueurs()[currentPlayer].jouerTour();
						}else {
							partie.getJoueurs()[currentPlayer].piocher();
						}
					}else {
						Comptage comptage = new Comptage(partie);
						comptage.addObserver(vuePartie);
						partie.getPlateau().accept(comptage);
						partie.nouveauTour();
					}
				}else {
					System.out.println("Fin de la partie");
				}
			}
		});
		btnPlacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getSelectedButtonPos(btnPos) != null) {
					if(partie.getJoueurs()[currentPlayer].poserCarte(getSelectedButtonPos(btnPos))) {
						btnPlacer.setEnabled(false);
						btnNextTurn.setEnabled(true);
					}
				}
				}
		});
		btnDeplace.addActionListener(new ActionListener() {
			boolean PwasEnabled = false;
			boolean NwasEnabled = false;
			public void actionPerformed(ActionEvent e) {
				if(getSelectedButtonPos(btnPos) != null) {
					if(phaseDeplacement == 1) {
						carteDepl = ((JoueurPhysique)partie.getJoueurs()[currentPlayer]).deplacerCartePh1(getSelectedButtonPos(btnPos));
						if(carteDepl != null) {
							if(btnPlacer.isEnabled()) PwasEnabled = true;
							if(btnNextTurn.isEnabled()) NwasEnabled = true;
							btnPlacer.setEnabled(false);
							btnNextTurn.setEnabled(false);
							phaseDeplacement = 2;
						}
					}else {
						if(((JoueurPhysique)partie.getJoueurs()[currentPlayer]).deplacerCartePh2(carteDepl, getSelectedButtonPos(btnPos))) {
							btnDeplace.setEnabled(false);
							if(PwasEnabled) btnPlacer.setEnabled(true);
							if(NwasEnabled) btnNextTurn.setEnabled(true);
							phaseDeplacement = 1;
						}
					}
				}
			}
		});
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * @param buttonGroup
	 * @return La valeur de la key fournit par la vue text
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	/**
	 * @param btnPos
	 * @return La valeur de la key fournit par la vue partie
	 */
	public String getSelectedButtonPos(LinkedHashMap<String, JToggleButton> btnPos) {
		for(Map.Entry<String, JToggleButton> entry : btnPos.entrySet()) {
		    String key = entry.getKey();
		    JToggleButton value = entry.getValue();

            if (value.isSelected()) {
                return key;
            }
        }

        return null;
    }
}
