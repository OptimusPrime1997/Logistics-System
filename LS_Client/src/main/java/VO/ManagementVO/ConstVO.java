package VO.ManagementVO;

import util.InputCheck;
import util.enumData.City;

public class ConstVO implements Comparable<ConstVO> {
	/**
	 * 按city编号排序
	 */
	public City city1;
	public City city2;
	public double priceConst;
	public double distanceConst;

	public ConstVO(City city1,City city2, double distanceConst, double priceConst) {
		super();
		this.city1 =City.getCity1(city1, city2);
		this.city2 = City.getCity2(city1, city2);	
		this.priceConst = priceConst;
		this.distanceConst = InputCheck.formatDouble(distanceConst);
	}

	public int compareTo(ConstVO v) {
		return (city1.getIndex())-(v.city1.getIndex());
	}

	public boolean equals(ConstVO v) {
		if (city1==v.city1
				&&city2==v.city2
				&&priceConst==v.priceConst
				&&distanceConst==v.distanceConst) {
			return true;
		}else {
			return false;
		}
	}
}
