package ex4.car;

import java.util.ArrayList;

public interface Car {
	public ArrayList<CarVo> listCarInfo(String str) throws Exception;//차의 정보를 조회하는 메서드
	public void regCarInfo(CarVo vo) throws Exception;  //새 차의 정보를 등록하는 메서드
	public void modCarInfo(CarVo vo) throws Exception;// 차 정보를 수정하는 메서드
	public void delCarInfo(String str) throws Exception;//차 정보를 삭제하는 메서드
}
