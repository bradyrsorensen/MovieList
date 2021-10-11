package movieList;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class MovieQueueMain {

	@Test
	void test() throws FileNotFoundException {
		
		//creates movieQueue queue
		MovieQueue movieQueue = new MovieQueue();
		
		//fills queue with objects from a given file
		movieQueue.fromFile("ushort.item");
		
		//test cases
		System.out.println(movieQueue.findType("Comedy"));
		System.out.println();
		System.out.println(movieQueue.findType("a"));
		System.out.println();
		System.out.println(movieQueue.findType("Drama"));
		System.out.println();
		
	}
	
	@Test
	void large() throws FileNotFoundException {
		
		//creates movieQueue queue
		MovieQueue movieQueue = new MovieQueue();
		//creates comedyQueue queue
		MovieQueue comedyQueue = new MovieQueue();
		int counter = 0; //counter that holds value of number of comedy movies
		
		//fills queue with objects from a given file
		movieQueue.fromFile("u.item");
		
		comedyQueue = movieQueue.findType("Comedy");
		
		//checks how many comedy movies there were in the comedyQueue
		while (!comedyQueue.isEmpty()) {
			
			comedyQueue.remove();
			
			counter++;
			
		}
		
		System.out.println(counter);
		
	}

}
