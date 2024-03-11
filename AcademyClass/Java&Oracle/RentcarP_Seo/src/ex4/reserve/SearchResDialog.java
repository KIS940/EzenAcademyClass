package ex4.reserve;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ex4.car.CarImpl;
import ex4.car.CarVo;
import ex4.car.DelCarDialog;
import ex4.car.ModCarDialog;
import ex4.common.RentTableModel;

public class SearchResDialog  extends JDialog{
	JPanel panelSearch,panelBtn;
	JLabel lName;
	JTextField tf ;
    JButton btnSearch ;
    JButton btnModify ;
    JButton btnDelete ;
    
    String[][] resItems ;
    JTable rentTable;
    RentTableModel model;
    Reserve resController;
    String[] columnNames={"�����ȣ","������ȣ","ȸ�����̵�","������","������","�ݳ���","��Ʈ��" };
    
    public SearchResDialog(String str){
    	
    	setTitle(str);
    	init();
    	
    }
    
    private void init(){
    	resController = new ReserveImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
        
    	lName = new JLabel("�����ȣ");
    	tf=new JTextField(10);
    	btnSearch=new JButton("��ȸ�ϱ�");
    	 
    	btnSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ResVo> resList=new ArrayList<ResVo>();
				
				try {
					resList=resController.listResInfo(tf.getText().trim());
					loadTableData(resList);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    	});
    	
    	panelSearch.add(lName);
    	panelSearch.add(tf);
    	panelSearch.add(btnSearch);
    	
    	btnModify=new JButton("�����ϱ�");
     	
     	btnModify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int arrRow = rentTable.getSelectedRow();
//    			int arrCol = rentTable.getSelectedColumn();
    			
				// ������ ���� ��ȣ�� �ҷ� �ö�
    			String resNo= (String) rentTable.getValueAt(arrRow, 0);
				new ModResDialog("���� ����â",resNo);
    			
    			// ���� �� ���� �� �ҷ� �ö�
//    			String [] resArr = new String[7];
//    			for(int i=0; i<7; i++) {
//    				resArr[i] = (String) rentTable.getValueAt(arrRow, i);
//    			}
//				new ModResDialog("���� ����â", resArr);
			}
    	});    
    	btnDelete=new JButton("�����ϱ�");
    	btnDelete.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int arrRow = rentTable.getSelectedRow();
    			String resNo= (String) rentTable.getValueAt(arrRow, 0);
    			
    			new DelResDialog("��������â", resNo);
    			
    		}
    	});  
    	
    	panelBtn.add(btnModify);
    	panelBtn.add(btnDelete);
    	
    	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
    	
    	resItems = new String[0][7];
        model=new RentTableModel(resItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        
        setLocation(300,100);//���̾�α� ��� ��ġ�� ���Ѵ�.
        setSize(600,600);
        setModal(true); //�׻� �θ�â ���� ���̰� �Ѵ�.
        setVisible(true);
    }
    
    private void loadTableData(ArrayList<ResVo> resList){
    	resItems = new String[resList.size()][7];
    	for(int i=0; i<resList.size();i++){
    		ResVo vo=resList.get(i);
    		resItems[i][0]=vo.resNo;
    		resItems[i][1]=vo.carNumber;
    		resItems[i][2]=vo.memberId;
    		resItems[i][3]=vo.resDate;
    		resItems[i][4]=vo.useBeginDate;
    		resItems[i][5]=vo.returnDate;
    		resItems[i][6]=vo.charge+"";
    	}
    	
    	model=new RentTableModel(resItems,columnNames);
    	rentTable.setModel(model);
    }
}
