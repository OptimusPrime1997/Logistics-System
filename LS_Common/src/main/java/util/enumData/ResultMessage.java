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
	LINK_FAILURE,//连接错误
	EXIST,	//已存在
	NOT_FOUND,	//没找到对应结果
	
	REPNUM_LENGTH_OVER,	//编号过长
	REPNUM_LENGTH_LACKING,	//编号过短
	REPNUM_NOT_RIGHT,	//编号不正确
	
	PHONE_LENGTH_WRONG,//手机号长度有误
	UNVALID_CHAR,	//含非法字符
	UNREASONABLE_GOODS_NUM,//不合理的内件数
	UNREASONABLE_WEIGHT_NUM,//不合理的重量数值
	UNREASONABLE_VOLUME_NUM,//不合理的体积数值
	NOT_COMPLETED,	//未填写
	
	WRONG_ACCOUNTNUM,	//账号格式错误
	NOT_FOUND_ACCOUNTNUM,//账号不存在
	WRONG_PASSWORD,//错误密码


	NOT_FOUND_FILE,//文件未找到

	INPUT_SHOULD_BE_POSITIVE_INTEGER, //输入应该为正整数
	NUMBER_OVER,   //输入数值太大
	NOT_AVAILABLE; //该库存区位已被占用
	
	public String toFriendlyString(ResultMessage resultMessage) {
		
		switch(resultMessage) {
		case REPNUM_LENGTH_OVER:
			return "过长";
		case REPNUM_LENGTH_LACKING:
			return "过短";
		case UNVALID_CHAR:
			return "含有非法字符";
		case WRONG_PASSWORD:
			return "密码错误";
		case NOT_COMPLETED:
			return "有项目未填写，请完成后再提交";
		}
		return null;
	}
	
}
