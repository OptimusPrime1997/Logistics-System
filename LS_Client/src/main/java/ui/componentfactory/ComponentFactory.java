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
	private ComponentFactory() {
	}

	public static ComponentFactory getInstance() {
		return ComponentHolder.component;
	}

	private static class ComponentHolder {
		private static ComponentFactory component = new ComponentFactory();
	}

	public JComboBox<Authority> getAuthorityJComboBox() {
		return new JComboBox<Authority>();
	}

	public JComboBox<Sex> getSexJComboBox() {
		return new JComboBox<Sex>();
	}

	public JComboBox<LogType> getLogTypeJComboBox() {
		return new JComboBox<LogType>();
	}
	public JComboBox<Integer> getYearJComboBox(int startYear,int endYear){
		assert (startYear>=1900&&endYear<=2050):("startYear or endYear out of bounds!");
		JComboBox<Integer> yearjComboBox=new JComboBox<Integer>();
		for(int i=startYear;i<=endYear;i++){
			yearjComboBox.addItem(i);
		}
		return yearjComboBox;
	}
	public JComboBox<Integer> getMonthJComboBox(){
		JComboBox<Integer> monthjComboBox=new JComboBox<Integer>();
		for(int i=1;i<=12;i++){
			monthjComboBox.addItem(i);
		}
		return monthjComboBox;
	}
	/**
	 * 得到天数的JCombobox
	 * @return
	 */
	public JComboBox<Integer> getDayJComboBox(){
		JComboBox<Integer> dayjComboBox=new JComboBox<Integer>();
		for(int i=1;i<=31;i++){
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
