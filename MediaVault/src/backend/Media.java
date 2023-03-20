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
	public String getStatus() {
		return this.status;
	}
	public Media setStatus(String status) { 
		this.status=status;
		return this;
	}
}
