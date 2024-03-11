package ex4.reserve;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class ResDAOImpl implements ResDAO {
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //����� DB���� ���� �����͸� �����Ѵ�.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String url ="jdbc:oracle:thin:@192.168.0.151:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	private Connection con; 
    private	Statement stmt;
    private ResultSet rs;

	
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

	@Override
	public void reserveCar(ResVo vo) throws Exception {
		String carNumber;	
		String memberId;		
		
		String resDate;		
		String useBeginDate;
		String returnDate;
		long charge;
		
		carNumber=vo.getCarNumber();
		memberId=vo.getMemberId();
		resDate=vo.getResDate();
		useBeginDate=vo.getUseBeginDate();
		returnDate=vo.getReturnDate();
		charge=vo.getCharge();

		connDB();  //DB�� �����ϴ� �޼��� 
		String query = "INSERT INTO Rent_Res(resNo,carNumber,memberId,resDate,useBeginDate,returnDate,charge)"
				+ " VALUES ( CONCAT('RES',LPAD(resNoplus.NEXTVAL,6,'0')),'" +
				carNumber+"','"+
				memberId+"','" +
				resDate+"','" +
				useBeginDate+"','" +
				returnDate+"'," +
				charge+")";
		System.out.println(query) ;	 

		try {
			stmt.executeUpdate( query );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

	}

	@Override
	public ArrayList<ResVo> listResInfo(String str) throws Exception {
		ArrayList<ResVo> resList=new ArrayList<ResVo>();
		connDB();  //DB�� �����ϴ� �޼��� 
		String query = "";
		if(str.equals("") || str == null) {
			query = "select * from Rent_Res ";
		} else {
			query = "select * from Rent_Res where carNumber like '%" + str +"%'";
		}
		System.out.println(query);
		rs = stmt.executeQuery(query);	//������ ������ �� ���ϵǴ� ���ڵ� ���� rs�� �����Ѵ�.		 
	 while( rs.next()){				        		//rs�� ���ڵ���� ������ �Ҵ��Ѵ�.
			 String resNo=rs.getString("resNo");						 
			 String carNumber = rs.getString("carNumber");
			 String memberId = rs.getString("memberId");					 
			 String resDate = rs.getString("resDate");
			 // �ú��� ����
			 String[] ud = resDate.split(" ");
			 resDate = ud[0];
			 
			 String useBeginDate=rs.getString("useBeginDate");
			 ud = useBeginDate.split(" ");
			 useBeginDate = ud[0];
			 String returnDate=rs.getString("returnDate");
			 ud = returnDate.split(" ");
			 returnDate = ud[0];
			 
			 Long charge=rs.getLong("charge");
			 ResVo Data= new ResVo();    
			 Data.setResNo(resNo);
			 Data.setCarNumber(carNumber);
			 Data.setMemberId(memberId);
			 Data.setResDate(resDate);
			 Data.setUseBeginDate(useBeginDate);
			 Data.setReturnDate(returnDate);
			 Data.setCharge(charge);
			 resList.add(Data);					
		}  
		rs.close();
		stmt.close();
		con.close();
		return resList;
	}

	@Override
	public void modResInfo(ResVo vo) throws Exception {
		String resNo;
		String carNumber;	
		String memberId;		
		
		String resDate;		
		String useBeginDate;
		String returnDate;
		long charge;
		
		resNo=vo.getResNo();
		carNumber=vo.getCarNumber();
		memberId=vo.getMemberId();
		resDate=vo.getResDate();
		useBeginDate=vo.getUseBeginDate();
		returnDate=vo.getReturnDate();
		charge=vo.getCharge();   	
    	connDB();  //DB�� �����ϴ� �޼��� 
    	PreparedStatement pstmt = con.prepareStatement("UPDATE Rent_Res SET "
    			+ "resNo=?,carNumber=?,memberId=?,"
    			+ "resDate=TO_DATE(?,'yyyy-mm-dd'),useBeginDate=TO_DATE(?,'yyyy-mm-dd'),"
    			+ "returnDate=TO_DATE(?,'yyyy-mm-dd'),charge=? "
    			+ " where resNo like ?"); 
    	pstmt.setString(1,resNo); 
        pstmt.setString(2,carNumber); 
        pstmt.setString(3,memberId); 
        pstmt.setString(4,resDate); 
        pstmt.setString(5,useBeginDate); 
        pstmt.setString(6,returnDate); 
        pstmt.setLong(7,charge); 
        pstmt.setString(8,resNo); 
		pstmt.executeUpdate();
		
	}

	@Override
	public void cancelResInfo(String str) throws Exception {
		String resNo = str;
		connDB();
		PreparedStatement pstmt = con.prepareStatement("DELETE from Rent_Res "
    			+ "where resNo like ?"); 
    	pstmt.setString(1,resNo); 
    	pstmt.executeUpdate();  
		
	}	

}
