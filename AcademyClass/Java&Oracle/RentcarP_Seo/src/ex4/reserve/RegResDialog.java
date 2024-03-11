package ex4.reserve;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ex4.car.Car;
import ex4.car.CarImpl;
import ex4.car.CarVo;
import ex4.base.Base;

public class RegResDialog extends JDialog {
	JPanel jPanel;
	JLabel lResNo, lMemId, lCarNum, lResDate, lUseBeginDate, lReturnDate, lCharge;
	JTextField tfResNo, tfMemId, tfCarNum, tfResDate, tfUseBeginDate, tfReturnDate, tfCharge;
	JButton btnReg;
	Reserve resController; 
	public RegResDialog(String str) {
		setTitle(str);
		System.out.println(123);
		init();
	}

	private void init() {
		resController = new ReserveImpl();
		Base base = new Base();
		// yyyy-mm-dd 형식에 맞추기 위한 패턴
		Pattern p = Pattern.compile("^([0-9]{4})-([0-1]{1})([0-9]{1})-([0-9]{2})$");
		
		lResNo = new JLabel("예약번호");
		lCarNum = new JLabel("차량번호");
		lMemId = new JLabel("회원아이디");
		lResDate = new JLabel("예약일");
		lUseBeginDate = new JLabel("렌트시작일 (yyyy-mm-dd)");
		lReturnDate = new JLabel("반납일 (yyyy-mm-dd)");
		lCharge = new JLabel("렌트비용");
		tfResNo = new JTextField(20);
		tfResNo.setEnabled(false);	// 사용 안함
		tfCarNum = new JTextField(20);
		tfMemId = new JTextField(20);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(20);
		tfReturnDate = new JTextField(20);
		tfCharge = new JTextField("하루 50,000원 입니다.");
		tfCharge.setEnabled(false);	// 사용 안함
		btnReg = new JButton("등록하기");
		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resNo = "";
				String carNumber = tfCarNum.getText().trim();
				String memberId = tfMemId.getText().trim();
				String resDate = tfResDate.getText().trim();
				String useBeginDate = tfUseBeginDate.getText().trim();
				String returnDate = tfReturnDate.getText().trim();
				
				// 날짜 패턴에 맞는지 확인
				Matcher m1 = p.matcher(useBeginDate);
				Matcher m2 = p.matcher(returnDate);
				
				if(m1.find() && m2.find()) {
					System.out.println("ok");
				} else {
					showMessage("날짜를 형식에 맞게 입력해주세요.\n다시 등록해 주세요.");
					return;
				}
				
				// 렌트비용 계산
				long charge = 50000;
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // mm은 분, MM이 월
				Date beginDate;
				try {
					beginDate = format.parse(useBeginDate);
					Date endDate = format.parse(returnDate);
					long diff = endDate.getTime()-beginDate.getTime();
					long diffDays = diff/(24*60*60*1000);
					System.out.println("대여일수 : " + diffDays);
					charge = diffDays*charge;
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
//				String[] startDay = useBeginDate.split("-");
//				String[] endDay = returnDate.split("-");
//				int rentYear = 0;
//				int rentMon = 0;
//				int rentDay = 0;
//				
//				rentYear = Integer.parseInt(endDay[0])-Integer.parseInt(startDay[0]);
//				rentMon = Integer.parseInt(endDay[1])-Integer.parseInt(startDay[1]);
//				rentDay = Integer.parseInt(endDay[2])-Integer.parseInt(startDay[2]);
//				if(rentYear == 0 && rentMon == 0) { // 년, 월이 같을때
//					charge = charge*rentDay;
//				} else if (rentYear == 0 && rentMon > 0 ){
//					charge = charge*(rentDay+(rentMon*30));
//				} else {
//					charge = charge*(rentDay+(30*(rentMon+(rentYear*12))));
//				}
				
				ResVo vo=new ResVo(resNo,carNumber,memberId,resDate,useBeginDate,returnDate,charge);
				try {
					resController.reserveCar(vo);
					showMessage("새 예약을  등록했습니다.");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("오류가 발생했습니다.\n다시 등록해 주세요.");
				}
			
				// dispose();
			}
		});
		jPanel = new JPanel(new GridLayout(0, 2));
		jPanel.add(lResNo);
		jPanel.add(tfResNo);
		
		jPanel.add(lCarNum);
		jPanel.add(tfCarNum);
		
		jPanel.add(lMemId);
		jPanel.add(tfMemId);
		
		jPanel.add(lResDate);
		jPanel.add(tfResDate);
		
		jPanel.add(lUseBeginDate);
		jPanel.add(tfUseBeginDate);
		
		jPanel.add(lReturnDate);
		jPanel.add(tfReturnDate);
		
		jPanel.add(lCharge);
		jPanel.add(tfCharge);
		
		add(jPanel, BorderLayout.NORTH);
		add(btnReg, BorderLayout.SOUTH);
		setLocation(400, 200);
		setSize(400, 400);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메지지 박스", JOptionPane.INFORMATION_MESSAGE);
	}
}
