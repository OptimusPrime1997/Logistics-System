package PO.ReceiptPO;

public class InStockPO {
	private String order;
	private String area;
	private String loc;
	public InStockPO(String order, String area, String loc) {
		super();
		this.order = order;
		this.area = area;
		this.loc = loc;
	}
	public String getOrder() {
		return order;
	}
	public String getArea() {
		return area;
	}
	public String getLoc() {
		return loc;
	}
	
}
