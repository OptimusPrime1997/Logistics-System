/**
 * 
 */
package ui.warehousemanui;

/**
 * @author G
 *
 */
public class CheckUtil {
	
	/**
	 * 查看输入是否是连续的
	 * @param input
	 * @return
	 */
	public static boolean isSucceNumber(String input) {
		if(input.matches("\\d+")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查看是否有小数点
	 * @param input
	 * @return
	 */
	public static boolean isDecimal(String input) {
		if(input.contains(".")){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查看首字符是否为负号
	 * @param input
	 * @return
	 */
	public static boolean isPositive(String input) {
		if(input.charAt(0)=='-'){
			return false;
		}else{
			return true;
		}
	}
}
