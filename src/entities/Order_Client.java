package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order_Client {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client_Order client; //composicao 1 cliente "1 para 1" 
	
	private List<OrderItem> itens = new ArrayList<>(); //composicao "1 para varios" se cria uma lista
	
	public Order_Client() {
	}

	public Order_Client(Date moment, OrderStatus status, Client_Order client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		//não acrescenta a lista aqui, pois ela ja foi instanciada lá em cima, ou seja, ela já possui um "valor"(0), então so deve acrescentar ou remover algo dela
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client_Order getClient() {
		return client;
	}

	public void setClient(Client_Order client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() { //eu poderia remover esse get para que ninguem tivesse acesso ao add ou remove da minha lista
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for (OrderItem it : itens) {
			sum += it.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order itens: \n");
		for (OrderItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
