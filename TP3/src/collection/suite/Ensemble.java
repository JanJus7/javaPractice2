package collection.suite;

import collection.Iterateur;

/**
 * Représente un ensemble d'objets quelconques (version étendue).
 * <p>
 * 
 * Les objets ne sont présents dans un ensemble qu'en une seule occurrence. Les
 * doublons d'objets sont donc interdits.
 * <p>
 * 
 * La détection de doublons d'objets est basée sur la méthode equals.
 * <p>
 * 
 * La référence null est interdite dans un ensemble.
 */
public interface Ensemble extends collection.Ensemble, Cloneable {

	/**
	 * Renvoie une copie en profondeur de l'ensemble.
	 * 
	 * @return copie de l'ensemble
	 */
	Ensemble clone();

	/**
	 * Crée un ensemble correspondant à l'union de deux ensembles (ces deux
	 * ensembles restent inchangés).
	 * 
	 * @param e1 première opérande de l'union
	 * @param e2 deuxième opérande de l'union
	 * @return ensemble contenant tous les éléments de e1 et tous les éléments de e2
	 */
	static Ensemble union(Ensemble e1, Ensemble e2) {

		// EXERCICE 2 :
		Ensemble ensemble = e1.clone();
		for (Iterateur it = e2.getIterateur(); it.hasNext();) {
			Object o = it.next();
			if (!e1.contains(o)) {
				ensemble.add(o);
			}
		}
		

		return ensemble;

	}

	/**
	 * Crée un ensemble correspondant à l'intersection de deux ensembles (ces deux
	 * ensembles restent inchangés).
	 * 
	 * @param e1 première opérande de l'intersection
	 * @param e2 deuxième opérande de l'intersection
	 * @return ensemble contenant tous les éléments présents à la fois dans e1 et
	 *         dans e2
	 */
	static Ensemble inter(Ensemble e1, Ensemble e2) {

		// TODO EXERCICE 2 : à compléter...

		return null; // <- TODO résultat à adapter

	}

	/**
	 * Crée un ensemble correspondant à la différence de deux ensembles (ces deux
	 * ensembles restent inchangés).
	 * 
	 * @param e1 première opérande de la différence
	 * @param e2 deuxième opérande de la différence
	 * @return ensemble contenant tous les éléments présents dans e1 mais pas dans
	 *         e2
	 */
	static Ensemble diff(Ensemble e1, Ensemble e2) {

		// TODO EXERCICE 2 : à compléter...

		return null; // <- TODO résultat à adapter

	}

	/**
	 * Renvoie la plus petite valeur de l'ensemble conformément à une relation
	 * d'ordre définie par un comparateur, ou null si l'ensemble est vide.
	 * <p>
	 * 
	 * Tous les éléments de l'ensemble doivent être comparables entre eux selon le
	 * comparateur
	 * fourni, faute de quoi le résultat est null.
	 * 
	 * @param c comparateur à utiliser pour déterminer le min
	 * @return plus petite valeur selon c si elle existe, null sinon
	 */
	default Object min(Comparateur c) {

		// TODO EXERCICE 3 : à compléter...

		return null; // <- TODO résultat à adapter

	}

	/**
	 * Renvoie la plus grande valeur de l'ensemble conformément à une relation
	 * d'ordre définie par un comparateur, ou null si l'ensemble est vide.
	 * <p>
	 * 
	 * Tous les éléments de l'ensemble doivent être comparables entre eux selon le
	 * comparateur
	 * fourni, faute de quoi le résultat est null.
	 * 
	 * @param c comparateur à utiliser pour déterminer le max
	 * @return plus grande valeur selon c si elle existe, null sinon
	 */
	default Object max(Comparateur c) {

		// TODO EXERCICE 3 : à compléter...

		return null; // <- TODO résultat à adapter

	}

}
