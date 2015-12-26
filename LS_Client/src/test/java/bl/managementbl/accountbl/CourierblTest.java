package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.AfterClass;
import org.junit.Test;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.CourierVO;

public class CourierblTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Courierbl courierbl=new Courierbl();
		CourierVO v=null;
		ResultMessage rmsg=courierbl.add(new CourierVO("02500106066", 10.0));
		System.out.println("添加快递员 运送金额"+ResultMessage.toFriendlyString(rmsg));
		ResultMessage r=courierbl.updateMoney("02500106066", 1000);
		System.out.println("添加快递员 修改金额"+ResultMessage.toFriendlyString(r));
		if(rmsg==ResultMessage.SUCCESS){
			try {
				v=courierbl.findByCourierNum("02500106066");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(1010, v.courrentMonthMoney,0.1);
		}
	}

}
