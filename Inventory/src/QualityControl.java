
public class QualityControl extends Product
{
	private int customerSatisfaction, productQuality;
	QualityControl(String i, double p, int q, int cs, int pq)
	{
		super(i, p, q);
		customerSatisfaction = cs;
		productQuality = pq;
	}
	
	public int getCustomerSatisfaction() { return customerSatisfaction; }
	public int getProductQuality() { return productQuality; }
}
