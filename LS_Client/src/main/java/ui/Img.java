package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.util.MyFrame;

public class Img {
	
	private static Image background_login = new ImageIcon("pic/background/background_login.png")
			.getImage();
	private static Image background_main=new ImageIcon("pic/background/background_main.png").getImage();
	private static Image background_searchState=new ImageIcon("pic/background/background_searchState.png").getImage();
	private static Image background_business=new ImageIcon("pic/background/business_background.png").getImage();
	
	private static Image form_business_img=new ImageIcon("pic/img/manage.png").getImage();
	private static Image form_profit_img=new ImageIcon("pic/img/profit.png").getImage();
	private static Image payRep_img=new ImageIcon("pic/img/pay.png").getImage();
	
	private static ImageIcon formBusiness_btn=new ImageIcon("pic/btn/formBusiness_btn.png");
	private static ImageIcon formBusiness_btn_pressed=new ImageIcon("pic/btn/formBusiness_btn_pressed.png");
	
	private static ImageIcon formProfit_btn=new ImageIcon("pic/btn/formProfit_btn.png");
	private static ImageIcon formProfit_btn_pressed=new ImageIcon("pic/btn/formProfit_btn_pressed.png");
	
	private static ImageIcon payRep_btn=new ImageIcon("pic/btn/payRep_btn.png");
	private static ImageIcon payRep_btn_pressed=new ImageIcon("pic/btn/payRep_btn_pressed.png");
	
	private static ImageIcon newBankAccount_btn=new ImageIcon("pic/btn/newBankAccount_btn.png");
	private static ImageIcon newBankAccount_btn_pressed=new ImageIcon("pic/btn/newBankAccount_btn_pressed.png");
	
	private static ImageIcon newDistance_btn=new ImageIcon("pic/btn/newDistance_btn.png");
	private static ImageIcon newDistance_btn_pressed=new ImageIcon("pic/btn/newDistance_btn_pressed.png");
	
	private static ImageIcon newSalary_btn=new ImageIcon("pic/btn/newSalary_btn.png");
	private static ImageIcon newSalary_btn_pressed=new ImageIcon("pic/btn/newSalary_btn_pressed.png");
	
	private static ImageIcon newInstitute_btn=new ImageIcon("pic/btn/newInstitute_btn.png");
	private static ImageIcon newInstitute_btn_pressed=new ImageIcon("pic/btn/newInstitute_btn_pressed.png");
	
	private static ImageIcon searchName_btn=new ImageIcon("pic/btn/searchName_btn.png");
	private static ImageIcon searchName_btn_pressed=new ImageIcon("pic/btn/searchName_btn_pressed.png");
	
	private static ImageIcon searchNumber_btn=new ImageIcon("pic/btn/searchNumber_btn.png");
	private static ImageIcon searchNumber_btn_pressed=new ImageIcon("pic/btn/searchNumber_btn_pressed.png");
	
	private static ImageIcon searchPersonName_btn=new ImageIcon("pic/btn/searchPersonName_btn.png");
	private static ImageIcon searchPersonName_btn_pressed=new ImageIcon("pic/btn/searchPersonName_btn_pressed.png");
	
	private static ImageIcon searchAccount_btn=new ImageIcon("pic/btn/searchAccount_btn.png");
	private static ImageIcon searchAccount_btn_pressed=new ImageIcon("pic/btn/searchAccount_btn_pressed.png");
	
	private static ImageIcon submit_btn=new ImageIcon("pic/btn/submit_btn.png");
	private static ImageIcon submit_btn_pressed=new ImageIcon("pic/btn/submit_btn_pressed.png");
	
	private static ImageIcon ok_btn=new ImageIcon("pic/btn/ok_btn.png");
	private static ImageIcon ok_btn_pressed=new ImageIcon("pic/btn/ok_btn_pressed.png");
	
	private static ImageIcon add_btn=new ImageIcon("pic/btn/add_btn.png");
	private static ImageIcon add_btn_pressed=new ImageIcon("pic/btn/add_btn_pressed.png");
	
	
	private static ImageIcon cancel_btn=new ImageIcon("pic/btn/btn_cancel.png");
	private static ImageIcon cancel_btn_pressed=new ImageIcon("pic/btn/btn_cancel_pressed.png");
	
	private static ImageIcon back_btn=new ImageIcon("pic/btn/back_btn.png");
	private static ImageIcon back_btn_pressed=new ImageIcon("pic/btn/back_btn_pressed.png");
	
	private static ImageIcon excel_btn=new ImageIcon("pic/btn/excel_btn.png");
	private static ImageIcon excel_btn_pressed=new ImageIcon("pic/btn/excel_btn_pressed.png");
	
	private static ImageIcon button0=new ImageIcon("pic/btn/ok_little_btn.png");
	private static ImageIcon button_over=new ImageIcon("pic/btn/ok_little_btn_pressed.png");
	
	private static ImageIcon search_btn=new ImageIcon("pic/btn/search_btn.png");
	private static ImageIcon search_btn_pressed=new ImageIcon("pic/btn/search_btn_pressed.png");
	
	private static ImageIcon find_btn=new ImageIcon("pic/btn/find_btn.png");
	private static ImageIcon find_btn_pressed=new ImageIcon("pic/btn/find_btn_pressed.png");
	
	private static ImageIcon login_btn=new ImageIcon("pic/btn/btn_login.png");
	private static ImageIcon login_btn_pressed=new ImageIcon("pic/btn/btn_login_pressed.png");
	

	private static ImageIcon shrink_btn=new ImageIcon("pic/btn/shrink_btn.png");
	private static ImageIcon shrink_btn_pressed=new ImageIcon("pic/btn/shrink_btn_pressed.png");
	
	private static ImageIcon exit_btn=new ImageIcon("pic/btn/btn_exit0.png");
	private static ImageIcon exit_btn_pressed=new ImageIcon("pic/btn/btn_exit1.png");
	
	private static ImageIcon newGoods_btn=new ImageIcon("pic/btn/newGoods_btn.png");
	private static ImageIcon newGoods_btn_pressed=new ImageIcon("pic/btn/newGoods_btn_pressed.png");
	
	private static ImageIcon signed_btn=new ImageIcon("pic/btn/signed_btn.png");
	private static ImageIcon signed_btn_pressed=new ImageIcon("pic/btn/signed_btn_pressed.png");
	
	private static ImageIcon to_both_btn=new ImageIcon("pic/btn/to_both_btn.png");
	private static ImageIcon to_both_btn_pressed=new ImageIcon("pic/btn/to_both_btn_pressed.png");
	
	private static ImageIcon to_transferCtr_btn=new ImageIcon("pic/btn/to_transferCtr_btn.png");
	private static ImageIcon to_transferCtr_btn_pressed=new ImageIcon("pic/btn/to_transferCtr_btn_pressed.png");
	
	private static ImageIcon to_yyt_btn=new ImageIcon("pic/btn/to_yyt_btn.png");
	private static ImageIcon to_yyt_btn_pressed=new ImageIcon("pic/btn/to_yyt_btn_pressed.png");
	
	private static ImageIcon deliver_btn=new ImageIcon("pic/btn/deliver_btn.png");
	private static ImageIcon deliver_pressed=new ImageIcon("pic/btn/deliver_btn_pressed.png");
	
	private static ImageIcon arrive_btn=new ImageIcon("pic/btn/arrive_btn.png");
	private static ImageIcon arrive_pressed=new ImageIcon("pic/btn/arrive_btn_pressed.png");
	
	private static ImageIcon arriveBig_btn=new ImageIcon("pic/btn/arriveBig_btn.png");
	private static ImageIcon arriveBig_btn_pressed=new ImageIcon("pic/btn/arriveBig_btn_pressed.png");
	
	
	private static ImageIcon carManage_btn=new ImageIcon("pic/btn/carManage_btn.png");
	private static ImageIcon carManage_btn_pressed=new ImageIcon("pic/btn/carManage_btn_pressed.png");
	
	private static ImageIcon driverManage_btn=new ImageIcon("pic/btn/driverManage_btn.png");
	private static ImageIcon driverManage_btn_pressed=new ImageIcon("pic/btn/driverManage_btn_pressed.png");
	
	private static ImageIcon moneyIn_btn=new ImageIcon("pic/btn/moneyIn_btn.png");
	private static ImageIcon moneyIn_btn_pressed=new ImageIcon("pic/btn/moneyIn_btn_pressed.png");
	
	private static ImageIcon stockInput_btn=new ImageIcon("pic/btn/stockInput_btn.png");
	private static ImageIcon stockInput_btn_pressed=new ImageIcon("pic/btn/stockInput_btn_pressed.png");
	
	private static ImageIcon stockOut=new ImageIcon("pic/btn/stockOut.png");
	private static ImageIcon stockOut_pressed=new ImageIcon("pic/btn/stockOut_pressed.png");
	
	private static ImageIcon stockIn=new ImageIcon("pic/btn/stockIn.png");
	private static ImageIcon stockIn_pressed=new ImageIcon("pic/btn/stockIn_pressed.png");
	
	private static ImageIcon stockShow=new ImageIcon("pic/btn/stockShow.png");
	private static ImageIcon stockShow_pressed=new ImageIcon("pic/btn/stockShow_pressed.png");
	
	private static ImageIcon stockShowLittle=new ImageIcon("pic/btn/stockShowLittle.png");
	private static ImageIcon stockShowLittle_pressed=new ImageIcon("pic/btn/stockShowLittle_pressed.png");
	
	private static ImageIcon stockCheck=new ImageIcon("pic/btn/stockCheck.png");
	private static ImageIcon stockCheck_pressed=new ImageIcon("pic/btn/stockCheck_pressed.png");
	
	private static ImageIcon stockChange=new ImageIcon("pic/btn/stockChange.png");
	private static ImageIcon stockChange_pressed=new ImageIcon("pic/btn/stockChange_pressed.png");
	
	
	public static Image getProfitIcon() {
		return form_profit_img;
	}

	public static Image getPayIcon() {
		return payRep_img;
	}

	public static Image getManageIcon() {
		return form_business_img;
	}
	
	public static Image getForm_business_img() {
		return form_business_img;
	}

	public static Image getForm_profit_img() {
		return form_profit_img;
	}

	public static Image getPayRep_img() {
		return payRep_img;
	}

	public static ImageIcon getBack_btn() {
		return back_btn;
	}

	public static ImageIcon getBack_btn_pressed() {
		return back_btn_pressed;
	}
	
	
	

	public static ImageIcon getFormBusiness_btn() {
		return formBusiness_btn;
	}

	public static ImageIcon getFormBusiness_btn_pressed() {
		return formBusiness_btn_pressed;
	}

	public static ImageIcon getFormProfit_btn() {
		return formProfit_btn;
	}

	public static ImageIcon getFormProfit_btn_pressed() {
		return formProfit_btn_pressed;
	}

	public static ImageIcon getPayRep_btn() {
		return payRep_btn;
	}

	public static ImageIcon getPayRep_btn_pressed() {
		return payRep_btn_pressed;
	}

	public static ImageIcon getNewBankAccount_btn() {
		return newBankAccount_btn;
	}

	public static ImageIcon getNewBankAccount_btn_pressed() {
		return newBankAccount_btn_pressed;
	}

	public static ImageIcon getNewDistance_btn() {
		return newDistance_btn;
	}

	public static ImageIcon getNewDistance_btn_pressed() {
		return newDistance_btn_pressed;
	}

	public static ImageIcon getNewSalary_btn() {
		return newSalary_btn;
	}

	public static ImageIcon getNewSalary_btn_pressed() {
		return newSalary_btn_pressed;
	}

	public static ImageIcon getNewInstitute_btn() {
		return newInstitute_btn;
	}

	public static ImageIcon getNewInstitute_btn_pressed() {
		return newInstitute_btn_pressed;
	}

	public static ImageIcon getSearchName_btn() {
		return searchName_btn;
	}

	public static ImageIcon getSearchName_btn_pressed() {
		return searchName_btn_pressed;
	}

	public static ImageIcon getSearchNumber_btn() {
		return searchNumber_btn;
	}

	public static ImageIcon getSearchNumber_btn_pressed() {
		return searchNumber_btn_pressed;
	}

	public static ImageIcon getSearchPersonName_btn() {
		return searchPersonName_btn;
	}

	public static ImageIcon getSearchPersonName_btn_pressed() {
		return searchPersonName_btn_pressed;
	}

	public static ImageIcon getSearchAccount_btn() {
		return searchAccount_btn;
	}

	public static ImageIcon getSearchAccount_btn_pressed() {
		return searchAccount_btn_pressed;
	}

	public static ImageIcon getSubmit_btn() {
		return submit_btn;
	}

	public static ImageIcon getSubmit_btn_pressed() {
		return submit_btn_pressed;
	}

	public static ImageIcon getSearch_btn() {
		return search_btn;
	}

	public static ImageIcon getSearch_btn_pressed() {
		return search_btn_pressed;
	}

	public static ImageIcon getLogin_btn() {
		return login_btn;
	}

	public static ImageIcon getLogin_btn_pressed() {
		return login_btn_pressed;
	}

	public static ImageIcon getExcel_btn() {
		return excel_btn;
	}

	public static ImageIcon getExcel_btn_pressed() {
		return excel_btn_pressed;
	}

	public static ImageIcon getStockShowLittle() {
		return stockShowLittle;
	}

	public static ImageIcon getStockShowLittle_pressed() {
		return stockShowLittle_pressed;
	}

	public static ImageIcon getStockInput_btn() {
		return stockInput_btn;
	}

	public static ImageIcon getShrink_btn() {
		return shrink_btn;
	}

	public static ImageIcon getShrink_btn_pressed() {
		return shrink_btn_pressed;
	}

	public static ImageIcon getStockInput_btn_pressed() {
		return stockInput_btn_pressed;
	}

	public static ImageIcon getStockOut() {
		return stockOut;
	}

	public static ImageIcon getStockOut_pressed() {
		return stockOut_pressed;
	}

	public static ImageIcon getStockIn() {
		return stockIn;
	}

	public static ImageIcon getStockIn_pressed() {
		return stockIn_pressed;
	}

	public static ImageIcon getStockShow() {
		return stockShow;
	}

	public static ImageIcon getStockShow_pressed() {
		return stockShow_pressed;
	}

	public static ImageIcon getStockCheck() {
		return stockCheck;
	}

	public static ImageIcon getStockCheck_pressed() {
		return stockCheck_pressed;
	}

	public static ImageIcon getStockChange() {
		return stockChange;
	}

	public static ImageIcon getStockChange_pressed() {
		return stockChange_pressed;
	}

	public static ImageIcon getInputStock_btn() {
		return stockInput_btn;
	}

	public static ImageIcon getInputStock_btn_pressed() {
		return stockInput_btn_pressed;
	}

	public static ImageIcon getCancel_btn() {
		return cancel_btn;
	}

	public static ImageIcon getCancel_btn_pressed() {
		return cancel_btn_pressed;
	}



	public static ImageIcon getAdd_btn() {
		return add_btn;
	}

	public static ImageIcon getAdd_btn_pressed() {
		return add_btn_pressed;
	}

	public static ImageIcon getArriveBig_btn() {
		return arriveBig_btn;
	}

	public static ImageIcon getArriveBig_btn_pressed() {
		return arriveBig_btn_pressed;
	}

	public static ImageIcon getMoneyIn_btn() {
		return moneyIn_btn;
	}

	public static ImageIcon getMoneyIn_btn_pressed() {
		return moneyIn_btn_pressed;
	}

	public static ImageIcon getDeliver_btn() {
		return deliver_btn;
	}

	public static ImageIcon getDeliver_pressed() {
		return deliver_pressed;
	}

	public static ImageIcon getTo_both_btn() {
		return to_both_btn;
	}

	public static ImageIcon getTo_both_btn_pressed() {
		return to_both_btn_pressed;
	}

	public static Image getBackground_business() {
		return background_business;
	}

	public static ImageIcon getTo_transferCtr_btn() {
		return to_transferCtr_btn;
	}

	public static ImageIcon getTo_transferCtr_btn_pressed() {
		return to_transferCtr_btn_pressed;
	}

	public static ImageIcon getTo_yyt_btn() {
		return to_yyt_btn;
	}

	public static ImageIcon getTo_yyt_btn_pressed() {
		return to_yyt_btn_pressed;
	}

	public static ImageIcon getCarManage_btn() {
		return carManage_btn;
	}

	public static ImageIcon getCarManage_btn_pressed() {
		return carManage_btn_pressed;
	}

	public static ImageIcon getDriverManage_btn() {
		return driverManage_btn;
	}

	public static ImageIcon getDriverManage_btn_pressed() {
		return driverManage_btn_pressed;
	}
	/**
	 * 登录界面的订单查询按钮
	 * @return
	 */
	public static ImageIcon getFind_btn() {
		return find_btn;
	}
	public static ImageIcon getFind_btn_pressed() {
		return find_btn_pressed;
	}

	public static ImageIcon getBtn_login_pressed() {
		return login_btn_pressed;
	}

	public static ImageIcon getArrive_btn() {
		return arrive_btn;
	}

	public static ImageIcon getArrive_pressed() {
		return arrive_pressed;
	}


	public static ImageIcon getSigned_btn() {
		return signed_btn;
	}

	public static ImageIcon getSigned_btn_pressed() {
		return signed_btn_pressed;
	}

	public static ImageIcon getNewGoods_btn() {
		return newGoods_btn;
	}

	public static ImageIcon getNewGoods_btn_pressed() {
		return newGoods_btn_pressed;
	}

	public static ImageIcon getExit_btn() {
		return exit_btn;
	}

	

	public static ImageIcon getBtn_login() {
		return login_btn;
	}

	

	public static ImageIcon getOk_btn() {
		return ok_btn;
	}

	public static ImageIcon getOk_btn_pressed() {
		return ok_btn_pressed;
	}

	public static Image getBackground_main() {
		return background_main;
	}

	public static Image getBackground_searchState() {
		return background_searchState;
	}

	public static ImageIcon getExit_btn_pressed() {
		return exit_btn_pressed;
	}

	public static ImageIcon getButton_over() {
		return button_over;
	}

	public static Image getBackground_login() {
		return background_login;
	}

	public static ImageIcon getButton0() {
		return button0;
	}

//	public static void main(String[] args) {
//		JPanel panel = new JPanel() {
//			public void paint(Graphics g) {
//				g.drawImage(Img.background_login, 0,0, 100, 100, null);
//			}
//		};
//		JFrame frame = new JFrame();
//		frame.setContentPane(panel);
//		frame.setSize(1000, 600);
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}

}
