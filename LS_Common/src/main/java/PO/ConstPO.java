package PO;

import java.io.Serializable;

public class ConstPO implements Serializable, Comparable<ConstPO> {
	public final static long serialVersionUID = 1L;
	/**
	 * 存储两个城市名称并按拼音排序，如：南京-上海 中间横线为中文字符
	 */
	private String twoCities;
	private double priceConst;
	private double distanceConst;

	public ConstPO(String twoCities, double distanceConst, double priceConst) {
		super();
		this.twoCities = twoCities;
		this.priceConst = priceConst;
		this.distanceConst = distanceConst;
	}

	public String getTwoCities() {
		return twoCities;
	}

	public void setTwoCities(String twoCities) {
		this.twoCities = twoCities;
	}

	public double getPriceConst() {
		return priceConst;
	}

	public void setPriceConst(double priceConst) {
		this.priceConst = priceConst;
	}

	public double getDistanceConst() {
		return distanceConst;
	}

	public void setDistanceConst(double distanceConst) {
		this.distanceConst = distanceConst;
	}

	@Override
	public int compareTo(ConstPO p) {
		return twoCities.compareTo(p.getTwoCities());
	}

}
