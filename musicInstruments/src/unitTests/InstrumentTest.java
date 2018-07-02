package unitTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import musicInstruments.Guitar;
import musicInstruments.Instrument;

public class InstrumentTest {
	
	@Test
	public void increaseQuantityOfGuitarTest() {
		Instrument guitarUnit = new Guitar("Orpheus", 40.0, 2);
		guitarUnit.increaseQuantity(4);
		int newQuantity = guitarUnit.getQuantity();
		assertEquals(6, newQuantity);
	}
	
	@Test
	public void decreaseQuantityOfGuitarTest() {
		Instrument guitarUnit = new Guitar("Orpheus", 65.20, 6);
		guitarUnit.decreaseQuantity(2);
		int newQuantity = guitarUnit.getQuantity();;
		assertEquals(4, newQuantity);
	}
	
	@Test
	public void toStringTest() {
		Instrument guitarUnit = new Guitar("Orpheus", 40.0, 2);
		assertEquals("Instrument [name = Orpheus, price = 40.0, quantity = 2]", guitarUnit.toString());
	}
	
}
