package movieList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class MovieQueue extends LinkedTransferQueue<Movies> {

	// builds the MovieQueue from the file name that is passed
	public void fromFile(String fileName) throws FileNotFoundException {

		// gets name of file and opens it
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		while (inputFile.hasNext()) {

			// creates movie object
			Movies movie = new Movies(inputFile.nextLine());

			// adds movie object to queue
			this.add(movie);

		}

		inputFile.close();

	}

	// method that returns a MovieQueue of movies that match the type that was
	// passed
	public MovieQueue findType(String type) {

		// creates new MovieQueue that will hold the movies with patching type
		MovieQueue typeQueue = new MovieQueue();

		String compareString; // holds string that gets compared to the type
		Iterator<Movies> toHold; // holds Iterator object of type movies
		Movies movie; // holds movies object

		toHold = this.iterator();
		movie = toHold.next();

		// checks that the type passed is a valid genre
		for (int i = 0; i < movie.getGenreList().length; i++) {

			// checks for a valid type, if found exits the loop
			if (movie.getGenreList()[i].equalsIgnoreCase(type)) {

				break;

			}

			// checks to see if all elements of the array have been checked
			if (i == movie.getGenreList().length - 1) {

				// if no element matches the type passed it is not a valid type
				System.out.println("not a valid type");

			}

		}

		// Adds movies to the typeQueue that match the type that was passed
		for (int j = 0; j < this.size(); j++) {

			for (int i = 0; i < movie.getGenre().length; i++) {

				// checks what genre the movie is
				if (movie.getGenre()[i] == true) {

					compareString = movie.getGenreList()[i];

					// checks to see if that genre matches the one passed, if it does, adds it to
					// queue
					if (compareString.equalsIgnoreCase(type)) {

						typeQueue.add(movie);

					}

				}

			}

			// checks to see if there is another movie in queue, if there is, gets the next
			// one
			if (toHold.hasNext()) {

				movie = toHold.next();

			}

		}

		// returns the queue of movies that match the genre
		return typeQueue;

	}

}
