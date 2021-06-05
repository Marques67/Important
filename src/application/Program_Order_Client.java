package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client_Order;
import entities.OrderItem;
import entities.Order_Client;
import entities.Product_Order;
import entities.enums.OrderStatus;

public class Program_Order_Client {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); //parse ta transformando o string quando digitar a data para o tipo date
		
		Client_Order client = new Client_Order(nameClient, emailClient, birthDate);
		
		System.out.println();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //converte o string para o valor correspondente definido lá no orderstatus
		
		Order_Client order = new Order_Client(new Date(), status, client);
		
		System.out.println();
		System.out.print("How many itens to this order? ");
		int N = sc.nextInt();
		for (int i=1; i<=N; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product_Order product = new Product_Order(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product); //esse product é o prodcut instanciado na linha acima. estamos associado o orderitem com o objeto produto
			
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);

		sc.close();
	}

}
