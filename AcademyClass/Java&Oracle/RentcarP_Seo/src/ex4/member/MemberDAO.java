package ex4.member;
import java.util.ArrayList;
import ex4.common.exception.RentException;

public interface MemberDAO {
	public void regMember(MemberVo vo) throws Exception; //회원 등록 메서드
	public ArrayList<MemberVo> listMember(String str) throws Exception; //정보 조회 메서드
	public void modMember(MemberVo vo) throws Exception;//기존 회원 정보를 수정하는 메서드
	public void delMember(String str) throws Exception;//기존 회원 정보를 삭제하는 메서드
}
