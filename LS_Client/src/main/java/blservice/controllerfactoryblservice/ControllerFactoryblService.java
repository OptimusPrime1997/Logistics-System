package blservice.controllerfactoryblservice;

import blservice.formblservice.BusinessFormBLService;
import blservice.formblservice.ProfitFormBLService;
//import blservice.goodsblservice.GetNumOfGoodsByCourierBLService;
import blservice.goodsblservice.GoodsCheckValidBLService;
import blservice.goodsblservice.GoodsDeleteBLService;
import blservice.goodsblservice.GoodsEndBLService;
//import blservice.goodsblservice.GoodsEndBLService;
import blservice.goodsblservice.GoodsExamineBLService;
import blservice.goodsblservice.GoodsFindBLService;
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

public interface ControllerFactoryblService {
	public BusinessFormBLService getBusinessFromController();

	public ProfitFormBLService getProfitFormController();

	public GoodsCheckValidBLService getGoodsCheckController();

	public GoodsDeleteBLService getGoodsDeleteController();

	public GoodsExamineBLService getGoodsExamineController();

	public GoodsFindBLService getGoodsFindController();

	public GoodsInitBLService getGoodsInitController();

	public GoodsSetStateBLService getGoodsSetStateController();

	public GoodsEndBLService getGoodsEndController();

	public LogBLService getLogController();

	public AccountBLService getAccountController();

	public BankAccountBLService getBankAccountController();

	public ConstBLService getConstController();

	public InstitutionBLService getInstitutionController();

	public SalaryPolicyBLService getSalaryPolicyController();

	public DriverBLService getDriverController();

	public VehicleBLService getVehicleController();

	public LoginBLService getLoginController();

	public CashRepblService getCashRepblService();

	public DeliverRepblService getDeliverRepblService();

	public GetRepblService getGetRepblService();

	public InStockRepblService getInStockRepblService();

	public OutStockRepblService getOutStockRepblService();

	public PayRepblService getPayRepblService();

	public ReceptionRepblService getReceptionRepblService();

	public ShipmentRepblServce getShipmentRepblServce();

	public ShippingRepblService getShippingRepblService();

	public TransferRepblService getTransferRepblService();

	public StockBLService getStockController();

	public StockNumBLService getStockNumController();

	public StockDivisionBLService getStockDivisionController();

}
