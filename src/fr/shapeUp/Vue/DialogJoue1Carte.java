package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.shapeUp.modele.partie.Carte;
import fr.shapeUp.modele.partie.Carte.contenu;
import fr.shapeUp.modele.partie.Carte.couleurCarte;
import fr.shapeUp.modele.partie.Carte.formeCarte;

import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class DialogJoue1Carte extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VueCarte carteview ;
	Carte carteCourante = new Carte(formeCarte.Carre,couleurCarte.Bleue,contenu.Plein);
	Carte carteVictoire = new Carte(formeCarte.Rond,couleurCarte.Rouge,contenu.Vide);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogJoue1Carte dialog = new DialogJoue1Carte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogJoue1Carte() {
		setBounds(100, 100, 586, 537);
		this.setTitle("Jouer Carte");
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
	    this.setIconImage(icon);  
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Panel panCarteCourante = new Panel();
			panCarteCourante.setBounds(10, 44, 259, 331);
			contentPanel.add(panCarteCourante);
			
			JLabel imageCarte = new JLabel();
			carteview = new VueCarte(carteCourante);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage().getScaledInstance(202, 308, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarte.setIcon(imageIcon);
			
			panCarteCourante.add(imageCarte);
			
			
		}
		{
			Panel panCarteVictoire = new Panel();
			panCarteVictoire.setBounds(301, 44, 259, 331);
			contentPanel.add(panCarteVictoire);
			JLabel imageCarteVict = new JLabel();
			carteview = new VueCarte(carteVictoire);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage().getScaledInstance(202, 308, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarteVict.setIcon(imageIcon);
			
			panCarteVictoire.add(imageCarteVict);
		}
		{
			JPanel panChoixPosition = new JPanel();
			panChoixPosition.setBounds(155, 400, 259, 54);
			panChoixPosition.setBorder(BorderFactory.createTitledBorder("Choix de la position"));
			contentPanel.add(panChoixPosition);
			
			{
				JComboBox choixPosition = new JComboBox();
				choixPosition.setModel(new DefaultComboBoxModel(new String[] {"A0", "A1", "A2"}));
				choixPosition.setMaximumRowCount(10);
				choixPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panChoixPosition.add(choixPosition);
			}
		}
		
		{
			JLabel lblCarteVictoire = new JLabel("Carte Victoire");
			lblCarteVictoire.setBounds(388, 11, 84, 14);
			contentPanel.add(lblCarteVictoire);
		}
		
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
