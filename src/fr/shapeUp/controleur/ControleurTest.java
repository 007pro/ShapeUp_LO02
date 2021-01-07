package fr.shapeUp.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.shapeUp.modele.partie.Menu;

public class ControleurTest {

	public ControleurTest(JButton btnDemarrer) {
		btnDemarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.nbrJoueurTypePlateau();
			}
		});
	}
}
