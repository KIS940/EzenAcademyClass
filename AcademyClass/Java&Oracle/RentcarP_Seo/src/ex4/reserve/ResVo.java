package ex4.reserve;

public class ResVo {
	String resNo;			// 예약번호 pk
	String carNumber;	// 차량번호 fk
	String memberId;			// 고객 memberId fk
	
	String resDate;		// 예약일
	String useBeginDate;// 대여시작일
	String returnDate;	// 반납일
	long charge;		// 결재금액
	
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
