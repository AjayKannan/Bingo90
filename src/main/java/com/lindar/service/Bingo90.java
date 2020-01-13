package com.lindar.service;

public class Bingo90 {

	public static void main(String[] args) {
		TicketGenerator generator = new TicketGenerator();
		generator.generate();
		generator.getTicketStrip().print();
	}
}
