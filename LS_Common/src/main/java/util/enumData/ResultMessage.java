/**
 * 
 */
package util.enumData;

import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author G
 *
 */
public enum ResultMessage {
	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 失败
	 */
	FAILED,
	/**
	 * 错误
	 */
	WRONG,
	/**
	 * 修改成功
	 */
	MODIFY_SUCCESS,

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
	 * 派件员编号过短
	 */
	DELIVER_COURIER_NUM_LACKING,
	/**
	 * 派件员编号过长
	 */
	DELIVER_COURIER_NUM_OVER,
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
	 * 账号未填写
	 */
	NOT_COMPLETED_ACCOUNT,
	/**
	 * 密码未填写
	 */
	NOT_COMPLETED_KEY,
	/**
	 * 账号格式错误
	 */
	WRONG_ACCOUNTNUM,//TODO
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
	NOT_AVAILABLE,
	/**
	 * 覆盖数据
	 */
	OVERRIDE_DATA,
	/**
	 * 添加成功
	 */
	ADD_SUCCESS,
	/**
	 * 提交成功
	 */
	SUBMIT_SUCCESS,
	/**
	 * 签收成功
	 */

	SIGNED_SUCCESS,
	/**
	 * 输入必须为正数
	 */
	INPUTNUM_MUST_BE_POSITIVE,
	/**
	 * 职位为空
	 */
	NULL_AUTHORITY,
	/**
	 * 薪水策略
	 */
	NULL_SALARYPOLICY,
	/**
	 * 远程连接失败
	 */
	REMOTE_FAILED;
	public static String toFriendlyString(ResultMessage resultMessage) {

		switch (resultMessage) {
		case REPNUM_LENGTH_OVER:
			return "过长";
		case REPNUM_LENGTH_LACKING:
			return "过短";
		case UNVALID_CHAR:
			return "含有非法字符，注意编号中只能有数字哦";
		case WRONG_PASSWORD:
			return "密码错误";
		case NOT_COMPLETED:
			return "有项目未填写，请完成后再提交";
		case LENGTH_WRONG:
			return "长度有误,订单号是11位哦~";
		case WRONG_FORMAT:
			return "格式错误";
		case WRONG_DATA:
			return "数据错误";
		case WRONG_ACCOUNTNUM:
			return "账号错误";
		case NOT_FOUND_ACCOUNTNUM:
			return "账号不存在";
		case NOT_COMPLETED_ACCOUNT:
			return "请输入账号~";
		case NOT_COMPLETED_KEY:
			return "请输入密码~";
		case ADD_SUCCESS:
			return "添加成功";
		case SUBMIT_SUCCESS:
			return "提交成功";
		case REPNUM_NOT_ALL_NUM:
			return "编号中存在非数字字符";
		case DELIVER_COURIER_NUM_LACKING:
			return "派件员编号过短";
		case DELIVER_COURIER_NUM_OVER:
			return "派件员编号过长";
		case OVERRIDE_DATA:
			return "覆盖数据";
		case NOT_FOUND:
			return "对不起，该订单不存在";
		case SIGNED_SUCCESS:
			return "签收成功~";
		case MODIFY_SUCCESS:
			return "修改成功";
		case IOFAILED:
			return "读写文件失败";
		case FAILED:
			return "系统程序错误";
		case SUCCESS:
			return "成功";
		case WRONG:
			return "错误";
		case REMOTE_FAILED:
			return "远程连接失败";
		case INPUTNUM_MUST_BE_POSITIVE:
			return "输入必须为正数";
		case EXIST:
			return "数据已存在";
		case NULL_SALARYPOLICY:
			return "薪水策略为空";
		case NULL_AUTHORITY:
			return "空职位";
		}

		return null;
	}
	public static void postCheck(ResultMessage expected,ResultMessage rmsg){
		try{
			assert (expected==rmsg):(ResultMessage.toFriendlyString(rmsg));
		}catch(AssertionError e){
			System.out.println(e.getMessage());
		}
	}

}
