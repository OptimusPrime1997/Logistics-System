package bl.controllerfactorybl;

import bl.formbl.controller.BusinessFormController;
import bl.formbl.controller.ProfitFormController;
import bl.goodsbl.controller.GoodsCheckController;
import bl.goodsbl.controller.GoodsDeleteController;
import bl.goodsbl.controller.GoodsEndController;
import bl.goodsbl.controller.GoodsExamineController;
import bl.goodsbl.controller.GoodsGetByCourierController;
import bl.goodsbl.controller.GoodsInitCompleteController;
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
//import blservice.goodsblservice.GetNumOfGoodsByCourierBLService;
import blservice.goodsblservice.GoodsCheckBLService;
import blservice.goodsblservice.GoodsDeleteBLService;
import blservice.goodsblservice.GoodsEndBLService;
//import blservice.goodsblservice.GoodsEndBLService;
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
import blservice.stockblservice.StockDivisionBLService;
import blservice.stockblservice.StockNumBLService;

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
		
		return new BusinessFormController();
	}

	@Override
	public ProfitFormBLService getProfitFormController() {
		
		return new ProfitFormController();
	}

	@Override
	public GoodsCheckBLService getGoodsCheckController() {
		
		return new GoodsCheckController();
	}

	@Override
	public GoodsDeleteBLService getGoodsDeleteController() {
		
		return new GoodsDeleteController();
	}

	@Override
	public GoodsExamineBLService getGoodsExamineController() {
		
		return new GoodsExamineController();
	}

	@Override
	public GoodsGetByCouriersBLService getGoodsGetByCourierController() {
		
		return new GoodsGetByCourierController();
	}

	@Override
	public GoodsInitBLService getGoodsInitController() {
		
		return new GoodsInitController();
	}

	@Override
	public GoodsSetStateBLService getGoodsSetStateController() {
		
		return new GoodsSetStateController();
	}

	@Override
	public LogBLService getLogController() {
		
		return null;
	}

	@Override
	public AccountBLService getAccountController() {
		
		return new AccountblController();
	}

	@Override
	public BankAccountBLService getBankAccountController() {
		
		return  new BankAccountblController();
	}

	@Override
	public ConstBLService getConstController() {
		
		return new ConstblController();
	}

	@Override
	public InstitutionBLService getInstitutionController() {
		
		return new InstitutionblController();
	}

	@Override
	public SalaryPolicyBLService getSalaryPolicyController() {
		
		return new SalaryPolicyblController();
	}

	@Override
	public DriverBLService getDriverController() {
		
		return new DriverblController();
	}

	@Override
	public VehicleBLService getVehicleController() {
		
		return new VehicleblController();
	}

	@Override
	public LoginBLService getLoginController() {
		
		return new LoginblController();
	}

	@Override
	public CashRepblService getCashRepblService() {
		
		return new CashRepController();
	}

	@Override
	public DeliverRepblService getDeliverRepblService() {
		
		return new DeliverController();
	}

	@Override
	public GetRepblService getGetRepblService() {
		
		return new GetRepController();
	}

	@Override
	public InStockRepblService getInStockRepblService() {
		
		return new InStockRepController();
	}

	@Override
	public OutStockRepblService getOutStockRepblService() {
		
		return new OutStockRepController();
	}

	@Override
	public PayRepblService getPayRepblService() {
		
		return new PayRepController();
	}

	@Override
	public ReceptionRepblService getReceptionRepblService() {
		
		return new ReceptionRepController();
	}

	@Override
	public ShipmentRepblServce getShipmentRepblServce() {
		
		return new ShipmentController();
	}

	@Override
	public ShippingRepblService getShippingRepblService() {
		
		return new ShippingRepController();
	}

	@Override
	public TransferRepblService getTransferRepblService() {
		
		return new TransferRepController();
	}

	
	@Override
	public StockBLService getStockController() {
		return new StockController();
	}

	
	@Override
	public GoodsInitCompleteBLService getGoodsInitCompleteController() {
		
		return new GoodsInitCompleteController();
	}

	@Override
	public GoodsEndBLService getGoodsEndController() {
		
		return new GoodsEndController();
	}


	

	
	@Override
	public StockNumBLService getStockNumController() {
		return new StockController();
	}

	
	@Override
	public StockDivisionBLService getStockDivisionController() {
		return new StockController();
	}

	
	
}
