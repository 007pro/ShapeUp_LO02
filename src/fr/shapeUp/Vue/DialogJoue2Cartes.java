package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Carte.contenu;
import fr.shapeUp.modele.partie.Carte.couleurCarte;
import fr.shapeUp.modele.partie.Carte.formeCarte;

import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DialogJoue2Cartes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private VueCarte carteview ;

	//TODO modifier par les cartes victoire et courante
	Carte carteVictoire = new Carte(formeCarte.Rond,couleurCarte.Rouge,contenu.Vide);
	Carte carte1 = new Carte(formeCarte.Carre,couleurCarte.Bleue,contenu.Plein);
	Carte carte2 = new Carte(formeCarte.Triangle,couleurCarte.Vert,contenu.Vide);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogJoue2Cartes dialog = new DialogJoue2Cartes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * Create the dialog.
	 */
	public DialogJoue2Cartes() {
		setBounds(100, 100, 687, 493);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
	    this.setIconImage(icon);  
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Panel panCarteVictoire = new Panel();
			panCarteVictoire.setBounds(10, 37, 202, 308);
			contentPanel.add(panCarteVictoire);
			
			JLabel imageCarteVict = new JLabel();
			carteview = new VueCarte(carteVictoire);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage().getScaledInstance(202, 308, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarteVict.setIcon(imageIcon);
			
			panCarteVictoire.add(imageCarteVict);
		}
		{
			
			Panel panCarte1 = new Panel();
			panCarte1.setBounds(238, 37, 202, 308);
			contentPanel.add(panCarte1);
			
			JLabel imageCarte1 = new JLabel();
			carteview = new VueCarte(carte1);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage().getScaledInstance(202, 308, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarte1.setIcon(imageIcon);
			if (carte1!=null) {
				panCarte1.add(imageCarte1);
			}
			
			
		}
		{
			Panel panCarte2 = new Panel();
			panCarte2.setBounds(456, 37, 202, 308);
			contentPanel.add(panCarte2);
			
			JLabel imageCarte2 = new JLabel();
			carteview = new VueCarte(carte2);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage().getScaledInstance(202, 308, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarte2.setIcon(imageIcon);
			panCarte2.add(imageCarte2);
		}
		{
			JPanel panChoixPosition = new JPanel();
			panChoixPosition.setBorder(BorderFactory.createTitledBorder("Choix de la position"));
			panChoixPosition.setBounds(215, 356, 259, 54);
			contentPanel.add(panChoixPosition);
			{
				JComboBox choixPosition = new JComboBox();
				choixPosition.setModel(new DefaultComboBoxModel(new String[] {"A0", "A1", "A2"}));
				choixPosition.setMaximumRowCount(10);
				choixPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panChoixPosition.add(choixPosition);
			}
		}
		
		JLabel lblCarteVictoire = new JLabel("Carte victoire");
		lblCarteVictoire.setBounds(73, 17, 94, 14);
		contentPanel.add(lblCarteVictoire);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
