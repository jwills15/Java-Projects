import java.util.ArrayList;

public class Inventory 
{
	private ArrayList<QualityControl> products;
	private int max;
	
	public Inventory()
	{ 
		/* code to initialize Inventory object */ 
		products = new ArrayList<QualityControl>();
		max = 0;
	}
	
	public void addNewProduct(String name, double cost, int amount, 
				int customerSatisfaction, int productQuality)
	{
		/* to be implemented in part (a) */
		products.add(new QualityControl(name,cost,amount,customerSatisfaction,
					productQuality));
		for (int n = products.size(); n > 1; n--)
		{
			max = 0;
			for (int i = 1; i < n; i++)
			{
				if (products.get(i).getItem().compareToIgnoreCase(
						products.get(max).getItem()) > 0)
					max = i;
			}
			QualityControl aTemp = products.get(max);
			products.set(max, products.get(n-1));
			products.set(n-1, aTemp);
		}
	}
	
	public ArrayList<String> mustOrder()
	{
		/* to be implemented in part (b) */
		ArrayList<String> orders = new ArrayList<String>();
		for (int i = 0; i < products.size(); i++)
		{
			if (products.get(i).getQuantity() < 20)
			{
				orders.add(products.get(i).getItem());
			}
		}
		return orders;
	}
	
	public String displayProducts()
	{ 
		/* code to display all products */
		String output = "";
		for (int i = 0; i < products.size(); i++)
		{
			output += products.get(i).getItem() + " - $" + products.get(i).getPrice()
					+ " - " + products.get(i).getQuantity() + "\n";
		}
		return output;
	}
	
	public ArrayList<String> lowRatings()
	{
		ArrayList<String> lowReviews = new ArrayList<String>();
		for (int i = 0; i < products.size(); i++)
		{
			if (products.get(i).getCustomerSatisfaction() < 5 ||
						products.get(i).getProductQuality() < 5)
			{
				lowReviews.add(products.get(i).getItem());
			}
		}
		return lowReviews;
	}
}
