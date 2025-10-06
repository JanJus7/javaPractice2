package tests;

import collection.*;

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

class Main {

	public static void main(String[] args) {
		
		System.out.println("---- Exercices 1 et 2 : constructeur, toString, size, contains et add ----\n");
	
		TabEnsemble e = new TabEnsemble();
		System.out.println("Ensemble initial : "); affiche(e, 'b', 'e', 'h', 'j');
		for (char c = 'a'; c < 'g'; c++) e.add(c);
		System.out.println("\nAjout de 'a', 'b', 'c', 'd', 'e' et 'f' : "); affiche(e, 'b', 'e', 'h', 'j');
		for (char c = 'c'; c < 'i'; c++) e.add(c);
		System.out.println("\nAjout de 'c', 'd', 'e', 'f', 'g' et 'h' : "); affiche(e, 'b', 'e', 'h', 'j');
	
		System.out.println("\n---- Exercice 3 : remove ----\n");
/*		
		e = new TabEnsemble();
		for (char c = 'a'; c < 'h'; c++) e.add(c);
		System.out.println("Ensemble initial : "); affiche(e, 'g', 'c', 'a');
		e.remove('g');
		System.out.println("\nSuppression de 'g' : "); affiche(e, 'g', 'c', 'a');
		e.remove('c');
		System.out.println("\nSuppression de 'c' : "); affiche(e, 'g', 'c', 'a');
		e.remove('c');
		System.out.println("\nSuppression de 'c' : "); affiche(e, 'g', 'c', 'a');
		e.remove('a');
		System.out.println("\nSuppression de 'a' : "); affiche(e, 'g', 'c', 'a');
*/		
		System.out.println("\n---- Exercice 4 : itérateurs ----\n");
/*		
		e = new TabEnsemble();
		for (char c = 'a'; c < 'h'; c++) e.add(c);
		System.out.println("Ensemble initial : "); affiche(e);
		System.out.print("\nParcours par itérateur : ");
		for (Iterateur it = e.getIterateur(); it.hasNext();) System.out.print(it.next() + " ");
		System.out.println(); affiche(e);
		System.out.print("\nSuppression des voyelles : ");
		for (Iterateur it = e.getIterateur(); it.hasNext();) {
			char c = (char) (it.next()); System.out.print(c);
			switch (c) {
			case 'a': case 'e': case 'i': case 'o': case 'u': case 'y':  
				System.out.print("[X] "); it.remove(); break;
			default : System.out.print(" ");
			}
		}
		System.out.println(); affiche(e);
*/		
	}

	// ******************************* FONCTION D'AFFICHAGE

	static void affiche(TabEnsemble e, Object... t) {
		String s1 = e.toStringInterne();
		String s2 = "toString() : \"" + e.toString() + "\" - size() : " + e.size();
		String ok = "", ko = "";
		for (Object o : t)
			if (e.contains(o)) ok += " " + o;
			else               ko += " " + o;
		String s3 = (ok.isEmpty() ? "" : "contient :" + ok);
		String s4 = (ko.isEmpty() ? "" : "ne contient pas :" + ko);
		System.out.println("-> " + s1 + "\n-> " + s2 + (s3.isEmpty() ? "" : "\n-> " + s3) + (s4.isEmpty() ? "" : "\n-> " + s4));
	}

}

/*

---- Exercices 1 et 2 : constructeur, toString, size, contains et add ----

Ensemble initial : 
-> tab : [null, null, null, null, null] - nbe : 0
-> toString() : "[ ]" - size() : 0
-> ne contient pas : b e h j

Ajout de 'a', 'b', 'c', 'd', 'e' et 'f' : 
-> tab : [a, b, c, d, e, f, null, null, null, null] - nbe : 6
-> toString() : "[ a b c d e f ]" - size() : 6
-> contient : b e
-> ne contient pas : h j

Ajout de 'c', 'd', 'e', 'f', 'g' et 'h' : 
-> tab : [a, b, c, d, e, f, g, h, null, null] - nbe : 8
-> toString() : "[ a b c d e f g h ]" - size() : 8
-> contient : b e h
-> ne contient pas : j

---- Exercice 3 : remove ----

Ensemble initial : 
-> tab : [a, b, c, d, e, f, g, null, null, null] - nbe : 7
-> toString() : "[ a b c d e f g ]" - size() : 7
-> contient : g c a

Suppression de 'g' : 
-> tab : [a, b, c, d, e, f, g, null, null, null] - nbe : 6
-> toString() : "[ a b c d e f ]" - size() : 6
-> contient : c a
-> ne contient pas : g

Suppression de 'c' : 
-> tab : [a, b, f, d, e, f, g, null, null, null] - nbe : 5
-> toString() : "[ a b f d e ]" - size() : 5
-> contient : a
-> ne contient pas : g c

Suppression de 'c' : 
-> tab : [a, b, f, d, e, f, g, null, null, null] - nbe : 5
-> toString() : "[ a b f d e ]" - size() : 5
-> contient : a
-> ne contient pas : g c

Suppression de 'a' : 
-> tab : [e, b, f, d, e] - nbe : 4
-> toString() : "[ e b f d ]" - size() : 4
-> ne contient pas : g c a

---- Exercice 4 : itérateurs ----

Ensemble initial : 
-> tab : [a, b, c, d, e, f, g, null, null, null] - nbe : 7
-> toString() : "[ a b c d e f g ]" - size() : 7

Parcours par itérateur : a b c d e f g 
-> tab : [a, b, c, d, e, f, g, null, null, null] - nbe : 7
-> toString() : "[ a b c d e f g ]" - size() : 7

Suppression des voyelles : a[X] g b c d e[X] f 
-> tab : [g, b, c, d, f, f, g, null, null, null] - nbe : 5
-> toString() : "[ g b c d f ]" - size() : 5

*/

