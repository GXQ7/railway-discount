package seatDiscountSystem;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SeatDiscountApplication {

	public static void main(String[] args){
		final String FILENAME = "seats.txt";
		double seatPrice, income, totalIncome = 0, totalDiscount = 0, price, discountAmount;
		int noBookings, discount = 20; 
		final String poundSign = "\u00a3";

		try {
			final FileReader fileObj = new FileReader(FILENAME);
			final Scanner reader = new Scanner(fileObj);
			final Scanner console = new Scanner(System.in);	

			System.out.println("\n----- Seat Discount System for Railway Managers -----");
			char answer = 'X';
			while (answer != 'Y' && answer != 'N'){
				System.out.print("Would you like to specify a custom discount rate? [Y|N]: ");
				answer = console.nextLine().toUpperCase().charAt(0);
			} 
	
			if(answer == 'Y'){
				System.out.print("\nPlease enter the discount rate (%):");
				discount = console.nextInt();	
			}
			else {
				System.out.format("\nAssuming the Discount Amount: %d%% " , discount);
			}

			do
			{
				System.out.format("\nSeat Type: %s", reader.next());
				seatPrice = reader.nextDouble();
				noBookings = reader.nextInt();
	
				System.out.format("\tSeat Price: %s%.2f" , poundSign,  seatPrice);
				System.out.format("\tBookings: %d", noBookings);
	
				price = seatPrice * noBookings;
				discountAmount = price /100 * discount ;
				income =  price - discountAmount; 
	
				System.out.format("\tDiscount: %s%.2f \tIncome: %s%.2f\n", poundSign, discountAmount, poundSign, income);
				totalDiscount += discountAmount; 
				totalIncome += income;
	
			} while (reader.hasNext());
	
			System.out.format("\nTotal Income: %s%.2f ", poundSign, totalIncome);
					System.out.format("\nTotal Discount: %s%.2f ", poundSign, totalDiscount);			
			System.out.print("\nExiting...");
			reader.close();
			console.close();
			System.exit(0);
					
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred. " + FILENAME + " cannot be found.");
		}	
	}
}

