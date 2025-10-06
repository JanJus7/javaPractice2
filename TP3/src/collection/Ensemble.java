package collection;

/**
 * Représente un ensemble d'objets quelconques.
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
public interface Ensemble {

	/**
	 * Ajoute un objet à l'ensemble, seulement si la référence fournie n'est pas
	 * null et si l'objet n'est pas déjà présent (selon equals).
	 * 
	 * @param o référence de l'objet à ajouter dans l'ensemble
	 */
	void add(Object o);

	/**
	 * Retire un objet de l'ensemble, seulement si la référence fournie désigne un
	 * objet effectivement présent (selon equals).
	 * 
	 * @param o référence de l'objet à retirer de l'ensemble
	 */
	void remove(Object o);

	/**
	 * Indique le nombre d'éléments dans l'ensemble.
	 * 
	 * @return cardinal de l'ensemble
	 */
	int size();

	/**
	 * Indique si un objet est présent (selon equals) dans l'ensemble.
	 * 
	 * @param o référence de l'objet recherché
	 * @return vrai ou faux selon que l'objet est présent ou non
	 */
	boolean contains(Object o);

	/**
	 * Renvoie un itérateur positionné sur l'ensemble.
	 * 
	 * @return nouvel itérateur
	 */
	Iterateur getIterateur();

}
