package ex4.car;

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
public class DelCarDialog  extends JDialog{
	JPanel jPanel;
	JLabel lCarName;
	JTextField tfCarName;
    JButton btnDel;    
    Car carController;    
//    public DelCarDialog(String str){
//    	setTitle(str);
//    	init();
//    }    
    public DelCarDialog(String str, String carName){
    	setTitle(str);
    	init(carName);
    }    
    private void init(String carName){
    	carController=new CarImpl();
    	lCarName = new JLabel("������");
    	tfCarName=new JTextField(carName);
    	btnDel=new JButton("�����ϱ�");    	
    	btnDel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String carName=tfCarName.getText().trim();
				try {
					carController.delCarInfo(carName);
					showMessage("������ �����߽��ϴ�.");
					tfCarName.setText("");
					
				} catch (Exception e1) {
					e1.printStackTrace();
					showMessage("������ �߻��߽��ϴ�.\n�ٽ� ����� �ּ���.");
				}				
				//dispose();				
			}
        });    	
    	jPanel=new JPanel(new GridLayout(0,2));
    	
    	jPanel.add(lCarName);
    	jPanel.add(tfCarName);
    	
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
