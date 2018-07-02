package musicInstruments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Shop {

	private static final double MARKUP = 2.5;
	
	private String name;
	private double money;
	private double income = 0;
	private HashMap<Instrument, Integer> sales;
	private TreeMap<InstrumentType, HashMap<String, Instrument>> instruments;
	
	Shop(String name) {
		this.name = name;
		instruments = new TreeMap<>();
		instruments.put(InstrumentType.PERCUSSION, new HashMap<>());
		instruments.get(InstrumentType.PERCUSSION).put("Pearls", new Drums("Perlite", 1500, 3));
		instruments.get(InstrumentType.PERCUSSION).put("Yamaha", new Drums("Yamaha Drums", 1850, 2));
		instruments.put(InstrumentType.KEYBOARDS, new HashMap<>());
		instruments.get(InstrumentType.KEYBOARDS).put("Yamaha", new Piano("Yamaha Piano", 2100, 2));
		instruments.get(InstrumentType.KEYBOARDS).put("Lassy", new Piano("Lassy", 59, 9));
		instruments.put(InstrumentType.STRING_INSTRUMENT, new HashMap<>());
		instruments.get(InstrumentType.STRING_INSTRUMENT).put("Fender", new Guitar("Fender", 800, 8));
		instruments.get(InstrumentType.STRING_INSTRUMENT).put("Orpheus", new Guitar("Orpheus", 20, 200));
		sales = new HashMap<>();
	}

/**
 * Sells instruments by name and quantity
 * @param name
 * @param quantity
 */
	public void sell(String name, int quantity) {
		for(InstrumentType type : instruments.keySet()) {
			if(instruments.get(type).containsKey(name)) {
				Instrument instrument = instruments.get(type).get(name);
				if(instrument.getQuantity() < quantity){
					System.out.println("Not enough quantity, only " + instrument.getQuantity() + " left");
				}
				else{
					instrument.decreaseQuantity(quantity);
					System.out.println("Sold!");
					this.money += quantity*instrument.getPrice()*MARKUP;
					this.income += quantity*instrument.getPrice()*MARKUP;
					if(sales.containsKey(instrument)) {
						sales.put(instrument, sales.get(instrument) + quantity);
					}
					else {
						sales.put(instrument, quantity);
					}
					break;
				}
			}
		}
	}

/**
 * receive new instruments by name and quantity
 * @param name
 * @param quantity
 */
	public void receive(String name, int quantity) {
		for(InstrumentType type : instruments.keySet()) {
			if(instruments.get(type).containsKey(name)) {
				Instrument instrument = instruments.get(type).get(name);
				if(this.money >= quantity*instrument.getPrice()) {
					instrument.increaseQuantity(quantity);
					System.out.println("Added!");
					this.money -= quantity*instrument.getPrice();
				}
				else {
					System.out.println("Not enough money");
				}
			}
		}
	}

/**
 * Prints the instruments by type
 */
	public void printInstrumentsByType() {
		for(InstrumentType type : instruments.keySet()){
			System.out.println("========================="+ type +"========================");
			for(Instrument instrument : instruments.get(type).values()){
				System.out.println(instrument);
			}
		}
	}

/**
 * Prints the instruments by name
 */
	public void printInstrumentsByName() {
		printInstruments(null);
	}

/**
 * Prints the instruments by price
 * Can choose between ascending and descending
 * @param s ascending or descending
 */
	public void printInstrumentsByPrice(Sort s) {
		printInstruments((instrument1, instrument2) -> {
			return Double.compare(instrument1.getPrice(), instrument2.getPrice()) * (s == Sort.ASCENDING ? 1 : -1); 
		} );	
	}
	
	private void printInstruments(Comparator<Instrument> comp) {
		TreeSet<Instrument> result = comp == null ? new TreeSet<>() : new TreeSet<>(comp);
		for(HashMap<String, Instrument> h : instruments.values()) {
			result.addAll(h.values());
		}	
		for(Instrument instrument : result) {
			System.out.println(instrument);
		}
	}

/**
 * Prints the available instruments in the shop
 */
	public void printAvailableInstruments() {
		for(InstrumentType type : instruments.keySet()) {
			System.out.println("========================="+ type +"=======================");
			for(Instrument i : instruments.get(type).values()){
				if(i.getQuantity() > 0) {
					System.out.println(i);
				}
			}
		}
	}

/**
 * Generates a list of sold instruments, 
 * ordered by number of sales
 */
	public void printSales() {	
		ArrayList<Entry<Instrument, Integer>> list = new ArrayList<>();
		list.addAll(sales.entrySet());
		Collections.sort(list, new Comparator<Entry<Instrument, Integer>>() {
			@Override
			public int compare(Entry<Instrument, Integer> o1, Entry<Instrument, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for(Entry<Instrument, Integer> e : list) {
			System.out.println(e.getKey());
		}
	}

/**
 * Prints the most sold instruments
 */
	public void printMostSold() {
		Instrument maxSold = null;
		int maxSale = 0;
		for(Entry<Instrument, Integer> e : sales.entrySet()) {
			if(maxSold == null) {
				maxSold = e.getKey();
				maxSale = e.getValue();
			}
			else {
				if(e.getValue() > maxSale) {
					maxSale = e.getValue();
					maxSold = e.getKey();
				}
			}
		}
		System.out.println("Max sale =" + maxSold);
	}

/**
 * Prints the most sold type of instruments
 */
	public void printMostSoldType() {
		int maxCount = 0;
		InstrumentType maxType = null;
		for(InstrumentType type : instruments.keySet()) {
			int countSales = 0; //sales for this type
			for(Instrument i : instruments.get(type).values()) {
				countSales += sales.get(i) == null ? 0 : sales.get(i);	
			}
			if(countSales > maxCount) {
				maxType = type;
				maxCount = countSales;
			}
		}
		System.out.println("Max sales for type = " + maxType);
	}

	
/**
 * Prints the most profitable type of instruments
 */
	public void printMostProfitableType() {
		double maxProfit = 0;
		InstrumentType maxType = null;
		for(InstrumentType type : instruments.keySet()){
			double countProfit = 0; 
			for(Instrument instrument : instruments.get(type).values()) {
				countProfit += sales.get(instrument) == null ? 0 : sales.get(instrument)*instrument.getPrice()*MARKUP;	
			}
			if(countProfit > maxProfit) {
				maxType = type;
				maxProfit = countProfit;
			}
		}
		System.out.println("Most profitable type = " + maxType);
	}
	
	public double getIncome() {
		return income;
	}
	
	public double getMoney() {
		return money;
	}
	
}


