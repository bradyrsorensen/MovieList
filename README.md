# MovieList
A small project which challenges myself to create robust and reusable code when it comes to dealing with data structues. 
## Introduction
This project started as a class assignment for a data structures class that I had, however I found the information and concepts given to us interesting enough that I wanted to expand upon it on my own. The idea of this project is fairly simple but it has some very interesting parts of it that I would like to highlight. 
Given a database of movies, or for the purposes of this project a text file which has information about movies in it, the user should be able to search that database of movies using specific tags such as movie name, whether what is input is exact or containing, movie genre, all movies are marked with what ever specific genre they fall into, and average rating, accompaning the text file with all the inforamation about movies, there is also a second text file which contains users ratings for the movies, meaning the user should be able to narrow their search by rating as well. 
## Highlights
To start I would like to draw attention to the text file that is used in this project to store all of the movie data, this data is formated in a specific way.

For Example: 1|Toy Story (1995)|01-Jan-1995||http://us.imdb.com/M/title-exact?Toy%20Story%20(1995)|0|0|0|1|1|1|0|0|0|0|0|0|0|0|0|0|0|0|0

This is so that I can token up the various information and put them in there respective fields.
```java
// gets tokens from string
String[] tokens = movieInfo.split("\\|");
```
1's and 0's are used in this format to denote true and false respectivly, this way I can determine what genres a movie falls under.
```java
// checks input file for 1 and 0 and sets boolean array elements to true if 1
// and false if 0
for (int i = 5; i < tokens.length; i++) {
	if (Integer.parseInt(tokens[i]) == 1) {
		genre[j] = true;
	}
	j++;
}
```
Given this format it is quite easy to add more movies to the text file as long as it follows the format. Additionally it would also be easy to add a method which will add user input movies to a serializable file and format the data automatically.

Let's continue to look at methods which deal with the genres of movies, here we see an example of code which takes an input genre from the user and checks through the movie list to select movies that match that genre and then adds those to a queue.
```java
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
```

