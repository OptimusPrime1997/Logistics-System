package VO.ManagementVO;


import util.enumData.ModifyState;

public class ConstVOPlus extends ConstVO {
	public ModifyState isModify;
	
	public ConstVOPlus(String twoCities, double distanceConst,
			double priceConst,  ModifyState isModify) {
		super(twoCities, distanceConst, priceConst);
		this.isModify = isModify;
		// TODO Auto-generated constructor stub
	}

	public ConstVOPlus(ConstVO v, ModifyState  iModify ){
		super(v.twoCities, v.distanceConst, v.priceConst);
		this.isModify= iModify;
	}
	public ConstVO getConstVO(){
		return new ConstVO(twoCities, distanceConst, priceConst);
	}

}
