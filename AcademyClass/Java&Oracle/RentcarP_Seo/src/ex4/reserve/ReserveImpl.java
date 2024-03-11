package ex4.reserve;

import java.util.ArrayList;

import ex4.base.Base;
import ex4.common.DataUtil;

public class ReserveImpl extends Base implements Reserve{
	String resData;
	ResDAO resDAO = new ResDAOImpl();
	
	public ArrayList<ResVo> listResInfo(String str) throws Exception{
		ArrayList<ResVo> resList = null;		
		try {
			resList=resDAO.listResInfo(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resList;
	}
	public String[] listResInfo(String str, int a) throws Exception{
		ArrayList<ResVo> resList = null;
		String [] resItems = null;
		if(a == 0) {
			resList=listResInfo(str);
			resItems = new String[resList.size()];
			for(int i=0; i<resList.size(); i++){
				ResVo vo = resList.get(i);
				resItems[i] = vo.getResNo(); 
			}
		}
		return resItems;
	}
//	String[] loadResData(int a) throws Exception{   // ���� ��ȣ ����Ʈ �޺��ڽ��� ��� -> ���� ��ȣ�� ���� ������ȣ ȸ����ȣ ����ϱ� �߰�
//    	ArrayList<ResVo> reslist = listResInfo("");
//    	String [] resItems = new String[reslist.size()];
//    	for(int i=0; i<reslist.size(); i++){
//    		ResVo vo = reslist.get(i);
//    		resItems[i] = vo.getResNo(); 
//    	}
//    	return resItems;
//	}
	
	//���� �����ϴ� �޼���
	public String reserveCar(ResVo vo){
		resData="���� ����ȣ:"+vo.carNumber+","+
	            "���� ����:"+vo.resDate+","+
	            "�̿� ���� ����"+vo.useBeginDate+","+
	            "�� �ݳ� ����:"+vo.returnDate;
		
		DataUtil.encodeData(resData);		
		System.out.println("����ī ����ð�:"+showTime());
		System.out.println("���� �����մϴ�.");
		DataUtil.decodeData(resData);		

		try {
			resDAO.reserveCar(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resData;
	}
	
	//�� ���������� �����ϴ� �޼���
	public void modResInfo(ResVo vo){
//		resData="���� ����ȣ:"+vo.carNumber+","+
//	            "���� ����:"+vo.resDate+","+
//	            "�̿� ���� ����"+vo.useBeginDate+","+
//	            "�� �ݳ� ����:"+vo.returnDate;
//		DataUtil.encodeData(resData);	
		System.out.println("����ī ���� ���� ���� �ð�:"+showTime());
		try {
			resDAO.modResInfo(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�� ���� ������ ����ϴ� �޼���
	public void cancelResInfo(String str){
		
		try {
			resDAO.cancelResInfo(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����ī ���� ���� ���� �ð�:"+showTime());
		System.out.println("�� ���� ������ �����մϴ�.");
	}


}
