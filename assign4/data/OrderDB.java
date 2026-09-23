package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class OrderDB {
	private Order[] orders;
	private int orderCount;
	
	public OrderDB() {
		this.orders = new Order[50];
		this.orderCount = 0;
}
	
	public void loadOrders(String fileName){
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			while(scanner.hasNextLine() && orderCount < orders.length) {
				String line = scanner.nextLine();
				
				String[] tokens = line.split(",");
				
				if(tokens.length >= 3) {
					String id = tokens[0].trim();
					String name = tokens[1].trim();
					String product = tokens[2].trim();
					double price = Double.parseDouble(tokens[3].trim());
					
					orders[orderCount] = new Order(id, name, product, price);
					orderCount++;
					
				}
			}
			scanner.close();
			JOptionPane.showMessageDialog(null,"Successfully loaded " + orderCount + " orders.");
		} catch(FileNotFoundException e) {
			System.out.println("Error: The file " + fileName + " was not found.");
		}catch(NumberFormatException e) {
			System.out.println("Error formatting numerical data from the file.");
		}
	}
	
	public void showOrders() {
		if(orderCount == 0) {
			System.out.println("No orders loaded in the database.");
			return;
		}
		System.out.println("========== ORDERS REPORT ====================\n");
		System.out.printf("%-9s%-28s%9s%n", "OrderId", "Product", "Total Amt");
		System.out.printf("%-9s%-28s%9s%n", "-------", "-------", "---------");
		
		
		int index = 0;
		for (index = 0; index < orderCount; index++) {
			Order currentOrder = orders[index];
			
			System.out.printf("%-9s%-28s%9.2f%n", currentOrder.getOrderId(),
												  currentOrder.getProductName(),
												  currentOrder.getTotalAmount());
		}
	}
}
