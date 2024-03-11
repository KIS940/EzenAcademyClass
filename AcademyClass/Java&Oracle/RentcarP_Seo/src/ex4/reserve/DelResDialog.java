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
    	lResNo = new JLabel("예약번호");
    	tfResNo=new JTextField(resNo);
    	btnDel=new JButton("삭제하기");    	
    	btnDel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String rN=tfResNo.getText().trim();
				try {
					resController.cancelResInfo(rN);
					showMessage("예약을 삭제했습니다.");
					tfResNo.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("오류가 발생했습니다.\n다시 등록해 주세요.");
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
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
    }    
    private void showMessage(String msg){
    	JOptionPane.showMessageDialog(this,
    			msg, 
    			"메지지 박스",
               JOptionPane.INFORMATION_MESSAGE);
    }
}
