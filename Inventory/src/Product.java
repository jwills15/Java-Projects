
public class Product 
{
	private String item;
	private double price;
	private int quantity;
	
	public Product(String i, double p, int q)
	{ 
		/* code to initialize private data */
		item = i;
		price = p;
		quantity = q;
	}
	
	public String getItem() { return item; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	
	public String toString(Object o)
	{ 
		/* returns string to display private data */ 
		return o.toString();
	}
}
