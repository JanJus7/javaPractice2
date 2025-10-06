package collection;

/**
 * Représente un itérateur sur un ensemble de données.
 * <p>
 * 
 * Un itérateur est une sorte de curseur qui se déplace sur un ensemble de
 * données et qui permet de parcourir tous les éléments de l'ensemble. L'ordre
 * de parcours n'est pas déterminé.
 */
public interface Iterateur {

	/**
	 * Indique si l'itérateur peut encore progresser dans son parcours des éléments
	 * de l'ensemble.
	 * 
	 * @return true s'il existe un prochain élément dans l'ordre de parcours, false
	 *         sinon
	 */
	boolean hasNext();

	/**
	 * Revoie le prochain élément dans l'ordre de parcours et déplace l'itérateur.
	 * 
	 * @return le prochain élément dans l'ordre de parcours s'il existe, null sinon
	 */
	Object next();

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
	boolean remove();

}
