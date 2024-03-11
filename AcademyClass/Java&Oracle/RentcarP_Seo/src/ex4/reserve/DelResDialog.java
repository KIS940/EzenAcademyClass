package ex4.reserve;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class DelResDialog  extends JDialog{
	JPanel jPanel;
	JLabel lResNo;
	JTextField tfResNo;
    JButton btnDel;    
    Reserve resController;
    
    public DelResDialog(String str, String resNo){
    	setTitle(str);
    	init(resNo);
    }    
    private void init(String resNo){
    	resController=new ReserveImpl();
    	lResNo = new JLabel("�����ȣ");
    	tfResNo=new JTextField(resNo);
    	btnDel=new JButton("�����ϱ�");    	
    	btnDel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String rN=tfResNo.getText().trim();
				try {
					resController.cancelResInfo(rN);
					showMessage("������ �����߽��ϴ�.");
					tfResNo.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("������ �߻��߽��ϴ�.\n�ٽ� ����� �ּ���.");
				}				
				//dispose();				
			}
        });    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lResNo);
    	jPanel.add(tfResNo);
    	
    	add(jPanel,BorderLayout.NORTH);
    	add(btnDel,BorderLayout.SOUTH);
    	
        setLocation(400, 200);
        setSize(400,400);
        setModal(true); //�׻� �θ�â ���� ���̰� �Ѵ�.
        setVisible(true);
    }    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"������ �ڽ�",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
