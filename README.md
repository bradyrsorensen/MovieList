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
