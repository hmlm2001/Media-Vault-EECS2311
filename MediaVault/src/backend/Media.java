package backend;

public abstract class Media {
	private int id;
	protected String title;
	
	public Media(int id) {
		this.id=id;
	}
	/**
	 * @return the title of the movie
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * @return the id of the movie
	 */
	public int getId() {
		return this.id;
	}
}
