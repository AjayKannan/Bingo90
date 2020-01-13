package com.lindar.service.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.lindar.bean.Ticket;
import com.lindar.bean.TicketStrip;
import com.lindar.service.TicketGenerator;

public class GenertorTest {

	@Test
	public void checkIfAllNumbersArePresentInStip() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		ArrayList<Integer> numberFromOneTo90 = new ArrayList<Integer>();
		for (int i = 1; i <= 90; i++)
			numberFromOneTo90.add(i);

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					numberFromOneTo90.remove(Integer.valueOf(ticket.getValues()[i][j]));
				}
			}
		}

		for (Integer integer : numberFromOneTo90) {
			System.out.println(integer);
		}

		if (numberFromOneTo90.size() > 0)
			fail("All numbers not part of ticket");
	}

	@Test
	public void checkIfEachRowContainsFiveNumbers() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];

			for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 9; j++) {
					if (ticket.getValues()[i][j] != 0)
						count++;
				}
				if (count != 5)
					fail("Each row does not contain 5 numbers");
			}
		}
	}

	@Test
	public void checkIfEachRowContainsFourBlankSpaces() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];

			for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 9; j++) {
					if (ticket.getValues()[i][j] == 0)
						count++;
				}
				if (count != 4)
					fail("Each row does not contain 5 numbers");
			}
		}
	}

	@Test
	public void checkIfEachColumnHasAtLeastOneNumber() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];

			for (int i = 0; i < 9; i++) {
				int count = 0;
				for (int j = 0; j < 3; j++) {
					if (ticket.getValues()[j][i] != 0)
						count++;
				}
				if (count == 0)
					fail("Column does not have at least one element" + count);
			}
		}
	}

	@Test
	public void checkEachColumnRange() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 3; j++) {
					if (!(ticket.getValues()[j][i] <= (i * 10) + 10))
						fail("Incorrect value in column");
				}
			}
		}
	}

	@Test
	public void checkEachTicketHasOnly15Elements() {
		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];
			int count = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					if (ticket.getValues()[i][j] != 0)
						count++;
				}
			}
			if (count!=15)fail("Incorrect number of elments in ticket");
		}
	}

	@Test
	public void checkForDuplicateNumbers() {

		TicketGenerator ticketGenerator = new TicketGenerator();
		ticketGenerator.generate();
		TicketStrip ticketStrip = ticketGenerator.getTicketStrip();

		// key as element of the ticket and value as the number of occurrence
		HashMap<Integer,Integer> valueMap = new HashMap<Integer,Integer>();
				
		for (int k = 0; k < 6; k++) {
			Ticket ticket = ticketStrip.getTickets()[k];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					Integer value = valueMap.get(ticket.getValues()[i][j]);
						if (value == null) valueMap.put(value, 0);
						else fail(value + " occurance more than once");
				}
			}
		}
	}
}
