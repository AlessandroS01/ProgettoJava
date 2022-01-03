package it.univpm.ProgettoOOP.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RootsTest {

	@Test
	void test() {
		Roots root = new Roots();
		String output1 = root.writer(null);
		String output2 = root.writerForecast(null);
		assertEquals( "Caricamento completato" , output1);
		assertEquals( "Caricamento completato" , output2);
	}

}
