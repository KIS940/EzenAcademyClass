package ex4.car;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.Entry;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import ex4.common.RentTableModel;

public class SearchCarDialog  extends JDialog{
	JPanel panelSearch,panelBtn;
	JLabel lCarName;
	JTextField tf ;
    JButton btnSearch ;
    JButton btnModify ;
    JButton btnDelete ;
    
    String[][] carItems ;
    JTable rentTable;
    RentTableModel model;
    CarImpl carController;
    String[] columnNames={"����ȣ","���̸�","��ⷮ","������","��������"};
    
    public SearchCarDialog(String str){
    	setTitle(str);
    	init();
    }
    
    private void init(){
    	carController=new CarImpl();
    	rentTable=new JTable();
    	panelSearch=new JPanel();
    	panelBtn=new JPanel();
      
    	lCarName = new JLabel("������");
    	tf=new JTextField(10);
    	btnSearch=new JButton("��ȸ�ϱ�");
    	 
    	btnSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<CarVo> carList=new ArrayList<CarVo>();
				try {
					carList=carController.listCarInfo(tf.getText().trim());
					loadTableData(carList);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
    	});    	
    	panelSearch.add(lCarName);
    	panelSearch.add(tf);
    	panelSearch.add(btnSearch);
    	
     	btnModify=new JButton("�����ϱ�");
     	
     	btnModify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int arrRow = rentTable.getSelectedRow();
//    			int arrCol = rentTable.getSelectedColumn();
    			
    			// ���ο� ���� ����
    			CarVo vo = new CarVo();
    			String [] carArr = new String[5];
    			for(int i=0; i<5; i++) {
    				carArr[i] = (String) rentTable.getValueAt(arrRow, i);
    				carArr[i] = carArr[i].trim();
    			}
    			vo.setCarNumber(carArr[0]); 
    			vo.setCarName(carArr[1]); 
    			vo.setCarSize(Integer.parseInt(carArr[2])); 
    			vo.setCarColor(carArr[3]); 
    			vo.setCarMaker(carArr[4]); 
    			
    			try {
					carController.modCarInfo(vo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			// ����â�� ������ carNumber�� �־ ��� 
//    			System.out.println("arrRow : "+arrRow);
//    			System.out.println("arrCol : "+arrCol);
//    			System.out.println(rentTable.getValueAt(arrRow, 0));
//    			String carNo= (String) rentTable.getValueAt(arrRow, 0);
//    			
//				new ModCarDialog("��������â",carNo);
			}
    	});    
    	btnDelete=new JButton("�����ϱ�");
    	btnDelete.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int arrRow = rentTable.getSelectedRow();
    			int arrCol = rentTable.getSelectedColumn();
    			
//    			System.out.println("arrRow : "+arrRow);
//    			System.out.println("arrCol : "+arrCol);
//    			System.out.println(rentTable.getValueAt(arrRow, 1));
    			String carName= (String) rentTable.getValueAt(arrRow, 1);
    			
    			new DelCarDialog("��������â", carName);
    			
    		}
    	});    
    	//
    	
    	panelBtn.add(btnModify);
    	panelBtn.add(btnDelete);
      	add(panelSearch,BorderLayout.NORTH);
    	add(panelBtn,BorderLayout.SOUTH);
      	carItems = new String[0][5];
        model=new RentTableModel(carItems,columnNames);
    	rentTable.setModel(model);
        add(new JScrollPane(rentTable),BorderLayout.CENTER);
        setLocation(300,100);//���̾�α� ��� ��ġ�� ���Ѵ�.
        setSize(600,600);
        setModal(true); //�׻� �θ�â ���� ���̰� �Ѵ�.
        setVisible(true);
    }
     private void loadTableData(ArrayList<CarVo > carList){
    	carItems = new String[carList.size()][5];
    	for(int i=0; i<carList.size();i++){
    		CarVo vo=carList.get(i);
    		carItems[i][0]=vo.carNumber;
    		carItems[i][1]=vo.carName;
    		carItems[i][2]=Integer.toString(vo.carSize);
    		carItems[i][3]=vo.carColor;
    		carItems[i][4]=vo.carMaker;
    	}
    	
    	model=new RentTableModel(carItems,columnNames);
    	rentTable.setModel(model);
	}    
}
