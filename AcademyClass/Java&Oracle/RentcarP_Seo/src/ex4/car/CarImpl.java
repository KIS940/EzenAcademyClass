package ex4.car;
import java.util.ArrayList;

import ex4.base.Base;
import ex4.common.DataUtil;
public class CarImpl extends Base implements Car{
	String carData;
	CarDAO carDAO=new CarDAOImpl();	
	//���� ������ ��ȸ�ϴ� �޼���
	public ArrayList<CarVo> listCarInfo(String str) throws Exception{
		ArrayList<CarVo> carList=null;		
		try {
			carList=carDAO.listCarInfo(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
	}	
	//�� ���� ������ ����ϴ� �޼���
	public void regCarInfo(CarVo vo)  throws Exception{
		carDAO.regCarInfo(vo);
	}	
	// �� ������ �����ϴ� �޼���
	public void modCarInfo(CarVo vo) throws Exception{
		carDAO.modCarInfo(vo);
	
	}	
	//�� ������ �����ϴ� �޼���
	public void delCarInfo(String str) throws Exception{
		carDAO.delCarInfo(str);
	
	}
	

}
