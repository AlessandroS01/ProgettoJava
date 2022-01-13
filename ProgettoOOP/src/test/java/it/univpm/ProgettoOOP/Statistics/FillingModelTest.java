package it.univpm.ProgettoOOP.Statistics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import it.univpm.ProgettoOOP.Model.Place;
class FillingModelTest {
   public FillingModel modelIntoJson = new FillingModel();
	public Place place;

	@Test
	void test() {
		this.place = modelIntoJson.fillPlaceForecast(); 
		assertNotNull("The field gust is not provided", place);
	}
	

}
