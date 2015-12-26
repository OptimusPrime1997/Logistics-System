package bl.managementbl.institutionbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.AfterClass;
import org.junit.Test;

import util.enumData.ResultMessage;
import Exception.InstitutionNotFoundException;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.InstitutionVO;

public class InstitutionblControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		InstitutionblController institutionblController = new InstitutionblController();
		InstitutionVO vo = null;
		InstitutionVO vo1 = null;
		try {
			ResultMessage[] rmsgs = new ResultMessage[3];
			rmsgs[0] = institutionblController.insert(new InstitutionVO(
					"025001", "南京市栖霞区营业厅","02589689345", "南京市栖霞区仙林大道163号", 
					""));
			rmsgs[1] = institutionblController.insert(new InstitutionVO(
					"025002", "南京市栖霞区营业厅", "02589689345", "南京市栖霞区仙林大道235号",
					""));
			rmsgs[2] = institutionblController.insert(new InstitutionVO(
					"025003", "南京市栖霞区营业厅", "02589689345", "南京市栖霞区仙林大道345号",
					""));
			for (int i = 0; i < 3; i++) {
				System.out.println(rmsgs[i].toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = institutionblController.findByInstitutionNum("025002");
			System.out.println(vo.address);
			assertEquals("南京市栖霞区仙林大道235号", vo.address);
			// institutionbl.delete(vo);
			vo1 = institutionblController.findByInstitutionName("南京市栖霞区营业厅");
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
		} catch (InstitutionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vo1 != null) {
			assertEquals("02589689345", vo1.contactInfo);
		} else {
			System.out.println("vo is null");
		}

	}

}
