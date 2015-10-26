package driver;

import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsBLService;

public class Client {
	public static void main(String[] args) {
		GoodsBLService goodsbl = new Goodsbl();
		GoodsBLService_Driver driver = new GoodsBLService_Driver(goodsbl);
		driver.drive(goodsbl);
	}
}
