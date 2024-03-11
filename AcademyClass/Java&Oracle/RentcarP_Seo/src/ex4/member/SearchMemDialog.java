package ex4.member;

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
import ex4.common.RentTableModel;

public class SearchMemDialog  extends JDialog{
	JPanel panelSearch,panelBtn;
	JLabel lName;
	JTextField tf ;
    JButton btnSearch ;
    JButton btnModify ;
    JButton btnDelete ;
    
    String[][] memItems ;
    JTable rentTable;
    RentTableModel model;
    MemberImpl memController;
    String[] columnNames={"아이디","비밀번호","이름","주소","전화번호"  };
    
    public SearchMemDialog(String str){
    	setTitle(str);
    	init();
    	
    }
    
    private void init(){
    	memController = new MemberImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
        
    	lName = new JLabel("회원명");
    	tf=new JTextField("	");
    	btnSearch=new JButton("조회하기");
    	 
    	btnSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<MemberVo> memList=new ArrayList<MemberVo>();
				try {
					memList=memController.listMember(tf.getText().trim());
					loadTableData(memList);
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
    	btnDelete=new JButton("삭제하기");
    	
    	panelBtn.add(btnModify);
    	panelBtn.add(btnDelete);
    	
    	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
    	
    	memItems = new String[0][5];
        model=new RentTableModel(memItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        
        setLocation(300,100);//다이얼로그 출력 위치를 정한다.
        setSize(600,600);
        setModal(true); //항상 부모창 위에 보이게 한다.
        setVisible(true);
    }
    
    private void loadTableData(ArrayList<MemberVo> memList){
    	memItems = new String[memList.size()][5];
    	for(int i=0; i<memList.size();i++){
    		MemberVo vo=memList.get(i);
    		memItems[i][0]=vo.id;
    		memItems[i][1]=vo.password;
    		memItems[i][2]=vo.name;
    		memItems[i][3]=vo.address;
    		memItems[i][4]=vo.phoneNum;
    	}
    	
    	model=new RentTableModel(memItems,columnNames);
    	rentTable.setModel(model);
    }
}
