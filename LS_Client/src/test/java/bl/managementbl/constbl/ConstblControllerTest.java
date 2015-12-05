package bl.managementbl.constbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.Test;

import Exception.ConstNotFoundException;
import VO.ManagementVO.ConstVO;

public class ConstblControllerTest {

	@Test
	public void test() {
		ConstblController constblController = new ConstblController();
		ConstVO vo = null;
		ConstVO vo1 = null;
		try {
			constblController.insert(new ConstVO("南京-上海", 900, 1));
			constblController.insert(new ConstVO("广州-南京", 1200, 1.1));
			constblController.insert(new ConstVO("广州-上海", 950, 1.2));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = constblController.findByCities("南京-上海");
			System.out.println(vo.distanceConst);
			assertEquals(900, vo.distanceConst, 0.01);
			// constbl.delete(vo);
			vo1 = constblController.findByCities("广州-上海");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vo1 != null) {
			assertEquals(1.2, vo1.priceConst, 0.01);
		} else {
			System.out.println("vo is null");
		}
	}
}