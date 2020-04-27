package simulation;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.*;

public class RandomGenerator {
	private Random random;
	private RandomAccessFile firstNames;
	private RandomAccessFile lastNames;
	private RandomAccessFile words;
	
	public RandomGenerator() {
		try {
			firstNames = new RandomAccessFile("storage/simulation/firstNames.txt","r");
			lastNames = new RandomAccessFile("storage/simulation/lastNames.txt","r");
			words = new RandomAccessFile("storage/simulation/words.txt","r");
		}catch(FileNotFoundException e){
			throw new Error(e);
		}
		random = new Random();
	}
}
