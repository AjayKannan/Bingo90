package com.lindar.service;

import java.util.ArrayList;

import com.lindar.bean.Ticket;
import com.lindar.bean.TicketStrip;
import com.lindar.util.NumberUtil;

/**
 * Class to generate Bingo 90 Tickets
 * 
 * @author Ajay
 *
 */
public class TicketGenerator {

	/**
	 * Instance of the ticket strip 
	 */
	private TicketStrip ticketStrip = new TicketStrip();

	/**
	 * Instance of the NumberUtil class
	 */
	private NumberUtil numberUtil = new NumberUtil();

	/**
	 * Method to generate the Bingo Ticket Strip 
	 */

	public void generate() {

		// Add one number in each column in all the tickets
		this.addOneElementToEachColumn();

		// fill the remaining 3 numbers into random tickets max 2 per column
		this.fillTicket(3, 2);
		// fill the remaining number into random tickets max 3 per column
		this.fillTicket(1, 3);

		// re arrange the number to ensure only 5 elements per row
		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];
			ensure5ElementsPerRow(ticket, 0);
			ensure5ElementsPerRow(ticket, 1);
			ensure5ElementsPerRow(ticket, 2);
		}
	}

	/**
	 * Method to Add an element to each of the column of the every ticket
	 * 
	 * Refer to {@link com.lindar.util.NumberUtil)} for number allocation strategy
	 */
	private void addOneElementToEachColumn() {

		for (int i = 0; i < 9; i++) {
			// min and max range for a column
			int min = (i * 10) + 1;
			int max = (i * 10) + 10;
			for (int j = 0; j < 6; j++) {
				int numberToAdd = numberUtil.getUnAllocatedNumberFromRange(min, max);
				// add number to jth ticket in column i
				ticketStrip.addNumberToTicket(j, numberToAdd, i);
			}
		}
	}

	/**
	 * Method to fill specified number of elements into every ticket and ensure number of elements in each
	 * column to be less than <code>maxPerColumn</code>
	 * 
	 * 
	 * Refer to {@link com.lindar.util.NumberUtil)} for number allocation strategy
	 * 
	 */
	public void fillTicket(int numberOfElements, int maxPerColumn) {

		int counter = 0;
		while (counter < numberOfElements) {
			for (int i = 0; i < 9; i++) {
				int min = (i * 10) + 1;
				int max = (i * 10) + 10;
				int numberToAdd = 1;
				// if all the numbers for the column is already filled -1 will be returned
				numberToAdd = numberUtil.getUnAllocatedNumberFromRange(min, max);

				boolean allocated = false;
				while (!allocated) {
					allocated = ticketStrip.addNumberToRandomTicket(numberToAdd, i, maxPerColumn);
				}
			}
			counter++;
		}
	}
	
	/**
	 * 
	 * Method will ensure that only 5 elements are present in any row
	 * 
	 * This method will swap the elements into other rows if it finds more than one element in a row
	 * 
	 * @param ticket Instance of the ticket  
	 * 
	 * @param sourceRow The row to ensure 5 elements in a row
	 */
	private void ensure5ElementsPerRow(Ticket ticket, int sourceRow) {

		ArrayList<Integer> rows = new ArrayList<Integer>();
		rows.add(0);
		rows.add(1);
		rows.add(2);
		rows.remove(sourceRow);

		for (int i = 0; i < 9; i++) {
			if (getElementCount(ticket, sourceRow) == 5)
				break;
			for (Integer row : rows) {
				swapElementsInRow(ticket, ticket.getValues()[sourceRow][i], i, row, sourceRow);
			}
		}
	}

	/**
	 * Method to swap elements between row
	 * 
	 * @param ticket Instance of the ticket
	 * @param value value to swap
	 * @param column column in which the value is present 
	 * @param row row in which the value is present 
	 * @param replaceRow the row in which the element needs to be replaced 
	 * 
	 * @return <code>True</code> if the element could be swapped <False> if it could be swapped 
	 */
	private boolean swapElementsInRow(Ticket ticket, int value, int column, int row, int replaceRow) {

		int count = 0;

		for (int i = 0; i < 9; i++) {
			if (ticket.getValues()[row][i] != 0)
				count++;
		}
		if (count >= 5)
			return false;

		int temp = ticket.getValues()[row][column];
		if (temp == 0) {
			ticket.getValues()[row][column] = value;
			ticket.getValues()[replaceRow][column] = 0;
		}

		return false;
	}


	private int getElementCount(Ticket ticket, int row) {

		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (ticket.getValues()[row][i] != 0)
				count++;
		}
		return count;
	}
	
	public TicketStrip getTicketStrip() {
		return ticketStrip;
	}

}
