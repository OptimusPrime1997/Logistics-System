package bl.controllerfactorybl;

import bl.formbl.controller.BusinessFormController;
import bl.formbl.controller.ProfitFormController;
import bl.goodsbl.controller.GoodsCheckController;
import bl.goodsbl.controller.GoodsDeleteController;
import bl.goodsbl.controller.GoodsExamineController;
import bl.goodsbl.controller.GoodsGetByCourierController;
import bl.goodsbl.controller.GoodsInitController;
import bl.goodsbl.controller.GoodsSetStateController;
import bl.loginbl.LoginblController;
import bl.managementbl.accountbl.AccountblController;
import bl.managementbl.bankaccountbl.BankAccountblController;
import bl.managementbl.constbl.ConstblController;
import bl.managementbl.institutionbl.InstitutionblController;
import bl.managementbl.salarypolicybl.SalaryPolicyblController;
import bl.managementbl.vehicleanddriverbl.DriverblController;
import bl.managementbl.vehicleanddriverbl.VehicleblController;
import blservice.controllerfactoryblservice.ControllerFactoryBLService;
import blservice.formblservice.BusinessFormBLService;
import blservice.formblservice.ProfitFormBLService;
import blservice.goodsblservice.GoodsCheckBLService;
import blservice.goodsblservice.GoodsDeleteBLService;
import blservice.goodsblservice.GoodsExamineBLService;
import blservice.goodsblservice.GoodsGetByCouriersBLService;
import blservice.goodsblservice.GoodsInitBLService;
import blservice.goodsblservice.GoodsSetStateBLService;
import blservice.logblservice.LogBLService;
import blservice.loginblservice.LoginBLService;
import blservice.managementblservice.accountblservice.AccountBLService;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;
import blservice.managementblservice.constblservice.ConstBLService;
import blservice.managementblservice.institutionblservice.InstitutionBLService;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

public class ControllerFactoryImpl implements ControllerFactoryBLService{
private ControllerFactoryImpl() {}
	
	public static ControllerFactoryImpl getInstance() {
		return ControllerFactoryImplHolder.controllerFactory;
	}
	
	private static class ControllerFactoryImplHolder {
		private static ControllerFactoryImpl controllerFactory = new ControllerFactoryImpl();
	}
	@Override
	public BusinessFormBLService getBusinessFromController() {
		// TODO Auto-generated method stub
		return new BusinessFormController();
	}

	@Override
	public ProfitFormBLService getProfitFormController() {
		// TODO Auto-generated method stub
		return new ProfitFormController();
	}

	@Override
	public GoodsCheckBLService getGoodsCheckController() {
		// TODO Auto-generated method stub
		return new GoodsCheckController();
	}

	@Override
	public GoodsDeleteBLService getGoodsDeleteController() {
		// TODO Auto-generated method stub
		return new GoodsDeleteController();
	}

	@Override
	public GoodsExamineBLService getGoodsExamineController() {
		// TODO Auto-generated method stub
		return new GoodsExamineController();
	}

	@Override
	public GoodsGetByCouriersBLService getGoodsGetByCourierController() {
		// TODO Auto-generated method stub
		return new GoodsGetByCourierController();
	}

	@Override
	public GoodsInitBLService getGoodsInitController() {
		// TODO Auto-generated method stub
		return new GoodsInitController();
	}

	@Override
	public GoodsSetStateBLService getGoodsSetStateController() {
		// TODO Auto-generated method stub
		return new GoodsSetStateController();
	}

	@Override
	public LogBLService getLogController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBLService getAccountController() {
		// TODO Auto-generated method stub
		return new AccountblController();
	}

	@Override
	public BankAccountBLService getBankAccountController() {
		// TODO Auto-generated method stub
		return  new BankAccountblController();
	}

	@Override
	public ConstBLService getConstController() {
		// TODO Auto-generated method stub
		return new ConstblController();
	}

	@Override
	public InstitutionBLService getInstitutionController() {
		// TODO Auto-generated method stub
		return new InstitutionblController();
	}

	@Override
	public SalaryPolicyBLService getSalaryPolicyController() {
		// TODO Auto-generated method stub
		return new SalaryPolicyblController();
	}

	@Override
	public DriverBLService getDriverController() {
		// TODO Auto-generated method stub
		return new DriverblController();
	}

	@Override
	public VehicleBLService getVehicleController() {
		// TODO Auto-generated method stub
		return new VehicleblController();
	}

	@Override
	public LoginBLService getLoginController() {
		// TODO Auto-generated method stub
		return new LoginblController();
	}

}
