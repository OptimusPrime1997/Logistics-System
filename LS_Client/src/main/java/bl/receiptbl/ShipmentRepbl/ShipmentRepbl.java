package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import PO.Receipt.ShipmentRepPO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShipmentRepVO;
import bl.managementbl.vehicleanddriverbl.Driverbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class ShipmentRepbl {

	private Receiptbl receiptbl = new Receiptbl();
	private Driverbl driverbl = new Driverbl();

	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShipmentRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		ShipmentRepVO shipmentRepVO = (ShipmentRepVO) vo;
		String driverNum = shipmentRepVO.driverNum;
		updateDriver(driverNum);
		receiptbl.submit(ShipmentRepVO.toPO(shipmentRepVO), Rep.ShipmentRep);
	}

	public ArrayList<ShipmentRepVO> getAllRep(String office)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ShipmentRep, office);
		return ShipmentRepVO.toArrayVO(receiptPOs);
	}

	public ShipmentRepVO getRepByNum(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShipmentRep);
		return new ShipmentRepVO((ShipmentRepPO) receiptPO);
	}

	public String getTruckSum(String date, String office)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		String truckNum = createNum(date, office);
		int index = 0;
		char strs[] = truckNum.toCharArray();
		for (int i = 0; i < truckNum.length(); i++) {
			if ('0' != strs[i]) {
				index = i;
				break;
			}
		}
		String strLast = truckNum.substring(index);
		int num = Integer.parseInt(strLast);
		String ans=num-1+"";
		System.out.println("Shipmentbl.getTruckSum "+ans);
		return num-1+"";
	}

	public boolean isTrueAccount(String num) {
		try {
			driverbl.findByDriverNum(num);
		} catch (ClassNotFoundException | NumNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isTrueOrder(String order) {
		return receiptbl.isTrueOrder(order);
	}

	private void updateDriver(String driverNum) {
		driverbl.addNumber(driverNum);
	}

}
