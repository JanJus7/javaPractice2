package collection.suite;

import collection.Iterateur;

/**
 * Représente un ensemble d'objets quelconques grâce à une chaîne d'objets
 * (version étendue).
 * <p>
 * 
 * Les éléments de l'ensemble sont stockés dans des chaînons reliés entre eux
 * par un simple chaînage.
 * <p>
 * 
 * La classe stocke la référence du chaînon de début de chaîne ainsi que la
 * taille de la chaîne (<i>i.e.</i> nombre d'éléments dans l'ensemble).
 */
@SuppressWarnings("unused") // <- TODO à supprimer
public class ChaineEnsemble implements Ensemble {

	// ******************************* CLASSE ENCAPSULEE

	/**
	 * Représente un chaînon de la chaîne avec une valeur stockée et la référence du
	 * chaînon suivant dans la chaîne.
	 */
	static class Chainon implements Cloneable {

		/**
		 * Référence de l'objet stocké.
		 */
		Object val;

		/**
		 * Référence du chaînon suivant dans la chaîne.
		 */
		Chainon next;

		/**
		 * Initialise un chaînon à partir d'un objet à stocker et de la référence du
		 * chaînon suivant.
		 * 
		 * @param val  référence de l'objet à stocker
		 * @param next référence du chaînon suivant (peut être null)
		 */
		Chainon(Object val, Chainon next) {
			this.val = val;
			this.next = next;
		}
		
		@Override
		public Chainon clone() {

			// TODO EXERCICE 4 : à compléter...

			return null; // <- TODO résultat à adapter

		}
	}

	// ******************************* ATTRIBUTS

	/**
	 * Référence du chaînon de début de chaîne.
	 */
	private Chainon debut;

	/**
	 * Nombre de chaînon, <i>i.e.</i> cardinal de l'ensemble.
	 */
	private int size;

	// ******************************* CONSTRUCTEUR, TOSTRING et TOSTRINGINTERNE

	/**
	 * Initialise un ensemble vide en créant une chaîne sans chaînon.
	 */
	public ChaineEnsemble() {

		// TODO EXERCICE 4 : à compléter...

	}

	@Override
	public String toString() {

		// TODO EXERCICE 4 : à compléter...

		return null; // <- TODO résultat à adapter

	}

	/**
	 * Représentation interne d'objet ChaineEnsemble.
	 * 
	 * @return indicateur d'existance de debut et nombre d'éléments
	 */
	public String toStringInterne() {
		return "debut : " + (this.debut == null ? "null" : "non null") + " - size : " + this.size;
	}

	// ******************************* MÉTHODES DE L'INTERFACE ENSEMBLE (VERSION ETENDUE)

	/**
	 * Indique le nombre d'éléments dans l'ensemble.
	 * 
	 * @return cardinal de l'ensemble
	 */
	@Override
	public int size() {

		// TODO EXERCICE 4 : à compléter...

		return 0; // <- TODO résultat à adapter

	}

	/**
	 * Indique si un objet est présent (selon equals) dans l'ensemble.
	 * 
	 * @param o référence de l'objet recherché
	 * @return vrai ou faux selon que l'objet est présent ou non
	 */
	@Override
	public boolean contains(Object o) {

		// TODO EXERCICE 4 : à compléter...

		return false; // <- TODO résultat à adapter

	}

	/**
	 * Ajoute un objet à l'ensemble, seulement si la référence fournie n'est pas
	 * null et si l'objet n'est pas déjà présent (selon equals).
	 * 
	 * @param o référence de l'objet à ajouter dans l'ensemble
	 */
	@Override
	public void add(Object o) {

		// TODO EXERCICE 4 : à compléter...

	}

	/**
	 * Retire un objet de l'ensemble, seulement si la référence fournie désigne un
	 * objet effectivement présent (selon equals).
	 * 
	 * @param o référence de l'objet à retirer de l'ensemble
	 */	
	@Override
	public void remove(Object o) {

		// TODO EXERCICE 4 : à compléter...

	}

	/**
	 * Renvoie une copie en profondeur de l'ensemble.
	 * <p>
	 * 
	 * Les modifications apportées sur le clone ne doivent pas avoir d'incidence sur
	 * l'ensemble d'origine.
	 * 
	 * @return copie de l'ensemble
	 */
	@Override
	public ChaineEnsemble clone() {		

		// TODO EXERCICE 4 : à compléter...

		return null; // <- TODO résultat à adapter

	}
	
	/**
	 * Renvoie un itérateur positionné sur l'ensemble.
	 * 
	 * @return nouvel itérateur
	 */
	@Override
	public Iterateur getIterateur() {

		// TODO EXERCICE 5 : à compléter...

		return null; // <- TODO résultat à adapter

	}
	
	// ******************************* CLASSE INTERNE

	/**
	 * Représente un itérateur sur un ensemble de type ChaineEnsemble.
	 * <p>
	 * 
	 * L'itérateur est matérialisé par référence du prochain chaînon à lire dans la
	 * chaîne.
	 */
	class ChaineEnsembleIterateur implements Iterateur {

		/**
		 * Référence du dernier chaînon lu dans l'ordre de parcours de l'itérateur.
		 */
		private Chainon courant;

		/**
		 * Indique si le parcours est fini.
		 */
		private boolean fini;

		/**
		 * Indique si la suppression par remove est possible ou non.
		 */
		private boolean removePossible;

		/**
		 * Chainon dont le next est à supprimer par remove si remove est possible dans
		 * le cas général (hors cas du premier chainon).
		 */
		private Chainon removeNext;

		/**
		 * Initialise un itérateur avec null comme dernier chaînon lu puisque la lecture
		 * n'a pas commencé.
		 */
		public ChaineEnsembleIterateur() {
			this.courant = null;
			this.fini = ChaineEnsemble.this.debut == null;
			this.removePossible = false;
			this.removeNext = null;
		}

		/**
		 * Indique si l'itérateur peut encore progresser dans son parcours des éléments
		 * de l'ensemble.
		 * 
		 * @return true s'il existe un prochain élément dans l'ordre de parcours, false
		 *         sinon
		 */
		@Override
		public boolean hasNext() {

			// TODO EXERCICE 5 : à compléter...

			return false; // <- TODO résultat à adapter

		}

		@Override
		public Object next() {
			
			// TODO EXERCICE 5 : à compléter...

			return null; // <- TODO résultat à adapter

		}

		/**
		 * Tente de supprimer le dernier élément renvoyé par next.
		 * <p>
		 * 
		 * Il n'est possible de supprimer cet élément que si next a été appelé au
		 * préalable, que le résultat n'était pas null, et que remove n'a pas déjà été
		 * appelé depuis.
		 * 
		 * @return booléen indiquant si la suppression a été faite
		 */
		@Override
		public boolean remove() {

			// TODO EXERCICE 5 : à compléter...

			return false; // <- TODO résultat à adapter

		}

	}

}
