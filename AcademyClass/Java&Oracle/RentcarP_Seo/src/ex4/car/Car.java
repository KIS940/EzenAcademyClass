package ex4.car;

import java.util.ArrayList;

public interface Car {
	public ArrayList<CarVo> listCarInfo(String str) throws Exception;//���� ������ ��ȸ�ϴ� �޼���
	public void regCarInfo(CarVo vo) throws Exception;  //�� ���� ������ ����ϴ� �޼���
	public void modCarInfo(CarVo vo) throws Exception;// �� ������ �����ϴ� �޼���
	public void delCarInfo(String str) throws Exception;//�� ������ �����ϴ� �޼���
}
