package ex4.reserve;

import java.util.ArrayList;

public interface Reserve {
	public ArrayList<ResVo> listResInfo(String str) throws Exception; //정보 조회 메서드
	public String reserveCar(ResVo vo);   //차를 예약 추가하는 메서드
	public void modResInfo(ResVo vo);   //차 예약정보를 수정하는 메서드
	public void cancelResInfo(String str);  //차 예약 정보를 취소하는 메서드
}
