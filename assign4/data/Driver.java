package data;

public class Driver {

	public static void main(String[] args) {
		OrderDB db = new OrderDB();
		
		db.loadOrders("orders.txt");
		
		db.showOrders();
		
	}

}
