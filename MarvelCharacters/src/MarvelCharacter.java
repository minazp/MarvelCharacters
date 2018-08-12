
public class MarvelCharacter {
	private int id;
	private int totalComics;
	private int totalStories;
	
	/**
	 * @return the totalAppearances
	 */
	public int getTotalAppearances() {		
		return totalStories + totalComics;
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
}
