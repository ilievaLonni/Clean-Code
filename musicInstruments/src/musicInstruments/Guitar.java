package musicInstruments;

public class Guitar extends Instrument {

/**
 * Constructor which creates an instance of class Guitar 
 * with name, price and quantity
 * @param name
 * @param price
 * @param quantity
 */
	public Guitar(String name, double price, int quantity) {
		super(name, price, quantity, InstrumentType.STRING_INSTRUMENT);
	}
		
}
