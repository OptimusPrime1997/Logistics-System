/**
 * 
 */
package util.enumData;

/**
 * @author G
 *
 */
public enum ResultMessage {
	SUCCESS, // 成功
	FAILED, // 失败
	WRONG, // 错误
	/**
	 * 添加成功
	 */
	ADD_SUCCESS,
	/**
	 * 提交成功
	 */
	SUBMIT_SUCCESS,
	/**
	 * 连接错误
	 */
	LINK_FAILURE,
	/**
	 * 已存在
	 */
	EXIST,
	/**
	 * 没找到对应结果
	 */
	NOT_FOUND,
	/**
	 * 合法
	 */
	VALID,
	/**
	 * 编号过长
	 */
	REPNUM_LENGTH_OVER,
	/**
	 * 编号过短
	 */
	REPNUM_LENGTH_LACKING,
	/**
	 * 编号长度有误
	 */
	REPNUM_LENGTH_WRONG,
	/**
	 * 编号出现非数字的字符
	 */
	REPNUM_NOT_ALL_NUM,
	/**
	 * 编号不正确
	 */
	REPNUM_NOT_RIGHT,
	/**
	 * 手机号长度有误
	 */
	PHONE_LENGTH_WRONG,
	/**
	 * 长度有误
	 */
	LENGTH_WRONG,
	/**
	 * 字符超出长度
	 */
	LENGTH_OVER,
	/**
	 * 含非法字符
	 */
	UNVALID_CHAR,
	/**
	 * 不合理的内件数
	 */
	UNREASONABLE_GOODS_NUM,
	/**
	 * 不合理的重量数值
	 */
	UNREASONABLE_WEIGHT_NUM,
	/**
	 * 不合理的体积数值
	 */
	UNREASONABLE_VOLUME_NUM,
	/**
	 * 未填写
	 */
	NOT_COMPLETED,
	/**
	 * 账号格式错误
	 */
	WRONG_ACCOUNTNUM,
	/**
	 * 账号不存在
	 */
	NOT_FOUND_ACCOUNTNUM,
	/**
	 * 数据格式错误
	 */
	WRONG_FORMAT,
	/**
	 * 错误密码
	 */
	WRONG_PASSWORD,
	/**
	 * 数据错误
	 */
	WRONG_DATA,
	/**
	 * 文件未找到
	 */
	NOT_FOUND_FILE,
	/**
	 * 文件读写失败
	 */
	IOFAILED,
	/**
	 * 输入应该为正整数
	 */
	INPUT_SHOULD_BE_POSITIVE_INTEGER,
	/**
	 * 输入数值太大
	 */
	NUMBER_OVER,
	/**
	 * 该库存区位已被占用
	 */
	NOT_AVAILABLE;

	public static String toFriendlyString(ResultMessage resultMessage) {

		switch (resultMessage) {
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
		case LENGTH_WRONG:
			return "长度有误";
		case WRONG_FORMAT:
			return "格式错误";
		case WRONG_DATA:
			return "数据错误";
		case WRONG_ACCOUNTNUM:
			return "账号错误";
		}
		return null;
	}

}
