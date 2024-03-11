package ex4.reserve;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ex4.base.Base;
import ex4.car.CarVo;
import ex4.common.RentTableModel;
public class ModResDialog  extends JDialog{
	JPanel jPanel;
	JLabel lResNo, lMemId, lCarNum, lResDate, lUseBeginDate, lReturnDate, lCharge;
	JTextField tfResNo, tfMemId, tfCarNum, tfResDate, tfUseBeginDate, tfReturnDate, tfCharge;
    JButton btnMod;    
    
    JComboBox<String> jC;
    ReserveImpl resController;    
    RentTableModel model;
  
    public ModResDialog(String str, String resNo){
    	model = new RentTableModel();
    	setTitle(str);
    	try {
			init(resNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
    public ModResDialog(String str, String[] resArr){
    	setTitle(str);
    	try {
			init(resArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
    
    private void init(String rN) throws Exception{
    	resController=new ReserveImpl();
    	Base base = new Base();
    	Pattern p = Pattern.compile("^([0-9]{4})-([0-1]{1})([0-9]{1})-([0-9]{2})$");
    	
    	lResNo = new JLabel("예약번호");
		lCarNum = new JLabel("차량번호");
		lMemId = new JLabel("회원아이디");
		lResDate = new JLabel("수정일");
		lUseBeginDate = new JLabel("렌트시작일 (yyyy-mm-dd)");
		lReturnDate = new JLabel("반납일 (yyyy-mm-dd)");
		lCharge = new JLabel("렌트비용");
		tfResNo = new JTextField(rN);
		tfCarNum = new JTextField(20);
		tfMemId = new JTextField(20);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(20);
		tfReturnDate = new JTextField(20);
		tfCharge = new JTextField(20);
		
		// 예약번호에 콤보박스
		String[] data = resController.listResInfo("", 0);
		jC = new JComboBox<String>(data);
		
    	btnMod=new JButton("수정하기");    	
    	btnMod.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String resNo = "";
				if(rN.equals("") || rN.equals(null)) {
		    		resNo = (String)jC.getSelectedItem();
				}else {
					resNo = tfResNo.getText().trim();
				}
				String carNumber = tfCarNum.getText().trim();
				String memberId = tfMemId.getText().trim();
				String resDate = tfResDate.getText().trim();
				String useBeginDate = tfUseBeginDate.getText().trim();
				String returnDate = tfReturnDate.getText().trim();
				
				// 날짜형식 패턴검사
				Matcher m1 = p.matcher(useBeginDate);
				Matcher m2 = p.matcher(returnDate);
				
				if(m1.find() && m2.find()) {
					System.out.println("ok");
				} else {
					showMessage("날짜를 형식에 맞게 입력해주세요.\n다시 등록해 주세요.");
					return;
				}
				long charge = Long.parseLong(tfCharge.getText().trim());
				ResVo vo=new ResVo(resNo,carNumber,memberId,resDate,useBeginDate,returnDate,charge);
				try {
					resController.modResInfo(vo);
					showMessage("예약를  수정했습니다.");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					tfCharge.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("오류가 발생했습니다.\n다시 등록해 주세요.");
				}				
				//dispose();				
			}
        });    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	jPanel.add(lResNo);
    	if(rN.equals("") || rN.equals(null)) {
    		jPanel.add(jC);
		}else {
			jPanel.add(tfResNo);
		}
		
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
		
    	add(jPanel,BorderLayout.NORTH);
    	add(btnMod,BorderLayout.SOUTH);
    	
        setLocation(400, 200);
        setSize(400,400);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
    }    

	private void init(String[] rN) throws Exception {
		resController = new ReserveImpl();
		Base base = new Base();
		Pattern p = Pattern.compile("^([0-9]{4})-([0-1]{1})([0-9]{1})-([0-9]{2})$");

		lResNo = new JLabel("예약번호");
		lCarNum = new JLabel("차량번호");
		lMemId = new JLabel("회원아이디");
		lResDate = new JLabel("수정일");
		lUseBeginDate = new JLabel("렌트시작일 (yyyy-mm-dd)");
		lReturnDate = new JLabel("반납일 (yyyy-mm-dd)");
		lCharge = new JLabel("렌트비용");
		tfResNo = new JTextField(rN[0]);
		tfResNo.setEnabled(false);
		tfCarNum = new JTextField(rN[1]);
		tfMemId = new JTextField(rN[2]);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(rN[4]);
		tfReturnDate = new JTextField(rN[5]);
		tfCharge = new JTextField(rN[6]);

		btnMod = new JButton("수정하기");
		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String resNo = tfResNo.getText().trim();
				String carNumber = tfCarNum.getText().trim();
				String memberId = tfMemId.getText().trim();
				String resDate = tfResDate.getText().trim();
				String useBeginDate = tfUseBeginDate.getText().trim();
				String returnDate = tfReturnDate.getText().trim();
				
				//
				Matcher m1 = p.matcher(useBeginDate);
				Matcher m2 = p.matcher(returnDate);

				if (m1.find() && m2.find()) {
					System.out.println("ok");
				} else {
					showMessage("날짜를 형식에 맞게 입력해주세요.\n다시 등록해 주세요.");
					return;
				}
				long charge = Long.parseLong(tfCharge.getText().trim());
				ResVo vo = new ResVo(resNo, carNumber, memberId, resDate, useBeginDate, returnDate, charge);
				try {
					resController.modResInfo(vo);
					showMessage("예약를  수정했습니다.");
					tfResNo.setText("");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfResDate.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					tfCharge.setText("");

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
		add(btnMod, BorderLayout.SOUTH);

		setLocation(400, 200);
		setSize(400, 400);
		setModal(true); // 항상 부모창 위에 보이게 한다.
		setVisible(true);
	}    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"메지지 박스",
               JOptionPane.INFORMATION_MESSAGE);
    }
    
}
