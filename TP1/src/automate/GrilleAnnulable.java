package automate;

import java.io.IOException;

/**
 * Grille circulaire d'automate cellulaire dont les étapes d'évolution peuvent
 * être annulées.
 */
@SuppressWarnings("unused") // <- TODO à supprimer
public class GrilleAnnulable extends GrilleCirculaire {

	// ******************************* ATTRIBUT

	/**
	 * Etat précédent de la grille s'il existe ou null.
	 */
	private GrilleAnnulable prev;

	// ******************************* CONSTRUCTEURS

	/**
	 * Constructeur : initialise la grille à partir d'un tableau.
	 * 
	 * @param cellules état initial du tableau de cellules
	 * @param evo      règles d'évolution
	 */
	public GrilleAnnulable(boolean[][] cellules, Evolution evo) {
		super(cellules, evo);
		this.prev = null;
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
	public GrilleAnnulable(int nbl, int nbc, int pct, Evolution evo) {
		super(nbl, nbc, pct, evo);
		this.prev = null;
	}

	/**
	 * Constructeur : initialise la grille à partir d'un fichier texte qui la
	 * représente ligne par ligne avec le caractère 'O' pour les cellules vivantes.
	 * 
	 * @param fichier nom du fichier texte
	 * @param evo     règles d'évolution
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public GrilleAnnulable(String fichier, Evolution evo) throws IOException {
		super(fichier, evo);
		this.prev = null;
	}
	
	// ******************************* METHODES

	/**
	 * Etape d'évolution : met à jour l'état de la grille en appliquant les règles
	 * d'évolution sur toutes les cases.
	 * 
	 * @return vrai si la grille a changé
	 */
	@Override
	public boolean next() {
		
		// TODO EXERCICE 6 : à compléter...
		
		return false; // <- TODO résultat à adapter !
		
	}

	/**
	 * Annule si elle existe la dernière étape d'évolution.
	 */
	public void prev() {
		
		// TODO EXERCICE 6 : à compléter...

	}

	/**
	 * Annule si possible plusieurs étapes d'évolution.
	 * 
	 * @param nbsteps nombre d'étapes à annuler
	 */
	public void prev(int nbsteps) {
		
		// TODO EXERCICE 6 : à compléter...

	}

	/**
	 * Replace la grille dans son état initial.
	 */
	public void reset() {
		
		// TODO EXERCICE 6 : à compléter...

	}

}
