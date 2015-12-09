package util.enumData;

public enum GoodsArrivalState {
	//intact=safe and sound
	INTACT("正常"),
	BROKEN("损毁"),
	LOST("丢失");
	
	private String ChineseName;
	
	private GoodsArrivalState(String ChineseName){
		this.ChineseName = ChineseName;
	}
	
	public String getChineseName(){
		return ChineseName;
	}
	
	public static GoodsArrivalState getGoodsArrivalState(String ChineseName){
		switch (ChineseName) {
		case "正常":
			return INTACT;
		case "损毁":
			return BROKEN;
		case "丢失":
			return LOST;
		default:
			return null;
		}
	}
}
