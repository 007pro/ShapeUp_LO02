package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogJoue2Cartes extends JDialog implements Observer {

	private final JPanel contentPanel = new JPanel();

	private VueCarte carteview;

	// TODO modifier par les cartes victoire et courante
	Carte carteVictoire = new Carte(formeCarte.Rond, couleurCarte.Rouge, contenu.Vide);
	Carte carte1 = new Carte(formeCarte.Carre, couleurCarte.Bleue, contenu.Plein);
	Carte carte2 = new Carte(formeCarte.Triangle, couleurCarte.Vert, contenu.Vide);

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
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
					.getScaledInstance(180, 290, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarteVict.setIcon(imageIcon);

			panCarteVictoire.add(imageCarteVict);
		}
		{

			Panel panCarte1 = new Panel();

			panCarte1.setBounds(238, 37, 202, 308);
			contentPanel.add(panCarte1);

			JLabel imageCarte1 = new JLabel();
			carteview = new VueCarte(carte1);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
					.getScaledInstance(180, 290, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarte1.setIcon(imageIcon);
			if (carte1 != null) {
				panCarte1.add(imageCarte1);
			}

		}
		{
			Panel panCarte2 = new Panel();

			panCarte2.setBounds(456, 37, 202, 308);
			contentPanel.add(panCarte2);

			JLabel imageCarte2 = new JLabel();
			carteview = new VueCarte(carte2);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(carteview.getCheminImage()).getImage()
					.getScaledInstance(180, 290, Image.SCALE_DEFAULT)); // permet de redimensionner une image
			imageCarte2.setIcon(imageIcon);
			panCarte2.add(imageCarte2);

		}

		JPanel panChoixPosition = new JPanel();
		panChoixPosition.setBorder(BorderFactory.createTitledBorder("Choix de la position"));
		panChoixPosition.setBounds(399, 356, 259, 54);
		contentPanel.add(panChoixPosition);
		JComboBox choixPosition = new JComboBox();
		choixPosition.setModel(new DefaultComboBoxModel(new String[] { "A0", "A1", "A2" }));
		choixPosition.setMaximumRowCount(10);
		choixPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panChoixPosition.add(choixPosition);

		JLabel lblCarteVictoire = new JLabel("Carte victoire");
		lblCarteVictoire.setBounds(73, 17, 94, 14);
		contentPanel.add(lblCarteVictoire);

		JPanel panChoixCarte = new JPanel();
		panChoixCarte.setBorder(BorderFactory.createTitledBorder("Choix de la carte"));
		panChoixCarte.setBounds(10, 356, 259, 54);
		contentPanel.add(panChoixCarte);

		JComboBox choixCarte = new JComboBox();
		choixCarte.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		choixCarte.setMaximumRowCount(10);
		choixCarte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panChoixCarte.add(choixCarte);

		JLabel lblCarte1 = new JLabel("Carte n\u00B01");
		lblCarte1.setBounds(311, 17, 53, 14);
		contentPanel.add(lblCarte1);

		JLabel lblCarte2 = new JLabel("Carte n\u00B02");
		lblCarte2.setBounds(538, 17, 53, 14);
		contentPanel.add(lblCarte2);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		// event
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String positionCarte = (String) choixPosition.getSelectedItem();
				String laCarteChoisis = (String) choixCarte.getSelectedItem();
				setVisible(false);

			}
		});

	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	/*
	 * panCarte2.addMouseListener(new MouseAdapter() {
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { if
	 * (imageCarte2.getBorder() ==null) {
	 * imageCarte2.setBorder(BorderFactory.createLineBorder(Color.red)); } else {
	 * imageCarte2.setBorder(null); } } });
	 */// pour select une carte mais je n'arrive pas a en selectionner 2

	
}
