package ex4.member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class MemberDAOImpl implements MemberDAO {
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String url ="jdbc:oracle:thin:@192.168.0.151:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	private Connection con; 
    private	Statement stmt;
    private ResultSet rs;
    
	public void regMember(MemberVo vo) throws Exception {
		String id;
		String password;
		String name;
		String address;
		String phoneNum;		
		id=vo.getId();
		password=vo.getPassword();
		name=vo.getName();
		address=vo.getAddress();
		phoneNum=vo.getPhoneNum();    	
    		connDB();  //DB�� �����ϴ� �޼��� 
			String query = "INSERT INTO Rent_Member(id,password,name,address,phoneNum) VALUES ('"
									+id+"','"+
					                password+"','"+
					                name+"','" +
					                address+"','" +
					                phoneNum+"')";
			System.out.println(query) ;	 
			
			try {
				stmt.executeUpdate( query );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	
	}

	public ArrayList<MemberVo> listMember(String str) throws Exception {
		ArrayList<MemberVo> memList=new ArrayList<MemberVo>();
		connDB();  //DB�� �����ϴ� �޼��� 
		String query = "";
		if(str.equals("") || str == null) {
			query = "select * from Rent_Member ";
		} else {
			query = "select * from Rent_Member where name like '%" + str +"%'";
		}
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);	//������ ������ �� ���ϵǴ� ���ڵ� ���� rs�� �����Ѵ�.		 
	 while( rs.next()){				        //rs�� ���ڵ���� ������ �Ҵ��Ѵ�.
			 String memID=rs.getString("id");						 
			 String memPass = rs.getString("password");
			 String memName = rs.getString("name");					 
			 String memAdd = rs.getString("address");
			 String memPhone=rs.getString("phoneNum");
			 MemberVo memData= new MemberVo();    
			 memData.setId(memID);
			 memData.setPassword(memPass);
			 memData.setName(memName);
			 memData.setAddress(memAdd);
			 memData.setPhoneNum(memPhone);
			 memList.add(memData);					
		}  
		rs.close();
		stmt.close();
		con.close();
		return memList;
	}

	public void modMember(MemberVo vo) throws Exception {
		String id;
		String password;
		String name;
		String address;
		String phoneNum;		
    	id=vo.getId();
    	password=vo.getPassword();
    	name=vo.getName();
    	address=vo.getAddress();
    	phoneNum=vo.getPhoneNum();    	
    	connDB();  //DB�� �����ϴ� �޼��� 
    	PreparedStatement pstmt = con.prepareStatement("UPDATE Rent_Member SET "
    			+ "id=?,password=?,name=?,address=?,phoneNum=? where id like ?"); 
    	pstmt.setString(1,id); 
        pstmt.setString(2,password); 
        pstmt.setString(3,name); 
        pstmt.setString(4,address); 
        pstmt.setString(5,phoneNum); 
        pstmt.setString(6,id); 
		pstmt.executeUpdate();
	}

	public void delMember(String str) throws Exception {
		String name = str;
		connDB();
		PreparedStatement pstmt = con.prepareStatement("DELETE from Rent_Member "
    			+ "where name like ?"); 
    	pstmt.setString(1,name); 
    	pstmt.executeUpdate();  
	}
	
	public void connDB(){
		try{
			Class.forName(driver);  
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt = con.createStatement();
			System.out.println("Statement ���� ����");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}	

}
