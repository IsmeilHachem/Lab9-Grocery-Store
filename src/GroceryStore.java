import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GroceryStore {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to Guenther's Market!");
		scnr.nextLine();
		
		ArrayList<String> items = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		ArrayList<String> orderItems = new ArrayList<>();
		ArrayList<Double> orderPrice = new ArrayList<>();
		
		String mmm = "y";
		String choice;
		
		items.add("Apple");
		items.add("Banana");
		items.add("Water");
		items.add("Watermelon");
		items.add("Oj");
		items.add("Snickers");
		items.add("Doritos");
		items.add("Grapes");
		
		price.add(0.99);
		price.add(0.59);
		price.add(1.00);
		price.add(4.99);
		price.add(3.49);
		price.add(1.49);
		price.add(1.89);
		price.add(1.29);
		
		do {
			System.out.println(String.format("Item" + "            " + "Price"));
			System.out.println("===================================");
			
			// loop to display the list
			for(int i = 0; i < items.size(); i++) {
				System.out.println(String.format("%-15s %s", items.get(i), price.get(i)));
			}
			boolean f = false;
			int i = 0;
			scnr.nextLine();
			System.out.println("What item would you like to order? (Please Capatalize the first letter)");
			choice = scnr.next();
			
			// check for error
			try {
				for (i = 0; i < items.size(); i++) {
					if (choice.equals(items.get(i))) {

						orderItems.add(choice);
						orderPrice.add(price.get(i));
						f = true;
						break;
					}
				}
			} catch (InputMismatchException ex) {
				f = false;
			}
			
			if (f == true) {
				System.out.println("Adding " + choice + " to cart at $" + String.valueOf(price.get(i)));
			}else {
				System.out.println("Sorry we ain't Costco. Please try again");
				continue;
			}
			System.out.println("Would you like to order more? (y/n)");
			mmm = scnr.next();
			
		}while(mmm.equalsIgnoreCase("y"));
		
		System.out.println("Tank you, come again!");
		scnr.nextLine();
		
		
		for (int i = 0; i < orderItems.size(); i++) {
			System.out.println(String.format("%-10s %s", orderItems.get(i), orderPrice.get(i)));
		}
		System.out.println("Average price per item in order was " + averageOfItems(orderPrice, orderItems.size()));
		System.out.println("Item with highest cost is " + maxPrice(orderPrice, orderItems.size()));
		System.out.println("Item with lowest cost is " + minPrice(orderPrice, orderItems.size()));
		
		
		scnr.close();
		
		
	}
	
	public static double averageOfItems(ArrayList<Double> items, int size) {
		double avg = 0.0;
		for (int i = 0; i < size; i++) {
			avg += items.get(i) / size;
		}
		return avg;

	}

	public static double maxPrice(ArrayList<Double> price, int size) {
		double max = price.get(0);
		for (int i = 0; i < size; i++) {
			
			if(max < price.get(i)) {
				max = price.get(i);
			}
		}
		return max;
	}
	
	
	public static double minPrice(ArrayList<Double> price, int size) {
		double min = price.get(0);
		for (int i = 0; i < size; i++) {
				
			if(min > price.get(i)) {
				min = price.get(i);
			}
		}
			return min;
	}

	

}
