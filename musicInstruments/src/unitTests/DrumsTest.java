package unitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import musicInstruments.Drums;

public class DrumsTest {

	@Test
	public void constuctorTest() {
		Drums drumsUnit = new Drums("Yamaha", 550, 5);
		assertEquals("Yamaha", drumsUnit.getName());
		assertEquals(550.0, drumsUnit.getPrice(), 550.0);
		assertEquals(5, drumsUnit.getQuantity());
	}

}
