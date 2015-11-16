/**
 * 
 */
package util.enumData;

/**
 * @author G
 *
 */
public enum ResultMessage {
	SUCCESS, //成功
	FAILED,	//失败
	WRONG,	//错误
	
	EXIST,	//已存在
	NOT_FOUND,	//没找到对应结果
	LENGTH_OVER,	//过长
	LENGTH_LACKING,	//过短
	UNVALID_CHAR,	//含非法字符
	
	NOT_COMPLETED,	//未填写
	
	WRONG_ID,	//错误用户名
	WRONG_PASSWORD,	//错误密码名
	
	
	
//	public String toFriendlyString() {
//		
//		switch(this) {
//		case LENGTH_OVER:
//			return "过长";
//		case LENGTH_LACKING:
//			return "过短";
//		case UNVALID_CHAR:
//			return "含有非法字符";
//		case WRONG_ID:
//			return "用户名错误";
//		case WRONG_PASSWORD:
//			return "密码错误";
//		case NOT_COMPLETED:
//			return "未填写";
//		default:
//			return null;
//		}
//	}
//	
	
}
