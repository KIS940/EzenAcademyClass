package ex4.reserve;

import java.util.ArrayList;

public interface Reserve {
	public ArrayList<ResVo> listResInfo(String str) throws Exception; //���� ��ȸ �޼���
	public String reserveCar(ResVo vo);   //���� ���� �߰��ϴ� �޼���
	public void modResInfo(ResVo vo);   //�� ���������� �����ϴ� �޼���
	public void cancelResInfo(String str);  //�� ���� ������ ����ϴ� �޼���
}
