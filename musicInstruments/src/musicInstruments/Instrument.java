package musicInstruments;

public abstract class Instrument implements Comparable<Instrument> {
	
	private String name;
	private double price;
	private int quantity;
	private InstrumentType type;

	public Instrument(String name, double price, int quantity, InstrumentType type) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}
	
	@Override
	public int compareTo(Instrument o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return "Instrument [name = " + name + ", price = " + price + ", quantity = " + quantity + "]";
	}
	
	public void increaseQuantity(int quantity){
		this.quantity += quantity;
	} 
	
	public void decreaseQuantity(int quantity){
		this.quantity -= quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
