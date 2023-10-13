package wtf.sikelio;

import java.util.ArrayList;
import java.util.List;

public class CommentGenerator {
	private static CommentGenerator instance = null;

	protected static List<String> listComments;

	private CommentGenerator() {
		listComments = new ArrayList<String>();
		listComments.add("But des locaux !!!");
		listComments.add("But des visiteurs !!!");
		listComments.add("Touche en faveur des locaux");
		listComments.add("Touche en faveur des visiteurs");
		listComments.add("Hors-jeu des locaux");
		listComments.add("Hors-jeu des visiteurs");
		listComments.add("Coup-franc des locaux");
		listComments.add("Coup-franc des visiteurs");
		listComments.add("Pénalty pour les locaux");
		listComments.add("Pénalty pour les visiteurs");
		listComments.add("Remplacement d'un joueur local");
		listComments.add("Remplacement d'un joueur visiteur");
		listComments.add("6 mètres pour les locaux");
		listComments.add("6 mètres pour les visiteurs");
		listComments.add("Belle occasion pour les locaux !");
		listComments.add("Belle occasion pour les visiteurs !");
		listComments.add("Faute des locaux");
		listComments.add("Faute des visiteurs");
		listComments.add("Envahissement du terrain par des supporters !");
	}

	public static CommentGenerator getInstance() {
		if (instance == null) {
			instance = new CommentGenerator();
		}

		return instance;
	}

	public static String getRandomComment() {
		int i = (int) Math.floor(Math.random() * listComments.size());

		return listComments.get(i);
	}
}
