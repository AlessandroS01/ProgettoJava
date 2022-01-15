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

	/**
	 * This method is used to keep an eye on the automatic writer of the local file ApiCallsByTime.
	 */
	@Test
	void test() {
		this.place = modelIntoJson.fillPlaceForecast(); 
		assertNotNull("The field gust is not provided", place);
	}
	

}
