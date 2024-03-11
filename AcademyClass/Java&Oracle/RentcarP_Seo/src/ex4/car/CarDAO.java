package ex4.car;

import java.util.ArrayList;

public interface CarDAO {
	public void regCarInfo(CarVo vo) throws Exception;
	public ArrayList<CarVo> listCarInfo(String str) throws Exception;
	public void modCarInfo(CarVo vo) throws Exception;
	public void delCarInfo(String str) throws Exception;
}
