package ex4.reserve;
import java.util.ArrayList;
import ex4.common.exception.RentException;

public interface ResDAO {
	public void reserveCar(ResVo vo) throws Exception; //예약 등록 메서드
	public ArrayList<ResVo> listResInfo(String str) throws Exception; //정보 조회 메서드
	public void modResInfo(ResVo vo) throws Exception;//기존 예약 정보를 수정하는 메서드
	public void cancelResInfo(String str) throws Exception;//기존 예약 정보를 삭제하는 메서드
}
