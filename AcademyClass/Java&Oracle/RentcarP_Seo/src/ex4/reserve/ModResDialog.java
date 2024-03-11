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
    	
    	lResNo = new JLabel("�����ȣ");
		lCarNum = new JLabel("������ȣ");
		lMemId = new JLabel("ȸ�����̵�");
		lResDate = new JLabel("������");
		lUseBeginDate = new JLabel("��Ʈ������ (yyyy-mm-dd)");
		lReturnDate = new JLabel("�ݳ��� (yyyy-mm-dd)");
		lCharge = new JLabel("��Ʈ���");
		tfResNo = new JTextField(rN);
		tfCarNum = new JTextField(20);
		tfMemId = new JTextField(20);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(20);
		tfReturnDate = new JTextField(20);
		tfCharge = new JTextField(20);
		
		// �����ȣ�� �޺��ڽ�
		String[] data = resController.listResInfo("", 0);
		jC = new JComboBox<String>(data);
		
    	btnMod=new JButton("�����ϱ�");    	
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
				
				// ��¥���� ���ϰ˻�
				Matcher m1 = p.matcher(useBeginDate);
				Matcher m2 = p.matcher(returnDate);
				
				if(m1.find() && m2.find()) {
					System.out.println("ok");
				} else {
					showMessage("��¥�� ���Ŀ� �°� �Է����ּ���.\n�ٽ� ����� �ּ���.");
					return;
				}
				long charge = Long.parseLong(tfCharge.getText().trim());
				ResVo vo=new ResVo(resNo,carNumber,memberId,resDate,useBeginDate,returnDate,charge);
				try {
					resController.modResInfo(vo);
					showMessage("���ฦ  �����߽��ϴ�.");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					tfCharge.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("������ �߻��߽��ϴ�.\n�ٽ� ����� �ּ���.");
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
        setModal(true); //�׻� �θ�â ���� ���̰� �Ѵ�.
        setVisible(true);
    }    

	private void init(String[] rN) throws Exception {
		resController = new ReserveImpl();
		Base base = new Base();
		Pattern p = Pattern.compile("^([0-9]{4})-([0-1]{1})([0-9]{1})-([0-9]{2})$");

		lResNo = new JLabel("�����ȣ");
		lCarNum = new JLabel("������ȣ");
		lMemId = new JLabel("ȸ�����̵�");
		lResDate = new JLabel("������");
		lUseBeginDate = new JLabel("��Ʈ������ (yyyy-mm-dd)");
		lReturnDate = new JLabel("�ݳ��� (yyyy-mm-dd)");
		lCharge = new JLabel("��Ʈ���");
		tfResNo = new JTextField(rN[0]);
		tfResNo.setEnabled(false);
		tfCarNum = new JTextField(rN[1]);
		tfMemId = new JTextField(rN[2]);
		tfResDate = new JTextField(base.showTime());
		tfResDate.setEnabled(false);
		tfUseBeginDate = new JTextField(rN[4]);
		tfReturnDate = new JTextField(rN[5]);
		tfCharge = new JTextField(rN[6]);

		btnMod = new JButton("�����ϱ�");
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
					showMessage("��¥�� ���Ŀ� �°� �Է����ּ���.\n�ٽ� ����� �ּ���.");
					return;
				}
				long charge = Long.parseLong(tfCharge.getText().trim());
				ResVo vo = new ResVo(resNo, carNumber, memberId, resDate, useBeginDate, returnDate, charge);
				try {
					resController.modResInfo(vo);
					showMessage("���ฦ  �����߽��ϴ�.");
					tfResNo.setText("");
					tfCarNum.setText("");
					tfMemId.setText("");
					tfResDate.setText("");
					tfUseBeginDate.setText("");
					tfReturnDate.setText("");
					tfCharge.setText("");

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
		add(btnMod, BorderLayout.SOUTH);

		setLocation(400, 200);
		setSize(400, 400);
		setModal(true); // �׻� �θ�â ���� ���̰� �Ѵ�.
		setVisible(true);
	}    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"������ �ڽ�",
               JOptionPane.INFORMATION_MESSAGE);
    }
    
}
