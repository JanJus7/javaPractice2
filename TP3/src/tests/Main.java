package tests;

import collection.Iterateur;
import collection.suite.*;

/*
 * NOTE D'UTILISATION DU PROGRAMME DE TEST :
 * 
 * - faites les exercices dans l'ordre
 * 
 * - quand un exercice est fait décommentez le code de test correspondant dans la fonction main
 *     
 * - quand la trace d'exécution coïncide avec celle indiquée en commentaire,
 *   vous pouvez passer à l'exercice suivant
 */

@SuppressWarnings("unused") // <- TODO à supprimer
class Main {

	public static void main(String[] args) {

		System.out.println("---- Exercice 1 : clone ----\n");

		TabEnsemble e = new TabEnsemble();
		for (int i = 0; i <  6; i++) e.add(i);
		Ensemble clone = e.clone();
		System.out.println("Original : "); affiche(false, e);
		System.out.println("\nClone : "); affiche(false, clone);
		e.add(6); e.add(7); e.remove(0);
		clone.remove(3); clone.remove(4); clone.add(-1);
		System.out.println("\nAjout de 6 et 7, suppression de 0 dans l'original.");
		System.out.println("Suppression de 3 et 4, ajout de -1 dans le clone.");
		System.out.println("\nOriginal : "); affiche(false, e);
		System.out.println("\nClone : "); affiche(false, clone);
	
		System.out.println("\n---- Exercice 2 : union, inter et diff ----\n");
/*
		Ensemble e1 = new TabEnsemble();
		Ensemble e2 = new TabEnsemble();
		for (int i = 0; i <  7; i++) e1.add(i);
		for (int i = 3; i < 10; i++) e2.add(i);
		System.out.println("E1          : " + e1);
		System.out.println("E2          : " + e2);
		System.out.println("E1 UNION E2 : " + Ensemble.union(e1, e2));
		System.out.println("E1 INTER E2 : " + Ensemble.inter(e1, e2));
		System.out.println("E1 DIFF  E2 : " + Ensemble.diff(e1, e2));
		System.out.println("E1          : " + e1);
		System.out.println("E2          : " + e2);
*/		
		System.out.println("\n---- Exercice 3 : min et max ----\n");
/*
		e = new TabEnsemble();
		System.out.println("Ensemble initial : "); affiche(e);
		e.add(5);
		System.out.println("\nAjout de 5 : "); affiche(e);
		e.add(2); e.add(-1); e.add(4); e.add(8); e.add(6); 
		System.out.println("\nAjout de 2, -1, 4, 8 et 6 : "); affiche(e);
		e.add('x');
		System.out.println("\nAjout de 'x' : "); affiche(e);
		e.add(-2); e.add(9); 
		System.out.println("\nAjout de -2 et 9 : "); affiche(e);
		e.remove('x');
		System.out.println("\nSuppression de 'x' : "); affiche(e);
*/
		System.out.println("\n---- Exercice 4 : ChaineEnsemble : constructeur, toString, size, contains, add, remove et clone ----\n");
/*
		ChaineEnsemble ce = new ChaineEnsemble();
		System.out.println("Ensemble initial : "); affiche(false, ce, 2, 5, 8, 10);
		for (int i = 0; i < 6; i++) ce.add(i);
		System.out.println("\nAjout de 0, 1, 2, 3, 4 et 5 : "); affiche(false, ce, 2, 5, 8, 10);
		for (int i = 3; i < 9; i++) ce.add(i);
		System.out.println("\nAjout de 3, 4, 5, 6, 7 et 8 : "); affiche(false, ce, 2, 5, 8, 10);
		ce.remove(8);
		System.out.println("\nSuppression de 8 : "); affiche(false, ce, 8, 3, 0);
		ce.remove(3);
		System.out.println("\nSuppression de 3 : "); affiche(false, ce, 8, 3, 0);
		ce.remove(3);
		System.out.println("\nSuppression de 3 : "); affiche(false, ce, 8, 3, 0);
		ce.remove(0);
		System.out.println("\nSuppression de 0 : "); affiche(false, ce, 8, 3, 0);
		
		ce = new ChaineEnsemble();
		for (int i = 0; i <  6; i++) ce.add(i);
		clone = ce.clone();
		System.out.println("\nOriginal : "); affiche(false, ce);
		System.out.println("\nClone : "); affiche(false, clone);
		ce.add(6); ce.add(7); ce.remove(0);
		clone.remove(3); clone.remove(4); clone.add(-1);
		System.out.println("\nAjout de 6 et 7, suppression de 0 dans l'original.");
		System.out.println("Suppression de 3 et 4, ajout de -1 dans le clone.");
		System.out.println("\nOriginal : "); affiche(false, ce);
		System.out.println("\nClone : "); affiche(false, clone);
*/		
		System.out.println("\n---- Exercice 5 : ChaineEnsemble : itérateurs (min, max et opérations ensemblistes) ----\n");
/*		
		ce = new ChaineEnsemble();
		for (int i = 0; i < 7; i++) ce.add(i);
		System.out.println("Ensemble initial : "); affiche(false, ce);
		System.out.print("\nParcours par itérateur : ");
		for (Iterateur it = ce.getIterateur(); it.hasNext();) System.out.print(it.next() + " ");
		System.out.println(); affiche(false, ce);
		System.out.print("\nSuppression des nombres pairs : ");
		for (Iterateur it = ce.getIterateur(); it.hasNext();) {
			int n = (int) (it.next()); System.out.print(n);
			if (n % 2 == 0) { System.out.print("[X] "); it.remove(); }
			else System.out.print(" ");
		}
		System.out.println(); affiche(false, ce);
				
		System.out.println("\nEnsemble initial : "); affiche(ce, 2, 5, 8, 10);
		for (int i = 0; i < 6; i++) ce.add(i);
		System.out.println("\nAjout de 0, 1, 2, 3, 4 et 5 : "); affiche(ce, 2, 5, 8, 10);
		for (int i = 3; i < 9; i++) ce.add(i);
		System.out.println("\nAjout de 3, 4, 5, 6, 7 et 8 : "); affiche(ce, 2, 5, 8, 10);
		ce.add('x');
		System.out.println("\nAjout de 'x' : "); affiche(ce);
		ce.add(-2); ce.add(9); 
		System.out.println("\nAjout de -2 et 9 : "); affiche(ce);
		ce.remove('x');
		System.out.println("\nSuppression de 'x' : "); affiche(ce);
		
		e1 = new ChaineEnsemble();
		e2 = new ChaineEnsemble();
		for (int i = 0; i <  7; i++) e1.add(i);
		for (int i = 3; i < 10; i++) e2.add(i);
		System.out.println("\nE1          : " + e1);
		System.out.println("E2          : " + e2);
		System.out.println("E1 UNION E2 : " + Ensemble.union(e1, e2));
		System.out.println("E1 INTER E2 : " + Ensemble.inter(e1, e2));
		System.out.println("E1 DIFF  E2 : " + Ensemble.diff(e1, e2));
		System.out.println("E1          : " + e1);
		System.out.println("E2          : " + e2);
*/
	}

	// ******************************* COMPARATEUR D'ENTIERS

	public static class ComparateurInteger implements Comparateur {
		@Override
		public boolean comparable(Object o1, Object o2) {
			return (o1 instanceof Integer) && (o2 instanceof Integer);
		}

		@Override
		public int compare(Object o1, Object o2) {
			return (Integer) o1 - (Integer) o2;
		}
	}

	// ******************************* FONCTION D'AFFICHAGE

	static void affiche(Ensemble e, Object... t) {
		affiche(true, e, t);
	}
	
	static void affiche(boolean mm, Ensemble e, Object... t) {
		ComparateurInteger comp = new ComparateurInteger();
		String s1 = (e instanceof TabEnsemble ? "-> " + ((TabEnsemble) e).toStringInterne() + "\n"
				: (e instanceof ChaineEnsemble ? "-> " + ((ChaineEnsemble) e).toStringInterne() + "\n" : ""));
		String s2 = "toString() : \"" + e.toString() + "\" - size() : " + e.size();
		String ok = "", ko = "";
		for (Object o : t)
			if (e.contains(o)) ok += " " + o;
			else               ko += " " + o;
		String s3 = (ok.isEmpty() ? "" : "contient :" + ok);
		String s4 = (ko.isEmpty() ? "" : "ne contient pas :" + ko);
		String s5 = mm ? "min : " + e.min(comp) + " ; max : " + e.max(comp) : "";
		System.out.println(s1 + "-> " + s2 + (s3.isEmpty() ? "" : "\n-> " + s3) + (s4.isEmpty() ? "" : "\n-> " + s4) + (mm ? "\n-> " + s5 : ""));
	}
	
}

/*

---- Exercice 1 : clone ----

Original : 
-> tab : [0, 1, 2, 3, 4, 5, null, null, null, null] - nbe : 6
-> toString() : "[ 0 1 2 3 4 5 ]" - size() : 6

Clone : 
-> tab : [0, 1, 2, 3, 4, 5, null, null, null, null] - nbe : 6
-> toString() : "[ 0 1 2 3 4 5 ]" - size() : 6

Ajout de 6 et 7, suppression de 0 dans l'original.
Suppression de 3 et 4, ajout de -1 dans le clone.

Original : 
-> tab : [7, 1, 2, 3, 4, 5, 6, 7, null, null] - nbe : 7
-> toString() : "[ 7 1 2 3 4 5 6 ]" - size() : 7

Clone : 
-> tab : [0, 1, 2, 5, -1, null, null, null, null, null] - nbe : 5
-> toString() : "[ 0 1 2 5 -1 ]" - size() : 5

---- Exercice 2 : union, inter et diff ----

E1          : [ 0 1 2 3 4 5 6 ]
E2          : [ 3 4 5 6 7 8 9 ]
E1 UNION E2 : [ 0 1 2 3 4 5 6 7 8 9 ]
E1 INTER E2 : [ 6 5 4 3 ]
E1 DIFF  E2 : [ 0 1 2 ]
E1          : [ 0 1 2 3 4 5 6 ]
E2          : [ 3 4 5 6 7 8 9 ]

---- Exercice 3 : min et max ----

Ensemble initial : 
-> tab : [null, null, null, null, null] - nbe : 0
-> toString() : "[ ]" - size() : 0
-> min : null ; max : null

Ajout de 5 : 
-> tab : [5, null, null, null, null] - nbe : 1
-> toString() : "[ 5 ]" - size() : 1
-> min : 5 ; max : 5

Ajout de 2, -1, 4, 8 et 6 : 
-> tab : [5, 2, -1, 4, 8, 6, null, null, null, null] - nbe : 6
-> toString() : "[ 5 2 -1 4 8 6 ]" - size() : 6
-> min : -1 ; max : 8

Ajout de 'x' : 
-> tab : [5, 2, -1, 4, 8, 6, x, null, null, null] - nbe : 7
-> toString() : "[ 5 2 -1 4 8 6 x ]" - size() : 7
-> min : null ; max : null

Ajout de -2 et 9 : 
-> tab : [5, 2, -1, 4, 8, 6, x, -2, 9, null] - nbe : 9
-> toString() : "[ 5 2 -1 4 8 6 x -2 9 ]" - size() : 9
-> min : null ; max : null

Suppression de 'x' : 
-> tab : [5, 2, -1, 4, 8, 6, 9, -2, 9, null] - nbe : 8
-> toString() : "[ 5 2 -1 4 8 6 9 -2 ]" - size() : 8
-> min : -2 ; max : 9

---- Exercice 4 : ChaineEnsemble : constructeur, toString, size, contains, add, remove et clone ----

Ensemble initial : 
-> debut : null - size : 0
-> toString() : "( )" - size() : 0
-> ne contient pas : 2 5 8 10

Ajout de 0, 1, 2, 3, 4 et 5 : 
-> debut : non null - size : 6
-> toString() : "( 5 4 3 2 1 0 )" - size() : 6
-> contient : 2 5
-> ne contient pas : 8 10

Ajout de 3, 4, 5, 6, 7 et 8 : 
-> debut : non null - size : 9
-> toString() : "( 8 7 6 5 4 3 2 1 0 )" - size() : 9
-> contient : 2 5 8
-> ne contient pas : 10

Suppression de 8 : 
-> debut : non null - size : 8
-> toString() : "( 7 6 5 4 3 2 1 0 )" - size() : 8
-> contient : 3 0
-> ne contient pas : 8

Suppression de 3 : 
-> debut : non null - size : 7
-> toString() : "( 7 6 5 4 2 1 0 )" - size() : 7
-> contient : 0
-> ne contient pas : 8 3

Suppression de 3 : 
-> debut : non null - size : 7
-> toString() : "( 7 6 5 4 2 1 0 )" - size() : 7
-> contient : 0
-> ne contient pas : 8 3

Suppression de 0 : 
-> debut : non null - size : 6
-> toString() : "( 7 6 5 4 2 1 )" - size() : 6
-> ne contient pas : 8 3 0

Original : 
-> debut : non null - size : 6
-> toString() : "( 5 4 3 2 1 0 )" - size() : 6

Clone : 
-> debut : non null - size : 6
-> toString() : "( 5 4 3 2 1 0 )" - size() : 6

Ajout de 6 et 7, suppression de 0 dans l'original.
Suppression de 3 et 4, ajout de -1 dans le clone.

Original : 
-> debut : non null - size : 7
-> toString() : "( 7 6 5 4 3 2 1 )" - size() : 7

Clone : 
-> debut : non null - size : 5
-> toString() : "( -1 5 2 1 0 )" - size() : 5

---- Exercice 5 : ChaineEnsemble : itérateurs (min, max et opérations ensemblistes) ----

Ensemble initial : 
-> debut : non null - size : 7
-> toString() : "( 6 5 4 3 2 1 0 )" - size() : 7

Parcours par itérateur : 6 5 4 3 2 1 0 
-> debut : non null - size : 7
-> toString() : "( 6 5 4 3 2 1 0 )" - size() : 7

Suppression des nombres pairs : 6[X] 5 4[X] 3 2[X] 1 0[X] 
-> debut : non null - size : 3
-> toString() : "( 5 3 1 )" - size() : 3

Ensemble initial : 
-> debut : non null - size : 3
-> toString() : "( 5 3 1 )" - size() : 3
-> contient : 5
-> ne contient pas : 2 8 10
-> min : 1 ; max : 5

Ajout de 0, 1, 2, 3, 4 et 5 : 
-> debut : non null - size : 6
-> toString() : "( 4 2 0 5 3 1 )" - size() : 6
-> contient : 2 5
-> ne contient pas : 8 10
-> min : 0 ; max : 5

Ajout de 3, 4, 5, 6, 7 et 8 : 
-> debut : non null - size : 9
-> toString() : "( 8 7 6 4 2 0 5 3 1 )" - size() : 9
-> contient : 2 5 8
-> ne contient pas : 10
-> min : 0 ; max : 8

Ajout de 'x' : 
-> debut : non null - size : 10
-> toString() : "( x 8 7 6 4 2 0 5 3 1 )" - size() : 10
-> min : null ; max : null

Ajout de -2 et 9 : 
-> debut : non null - size : 12
-> toString() : "( 9 -2 x 8 7 6 4 2 0 5 3 1 )" - size() : 12
-> min : null ; max : null

Suppression de 'x' : 
-> debut : non null - size : 11
-> toString() : "( 9 -2 8 7 6 4 2 0 5 3 1 )" - size() : 11
-> min : -2 ; max : 9

E1          : ( 6 5 4 3 2 1 0 )
E2          : ( 9 8 7 6 5 4 3 )
E1 UNION E2 : ( 7 8 9 6 5 4 3 2 1 0 )
E1 INTER E2 : ( 6 5 4 3 )
E1 DIFF  E2 : ( 2 1 0 )
E1          : ( 6 5 4 3 2 1 0 )
E2          : ( 9 8 7 6 5 4 3 )

*/
