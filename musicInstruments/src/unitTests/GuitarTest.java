package unitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import musicInstruments.Guitar;

public class GuitarTest {

	@Test
	public void constuctorTest() {
		Guitar guitarUnit = new Guitar("Orpheus", 40.0, 2);
		assertEquals("Orpheus", guitarUnit.getName());
		assertEquals(40.0, guitarUnit.getPrice(), 40.0);
		assertEquals(2, guitarUnit.getQuantity());
	}
	
}
