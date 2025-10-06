package automate;

import java.io.IOException;

import visu.UtilGrille;

/**
 * Grille d'automate cellulaire.
 * <p>
 * 
 * La grille est un tableau de cellules. Une cellule n'a que deux états
 * possibles : <i>vivante</i> ou <i>morte</i>. Ces états sont représentés par
 * des valeurs booléennes :
 * <ul>
 * <li><tt>true </tt> : <i>cellule vivante</i></li>
 * <li><tt>false</tt> : <i>cellule morte  </i></li>
 * </ul>
 * Le tableau de cellules est donc concrètement un tableau de booléens.
 */
public class Grille {

	// ******************************* ATTRIBUTS

	/**
	 * Tableau de cellules.
	 */
	protected boolean[][] cellules;

	/**
	 * Nombre de lignes.
	 */
	public final int NL;

	/**
	 * Nombre de colonnes.
	 */
	public final int NC;

	/**
	 * Règles d'évolution de la grille.
	 */
	protected Evolution evo;

	// ******************************* FONCTION UTILITAIRE
	
	/**
	 * Fournit une copie en profondeur d'un tableau de booléens.
	 * 
	 * @param tab tableau à copier
	 * @return copie pleinement séparée de tab
	 */
	@SuppressWarnings("unused") // <- TODO à supprimer
	private static boolean[][] copie(boolean[][] tab) {
		
		// TODO EXERCICE 2 : à compléter...
		
		return null; // <- TODO résultat à adapter !
				
	}

	// ******************************* CONSTRUCTEURS
	
	/**
	 * Constructeur : initialise la grille à partir d'un tableau.
	 * 
	 * @param cellules état initial du tableau de cellules
	 * @param evo      règles d'évolution
	 */
	public Grille(boolean[][] cellules, Evolution evo) {

		// TODO EXERCICE 2 : à compléter...

		
		// ATTENTION : on doit copier le tableau pour ne pas rompre l'encapsulation
		//             this.cellules = cellules; est interdit
		
		
		this.NL = this.NC = 0; // <- TODO à mettre à jour !

	}
	
	/**
	 * Constructeur : initialise la grille à partir d'un pourcentage de cellules
	 * initialement vivantes réparties aléatoirement.
	 *
	 * @param nbl nombre de lignes
	 * @param nbc nombre de colonnes
	 * @param pct pourcentage de cellules initialement vivantes
	 * @param evo règles d'évolution
	 */
	public Grille(int nbl, int nbc, int pct, Evolution evo) {

		// TODO EXERCICE 2 * (non prioritaire) : à compléter...
		
		this.NL = this.NC = 0; // <- TODO à mettre à jour !

	}

	/**
	 * Constructeur : initialise la grille à partir d'un fichier texte qui la
	 * représente ligne par ligne avec le caractère 'O' pour les cellules vivantes.
	 * 
	 * @param fichier nom du fichier texte
	 * @param evo     règles d'évolution
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public Grille(String fichier, Evolution evo) throws IOException {
		this(UtilGrille.load(fichier), evo);
	}
	
	// ******************************* METHODES

	/**
	 * Fournit une cellule désignée par ses coordonnées dans la grille, ou false si
	 * les coordonnées sont incorrectes.
	 * 
	 * @param i numéro de ligne de la cellule
	 * @param j numéro de colonne de la cellule
	 * @return cellule de coordonnées (i, j)
	 */
	public boolean get(int i, int j) {
		
		// TODO EXERCICE 3 : à compléter...
		
		return false; // <- TODO résultat à adapter !
		
	}

	/**
	 * Fournit le nombre de cellules vivantes dans le voisinage direct d'une
	 * cellule.
	 * 
	 * @param i numéro de ligne de la cellule
	 * @param j numéro de colonne de la cellule
	 * @return Nombre de cellules vivantes autour de la cellule de coordonnées [i][j]
	 */
	public int nbVois(int i, int j) {
		
		// TODO EXERCICE 3 : à compléter...
		
		return 0; // <- TODO résultat à adapter !
		
	}

	/**
	 * Indique si une cellule changera d'état au tour suivant.
	 * 
	 * @param i numéro de ligne de la cellule
	 * @param j numéro de colonne de la cellule
	 * @return vrai si la cellule changera d'état, faux sinon
	 */
	public boolean changera(int i, int j) {
		
		// TODO EXERCICE 3 : à compléter...
		
		return false; // <- TODO résultat à adapter !
		
	}

	/**
	 * Etape d'évolution : met à jour l'état de la grille en appliquant les règles
	 * d'évolution sur toutes les cases.
	 * 
	 * @return vrai si la grille a changé
	 */
	public boolean next() {
		
		// TODO EXERCICE 4 : à compléter...
		
		return false; // <- TODO résultat à adapter !
		
	}

	/**
	 * Fait évoluer la grille de plusieurs étapes.
	 * 
	 * @param nbsteps nombre d'étapes
	 */
	public void next(int nbsteps) {
		
		// TODO EXERCICE 4 : à compléter...
		
	}

	/**
	 * Représentation textuelle de la grille, ligne par ligne, avec '.' pour une
	 * cellule morte, et 'O' pour une cellulle vivante.
	 * 
	 * @return Représentation de la grille.
	 */
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < this.NL; i++) {
			for (int j = 0; j < this.NC; j++)
				res += (this.cellules[i][j] ? 'O' : '.');
			res += '\n';
		}
		return res;
	}
	
	/**
	 * Sauvegarde la grille dans un fichier texte.
	 * @param fichier nom du fichier à créer
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public void save(String fichier) throws IOException {
		UtilGrille.save(this.cellules, fichier);
	}

}
