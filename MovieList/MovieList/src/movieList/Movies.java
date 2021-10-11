package movieList;

public class Movies {

	protected int movieId; // holds the movie id
	protected String movieName; // holds the movie name
	protected String releaseDate; // holds the movie release date
	protected String videoReleaseDate; // holds the video release date
	protected String url; // holds the url
	protected boolean[] genre = new boolean[19]; // holds the booleans to determine genre
	protected String genreList[] = { "unknown", "Action", "Adventure", "Animation", "Children's", "Comedy", "Crime",
			"Documentary", "Drama", "Fantasy", "Film-Noir", "Horror", "Musical", "Mystery", "Romance", "Sci-Fi",
			"Thriller", "War", "Western" }; // holds the names of the genres themselves

	// creates constructor that accepts an int four strings and a boolean array
	public Movies(int newMovieId, String newMovieName, String newReleaseDate, String newVideoReleaseDate, String newUrl,
			boolean newGenre[]) {

		movieId = newMovieId;
		movieName = newMovieName;
		releaseDate = newReleaseDate;
		videoReleaseDate = newVideoReleaseDate;
		url = newUrl;
		genre = newGenre;

	}

	// creates constructor that accepts a string from input file
	public Movies(String movieInfo) {

		// initializes variable j
		int j = 0;

		// gets tokens from string
		String[] tokens = movieInfo.split("\\|");

		// sets each field with tokens from input file
		movieId = Integer.parseInt(tokens[0]);
		movieName = tokens[1];
		releaseDate = tokens[2];
		videoReleaseDate = tokens[3];
		url = tokens[4];

		// checks input file for 1 and 0 and sets boolean array elements to true if 1
		// and false if 0
		for (int i = 5; i < tokens.length; i++) {

			if (Integer.parseInt(tokens[i]) == 1) {

				genre[j] = true;

			}

			j++;

		}
	}

	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the videoReleaseDate
	 */
	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}

	/**
	 * @param videoReleaseDate the videoReleaseDate to set
	 */
	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the genre
	 */
	public boolean[] getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(boolean[] genre) {
		this.genre = genre;
	}
	
	public String[] getGenreList() {
		return genreList;
	}

	// creates string to be displayed in console
	public String toString() {

		StringBuilder msg = new StringBuilder();

		msg.append("Movie: " + "\n");
		msg.append(" ID: ");
		msg.append(movieId + "\n");
		msg.append(" Name: ");
		msg.append(movieName + "\n");
		msg.append(" Released: ");
		msg.append(releaseDate + "\n");
		msg.append(" Video Released: ");
		msg.append(videoReleaseDate + "\n");
		msg.append(" URL: ");
		msg.append(url + "\n");

		// checks which elements of boolean array are true and displays corresponding
		// genre
		for (int i = 0; i < genre.length; i++) {

			if (genre[i] == true) {

				msg.append(" type: ");
				msg.append(" " + genreList[i] + " " + "\n");

			}

		}

		return msg.toString();

	}
}
