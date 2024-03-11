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
		// yyyy-mm-dd ���Ŀ� ���߱� ���� ����
		Pattern p = Pattern.compile("^([0-9]{4})-([0-1]{1})([0-9]{1})-([0-9]{2})$");
		
		lResNo = new JLabel("�����ȣ");
		lCarNum = new JLabel("������ȣ");
		lMemId = new JLabel("ȸ�����̵�");
		lResDate = new JLabel("������");
		lUseBeginDate = new JLabel("��Ʈ������ (yyyy-mm-dd)");
		lReturnDate = new JLabel("�ݳ��� (yyyy-mm-dd)");
		lCharge = new JLabel("��Ʈ���");
		tfResNo = new JTextField(20);
		tfResNo.setEnabled(false);	// ��� ����
		tfCarNum = new JTextField(20);
		tfMemId = new JTextField(20);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(20);
		tfReturnDate = new JTextField(20);
		tfCharge = new JTextField("�Ϸ� 50,000�� �Դϴ�.");
		tfCharge.setEnabled(false);	// ��� ����
		btnReg = new JButton("����ϱ�");
		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resNo = "";
				String carNumber = tfCarNum.getText().trim();
				String memberId = tfMemId.getText().trim();
				String resDate = tfResDate.getText().trim();
				String useBeginDate = tfUseBeginDate.getText().trim();
				String returnDate = tfReturnDate.getText().trim();
				
				// ��¥ ���Ͽ� �´��� Ȯ��
				Matcher m1 = p.matcher(useBeginDate);
				Matcher m2 = p.matcher(returnDate);
				
				if(m1.find() && m2.find()) {
					System.out.println("ok");
				} else {
					showMessage("��¥�� ���Ŀ� �°� �Է����ּ���.\n�ٽ� ����� �ּ���.");
					return;
				}
				
				// ��Ʈ��� ���
				long charge = 50000;
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // mm�� ��, MM�� ��
				Date beginDate;
				try {
					beginDate = format.parse(useBeginDate);
					Date endDate = format.parse(returnDate);
					long diff = endDate.getTime()-beginDate.getTime();
					long diffDays = diff/(24*60*60*1000);
					System.out.println("�뿩�ϼ� : " + diffDays);
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
//				if(rentYear == 0 && rentMon == 0) { // ��, ���� ������
//					charge = charge*rentDay;
//				} else if (rentYear == 0 && rentMon > 0 ){
//					charge = charge*(rentDay+(rentMon*30));
//				} else {
//					charge = charge*(rentDay+(30*(rentMon+(rentYear*12))));
//				}
				
				ResVo vo=new ResVo(resNo,carNumber,memberId,resDate,useBeginDate,returnDate,charge);
				try {
					resController.reserveCar(vo);
					showMessage("�� ������  ����߽��ϴ�.");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("������ �߻��߽��ϴ�.\n�ٽ� ����� �ּ���.");
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
		setModal(true); // �׻� �θ�â ���� ���̰� �Ѵ�.
		setVisible(true);
	}

	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "������ �ڽ�", JOptionPane.INFORMATION_MESSAGE);
	}
}
