package visu;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import automate.Grille;

/**
 * Automate cellulaire représenté sous forme d'image.
 */
public class ImageGrille {

	// ******************************* ATTRIBUTS

	/**
	 * Nom de l'automate.
	 */
	private String nom;
		
	/**
	 * Automate représenté.
	 */
	private Grille automate;

	/**
	 * Image de l'automate.
	 */
	private BufferedImage image;

	/**
	 * Largeur de l'image.
	 */
	private int largeurImage;

	/**
	 * Hauteur de l'image.
	 */
	private int hauteurImage;
	
	/**
	 * Epaisseur de la grille.
	 */
	private int epaisseurGrille;
	
	/**
	 * Largeur d'une cellule.
	 */
	private int largeurCellule;

	/**
	 * Hauteur d'une cellule.
	 */
	private int hauteurCellule;
	
	/**
	 * Epaisseur du cadre interne d'une cellule.
	 */
	private int epaisseurCadreCellule;
	
	/**
	 * Indique si une cellule vivante doit marquer sa trace dans la grille ou non.
	 */
	private boolean traceOK;	
	
	/**
	 * Couleur d'une cellule vivante.
	 */
	private Color colVivante;

	/**
	 * Couleur d'une cellule morte.
	 */
	private Color colMorte;

	/**
	 * Couleur de la grille.
	 */
	private Color colGrille;

	/**
	 * Couleur de la trace des cellules vivantes.
	 */
	private Color colTrace;

	/**
	 * Couleur du cadre d'une cellule qui va mourir.
	 */
	private Color colMeurt;

	/**
	 * Couleur d'une cellule qui va naître.
	 */
	private Color colNait;

	/**
	 * Epaisseur par défaut de la grille.
	 */
	public static final int EPG = 3;

	/**
	 * Epaisseur par défaut de cadre interne d'une cellule.
	 */
	public static final int EPCC = 6;

	// Couleurs prédéfinies :
	
	public static final Color NOIR = new Color(0, 0, 0);
	public static final Color BLANC = new Color(255, 255, 255);
	public static final Color GRIS = new Color(127, 127, 127);
	public static final Color ROUGE = new Color(255, 0, 0);
	public static final Color VERT = new Color(0, 255, 0);
	public static final Color BLEU = new Color(0, 0, 255);

	// ******************************* CONSTRUCTEURS

	/**
	 * Constructeur minimal.
	 * 
	 * @param nom nom de l'automate
	 * @param a   automate représenté
	 * @param l   largeur de l'image
	 * @param h   hauteur de l'image
	 */
	public ImageGrille(String nom, Grille a, int l, int h) {
		this(nom, a, l, h, EPG, EPCC, false, NOIR, BLANC, GRIS, BLEU, ROUGE, VERT);
	}

	/**
	 * Constructeur minimal plus précision des épaisseurs de grille et de cadre.
	 * 
	 * @param nom nom de l'automate
	 * @param a   automate représenté
	 * @param l   largeur de l'image
	 * @param h   hauteur de l'image
	 * @param eg  épaisseur de la grille
	 * @param ecc épaisseur du cadre des cellules
	 */
	public ImageGrille(String nom, Grille a, int l, int h, int eg, int ecc) {
		this(nom, a, l, h, eg, ecc, false, NOIR, BLANC, GRIS, BLEU, ROUGE, VERT);
	}

	/**
	 * Constructeur d'image complètement paramétrable.
	 * 
	 * @param nom   nom de l'automate
	 * @param a     automate représenté
	 * @param l     largeur de l'image
	 * @param h     hauteur de l'image
	 * @param eg    épaisseur de la grille
	 * @param ecc   épaisseur du cadre des cellules
	 * @param trace indice si les cellules vivantes doivent laisser une trace ou non
	 * @param cv    couleur de cellule vivante
	 * @param cm    couleur de cellule morte
	 * @param cg    couleur du cadre de la grille
	 * @param ct    couleur de la trace des cellules vivantes
	 * @param cmeu  couleur d'une cellule mourante
	 * @param cn    couleur d'une cellule naissante
	 */
	public ImageGrille(String nom, Grille a, int l, int h, int eg, int ecc, boolean trace, Color cv, Color cm, Color cg,
			Color ct, Color cmeu, Color cn) {
		this.nom = nom;
		this.automate = a;

		this.epaisseurGrille = eg;
		this.epaisseurCadreCellule = ecc;
		this.hauteurCellule = (h - eg) / a.NL;
		this.largeurCellule = (l - eg) / a.NC;
		this.hauteurImage = this.hauteurCellule * a.NL + eg;
		this.largeurImage = this.largeurCellule * a.NC + eg;

		this.traceOK = trace;

		this.colVivante = cv;
		this.colMorte = cm;
		this.colGrille = cg;
		this.colTrace = ct;
		this.colMeurt = cmeu;
		this.colNait = cn;

		this.image = new BufferedImage(this.largeurImage, this.hauteurImage, BufferedImage.TYPE_INT_RGB);
		this.dessineRectangle(0, 0, this.largeurImage, this.hauteurImage, this.colGrille);
		this.dessineGrille();
	}

	// ******************************* METHODES
	
	/**
	 * Dessine l'état courant de l'automate.
	 */
	public void dessineGrille() {
		for (int i = 0; i < automate.NL; i++)
			for (int j = 0; j < automate.NC; j++) {
				boolean cellVivante = this.automate.get(i, j);
				// Cadre de la case si trace demandée :
				if (this.traceOK && cellVivante)
					this.dessineRectangle(j * this.largeurCellule, i * this.hauteurCellule,
							              this.largeurCellule + this.epaisseurGrille, 
							              this.hauteurCellule + this.epaisseurGrille,
							              this.colTrace);
				// Fond de la case :
				this.dessineRectangle(j * this.largeurCellule + this.epaisseurGrille,
						              i * this.hauteurCellule + this.epaisseurGrille, 
						              this.largeurCellule - this.epaisseurGrille,
						              this.hauteurCellule - this.epaisseurGrille, 
						              (cellVivante ? this.colVivante : this.colMorte));
			}
	}
	
	/**
	 * Dessine sur l'état courant les cellules qui vont évoluer au prochain tour.
	 */
	public void dessineEvolutionGrille() {
		for (int i = 0; i < automate.NL; i++)
			for (int j = 0; j < automate.NC; j++)
				if (this.automate.changera(i, j)) {
					int x = j * this.largeurCellule + this.epaisseurGrille;
					int y = i * this.hauteurCellule + this.epaisseurGrille;
					Color c = this.automate.get(i, j) ? this.colMeurt : this.colNait;
					this.dessineRectangle(x, y, this.largeurCellule - this.epaisseurGrille, this.epaisseurCadreCellule, c);
					this.dessineRectangle(x,
							y + this.hauteurCellule - this.epaisseurGrille - this.epaisseurCadreCellule,
							this.largeurCellule - this.epaisseurGrille, this.epaisseurCadreCellule, c);
					this.dessineRectangle(x, y + this.epaisseurCadreCellule, this.epaisseurCadreCellule,
							this.hauteurCellule - this.epaisseurGrille - 2 * this.epaisseurCadreCellule, c);
					this.dessineRectangle(x + this.largeurCellule - this.epaisseurGrille - this.epaisseurCadreCellule,
							y + this.epaisseurCadreCellule, this.epaisseurCadreCellule,
							this.hauteurCellule - this.epaisseurGrille - 2 * this.epaisseurCadreCellule, c);
				}
	}

	/**
	 * Dessine un rectangle.
	 * 
	 * @param x abscisse du point en haut à gauche du rectangle
	 * @param y ordonnée du point en haut à gauche du rectangle
	 * @param l largeur du rectangle
	 * @param h hauteur du rectangle
	 * @param c couleur du rectangle
	 */
	private void dessineRectangle(int x, int y, int l, int h, Color c) {
		int rgb = c.getRGB();
		for (int dx = 0; dx < l; dx++)
			for (int dy = 0; dy < h; dy++)
				this.image.setRGB(dx + x, dy + y, rgb);
	}

	/**
	 * Fournit la dernière image créée.
	 * 
	 * @return image d'état de l'automate
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Sauvegarde la dernière image dans un fichier.
	 * 
	 * @param fichier nom du fichier
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public void save(String fichier) throws IOException {
		this.save(fichier, true);
	}

	/**
	 * Sauvegarde la dernière image dans un fichier.
	 * 
	 * @param fichier nom du fichier
	 * @param verbose indique si un message doit être affichée sur la console
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public void save(String fichier, boolean verbose) throws IOException {
		if (verbose) System.out.print("Sauvegarde dans " + fichier + "... ");
		int i = fichier.lastIndexOf('.');
		String type = (i > 0 ? fichier.substring(i + 1) : "png");
		javax.imageio.ImageIO.write(this.image, type, new File(fichier));
		if (verbose) System.out.println("ok.");
	}

	/**
	 * Active ou désactive la trace des cellules vivantes.
	 */
	public void switchTrace() {
		this.traceOK = !this.traceOK;
	}

	/**
	 * Fournit l'état d'activation de la trace des cellules vivantes
	 * 
	 * @return vrai si la trace est activée, faux sinon
	 */
	public boolean getTrace() {
		return this.traceOK;
	}

	/**
	 * Avance l'automate d'une étape.
	 * 
	 * @return vrai si la grille a changé
	 */
	public boolean next() {
		return this.automate.next();
	}

	/**
	 * Fournit le nom de l'automate.
	 * 
	 * @return nom de l'automate
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Fournit le nombre de lignes de l'automate
	 * 
	 * @return nombre de lignes
	 */
	public int getNL() {
		return this.automate.NL;
	}

	/**
	 * Fournit le nombre de colonnes de l'automate
	 * 
	 * @return nombre de colonnes
	 */
	public int getNC() {
		return this.automate.NC;
	}

}
