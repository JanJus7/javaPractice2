package collection;

import java.util.Arrays;

/**
 * Représente un ensemble d'objets quelconques grâce à un tableau.
 * <p>
 * 
 * Les éléments de l'ensemble sont stockés dans un tableau réalloué par blocs.
 * Quand le tableau est plein, il est réalloué avec n cases en plus. Ces n cases
 * constituent un bloc.
 * <P>
 * 
 * De même, quand les cases libres du tableau constituent un bloc entier, le
 * tableau est réalloué avec un bloc de cases en moins.
 */
@SuppressWarnings("unused") // <- TODO à supprimer
public class TabEnsemble implements Ensemble {

	// ******************************* ATTRIBUTS

	/**
	 * Constante représentant la taille d'un bloc d'allocation.
	 */
	protected static final int TAILLEBLOC = 5;

	/**
	 * Tableau stockant dans sa première partie les éléments de l'ensemble.
	 */
	protected Object[] tab;

	/**
	 * Nombre d'éléments stockés (et prochain indice d'écriture dans tab).
	 */
	protected int nbe;

	// ******************************* CONSTRUCTEUR, TOSTRING et TOSTRINGINTERNE

	/**
	 * Initialise un ensemble vide en créant un tableau de la taille d'un bloc.
	 */
	public TabEnsemble() {

		// TODO EXERCICE 1 : à compléter...
		this.tab = new Object[TAILLEBLOC];
		this.nbe = 0;

	}

	@Override
	public String toString() {
		String var = "[ ";
		for (int i = 0; i < this.nbe; i++) {
			var += this.tab[i].toString();
			var += " ";
		}
		var += "]";
		// TODO EXERCICE 1 : à compléter...
		return var;
		// <- TODO résultat à adapter
	}

	/**
	 * Représentation interne d'objet TabEnsemble.
	 * 
	 * @return représentation du tableau complet et du nombre d'éléments
	 */
	public String toStringInterne() {
		return "tab : " + Arrays.toString(this.tab) + " - nbe : " + this.nbe;
	}

	// ******************************* MÉTHODES DE L'INTERFACE ENSEMBLE ET MÉTHODES
	// AUXILIAIRES

	/**
	 * Indique le nombre d'éléments dans l'ensemble.
	 * 
	 * @return cardinal de l'ensemble
	 */
	@Override
	public int size() {

		// TODO EXERCICE 2 : à compléter...
		return this.nbe; // <- TODO résultat à adapter

	}

	/**
	 * Fonction utilitaire de recherche de l'indice d'un élément dans le tableau.
	 * 
	 * @param o object dont on recherche l'indice
	 * @return indice de o s'il existe ou -1
	 */
	private int indice(Object o) {

		// TODO EXERCICE 2 : à compléter...
		
		for (int i = 0; i < this.nbe; i++) {
			if (this.tab[i].equals(o)) {
				return i;
			}
		}

		return -1; // <- TODO résultat à adapter

	}

	/**
	 * Indique si un objet est présent (selon equals) dans l'ensemble.
	 * 
	 * @param o référence de l'objet recherché
	 * @return vrai ou faux selon que l'objet est présent ou non
	 */
	@Override
	public boolean contains(Object o) {

		// TODO EXERCICE 2 : à compléter...

		return this.indice(o) != -1; 
		// <- TODO résultat à adapter

	}

	/**
	 * Ajoute un objet à l'ensemble, seulement si la référence fournie n'est pas
	 * null et si l'objet n'est pas déjà présent (selon equals).
	 * 
	 * @param o référence de l'objet à ajouter dans l'ensemble
	 */
	@Override
	public void add(Object o) {

		// TODO EXERCICE 2 : à compléter...
		if (this.contains(o) != true && o != null) {
			if (this.size() % 5 == 0) {
				this.tab = Arrays.copyOf(this.tab, this.size() + TAILLEBLOC);
			}
			this.tab[this.nbe] = o;
			this.nbe++;
		}

	}

	/**
	 * Fonction utilitaire de suppression d'élément dans le tableau : retire un
	 * objet à un certain indice valide du tableau, comble le trou, et réalloue le
	 * tableau au besoin.
	 * 
	 * @param i indice (valide) de l'objet à retirer de l'ensemble
	 */
	private void remove(int i) {

		// TODO EXERCICE 3 : à compléter...

	}

	/**
	 * Retire un objet de l'ensemble, seulement si la référence fournie désigne un
	 * objet effectivement présent (selon equals).
	 * 
	 * @param o référence de l'objet à retirer de l'ensemble
	 */
	@Override
	public void remove(Object o) {

		// TODO EXERCICE 3 : à compléter...

	}

	/**
	 * Renvoie un itérateur positionné sur l'ensemble.
	 * 
	 * @return nouvel itérateur
	 */
	@Override
	public Iterateur getIterateur() {

		// TODO EXERCICE 4 : à compléter...

		return null; // <- TODO résultat à adapter

	}

	// ******************************* CLASSE INTERNE

	/**
	 * Représente un itérateur sur un ensemble de type TabEnsemble.
	 * <p>
	 * 
	 * L'itérateur est matérialisé par l'indice du prochain élément à lire dans le
	 * tableau.
	 */
	class TabEnsembleIterateur implements Iterateur {

		/**
		 * Indice du prochain élément à lire dans l'ordre de parcours de l'itérateur.
		 */
		private int next;

		/**
		 * Indique si la suppression par remove est possible ou non.
		 */
		private boolean removePossible;

		/**
		 * Initialise un itérateur avec comme premier élément à lire l'élément d'indice
		 * 0.
		 */
		public TabEnsembleIterateur() {
			this.next = 0;
			this.removePossible = false;
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

			// TODO EXERCICE 4 : à compléter...

			return false; // <- TODO résultat à adapter

		}

		/**
		 * Revoie le prochain élément dans l'ordre de parcours et déplace l'itérateur.
		 * 
		 * @return le prochain élément dans l'ordre de parcours s'il existe, null sinon
		 */
		@Override
		public Object next() {

			// TODO EXERCICE 4 : à compléter...

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

			// TODO EXERCICE 4 : à compléter...

			return false; // <- TODO résultat à adapter

		}
	}
}
