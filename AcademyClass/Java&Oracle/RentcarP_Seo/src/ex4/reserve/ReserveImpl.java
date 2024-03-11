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
//	String[] loadResData(int a) throws Exception{   // 예약 번호 리스트 콤보박스로 출력 -> 예약 번호에 따른 차량번호 회원번호 출력하기 추가
//    	ArrayList<ResVo> reslist = listResInfo("");
//    	String [] resItems = new String[reslist.size()];
//    	for(int i=0; i<reslist.size(); i++){
//    		ResVo vo = reslist.get(i);
//    		resItems[i] = vo.getResNo(); 
//    	}
//    	return resItems;
//	}
	
	//차를 예약하는 메서드
	public String reserveCar(ResVo vo){
		resData="예약 차번호:"+vo.carNumber+","+
	            "예약 날자:"+vo.resDate+","+
	            "이용 시작 일자"+vo.useBeginDate+","+
	            "차 반납 일자:"+vo.returnDate;
		
		DataUtil.encodeData(resData);		
		System.out.println("렌터카 예약시간:"+showTime());
		System.out.println("차를 예약합니다.");
		DataUtil.decodeData(resData);		

		try {
			resDAO.reserveCar(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resData;
	}
	
	//차 예약정보를 수정하는 메서드
	public void modResInfo(ResVo vo){
//		resData="예약 차번호:"+vo.carNumber+","+
//	            "예약 날자:"+vo.resDate+","+
//	            "이용 시작 일자"+vo.useBeginDate+","+
//	            "차 반납 일자:"+vo.returnDate;
//		DataUtil.encodeData(resData);	
		System.out.println("렌터카 예약 정보 수정 시간:"+showTime());
		try {
			resDAO.modResInfo(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//차 예약 정보를 취소하는 메서드
	public void cancelResInfo(String str){
		
		try {
			resDAO.cancelResInfo(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("렌터카 예약 정보 삭제 시간:"+showTime());
		System.out.println("차 예약 정보를 삭제합니다.");
	}


}
