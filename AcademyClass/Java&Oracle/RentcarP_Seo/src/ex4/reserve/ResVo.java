package ex4.reserve;

public class ResVo {
	String resNo;			// �����ȣ pk
	String carNumber;	// ������ȣ fk
	String memberId;			// �� memberId fk
	
	String resDate;		// ������
	String useBeginDate;// �뿩������
	String returnDate;	// �ݳ���
	long charge;		// ����ݾ�
	
	public ResVo() {
		
	}
	public ResVo(String resNo) {
		this.resNo = resNo;
	}
	public ResVo(String resNo, String carNumber, String memberId, String resDate, 
			String useBeginDate, String returnDate, long charge) {
		this.resNo = resNo;
		this.carNumber = carNumber;
		this.memberId = memberId;
		this.resDate = resDate;
		this.useBeginDate = useBeginDate;
		this.returnDate = returnDate;
		this.charge = charge;
	}
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getUseBeginDate() {
		return useBeginDate;
	}
	public void setUseBeginDate(String useBeginDate) {
		this.useBeginDate = useBeginDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public long getCharge() {
		return charge;
	}
	public void setCharge(long charge) {
		this.charge = charge;
	}
	
}
