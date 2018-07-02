package unitTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import musicInstruments.Piano;

public class PianoTest {

	@Test
	public void constuctorTest() {
		Piano pianoUnit = new Piano("Yamaha", 340.50, 6);
		assertEquals("Yamaha", pianoUnit.getName());
		assertEquals(340.50, pianoUnit.getPrice(), 340.50);
		assertEquals(6, pianoUnit.getQuantity());
	}
	
}
