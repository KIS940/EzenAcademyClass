package ex4.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ex4.car.CarImpl;
import ex4.car.CarVo;
import ex4.car.DelCarDialog;
import ex4.car.ModCarDialog;
import ex4.car.RegCarDialog;
import ex4.car.SearchCarDialog;
import ex4.common.RentTableModel;
import ex4.member.DelMemDialog;
import ex4.member.Member;
import ex4.member.MemberImpl;
import ex4.member.MemberVo;
import ex4.member.ModMemDialog;
import ex4.member.RegMemDialog;
import ex4.member.SearchMemDialog;
import ex4.reserve.DelResDialog;
import ex4.reserve.ModResDialog;
import ex4.reserve.RegResDialog;
import ex4.reserve.SearchResDialog;


public class RentMainWindow extends JFrame  {
	JPanel panelSearch;
	JFrame f;
	JMenuBar menuBar;
	JMenu carMenu, memberMenu, rentMenu,helpMenu; //메인 메뉴 항목
	//서브 메뉴 항목
		 JMenuItem carMenu11, carMenu12, carMenu13, carMenu14;
		 JMenuItem memMenu21, memMenu22, memMenu23, memMenu24;
		 JMenuItem rentMenu31, rentMenu32, rentMenu33, rentMenu34;
		 JMenuItem helpMenu41;
	JPanel jPanel1, jPanel2, jPanel3 ;
	JLabel lCarName;
	JLabel lMemName;
	JLabel label;
	JTextField tf1, tf2;
    JButton searchCarBtn;
    JButton searchMemBtn;
    
    RentTableModel model;
    String[][] carItems;
    String[][] memItems;
    JTable rentCarTable;
    JTable rentMemTable;
    String[] carColumnNames={"차번호","차이름","배기량","차색상","차제조사"};
    String[] memColumnNames={"아이디","비번","이름","주소","폰번호"};
    CarImpl carController;
    MemberImpl memController;
   
	public RentMainWindow(){
		f = new JFrame("렌트카 예약 시스템");
		menuBar = new JMenuBar(); //메인 메뉴  항목 객체 생성
		carMenu = new JMenu("차량 관리");
		memberMenu = new JMenu("회원관리");
		rentMenu = new JMenu("예약관리");
		helpMenu = new JMenu("도움말");
		panelSearch=new JPanel();
		rentCarTable=new JTable();
		rentMemTable=new JTable();
		
		// 전체 차량 정보 출력
		ArrayList<CarVo> carList=new ArrayList<CarVo>();
		carController =new CarImpl();
		try {
			carList=carController.listCarInfo("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadCarData(carList);
		
		// 전체 회원 정보 출력
		ArrayList<MemberVo> memList=new ArrayList<MemberVo>();
		memController =new MemberImpl();
		try {
			memList=memController.listMember("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadMemData(memList);
	}
	private void loadCarData(ArrayList<CarVo> carList){
    	carItems = new String[carList.size()][5];
    	for(int i=0; i<carList.size();i++){
    		CarVo vo=carList.get(i);
    		carItems[i][0]=vo.getCarNumber();
    		carItems[i][1]=vo.getCarName();
    		carItems[i][2]=Integer.toString(vo.getCarSize());
    		carItems[i][3]=vo.getCarColor();
    		carItems[i][4]=vo.getCarMaker();
    	}
    	
    	model=new RentTableModel(carItems,carColumnNames);
    	rentCarTable.setModel(model);
	}    
	private void loadMemData(ArrayList<MemberVo> memList){
		memItems = new String[memList.size()][5];
		for(int i=0; i<memList.size();i++){
			MemberVo vo=memList.get(i);
			memItems[i][0]=vo.getId();
			memItems[i][1]=vo.getPassword();
			memItems[i][2]=vo.getName();
			memItems[i][3]=vo.getAddress();
			memItems[i][4]=vo.getPhoneNum();
		}
		
		model=new RentTableModel(memItems,memColumnNames);
		rentMemTable.setModel(model);
	}    

	// 서브메뉴 생성 메소드
		protected void startFrame() { 
		  f.setJMenuBar(menuBar); //Frame에 메뉴바를 단다.
		  menuBar.add(carMenu); //메뉴바에 "파일"항목을 단다.
		  //파일 메뉴 관련 서브 메뉴 항목
		  carMenu.add(carMenu11 = new JMenuItem("챠량등록"));
		  carMenu.add(carMenu12 = new JMenuItem("차량조회"));
		  carMenu.addSeparator(); //분리선 설정하기
		  carMenu.add(carMenu13 = new JMenuItem("차량수정"));
		  carMenu.add(carMenu14 = new JMenuItem("차량삭제"));
		 
		  menuBar.add(memberMenu); //메뉴바에 "회원관리"항목을 단다.
		  //회원 관리 메뉴 관련 서브 메뉴 항목
		  memberMenu.add(memMenu21=new JMenuItem("회원등록"));
		  memberMenu.add(memMenu22=new JMenuItem("회원조회"));
		  memberMenu.addSeparator(); //분리선 설정하기
		  memberMenu.add(memMenu23=new JMenuItem("회원수정"));
		  memberMenu.add(memMenu24=new JMenuItem("회원삭제"));
		  
		  menuBar.add(rentMenu); //메뉴바에 "예약관리"항목을 단다.
		  //회원 관리 메뉴 관련 서브 메뉴 항목
		  rentMenu.add(rentMenu31=new JMenuItem("예약등록"));
		  rentMenu.add(rentMenu32=new JMenuItem("예약조회"));
		  rentMenu.addSeparator(); //분리선 설정하기
		  rentMenu.add(rentMenu33=new JMenuItem("예약수정"));
		  rentMenu.add(rentMenu34=new JMenuItem("예약삭제"));
		 
		  
		  menuBar.add(helpMenu);
		  helpMenu.add(helpMenu41 = new JMenuItem("버전"));
		  
		 jPanel1=new JPanel();
		 jPanel2=new JPanel();
		 jPanel3=new JPanel();
		 
		 lCarName=new JLabel("차이름");
		 tf1 = new JTextField(10);
		 searchCarBtn = new JButton("차량 조회");
		 searchCarBtn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<CarVo> carList=new ArrayList<CarVo>();
					try {
						carList=carController.listCarInfo(tf1.getText().trim());
						loadCarData(carList);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
	     });    
		 lMemName=new JLabel("회원명");
		 tf2 = new JTextField(10);
		 searchMemBtn = new JButton("회원 조회");
		 searchMemBtn.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ArrayList<MemberVo> memList=new ArrayList<MemberVo>();
				 try {
					 memList=memController.listMember(tf2.getText().trim());
					 loadMemData(memList);
				 } catch (Exception e1) {
					 e1.printStackTrace();
				 }
			 }
		 });
		 
		 panelSearch.add(lCarName);
		 panelSearch.add(tf1);
		 panelSearch.add(searchCarBtn);
		 
		 label = new JLabel("                              ||                             ");
		 panelSearch.add(label);
		 
		 panelSearch.add(lMemName);
		 panelSearch.add(tf2);
		 panelSearch.add(searchMemBtn);
		 
		 jPanel1.add(panelSearch);
		 
		 JScrollPane jsp1 = new JScrollPane(rentCarTable, 
			        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 JScrollPane jsp2 = new JScrollPane(rentMemTable, 
				 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 
		 jPanel2.add(jsp1);
		 jPanel3.add(jsp2);
		 
		 Container con=f.getContentPane(); //contentPane 을 가지고 올 때 사용하는 메소드
		 con.add(jPanel1,"North");
		 con.add(jPanel2,"West");
		 con.add(jPanel3,"East");
		 pack();
		 
		  f.setLocation(250, 10);
		  f.setSize(980, 550);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		  //메뉴 항목 선택 이벤트와 이벤트 리스너를 연결한다.
		  carMenu11.addActionListener(new CarHandler());
		  carMenu12.addActionListener(new CarHandler());
		  carMenu13.addActionListener(new CarHandler());
		  carMenu14.addActionListener(new CarHandler());
		  
		  memMenu21.addActionListener(new MemberHandler());
		  memMenu22.addActionListener(new MemberHandler());
		  memMenu23.addActionListener(new MemberHandler());
		  memMenu24.addActionListener(new MemberHandler());
		  
		  rentMenu31.addActionListener(new ReserveHandler());
		  rentMenu32.addActionListener(new ReserveHandler());
		  rentMenu33.addActionListener(new ReserveHandler());
		  rentMenu34.addActionListener(new ReserveHandler());
		  
		  helpMenu41.addActionListener(new HelpHandler());
	}

	private class CarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==carMenu11){
				new RegCarDialog("차량등록창");
			}else if(e.getSource()==carMenu12){
				new SearchCarDialog("차량조회창");
			}else if(e.getSource()==carMenu13){
				new ModCarDialog("차량수정창","");
			}else if(e.getSource()==carMenu14){
				new DelCarDialog("차량삭제창","");
			}
		}
	}
	
	private class MemberHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==memMenu21){
				new RegMemDialog("회원 등록창");
			}else if(e.getSource()==memMenu22){
				new SearchMemDialog("회원 조회창");
			}else if(e.getSource()==memMenu23){
				new ModMemDialog("회원 수정창");
			}else if(e.getSource()==memMenu24){
				new DelMemDialog("회원 삭제창");
			}
		}
	}
	
	private class ReserveHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if(e.getSource()==rentMenu31){
				new RegResDialog("예약 등록창");
			}else if(e.getSource()==rentMenu32){
				new SearchResDialog("예약 조회창");
			}else if(e.getSource()==rentMenu33){
				String[] arr = new String[7];
//				new ModResDialog("예약 수정창", arr);
				new ModResDialog("예약 수정창", "");
			}else if(e.getSource()==rentMenu34){
				new DelResDialog("예약 취소창", "");
			}
		}
	}
	
	private class HelpHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			version();
		}
	}
	
	//버전 메뉴 클릭 시 수행하는 메소드
		public void version() { // 버전관리창 생성
		  final JDialog d = new JDialog(this, "버전관리");
		  JLabel jbver = new JLabel("       버전1.0");
		  JLabel jbdate = new JLabel("       2015.03.11");
		  JLabel jbauthor = new JLabel("       제작 : idea java");
		  
		  d.setLayout(new FlowLayout());
		  d.add(jbver);
		  d.add(jbdate);
		  d.add(jbauthor);
		  
		  d.setLocation(250, 230);
		  d.setSize(200, 100);
		  d.setVisible(true);
		  
		  d.addWindowListener(new WindowAdapter(){ // 버전관리창 종료
			   public void windowClosing(WindowEvent e){
				   d.dispose();
				   d.setVisible(false);
			   }
		  });
		 }	
		

	 
	public static void main(String[] args){
		RentMainWindow test=new RentMainWindow();
		test.startFrame();
	}
}
