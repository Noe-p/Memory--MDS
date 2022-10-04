package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cartes.classique.Carte32;
import cartes.paquet.Paquet32;
import joueur.Joueur;

public class SwingView implements ISwingView {

	private static final JPanel panel = new JPanel();
	private static final GridBagConstraints gc = new GridBagConstraints();
	private static final JFrame frame = new JFrame();
	private Carte32 numCarte = null;

	public void print(Object object) {
		panel.add(new JLabel(object.toString()), gc);
		panel.updateUI();
	}

	public int readANumber(String text) {
		JLabel label = new JLabel();

		int result = Integer.parseInt(
				(String) JOptionPane.showInputDialog(frame, text, null, JOptionPane.PLAIN_MESSAGE, null, null, 0));

		panel.add(label);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.updateUI();

		if (result > 0) {
			return result;
		} else {
			return 0;
		}
	}

	public String readAString(String text) {
		JLabel label = new JLabel();

		String result = (String) JOptionPane.showInputDialog(frame, text, null, JOptionPane.PLAIN_MESSAGE, null, null,
				0);

		panel.add(label);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.updateUI();

		if (result != null && result.length() > 0) {
			return result;
		} else {
			return null;
		}
	}

	public void creerLaFenetre() {
		panel.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 3;
		gc.weighty = 3;
	}

	@Override
	public void afficherLeJeu(Paquet32 paquet, List<Joueur> lesJoueurs, Joueur joueur) {
		panel.removeAll();
		int nb = 1;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j < 5; j++) {
				gc.gridx = i;
				gc.gridy = j;
				if (nb <= 32) {
					panel.add(paquet.trouverCarte(nb).getButton(), gc);
				}
				nb++;
			}
		}
		gc.gridx = 3;
		gc.gridy++;
		this.print(joueur.getNom()+", c'est à vous de jouer !");
		gc.gridy++;
		this.print("SCORE :");
		gc.gridy++;
		for (int i = 0; i < lesJoueurs.size(); i++) {
			this.print(lesJoueurs.get(i).getNom() + " a " + lesJoueurs.get(i).getCartesGagnees() + " carte(s).");
			gc.gridx++;
		}
	}

	@Override
	public Carte32 choisirUneCarte(Paquet32 paquet) {
		this.numCarte = null;
		while(this.numCarte == null) {
			for(int i=1; i<=32; i++) {
				if(this.numCarte == null) {
					Carte32 carte = paquet.trouverCarte(i);
					carte.getButton().addActionListener(e -> {
						if(!carte.isVisible()) {
							this.numCarte = carte;
						}
					});
				}
			}
		}
		return this.numCarte;
	}
	
	public void finDuJeu(Joueur gagnant,List<Joueur> joueurs ) {
		panel.removeAll();
		gc.gridx = 5;
		gc.gridy = 3;
		this.print("Le jeu est terminé !");
		gc.gridy++;
		this.print(gagnant.getNom() + " a gagné avec "+gagnant.getCartesGagnees()+" cartes gagnées !!!");
		gc.gridy++;
		this.print("SCORE :");
		gc.gridy++;
		for (int i = 0; i < joueurs.size(); i++) {
			this.print(joueurs.get(i).getNom() + " a " + joueurs.get(i).getCartesGagnees() + " carte(s).");
			gc.gridx++;
		}
	
	}


	

}