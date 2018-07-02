package musicInstruments;

public class Piano extends Instrument {

/**
 * Constructor which creates an instance of class Piano 
 * with name, price and quantity
 * @param name
 * @param price
 * @param quantity
 */
	public Piano(String name, double price, int quantity) {
		super(name, price, quantity, InstrumentType.KEYBOARDS);
	}
	
}
