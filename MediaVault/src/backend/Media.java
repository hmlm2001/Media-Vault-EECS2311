package backend;

public class Media extends DBvsStub{
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
	public int getId() {
		return this.id;
	}
}
