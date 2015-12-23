package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.Receipt.GetRepVO;
import VO.Receipt.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.GetRepblService;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.Rep;

public class GetRepController extends ReceiptblController implements GetRepblService{
	private GetRepbl getRepbl = new GetRepbl();
	private GetRepCheckbl getRepCheckbl = new GetRepCheckbl();
	private GetRepShowbl getRepShowbl = new GetRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return getRepbl.createNum(date, office);
	}

	@Override
	public GetRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, 
	IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		getRepbl.submit(vo);
	}

	@Override
	public ArrayList<GetRepVO> getAllRep(String office) throws NotBoundException, ClassNotFoundException, 
	IOException {
		// TODO Auto-generated method stub
		return getRepbl.getAllRep(office);
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return getRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepShowbl.initShow(num);
	}

	@Override
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepbl.initTable(rep, num, existOrders);
	}

	@Override
	public void transferOver(String num, GoodsArrivalState goodsArrivalState) {
		// TODO Auto-generated method stub
		getRepbl.transferOver(num, goodsArrivalState);
	}

	@Override
	public String getDepart(Rep rep, String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepbl.getDepart(rep, num);
	}

	@Override
	public boolean isTrueOrder(String order) {
		// TODO Auto-generated method stub
		return getRepbl.isTrueOrder(order);
	}

	@Override
	public void changeLogistic(String num, GoodsLogisticState goodsLogisticState) {
		// TODO Auto-generated method stub
		getRepbl.changeLogistic(num, goodsLogisticState);
	}

	@Override
	public String getDestination(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return getRepbl.getDestination(order);
	}

}
