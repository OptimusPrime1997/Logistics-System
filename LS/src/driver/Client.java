package driver;

import _Stub.GoodsBLService_Stub;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsBLService;

public class Client {
	public static void main(String[] args) {
		GoodsBLService goodsbl_stub = new GoodsBLService_Stub();
		GoodsBLService_Driver driver = new GoodsBLService_Driver(goodsbl_stub);
		driver.drive(goodsbl_stub);
	}
}
