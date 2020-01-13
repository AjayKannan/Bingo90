package com.lindar.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class represents a Bing90 Ticket
 * 
 * @author Ajay
 *
 */
public class Ticket {

	/**
	 * Values of the Ticket as an Array
	 */
	private int[][] values = new int[3][9];

	/**
	 * Number of non zero element in the array
	 */
	private int noOfElements = 0;


	/**
	 * 
	 * This method adds an element into the ticket in a random position in the specified column.<p/>
	 * 
	 * It also ensures following conditions are satisfied 
	 * 
	 *<li/> Ensures that number of tickets is less than 15
	 *<li/> Ensures that number of elements in column is less than maxSize parameter
	 * 
	 * 
	 * @param column column to insert in
	 * @param value value to be inserted 
	 * @param maxSize max number of elements in the column
	 * @return <code>True</code> if successfully inserted <code>false</code> if unable to insert the element 
	 */
	public boolean add(int column, int value, int maxSize) {

		// Each ticket can have only 15 elements
		if (noOfElements >= 15)		return false;

		// determine the position which is empty
		List<Integer> freePositions = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			if (values[i][column] == 0) {
				freePositions.add(i);
			}
		}

		// if all the columns are filled
		if (freePositions.size() == 0)
			return false;

		if( maxSize == 2 && freePositions.size()== 1) return false;
		
		// randomly place the value in the column
		Collections.shuffle(freePositions);

		values[freePositions.get(0)][column] = value;
		noOfElements++;

		return true;
	}


	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.values[i][j] <= 9)
					message.append(" ");
				message.append(this.values[i][j]).append(" ");

			}
			message.append(System.lineSeparator());
		}

		return message.toString();
	}

	public int[][] getValues() {
		return values;
	}

	public void setValues(int[][] values) {
		this.values = values;
	}
}
