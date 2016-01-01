package VO.ManagementVO;


import util.enumData.City;
import util.enumData.ModifyState;

public class ConstVOPlus extends ConstVO {
	public ModifyState isModify;
	
	public ConstVOPlus(City city1,City city2, double distanceConst,
			double priceConst,  ModifyState isModify) {
		super(city1,city2, distanceConst, priceConst);
		this.isModify = isModify;
		// TODO Auto-generated constructor stub
	}

	public ConstVOPlus(ConstVO v, ModifyState  iModify ){
		super(v.city1,v.city2, v.distanceConst, v.priceConst);
		this.isModify= iModify;
	}
	public ConstVO getConstVO(){
		return new ConstVO(city1,city2, distanceConst, priceConst);
	}

}
