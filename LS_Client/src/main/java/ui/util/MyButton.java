package ui.util;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.Img;

public class MyButton extends JButton {
	/*
	 * 
	 * setIcon--->原始图片 setRolloverIcon-->鼠标进入的 setPressedIcon-->鼠标按下
	 * 
	 * selectedIcon disabledSelectedIcon disabledIcon
	 */
	public MyButton(int x, int y) {
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(Img.getButton0());
		setRolloverIcon(Img.getButton_over());
		setBounds(x, y, Img.getButton0().getIconWidth(), Img.getButton0()
				.getIconHeight());
	}

	public MyButton(ButtonType type) {
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch (type) {
		case ADD:
			setIcon(Img.getAdd_btn());
			setRolloverIcon(Img.getAdd_btn_pressed());
			break;
		case STOCK_IN:
			setIcon(Img.getStockIn());
			setRolloverIcon(Img.getStockIn_pressed());
			break;
		case OK:
			setIcon(Img.getOk_btn());
			setRolloverIcon(Img.getOk_btn_pressed());
			break;
		case SIGNED:
			setIcon(Img.getSigned_btn());
			setRolloverIcon(Img.getSigned_btn_pressed());
			break;
		case NEWGOODS:
			setIcon(Img.getNewGoods_btn());
			setRolloverIcon(Img.getNewGoods_btn_pressed());
			break;
		case SEARCH:
			setIcon(Img.getFind_btn());
			setRolloverIcon(Img.getFind_btn_pressed());
			break;
		case EXIT:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
			break;
		case LOGIN:
			setIcon(Img.getBtn_login());
			setRolloverIcon(Img.getBtn_login_pressed());
			break;
		case CANCEL:
			setIcon(Img.getCancel_btn());
			setRolloverIcon(Img.getCancel_btn_pressed());
			break;
		case ARRIVE:
			setIcon(Img.getArrive_btn());
			setRolloverIcon(Img.getArrive_pressed());
			break;
		case CAR_MANAGEMENT:
			setIcon(Img.getCarManage_btn());
			setRolloverIcon(Img.getCarManage_btn_pressed());
			break;
		case DRIVER_MANAGEMENT:
			setIcon(Img.getDriverManage_btn());
			setRolloverIcon(Img.getDriverManage_btn_pressed());
			break;
		case DELIVER:
			setIcon(Img.getDeliver_btn());
			setRolloverIcon(Img.getDeliver_pressed());
			break;
		case MONEY_IN_RECORD:// TODO
			setIcon(Img.getMoneyIn_btn());
			setRolloverIcon(Img.getMoneyIn_btn_pressed());
			break;
		case TO_TRANSFER_CTR:
			setIcon(Img.getTo_transferCtr_btn());
			setRolloverIcon(Img.getTo_transferCtr_btn_pressed());
			break;
		case TO_TRS_CTR_OR_YYT:
			setIcon(Img.getTo_both_btn());
			setRolloverIcon(Img.getTo_both_btn_pressed());
			break;
		case TO_YYT:
			setIcon(Img.getTo_yyt_btn());
			setRolloverIcon(Img.getTo_yyt_btn_pressed());
			break;
		case ARRIVE_BIG:
			setIcon(Img.getArriveBig_btn());
			setRolloverIcon(Img.getArriveBig_btn_pressed());
			break;
		case BACK:
			setIcon(Img.getBack_btn());
			setRolloverIcon(Img.getBack_btn_pressed());
			break;
		// TODO
		case FORM_BUSINESS:
			setIcon(Img.getFormBusiness_btn());
			setRolloverIcon(Img.getFormBusiness_btn_pressed());
			break;
		case FORM_PROFIT:
			setIcon(Img.getFormProfit_btn());
			setRolloverIcon(Img.getFormProfit_btn_pressed());
			break;
		case NEW_BANK_ACCOUNT:
			setIcon(Img.getNewBankAccount_btn());
			setRolloverIcon(Img.getNewBankAccount_btn_pressed());
			break;
		case NEW_DISTANCE:
			setIcon(Img.getNewDistance_btn());
			setRolloverIcon(Img.getNewDistance_btn_pressed());
			break;
		case NEW_INSTITUTE:
			setIcon(Img.getNewInstitute_btn());
			setRolloverIcon(Img.getNewInstitute_btn_pressed());
			break;
		case NEW_SALARY:
			setIcon(Img.getNewSalary_btn());
			setRolloverIcon(Img.getNewSalary_btn_pressed());
			break;
		case PAY_REP:
			setIcon(Img.getPayRep_btn());
			setRolloverIcon(Img.getPayRep_btn_pressed());
			break;
		case SEARCH_ACCOUNT:
			setIcon(Img.getSearchAccount_btn());
			setRolloverIcon(Img.getSearchAccount_btn_pressed());
			break;
		case SEARCH_NAME:
			setIcon(Img.getSearchName_btn());
			setRolloverIcon(Img.getSearchName_btn_pressed());
			break;
		case SEARCH_NUMBER:
			setIcon(Img.getSearchNumber_btn());
			setRolloverIcon(Img.getSearchNumber_btn_pressed());
			break;
		case SEARCH_PERSON_NAME:
			setIcon(Img.getSearchPersonName_btn());
			setRolloverIcon(Img.getSearchPersonName_btn_pressed());
			break;
		case SUBMIT:
			setIcon(Img.getSubmit_btn());
			setRolloverIcon(Img.getSubmit_btn_pressed());
		}
	}

	public MyButton(int x, int y, ButtonType type) {
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch (type) {
		case SHRINK:
			setIcon(Img.getShrink_btn());
			setRolloverIcon(Img.getShrink_btn_pressed());
			setBounds(x, y, Img.getShrink_btn().getIconWidth(), Img.getShrink_btn()
					.getIconHeight());
			break;
		case ADD:
			setIcon(Img.getAdd_btn());
			setRolloverIcon(Img.getAdd_btn_pressed());
			setBounds(x, y, Img.getAdd_btn().getIconWidth(), Img.getAdd_btn()
					.getIconHeight());
			break;
		case STOCK_SHOW_LITTLE:
			setIcon(Img.getStockShowLittle());
			setRolloverIcon(Img.getStockShowLittle_pressed());
			setBounds(x, y, Img.getStockShowLittle().getIconWidth(), Img
					.getStockShowLittle().getIconHeight());
			break;
		case EXCEL_OUT:
			setIcon(Img.getExcel_btn());
			setRolloverIcon(Img.getExcel_btn_pressed());
			setBounds(x, y, Img.getExcel_btn().getIconWidth(), Img
					.getExcel_btn().getIconHeight());
			break;
		case BACK:
			setIcon(Img.getBack_btn());
			setRolloverIcon(Img.getBack_btn_pressed());
			setBounds(x, y, Img.getBack_btn().getIconWidth(), Img.getBack_btn()
					.getIconHeight());
			break;
		case STOCK_INPUT:
			setIcon(Img.getInputStock_btn());
			setRolloverIcon(Img.getInputStock_btn_pressed());
			setBounds(x, y, Img.getInputStock_btn().getIconWidth(), Img
					.getInputStock_btn().getIconHeight());
			break;
		case STOCK_CHANGE:
			setIcon(Img.getStockChange());
			setRolloverIcon(Img.getStockChange_pressed());
			setBounds(x, y, Img.getStockChange().getIconWidth(), Img
					.getStockChange().getIconHeight());
			break;
		case STOCK_CHECK:
			setIcon(Img.getStockCheck());
			setRolloverIcon(Img.getStockCheck_pressed());
			setBounds(x, y, Img.getStockCheck().getIconWidth(), Img
					.getStockCheck().getIconHeight());
			break;
		case STOCK_IN:
			setIcon(Img.getStockIn());
			setRolloverIcon(Img.getStockIn_pressed());
			setBounds(x, y, Img.getStockIn().getIconWidth(), Img.getStockIn()
					.getIconHeight());
			break;
		case STOCK_OUT:
			setIcon(Img.getStockOut());
			setRolloverIcon(Img.getStockOut_pressed());
			setBounds(x, y, Img.getStockOut().getIconWidth(), Img.getStockOut()
					.getIconHeight());
			break;
		case STOCK_SHOW:
			setIcon(Img.getStockShow());
			setRolloverIcon(Img.getStockShow_pressed());
			setBounds(x, y, Img.getStockShow().getIconWidth(), Img
					.getStockShow().getIconHeight());
			break;
		case OK:
			setIcon(Img.getOk_btn());
			setRolloverIcon(Img.getOk_btn_pressed());
			setBounds(x, y, Img.getOk_btn().getIconWidth(), Img.getOk_btn()
					.getIconHeight());
			break;
		case SIGNED:
			setIcon(Img.getSigned_btn());
			setRolloverIcon(Img.getSigned_btn_pressed());
			setBounds(x, y, Img.getSigned_btn().getIconWidth(), Img
					.getSigned_btn().getIconHeight());
			break;
		case NEWGOODS:
			setIcon(Img.getNewGoods_btn());
			setRolloverIcon(Img.getNewGoods_btn_pressed());
			setBounds(x, y, Img.getNewGoods_btn().getIconWidth(), Img
					.getNewGoods_btn().getIconHeight());
			break;
		case SEARCH:
			setIcon(Img.getFind_btn());
			setRolloverIcon(Img.getFind_btn_pressed());
			setBounds(x, y, Img.getFind_btn().getIconWidth(), Img.getFind_btn()
					.getIconHeight());
			break;
		case EXIT:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
			setBounds(x, y, Img.getExit_btn().getIconWidth(), Img.getExit_btn()
					.getIconHeight());
			break;
		case LOGIN:
			setIcon(Img.getBtn_login());
			setRolloverIcon(Img.getBtn_login_pressed());
			setBounds(x, y, Img.getBtn_login().getIconWidth(), Img
					.getBtn_login().getIconHeight());
			break;
		case CANCEL:
			setIcon(Img.getCancel_btn());
			setRolloverIcon(Img.getCancel_btn_pressed());
			setBounds(x, y, Img.getCancel_btn().getIconWidth(), Img
					.getCancel_btn().getIconHeight());
			break;

		case TO_TRANSFER_CTR:
			setIcon(Img.getTo_transferCtr_btn());
			setRolloverIcon(Img.getTo_transferCtr_btn_pressed());
			setBounds(x, y, Img.getTo_transferCtr_btn().getIconWidth(), Img
					.getTo_transferCtr_btn().getIconHeight());
			break;
		case TO_TRS_CTR_OR_YYT:
			setIcon(Img.getTo_both_btn());
			setRolloverIcon(Img.getTo_both_btn_pressed());
			setBounds(x, y, Img.getTo_both_btn().getIconWidth(), Img
					.getTo_both_btn().getIconHeight());
			break;
		case TO_YYT:
			setIcon(Img.getTo_yyt_btn());
			setRolloverIcon(Img.getTo_yyt_btn_pressed());
			setBounds(x, y, Img.getTo_yyt_btn().getIconWidth(), Img
					.getTo_yyt_btn().getIconHeight());
			break;
		case ARRIVE_BIG:
			setIcon(Img.getArriveBig_btn());
			setRolloverIcon(Img.getArriveBig_btn_pressed());
			setBounds(x, y, Img.getArriveBig_btn().getIconWidth(), Img
					.getArriveBig_btn().getIconHeight());
			break;

		}
	}
	//
	// public static void main(String[] args) {
	// JFrame frame=new JFrame();
	// JPanel panel=new JPanel();
	// MyButton btn=new MyButton(10,10);
	// btn.setBounds(0,0,20,20);
	// panel.add(btn);
	// frame.setContentPane(panel);
	// frame.setVisible(true);
	// frame.setSize(600, 800);
	// frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	// }
}
