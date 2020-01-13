package com.lindar.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * This call will help to generate the numbers required to fill each column
 * 
 * Each list represents a column and will maintain state of allocated and un allocated values 
 * 
 * The first column contains numbers from 1 to 10,
 * The second column numbers from 11 to 20,
 * The third,  21 to 30 and so on up until the last column, which contains numbers from 81 to 90.
 * 
 * 
 * 
 * @author Ajay
 *
 */
public class NumberUtil {

	// we can also represent this as ArrayList<ArrayList<Integer>, however, this may be difficult to visualise 
	
	private ArrayList<Integer> firstColumn = new ArrayList<Integer>();
	private ArrayList<Integer> secondColumn = new ArrayList<Integer>();
	private ArrayList<Integer> thirdColumn = new ArrayList<Integer>();
	private ArrayList<Integer> fourthColumn = new ArrayList<Integer>();
	private ArrayList<Integer> fifthColumn = new ArrayList<Integer>();
	private ArrayList<Integer> sixthColumn = new ArrayList<Integer>();
	private ArrayList<Integer> seventhColumn = new ArrayList<Integer>();
	private ArrayList<Integer> eightColumn = new ArrayList<Integer>();
	private ArrayList<Integer> ninethColumn = new ArrayList<Integer>();



	public int getUnAllocatedNumberFromRange(int min, int max) {

		if (min == 1 && max == 10 && firstColumn.size() > 0) {
			int numberToReturn = firstColumn.get(0);
			firstColumn.remove(0);
			return numberToReturn;
		}

		if (min == 11 && max == 20 && secondColumn.size() > 0) { 
			int numberToReturn = secondColumn.get(0);
			secondColumn.remove(0);
			return numberToReturn;
		}

		if (min == 21 && max == 30 && thirdColumn.size() > 0) { 
			int numberToReturn = thirdColumn.get(0);
			thirdColumn.remove(0);
			return numberToReturn;
		}

		if (min == 31 && max == 40 && fourthColumn.size() > 0) { 
			int numberToReturn = fourthColumn.get(0);
			fourthColumn.remove(0);
			return numberToReturn;
		}
		if (min == 41 && max == 50 && fifthColumn.size() > 0) { 
			int numberToReturn = fifthColumn.get(0);
			fifthColumn.remove(0);
			return numberToReturn;
		}
		if (min == 51 && max == 60 && sixthColumn.size() > 0) { 
			int numberToReturn = sixthColumn.get(0);
			sixthColumn.remove(0);
			return numberToReturn;
		}
		if (min == 61 && max == 70 && seventhColumn.size() > 0) { 
			int numberToReturn = seventhColumn.get(0);
			seventhColumn.remove(0);
			return numberToReturn;
		}
		if (min == 71 && max == 80 && eightColumn.size() > 0) { 
			int numberToReturn = eightColumn.get(0);
			eightColumn.remove(0);
			return numberToReturn;
		}

		if (min == 81 && max == 90 && ninethColumn.size() > 0) { 
			int numberToReturn = ninethColumn.get(0);
			ninethColumn.remove(0);
			return numberToReturn;
		}
		
		return -1;
	}

	
	/**
	 *  Constructor to setup the list for each column 
	 *  Shuffle to randomise
	 */
	public NumberUtil() {
		super();

		for (int i = 1; i <= 10; i++) {
			firstColumn.add(i);
		}
		Collections.shuffle(firstColumn);

		for (int i = 11; i <= 20; i++) {
			secondColumn.add(i);
		}
		Collections.shuffle(secondColumn);

		for (int i = 21; i <= 30; i++) {
			thirdColumn.add(i);
		}
		Collections.shuffle(thirdColumn);

		for (int i = 31; i <= 40; i++) {
			fourthColumn.add(i);
		}
		Collections.shuffle(secondColumn);

		for (int i = 41; i <= 50; i++) {
			fifthColumn.add(i);
		}
		Collections.shuffle(fifthColumn);

		for (int i = 51; i <= 60; i++) {
			sixthColumn.add(i);
		}
		Collections.shuffle(sixthColumn);

		for (int i = 61; i <= 70; i++) {
			seventhColumn.add(i);
		}
		Collections.shuffle(seventhColumn);

		for (int i = 71; i <= 80; i++) {
			eightColumn.add(i);
		}
		Collections.shuffle(eightColumn);

		for (int i = 81; i <= 90; i++) {
			ninethColumn.add(i);
		}
		Collections.shuffle(ninethColumn);

	}
}
