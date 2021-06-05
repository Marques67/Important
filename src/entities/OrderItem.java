package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product_Order product; //aqui está realizando a composição
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product_Order product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product_Order getProduct() {
		return product;
	}

	public void setProduct(Product_Order product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return quantity * price;
	}
	
	public String toString() {
		return getProduct().getName() 
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
	}
}
