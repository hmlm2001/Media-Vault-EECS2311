package backend;

public abstract class Media {
	private int id;
	protected String title;
	private String status;
	
	public Media(int id) {
		this.id=id;
		this.status="---";
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
	/**
	 * Get the status of the media
	 * @return the status as a string
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * Set the status of a media
	 * @param status is the input status String which will overwrite the existing status
	 * @return the instance with the updated status
	 */
	public Media setStatus(String status) { 
		this.status=status;
		return this;
	}
}
