package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DialogJoue2Cartes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//TODO rezise la taille des images pour quelle rentre dans bien de jPanel
	JLabel image = new JLabel(new ImageIcon("img/CarreBleueVide.jpg"));
	JLabel image2 = new JLabel(new ImageIcon("img/CarreBleueVide.jpg"));
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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Panel panel = new Panel();
			panel.setBounds(10, 37, 202, 308);
			contentPanel.add(panel);
		}
		{
			Panel panel = new Panel();
			panel.setBounds(238, 37, 195, 308);
			contentPanel.add(panel);
		}
		{
			Panel panel = new Panel();
			panel.setBounds(456, 37, 195, 308);
			contentPanel.add(panel);
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
		lblCarteVictoire.setBounds(73, 17, 74, 14);
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
