package com.lindar.bean;

import com.lindar.util.RandomUtil;

/**
 * Class to represent a Ticket Strip. </p>
 * 
 * Each strips has 6 tickets, because this allows every number from 1 to 90 to appear across all 6 tickets. 
 * If they buy a full strip of six it means that players are guaranteed to mark off a 
 * number every time a number is called.
 * 
 * @author Ajay
 *
 */
public class TicketStrip {

	/**
	 * Array to store 6 tickets of a strip
	 */
	Ticket[] tickets = new Ticket[6];

	/**
	 * Initialise the array 
	 */
	public TicketStrip() {
		
		for(int i=0;i<6;i++) {
			tickets[i] = new Ticket();
		}
	}

	/**
	 * Method to add a number to the specific ticket in the strip in a specific column
	 * 
	 * Refer to {@link com.lindar.bean.Ticket#add(int,int,int)} 
	 * 
	 * @param ticketIndex Index of the ticket to be added 
	 * @param numberToAdd value/element to be added
	 * @param column index of the column to be added 
	 * @return <code>True</code> if successfully inserted <code>false</code> if unable to insert the element 
	 */
	public boolean addNumberToTicket(int ticketIndex, int numberToAdd, int column) {

		Ticket ticket = tickets[ticketIndex];
		return ticket.add(column,numberToAdd,3);
	}
	
	
	/**
	 * Method to add a number to the specific ticket in the strip  in Random postion 
	 * 
	 * Refer to {@link com.lindar.bean.Ticket#add(int,int,int)} 
	 * 
	 * @param numberToAdd value/element to be added
	 * @param column index of the column to be added 
	 * @return <code>True</code> if successfully inserted <code>false</code> if unable to insert the element 
	 */
	public boolean addNumberToRandomTicket(int numberToAdd, int column, int maxSize) {

		int randomIndex = RandomUtil.getRandomNmber(0, 5);
		Ticket ticket = tickets[randomIndex];
		return ticket.add(column,numberToAdd,maxSize);
	}

	/**
	 * Method to print the ticket details on console 
	 */
	public void print() {
		for(int i=0;i<6;i++) {
			Ticket ticket = this.tickets[i];
			System.out.println(ticket);
		}
	}
	
	public Ticket[] getTickets() {
		return tickets;
	}
}
