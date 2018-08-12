
public class MarvelCharacters {
	public static void main(String[] args) {
		try {
			MarvelCharactersService gmc = new MarvelCharactersService();
			gmc.getCharacters();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
