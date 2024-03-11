package ex4.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ex4.base.Base;
import ex4.car.CarVo;
import ex4.common.DataUtil;
import ex4.common.exception.RentException;

public class MemberImpl extends Base implements Member{
	String memData;
	MemberDAO memDAO = new MemberDAOImpl();
	
	//���� ȸ�� ���� ��ȸ�ϴ� �޼���
	public ArrayList<MemberVo> listMember(String str) throws Exception{
		ArrayList<MemberVo> memList=null;		
		try {
			memList=memDAO.listMember(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memList;
	}
	//���ο� ȸ�� ��� �ϴ� �޼���
	public void regMember(MemberVo vo) throws Exception{
		memDAO.regMember(vo);
	}
	
	//���� ȸ�� ������ �����ϴ� �޼���
	public void modMember(MemberVo vo) throws Exception{
		memDAO.modMember(vo);
	}
	
	//���� ȸ�� ������ �����ϴ� �޼���
	public void delMember(String str) throws Exception{
		memDAO.delMember(str);
	}
}
