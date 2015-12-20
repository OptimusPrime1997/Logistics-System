package blservice.receiptblservice;

import util.enumData.LogType;

/**
 * @author bismuth
 *
 */
public interface PreReceiptblService {
	
	/**添加日志
	 * @param operationName
	 * @param operatorID
	 * @param time
	 */
	public void addLog(LogType operationName, String operatorID, String time);
	
	/**得到当前日期
	 * @return
	 */
	public String getDate();

	/**得到编号中的日期部分
	 * @param string
	 * @return
	 */
	public String getDateInNum(String string);
	
	/**检查编号格式
	 * @param string
	 * @param n
	 * @param info
	 * @return
	 */
	public String checkNum(String string, int n, String info);
}
