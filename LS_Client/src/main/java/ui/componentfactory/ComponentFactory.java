package ui.componentfactory;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import blservice.logblservice.LogBLService;
import util.enumData.Authority;
import util.enumData.LogType;
import util.enumData.Sex;

public class ComponentFactory {
	public final static String REMOTEFAILD = "远程连接失败！";
	public final static long DISPLAY_TIME = 5;

	private ComponentFactory() {
	}

	public static ComponentFactory getInstance() {
		return ComponentHolder.component;
	}

	private static class ComponentHolder {
		private static ComponentFactory component = new ComponentFactory();
	}

	/**
	 * 得到职位的jcombobox
	 * 
	 * @return
	 */
	public JComboBox<Authority> getAuthorityJComboBox() {
		JComboBox<Authority> authorityjComboBox = new JComboBox<Authority>();
		for (int i = 1; i <= 9; i++) {
			authorityjComboBox.addItem(Authority.getAuthority(i));
		}
		return authorityjComboBox;

	}

	/**
	 * 得到性别jcombobox
	 * 
	 * @return
	 */
	public JComboBox<Sex> getSexJComboBox() {
		JComboBox<Sex> sexjComboBox = new JComboBox<Sex>();
		sexjComboBox.addItem(Sex.Sex_MALE);
		sexjComboBox.addItem(Sex.Sex_FAMALE);
		return sexjComboBox;
	}

	/**
	 * 得到日志类型的jcombobox
	 * 
	 * @return
	 */
	public JComboBox<LogType> getLogTypeJComboBox() {
		JComboBox<LogType> logjComboBox = new JComboBox<LogType>();
		for (int i = 1; i <= 21; i++) {
			logjComboBox.addItem(LogType.toLogType(i));
		}
		return logjComboBox;
	}

	/**
	 * 得到startYear~endYear的jcombobox
	 * 
	 * @param startYear
	 * @param endYear
	 * @return
	 */
	public JComboBox<Integer> getYearJComboBox(int startYear, int endYear) {
		assert (startYear >= 1900 && endYear <= 2050) : ("startYear or endYear out of bounds!");
		JComboBox<Integer> yearjComboBox = new JComboBox<Integer>();
		for (int i = startYear; i <= endYear; i++) {
			yearjComboBox.addItem(i);
		}
		return yearjComboBox;
	}

	/**
	 * 得到月份的jcombobox
	 * 
	 * @return
	 */
	public JComboBox<Integer> getMonthJComboBox() {
		JComboBox<Integer> monthjComboBox = new JComboBox<Integer>();
		for (int i = 1; i <= 12; i++) {
			monthjComboBox.addItem(i);
		}
		return monthjComboBox;
	}

	/**
	 * 得到天数的JCombobox
	 * 
	 * @return
	 */
	public JComboBox<Integer> getDayJComboBox() {
		JComboBox<Integer> dayjComboBox = new JComboBox<Integer>();
		for (int i = 1; i <= 31; i++) {
			dayjComboBox.addItem(i);
		}
		return dayjComboBox;
	}

	/**
	 * 将表格文字居中显示
	 * 
	 * @param jtable
	 */
	public void setJTableTextCenter(JTable jTable) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容-11
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 设置table内容居中-2
		jTable.setDefaultRenderer(Object.class, tcr);
		((DefaultTableCellRenderer) jTable.getTableHeader()
				.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// 设置表头居中
		jTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	}
}
