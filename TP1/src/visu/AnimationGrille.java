package visu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * Animation d'un automate cellulaire.
 */
public class AnimationGrille {
	
	// ******************************* CLASSE INTERNE

	/**
	 * Gestion des événements clavier.
	 */
	private class KeyVueGrille implements KeyListener {

		/**
		 * Met en pause la visualisation.
		 * 
		 * @return true si la visualisation a effectivement été mise en pause
		 */
		private boolean pause() {
			if (AnimationGrille.this.play) {
				AnimationGrille.this.play = false;
				AnimationGrille.this.filAffich.interrupt();
				AnimationGrille.this.updateTitle();
				return true;
			}
			return false;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE: 
			case KeyEvent.VK_Q: 
				AnimationGrille.this.end = true;
				AnimationGrille.this.filAffich.interrupt();
				AnimationGrille.this.closeWindow();
				break;
			case KeyEvent.VK_P: 
				if (!this.pause()) { // déjà en pause
					AnimationGrille.this.play = true;
					AnimationGrille.this.updateTitle();
					synchronized(AnimationGrille.this) { AnimationGrille.this.notify(); }
				}
				break;
			case KeyEvent.VK_E:
				if(e.getKeyCode()== KeyEvent.VK_E)
				AnimationGrille.this.preview = !AnimationGrille.this.preview;
				AnimationGrille.this.updateTitle();
				break;
			case KeyEvent.VK_T:
				if(e.getKeyCode()== KeyEvent.VK_T)
				AnimationGrille.this.ig.switchTrace();
				AnimationGrille.this.updateTitle();
				break;
			case KeyEvent.VK_S:
				this.pause();
				String nomf = AnimationGrille.this.ig.getNom() + ", " +AnimationGrille.this.etape + " - " + System.currentTimeMillis()+".png";
				try {
					AnimationGrille.this.ig.save(nomf);
					JOptionPane.showMessageDialog(null, "Image sauvegardée dans le fichier " +nomf);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erreur de sauvegarde");
				}
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_KP_RIGHT:
				this.pause();
				AnimationGrille.this.update();
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				if (AnimationGrille.this.pause>20) AnimationGrille.this.pause -= 20;
				AnimationGrille.this.updateTitle();
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				if (AnimationGrille.this.pause<4000) AnimationGrille.this.pause += 20;
				AnimationGrille.this.updateTitle();
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
	}
	
	// ******************************* ATTRIBUTS

	/**
	 * Temps d'affichage par défaut.
	 */
	private final static int PAUSE = 500;
	
	/**
	 * Nombre de fenêtres affichées.
	 */
	private static int nbw = 0;
	
	/**
	 * Décalage horizontal en nombre de pixels à la création d'une nouvelle fenêtre.
	 */
	private static int wdx = 3;

	/**
	 * Décalage horizontal en nombre de pixels à la création d'une nouvelle fenêtre.
	 */
	private static int wdy = 3;
	
	/**
	 * Générateur d'images de l'automate.
	 */
	private ImageGrille ig;
	
	/**
	 * Numéro d'itération.
	 */
	private int etape;
	
	/**
	 * Indique si la visualisation a démarré.
	 */
	private boolean start;
	
	/**
	 * Indique si la visualisation est terminée.
	 */
	private boolean end;
	
	/**
	 * Indique l'animation est en cours.
	 */
	private boolean play;
	
	/**
	 * Indique si la prévisualisation de l'état suivant est active.
	 */
	private boolean preview;
	
	/**
	 * Indique si la dernière image affichée était une prévisualisation.
	 */
	private boolean lastPrev;	
	
	/**
	 * Temps d'affichage d'une image.
	 */
	private int pause;
	
	/**
	 * Fil en charge de l'animation.
	 */
	private Thread filAffich;
	
	/**
	 * Panneau d'affichage de l'image
	 */
	private JLabel panneauVue;
	
	/**
	 * Cadre du panneau d'affichage.
	 */
	private JScrollPane panneauVueScroll;
	
	/**
	 * Fenêtre principale.
	 */
	private JFrame fenetre;
	
	// ******************************* CONSTRUCTEUR

	/**
	 * Constructeur : crée l'animation d'un automate cellulaire à partir de sa
	 * représentation sous forme d'image.
	 * 
	 * @param ig représentation sous forme d'image de l'automate à animer
	 */
	public AnimationGrille(ImageGrille ig) {
		this.ig = ig;
		this.etape = 0;
		this.start = false;
		this.end = false;
		this.play = false;
		this.preview = false;
		this.lastPrev = false;
		this.pause = PAUSE;
		this.filAffich = new Thread(() -> {
			while(!this.end) {
				try { 
					if (! this.play) synchronized(this) { this.wait(); }
					Thread.sleep(this.pause / (this.preview ? 2 : 1));
					this.update();
				} catch (InterruptedException e) {}
			}
		});
	}

	// ******************************* METHODES

	/**
	 * Affichage de la fenêtre de visualisation.
	 */
	public void start() {
		if (!this.start) {
			this.createVue();
			this.filAffich.start();
			this.start = true;
			nbw++;
		}
	}
	
	/**
	 * Création de la fenêtre de visualisation.
	 */
	private void createVue() {
		// Création de la fenêtre :
		try {
			String lf = UIManager.getSystemLookAndFeelClassName();
			if (lf.endsWith("MetalLookAndFeel"))
				lf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
			UIManager.setLookAndFeel(lf);
		}
		catch (Exception e) {}	
		// *********************************** panneauVue
		this.panneauVue = new JLabel();
		this.panneauVue.setOpaque(true); // pas de couleur de fond
		this.panneauVue.setHorizontalAlignment(JLabel.CENTER);
		this.panneauVue.setIcon(new ImageIcon(this.ig.getImage()));
		// *********************************** panneauVueScroll
		this.panneauVueScroll = new JScrollPane(panneauVue);
		this.panneauVueScroll.setOpaque(false);
		this.updateTitle();
		// *********************************** help
		JLabel help = new JLabel();
		help.setText("p : play/pause ; e : preview ; t : trace ; s : save ; \u2193\u2191 : speed ; \u2192 : next ; esc/q : quit");
		// *********************************** gui
		JPanel gui = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(); 
		c.fill = GridBagConstraints.BOTH; // composants étirés
		c.weightx = 1; // remplissage de l'espace horizontal
		c.weighty = 1; // remplissage de l'espace vertical
		gui.add(panneauVueScroll, c, 0);
		c.gridy = 1; // le panneau d'aide est sur la 2ème ligne
		c.weighty = 0; // pas de remplissage de l'espace vertical pour lui
		gui.add(help, c, 0);
		gui.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		// *********************************** fenetre
		this.fenetre = new JFrame(this.ig.getNom() + " : " + this.ig.getNL() + " lignes x " + this.ig.getNC() + " colonnes");
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setContentPane(gui); // ajout du composant Gui dans la fenêtre
		this.fenetre.pack();
		this.fenetre.setExtendedState(fenetre.getExtendedState() | JFrame.NORMAL);
		this.fenetre.setLocation(wdx*nbw, wdy*nbw);
		this.fenetre.setVisible(true);	
		this.fenetre.addKeyListener(this.new KeyVueGrille());
		this.fenetre.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        AnimationGrille.this.closeWindow();
		    }
		});
	}
	
	/**
	 * Mise à jour de l'image affichée.
	 */
	private void update() {
		if (this.preview && !this.lastPrev) {
			this.ig.dessineEvolutionGrille();
			this.panneauVue.setIcon(new ImageIcon(this.ig.getImage()));
			this.lastPrev = true;
		}
		else {
			boolean change = this.ig.next();
			this.ig.dessineGrille();
			this.panneauVue.setIcon(new ImageIcon(this.ig.getImage()));
			this.etape++;
			this.lastPrev = false;
			if (!change) this.play = false;
		}
		this.updateTitle();
	}
	
	/**
	 * Mise à jour du cadre de l'image affichée.
	 */
	private void updateTitle() {
		String s = "[ " + (this.play ? "RUN  " : "STOP ") + this.pause + " ms ] - itération n°" + this.etape + " ";
		s+=(this.preview ? " [ PREVISUALISATION ]" : "");
		s+=(this.ig.getTrace() ? " [ TRACE ]" : "");
		this.panneauVueScroll.setBorder(BorderFactory.createTitledBorder(s));						
	}
	
	/**
	 * Action liée à la fermeture de la fenêtre.
	 */
	private void closeWindow() {
		this.fenetre.setVisible(false);
		this.fenetre.dispose();
		nbw--;
		if (nbw==0) 
			System.exit(0);
	}
}
