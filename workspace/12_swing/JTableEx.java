import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel{
	Object[][] data = {{"Nari", "마루치", new Integer(1234), "옆집친구"},
						{"One", "오윤아", new Integer(1111), "예쁜이"},
						{"Two", "오윤서", new Integer(2222), "귀염둥이"},
						{"Three", "아라치", new Integer(3333), "동아리친구"}};
	String[] name = {"아이디", "이름", "비밀번호", "구분"};

	public int getColumnCount(){
		return name.length;
	}
	public int getRowCount(){
		return data.length;
	}
	public Object getValueAt(int r, int c){
		return data[r][c];
	}
	public boolean isCellEditable(int r, int c){
		return (c!=0) ? true : false;
	}
	public String getColumnName(int c){
		return name[c];
	}
	public void setValueAt(Object obj, int r, int c){
		data[r][c] = obj;
	}
}
public class JTableEx extends JFrame{
	JTable table;
	JTableModel model;

	public JTableEx(){
		model = new JTableModel();
		table = new JTable(model);

		add(new JScrollPane(table));

		setBounds(400, 400 , 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		new JTableEx();
	}
}
