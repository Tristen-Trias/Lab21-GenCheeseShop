import java.util.*;

public class GenCheeseShop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Double> price = new ArrayList<Double>();
		double total = 0.0;

		name.add(0, "Humboldt Fog");
		name.add(1,"Red Hawk");
		name.add(2, "Teleme");

		price.add(0, 25.00);
		price.add(1, 40.50);
		price.add(2, 17.25);

		System.out.print("Enter the number of Cheeses for shop setup: ");

		int max = s.nextInt();
		double[] amount = new double[max];
		System.out.println("We sell " + max + " kinds of Cheese:");
		
		Random ranGen = new Random(100);
		
		if (max > 0) {
			for (int i = 0; i < 3; i++) {
				System.out.println(name.get(i) + ": $" + price.get(i) + " per pound");
			}
		}
		
		for (int i = 3; i < max; i++) {
			name.add(i, "Cheese Type " + (char)('A' + i));
			price.add(i, ranGen.nextInt(1000)/100.0);
			System.out.println(name.get(i) + ": $" + price.get(i) + " per pound");
		}

		System.out.println();

		for (int i = 0; i < max; i++) {
			System.out.print("Enter number of " + name.get(i) + ": ");
			while(true) {
				amount[i] = s.nextDouble();
				if (check(amount[i])) break;
			}
		}
		
		if (max > 0) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			if (s.nextInt() == 1) {
				for (int i = 0; i < max; i++) {
					System.out.println(amount[i] + " of " + name.get(i) + " @ " + " = \t$" + (price.get(i) * amount[i]));
					total += (price.get(i) * amount[i]);
				}
			}
		}

		System.out.println("Original subtotal: \t$" + (total));
		System.out.println("\nSpecials...");
		
		if (max > 0) {

			System.out.println("Humboldt Fog (Buy 1 get 1 free): \t -$" + (int)(amount[0] / 2) * price.get(0));
			total -= (int)(amount[0] / 2) * price.get(0);

			System.out.println("Red Hawk (Buy 2 Get 1 Free): \t\t -$" + (int)(amount[1] * 2 / 3) * (price.get(1) / 2));
			total -= (int)(amount[1] * 2 / 3) * (price.get(1) / 2);

			System.out.println("New subtotal: \t\t\t\t  $" + (total));

			if (total > 250.00) {
				System.out.println("Additional 25% Discount: \t\t -$" + (total * 0.25));
				total *= 0.75;
			} else if (total > 100.00) {
				System.out.println("Additional 10% Discount: \t\t -$" + (total * 0.10));
				total *= 0.90;
			} 
			
		} else System.out.println("None \t\t\t\t\t -$0.0");

		System.out.printf("Final total: \t\t\t\t  $%.2f", total);
		s.close();

	}

	public static boolean check (double uIn) {
		if (uIn < 0) {
			System.out.print("Invalid Input. Enter a value >= 0:");
			return false;
		} else if (uIn % 0.5 != 0) {
			System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
			return false;
		} else return true;
	}
}