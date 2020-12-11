package fr.shapeUp.Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class DialogJoue1Carte extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 335, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Panel panel = new Panel();
			panel.setBounds(32, 10, 259, 331);
			contentPanel.add(panel);
		}
		{
			JPanel panChoixPosition = new JPanel();
			panChoixPosition.setBounds(32, 395, 259, 54);
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
