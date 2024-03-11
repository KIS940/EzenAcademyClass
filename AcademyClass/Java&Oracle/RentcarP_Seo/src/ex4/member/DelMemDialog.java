package ex4.member;

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
public class DelMemDialog  extends JDialog{
	JPanel jPanel;
	JLabel lName;
	JTextField tfName;
    JButton btnDel;    
    Member memController;    
    public DelMemDialog(String str){
    	setTitle(str);
    	init();
    }    
    private void init(){
    	memController=new MemberImpl();
    	lName = new JLabel("회원명");
    	tfName=new JTextField(20);
    	btnDel=new JButton("삭제하기");    	
    	btnDel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String Name=tfName.getText().trim();
				try {
					memController.delMember(Name);
					showMessage("회원 정보를 삭제했습니다.");
					tfName.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("오류가 발생했습니다.\n다시 등록해 주세요.");
				}				
				//dispose();				
			}
        });    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lName);
    	jPanel.add(tfName);
    	
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
