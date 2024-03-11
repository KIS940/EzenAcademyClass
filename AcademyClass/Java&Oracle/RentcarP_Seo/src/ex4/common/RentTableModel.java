package ex4.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ex4.reserve.ResVo;

public  class RentTableModel extends AbstractTableModel {
	
	String[] columnNames;

	Object[][] data;

	public RentTableModel() {
		
	}
	public RentTableModel( Object[][] data,String[] columnNames) {
		this.columnNames=columnNames;
		this.data = data;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return data[arg0][arg1];
	}
	
	public String getColumnName(int arg0){
		return columnNames[arg0];
	}

	// 수정할 수 있는 컬럼 지정
	 boolean[] columnEditables = new boolean[] {
            false, true, true, true, true, true, true
       };

     public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
     }
     
  
     public void setValueAt(Object value,int row,int col){
    	 data[row][col]=value;
 		fireTableCellUpdated(row,col);
 	}
     
//     public String[] loadResData(ArrayList<?> resList, int tuNo ){
//    	String [] resultArr= new String[7];
//    	Iterator it = resList.iterator();
//    	while(it.hasNext()) {
//    		System.out.println(it.next());
//    	}
//     	return resultArr;
//     }
	public Object loadResData(ArrayList<?> resList, int tuNo) {
    	System.out.println(resList.size());
//		Iterator it = resList.iterator();
//		while(it.hasNext()) {
//			Map.Entry e = (Map.Entry) it.next();
//			
//			String key = (String)e.getKey();
//			String name = (String)e.getValue();
//			System.out.println(key+", "+ name);
//		}
		return resList.get(tuNo);
	}
     
}
