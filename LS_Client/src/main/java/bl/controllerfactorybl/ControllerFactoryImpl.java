package bl.controllerfactorybl;

import bl.formbl.controller.BusinessFormController;
import bl.formbl.controller.ProfitFormController;
import bl.goodsbl.controller.GoodsCheckController;
import bl.goodsbl.controller.GoodsDeleteController;
import bl.goodsbl.controller.GoodsExamineController;
import bl.goodsbl.controller.GoodsGetByCourierController;
import bl.goodsbl.controller.GoodsInitCompleteController;
import bl.goodsbl.controller.GoodsInitController;
import bl.goodsbl.controller.GoodsSetStateController;
import bl.loginbl.LoginBLController;
import bl.managementbl.accountbl.AccountblController;
import bl.managementbl.bankaccountbl.BankAccountblController;
import bl.managementbl.constbl.ConstblController;
import bl.managementbl.institutionbl.InstitutionblController;
import bl.managementbl.salarypolicybl.SalaryPolicyblController;
import bl.managementbl.vehicleanddriverbl.DriverblController;
import bl.managementbl.vehicleanddriverbl.VehicleblController;
import bl.receiptbl.CashRepbl.CashRepController;
import bl.receiptbl.DeliverRepbl.DeliverController;
import bl.receiptbl.GetRepbl.GetRepController;
import bl.receiptbl.InStockRepbl.InStockRepController;
import bl.receiptbl.OutStockRepbl.OutStockRepController;
import bl.receiptbl.PayRepbl.PayRepController;
import bl.receiptbl.ReceptionRepbl.ReceptionRepController;
import bl.receiptbl.ShipmentRepbl.ShipmentController;
import bl.receiptbl.ShippingRepbl.ShippingRepController;
import bl.receiptbl.TransferRepbl.TransferRepController;
import bl.stockbl.StockController;
import blservice.controllerfactoryblservice.ControllerFactoryblService;
import blservice.formblservice.BusinessFormBLService;
import blservice.formblservice.ProfitFormBLService;
import blservice.goodsblservice.GoodsCheckBLService;
import blservice.goodsblservice.GoodsDeleteBLService;
import blservice.goodsblservice.GoodsExamineBLService;
import blservice.goodsblservice.GoodsGetByCouriersBLService;
import blservice.goodsblservice.GoodsInitBLService;
import blservice.goodsblservice.GoodsInitCompleteBLService;
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
import blservice.receiptblservice.CashRepblService;
import blservice.receiptblservice.DeliverRepblService;
import blservice.receiptblservice.GetRepblService;
import blservice.receiptblservice.InStockRepblService;
import blservice.receiptblservice.OutStockRepblService;
import blservice.receiptblservice.PayRepblService;
import blservice.receiptblservice.ReceptionRepblService;
import blservice.receiptblservice.ShipmentRepblServce;
import blservice.receiptblservice.ShippingRepblService;
import blservice.receiptblservice.TransferRepblService;
import blservice.stockblservice.StockBLService;

public class ControllerFactoryImpl implements ControllerFactoryblService{
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
		return new LoginBLController();
	}

	@Override
	public CashRepblService getCashRepblService() {
		// TODO Auto-generated method stub
		return new CashRepController();
	}

	@Override
	public DeliverRepblService getDeliverRepblService() {
		// TODO Auto-generated method stub
		return new DeliverController();
	}

	@Override
	public GetRepblService getGetRepblService() {
		// TODO Auto-generated method stub
		return new GetRepController();
	}

	@Override
	public InStockRepblService getInStockRepblService() {
		// TODO Auto-generated method stub
		return new InStockRepController();
	}

	@Override
	public OutStockRepblService getOutStockRepblService() {
		// TODO Auto-generated method stub
		return new OutStockRepController();
	}

	@Override
	public PayRepblService getPayRepblService() {
		// TODO Auto-generated method stub
		return new PayRepController();
	}

	@Override
	public ReceptionRepblService getReceptionRepblService() {
		// TODO Auto-generated method stub
		return new ReceptionRepController();
	}

	@Override
	public ShipmentRepblServce getShipmentRepblServce() {
		// TODO Auto-generated method stub
		return new ShipmentController();
	}

	@Override
	public ShippingRepblService getShippingRepblService() {
		// TODO Auto-generated method stub
		return new ShippingRepController();
	}

	@Override
	public TransferRepblService getTransferRepblService() {
		// TODO Auto-generated method stub
		return new TransferRepController();
	}

	/* (non-Javadoc)
	 * @see blservice.controllerfactoryblservice.ControllerFactoryblService#getStockController()
	 */
	@Override
	public StockBLService getStockController() {
		return new StockController();
	}

	@Override
	public GoodsInitCompleteBLService getGoodsInitCompleteController() {
		// TODO Auto-generated method stub
		return new GoodsInitCompleteController();
	}
	
	
}
