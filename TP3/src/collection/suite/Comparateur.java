package collection.suite;

/**
 * Représente une relation d'ordre sur un sous-ensemble d'objets de même type.
 */
public interface Comparateur {

	/**
	 * Indique si deux objets sont comparables entre eux.
	 * 
	 * @param o1 premier objet
	 * @param o2 deuxième objet
	 * @return true si o1 et o2 sont comparables entre eux
	 */
	boolean comparable(Object o1, Object o2);

	/**
	 * Compare deux objets comparables entre eux.
	 * <p>
	 * Renvoie une valeur négative, nulle ou positive, selon que le premier
	 * paramètre est inférieur, égal ou supérieur au deuxième. Par exemple si
	 * compare(o1, o2) est négatif, alors o1 est plus petit que o2.
	 * 
	 * @param o1 premier objet
	 * @param o2 deuxième objet
	 * @return valeur négative si o1&lt;o2, 0 si o1=o2, valeur positive si o1&gt;o2
	 */
	int compare(Object o1, Object o2);

}
