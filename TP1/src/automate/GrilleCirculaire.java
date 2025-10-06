package automate;

import java.io.IOException;

/**
 * Grille d'automate cellulaire gérée de manière <i>circulaire</i> :
 * <ul>
 * <li>la colonne à droite de la dernière correspond à la première</li>
 * <li>la colonne à gauche de la première correspond à la dernière</li>
 * <li>la ligne qui suit la dernière correspond à la première</li>
 * <li>la ligne qui précède la première correspond à la dernière</li>
 * </ul>
 */
@SuppressWarnings("unused") // <- TODO à supprimer
public class GrilleCirculaire extends Grille {

	// ******************************* CONSTRUCTEURS
	
	/**
	 * Constructeur : initialise la grille à partir d'un tableau.
	 * 
	 * @param cellules état initial du tableau de cellules
	 * @param evo      règles d'évolution
	 */
	public GrilleCirculaire(boolean[][] cellules, Evolution evo) {
		super(cellules, evo);
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
	public GrilleCirculaire(int nbl, int nbc, int pct, Evolution evo) {
		super(nbl, nbc, pct, evo);
	}

	/**
	 * Constructeur : initialise la grille à partir d'un fichier texte qui la
	 * représente ligne par ligne avec le caractère 'O' pour les cellules vivantes.
	 * 
	 * @param fichier nom du fichier texte
	 * @param evo     règles d'évolution
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public GrilleCirculaire(String fichier, Evolution evo) throws IOException {
		super(fichier, evo);
	}

	// ******************************* METHODES

	/**
	 * Détermine un numéro de ligne valide.
	 * 
	 * @param i numéro de ligne quelconque
	 * @return numéro de ligne équivalent contenu dans l'intervalle [0 ; NL[
	 */
	private int ligne(int i) {
		
		// TODO EXERCICE 5 : à compléter...
		
		return 0; // <- TODO résultat à adapter !
				
	}

	/**
	 * Détermine un numéro de colonne valide.
	 * 
	 * @param j numéro de colonne quelconque
	 * @return numéro de colonne équivalent contenu dans l'intervalle [0 ; NC[
	 */
	private int colonne(int j) {
		
		// TODO EXERCICE 5 : à compléter...
		
		return 0; // <- TODO résultat à adapter !
				
	}

	/**
	 * Fournit une cellule désignée par ses coordonnées dans la grille. Les
	 * coordonnées sont toujours valides car la grille est gérée de manière
	 * circulaire.
	 * 
	 * @param i numéro de ligne de la cellule
	 * @param j numéro de colonne de la cellule
	 * @return cellule de coordonnées (i, j)
	 */
	@Override
	public boolean get(int i, int j) {
		
		// TODO EXERCICE 5 : à compléter...
		
		return false; // <- TODO résultat à adapter !
				
	}

}
