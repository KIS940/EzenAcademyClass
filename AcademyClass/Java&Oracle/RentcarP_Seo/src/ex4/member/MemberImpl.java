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
	
	//기존 회원 정보 조회하는 메서드
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
	//새로운 회원 등록 하는 메서드
	public void regMember(MemberVo vo) throws Exception{
		memDAO.regMember(vo);
	}
	
	//기존 회원 정보를 수정하는 메서드
	public void modMember(MemberVo vo) throws Exception{
		memDAO.modMember(vo);
	}
	
	//기존 회원 정보를 삭제하는 메서드
	public void delMember(String str) throws Exception{
		memDAO.delMember(str);
	}
}
