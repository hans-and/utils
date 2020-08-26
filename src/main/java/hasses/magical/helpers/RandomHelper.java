package hasses.magical.helpers;

import java.util.Date;
import java.util.Random;

public class RandomHelper {
	private static final String[] EXPLETIVS = { "Bella", "Blindstyre", "Bondlurk", "Bös", "Dissa", "Djävla",
			"DjävlarAnamma", "Drummel", "Dummerjöns", "Dyngspridare", "Enfälling", "Fan", "Fanken", "Fasiken", "Fitta",
			"FyFabian", "FyFan", "FyFarao", "FyFasiken", "FySkjuttsingen", "Fåntratt", "Förbaskad", "Gallfåne",
			"Gamla knölsvan", "Gnet", "Gnällspik", "Hagga", "Helvete", "Helvetti", "Hönshjärna", "Jädra", "Jäkla",
			"Jävla", "Jävlar", "Kanalje", "Klägg", "Knickedick", "Kräkla", "Krämare", "Kuk", "Kuse", "Lortpåse",
			"Luskung", "Morsgris", "Mög", "Pajas", "Perkele", "Pirra", "Planta", "Plattfot", "Potatisgris", "Pottsork",
			"Praktarsle", "Pulver", "Rötägg", "Saatana", "Sarre", "Satan", "Sjutton", "Skabbhals", "Skabbråtta",
			"Skinnbracka", "Skit", "Skojare", "Slappsvans", "Snorslev", "Snortut", "Snorvalp", "Sopprot",
			"Storsnorkare", "Sula", "Svinpäls", "Syltrygg", "Talglymmel", "Tjockskalle", "Tyken", "Tångräka", "Vafan",
			"Vittu", "Ärkebandit", "XXX", "ZZZ" };
	private static final Random rand = new Random(new Date().getTime());

	public static String getConfirmationWord() {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 6; i++)
			builder.append(EXPLETIVS[rand.nextInt(EXPLETIVS.length - 1)]);

		return builder.toString();
	}

}
