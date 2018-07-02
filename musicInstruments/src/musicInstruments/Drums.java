package musicInstruments;

public class Drums extends Instrument {

/**
 * Constructor which creates an instance of class Drums 
 * with name, price and quantity
 * @param name
 * @param price
 * @param quantity
 */
	public Drums(String name, double price, int quantity) {
		super(name, price, quantity, InstrumentType.PERCUSSION);
	}
	
}
