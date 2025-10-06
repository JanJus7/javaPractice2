package automate;

/**
 * Représente les règles d'évolution d'un automate cellulaire.
 */
@SuppressWarnings("unused") // <- TODO à supprimer
public class Evolution {

	// ******************************* ATTRIBUTS STATIQUES

	// Règles prédéfinies

	public static final Evolution CONWAY = new Evolution(new int[] { 2, 3 }, new int[] { 3 });

	public static final Evolution DAYANDNIGHT = new Evolution(new int[] { 3, 4, 6, 7, 8 }, new int[] { 3, 6, 7, 8 });

	public static final Evolution HIGHLIFE = new Evolution(new int[] { 2, 3 }, new int[] { 3, 6 });

	// ******************************* ATTRIBUTS D'INSTANCES

	/**
	 * Nombres de cellules vivantes dans le voisinage d'une cellule vivante qui lui
	 * permettent de survivre.
	 */
	private int[] nbSurvivre;

	/**
	 * Nombres de cellules vivantes dans le voisinage d'une cellule morte qui lui
	 * permettent de renaitre.
	 */
	private int[] nbNaitre;

	// ******************************* CONSTRUCTEUR

	/**
	 * Constructeur : initialisation des tableaux.
	 * 
	 * @param nbs tableau des nombres de cellules pour survivre
	 * @param nbn tableau des nombres de cellules pour naître
	 */
	public Evolution(int[] nbs, int[] nbn) {

		// TODO EXERCICE 1 : à compléter...
		nbNaitre = nbn.clone();
		nbSurvivre = nbs.clone();

		// ATTENTION : on doit copier les tableaux pour ne pas rompre l'encapsulation
	}

	// ******************************* METHODES

	/**
	 * Indique si un nombre de cellules vivantes permet à une cellule de naître.
	 * 
	 * @param nb nombre de cellules vivantes
	 * @return vrai si nb apparaît dans nbNaitre
	 */
	public boolean peutNaitre(int nb) {

		// TODO EXERCICE 1 : à compléter...
		for (int i = 0; i < nbNaitre.length; i++) {
			if (nbNaitre[i] == nb) {
				return true;
			}
		}
		return false; // <- TODO résultat à adapter !
	}

	/**
	 * Indique si un nombre de cellules vivantes permet à une cellule de survivre.
	 * 
	 * @param nb nombre de cellules vivantes
	 * @return vrai si nb apparaît dans nbSurvivre
	 */
	public boolean peutSurvivre(int nb) {

		// TODO EXERCICE 1 : à compléter...
		for (int i = 0; i < nbSurvivre.length; i++) {
			if (nbSurvivre[i] == nb) {
				return true;
			}
		}
		return false; // <- TODO résultat à adapter !

	}

	/**
	 * Indique si une cellule changera d'état à l'étape suivante conformément aux
	 * règles d'évolution.
	 * <p>
	 * 
	 * Une cellule changera d'état à l'étape suivante si et seulement si elle est
	 * vivante et mourra, ou si elle est morte et naîtra.
	 * 
	 * @param vivante état de la cellule (true : vivante, false : morte)
	 * @param nb      nombre de cellules vivantes dans le voisinage de la cellule
	 * @return true si la cellule changera d'état à l'étape suivante, false sinon
	 */
	public boolean changeraDEtat(boolean vivante, int nb) {

		// TODO EXERCICE 1 : à compléter...
		if (vivante) {
			return !peutSurvivre(nb) ? true : false;
		} else {
			return peutNaitre(nb) ? true : false;
		}

//		return false; // <- TODO résultat à adapter !

	}

}
