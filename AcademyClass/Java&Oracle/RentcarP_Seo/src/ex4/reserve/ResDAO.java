package ex4.reserve;
import java.util.ArrayList;
import ex4.common.exception.RentException;

public interface ResDAO {
	public void reserveCar(ResVo vo) throws Exception; //���� ��� �޼���
	public ArrayList<ResVo> listResInfo(String str) throws Exception; //���� ��ȸ �޼���
	public void modResInfo(ResVo vo) throws Exception;//���� ���� ������ �����ϴ� �޼���
	public void cancelResInfo(String str) throws Exception;//���� ���� ������ �����ϴ� �޼���
}
