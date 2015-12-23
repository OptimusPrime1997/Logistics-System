package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepBonusRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepBonusblService;

public class PayRepBounsController extends PayThingMethods implements PayRepBonusblService{
	
	private Bonusbl bonusbl = new Bonusbl();

	@Override
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO) {
		// TODO Auto-generated method stub
		bonusbl.submitBonus(payRepVO, payRepBonusRepVO);
	}

	@Override
	public Vector<Object> initBonusTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return bonusbl.initBonusTable(payRepVO);
	}

	@Override
	public String getReceiverName(String num) 
			throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return bonusbl.getReceiverName(num);
	}

}
