package bl.receiptbl.DocumentCheckbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;
import VO.Receipt.ReceiptVO;
import blservice.receiptblservice.DocumentCheckblService;
import util.enumData.Rep;

public class DocumentCheckController implements DocumentCheckblService{
	DocumentCheckbl documentCheckbl = new DocumentCheckbl();

	@Override
	public void saveRep(ReceiptVO vo, Rep rep) {
		// TODO Auto-generated method stub
	}

	@Override
	public Vector<Object> initTable() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.initTable();
	}

}
