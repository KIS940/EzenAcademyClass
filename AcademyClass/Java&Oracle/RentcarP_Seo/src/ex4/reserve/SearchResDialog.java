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
    String[] columnNames={"예약번호","차량번호","회원아이디","예약일","시작일","반납일","렌트비" };
    
    public SearchResDialog(String str){
    	
    	setTitle(str);
    	init();
    	
    }
    
    private void init(){
    	resController = new ReserveImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
        
    	lName = new JLabel("예약번호");
    	tf=new JTextField(10);
    	btnSearch=new JButton("조회하기");
    	 
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
    	
    	btnModify=new JButton("수정하기");
     	
     	btnModify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int arrRow = rentTable.getSelectedRow();
//    			int arrCol = rentTable.getSelectedColumn();
    			
				// 선택한 예약 번호만 불러 올때
    			String resNo= (String) rentTable.getValueAt(arrRow, 0);
				new ModResDialog("예약 수정창",resNo);
    			
    			// 선택 한 라인 다 불러 올때
//    			String [] resArr = new String[7];
//    			for(int i=0; i<7; i++) {
//    				resArr[i] = (String) rentTable.getValueAt(arrRow, i);
//    			}
//				new ModResDialog("예약 수정창", resArr);
			}
    	});    
    	btnDelete=new JButton("삭제하기");
    	btnDelete.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int arrRow = rentTable.getSelectedRow();
    			String resNo= (String) rentTable.getValueAt(arrRow, 0);
    			
    			new DelResDialog("차량삭제창", resNo);
    			
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
        
        setLocation(300,100);//다이얼로그 출력 위치를 정한다.
        setSize(600,600);
        setModal(true); //항상 부모창 위에 보이게 한다.
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
