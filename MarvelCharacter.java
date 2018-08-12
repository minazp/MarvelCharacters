
public class MarvelCharacter implements Comparable <MarvelCharacter>{
	private int id;
	private int totalComics;
	private int totalStories;
	private int totalAppearances;
	
	/**
	 * @return the totalComics
	 */
	public int getTotalComics() {
		return totalComics;
	}

	/**
	 * @return the totalStories
	 */
	public int getTotalStories() {
		return totalStories;
	}

	/**
	 * @return the totalAppearances
	 */
	public int getTotalAppearances() {	
		totalAppearances = totalStories + totalComics;
		return totalAppearances;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param totalComics the totalComics to set
	 */
	public void setTotalComics(int totalComics) {
		this.totalComics = totalComics;
	}
	
	/**
	 * @param totalStories the totalStories to set
	 */
	public void setTotalStories(int totalStories) {
		this.totalStories = totalStories;
	}


	@Override
	public int compareTo(MarvelCharacter compareMarvelCharacter) {
		int compareCharacter = compareMarvelCharacter.getTotalAppearances();
		return compareCharacter - this.totalAppearances;
	}
}