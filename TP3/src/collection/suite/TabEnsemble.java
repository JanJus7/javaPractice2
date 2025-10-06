package collection.suite;

/**
 * Représente un ensemble d'objets quelconques grâce à un tableau (version
 * étendue).
 * <p>
 * 
 * Les éléments de l'ensemble sont stockés dans un tableau réalloué par blocs.
 * Quand le tableau est plein, il est réalloué avec n cases en plus. Ces n cases
 * constituent un bloc.
 * <p>
 * 
 * De même, quand les cases libres du tableau constituent un bloc entier, le
 * tableau est réalloué avec un bloc de cases en moins.
 */
public class TabEnsemble extends collection.TabEnsemble implements Ensemble {

	// ******************************* HERITAGE ACCESSIBLE

	/*
	  
	 - attributs TAILLEBLOC, tab et nbe
	 - constructeur sans paramètre créant un ensemble vide
	 - méthodes toString et toStringInterne
	 - méthodes de la première interface Ensemble :
	 --> size, contains, add, remove et getIterateur
	  
	 */
	
	// ******************************* CONSTRUCTEUR

	/**
	 * Initialise un ensemble vide en créant un tableau de la taille d'un bloc.
	 */
	public TabEnsemble() {
		super();
	}

	// ******************************* MÉTHODE DE L'INTERFACE ENSEMBLE

	/**
	 * Renvoie une copie en profondeur de l'ensemble.
	 * 
	 * @return copie de l'ensemble
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public TabEnsemble clone() {

		// EXERCICE 1 :
		
		TabEnsemble cloned;
		try {
			cloned = (TabEnsemble) super.clone();
			cloned.tab = this.tab.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
