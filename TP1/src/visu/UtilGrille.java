package visu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe utilitaire pour la lecture et l'écriture de fichiers de grilles.
 */
public class UtilGrille {

	/**
	 * Crée un tableau de cellules à partir d'un fichier texte.
	 * 
	 * @param fichier nom du fichier texte
	 * @return tableau créé à paertir du fichier
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public static boolean[][] load(String fichier) throws IOException {
		boolean[][] res;
		BufferedReader br = new BufferedReader(new FileReader(fichier));
		SortedSet<Integer> nbnbc = new TreeSet<>();
		List<String> lignes = new ArrayList<>();
		for (String l = br.readLine(); l != null; l = br.readLine()) {
			nbnbc.add(l.length());
			lignes.add(l);
		}
		if (lignes.isEmpty()) res = null;
		else {
			int nbc = nbnbc.last();
			if (nbc == 0) res = null;
			else {
				int nbl = lignes.size();
				res = new boolean[nbl][nbc];
				for (int i = 0; i < nbl; i++) {
					String l = lignes.get(i);
					for (int j = 0; j < l.length(); j++)
						res[i][j] = l.charAt(j) == 'O';
				}
			}
		}
		br.close();
		return res;
	}

	/**
	 * Sauvegarde un tableau de cellules dans un fichier texte.
	 * 
	 * @param tab     tableau à sauvegarder
	 * @param fichier nom du fichier texte
	 * @throws IOException soulevée si le fichier n'est pas accessible
	 */
	public static void save(boolean[][] tab, String fichier) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichier));
		for (boolean[] ligne : tab) {
			for (boolean c : ligne)
				bw.write(c ? "O" : ".");
			bw.newLine();
		}
		bw.close();
	}

}
