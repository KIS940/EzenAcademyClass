package ex4.member;

import java.io.IOException;
import java.util.ArrayList;

import ex4.common.exception.RentException;

public interface Member {
	public ArrayList<MemberVo> listMember(String str) throws Exception; //ȸ�� ���� ��ȸ �޼���
	public void regMember(MemberVo vo) throws Exception; //ȸ�� ��� �޼���
	public void modMember(MemberVo vo) throws Exception;//���� ȸ�� ������ �����ϴ� �޼���
	public void delMember(String str) throws Exception;//���� ȸ�� ������ �����ϴ� �޼���

}
