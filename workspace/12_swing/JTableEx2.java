import java.awt.*;				//Container, FlowLayout
import java.awt.event.*;		//ActionListener ActionEvent
import java.util.*;				//ArrayList, Vector
import javax.swing.*;			//JFrame, JTable, JScrollPane, JPanel, JButton, JOptionPane
import javax.swing.table.*;		//DefaultTableModel

public class JTableEx2 extends JFrame implements ActionListener{
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;

	public JTableEx2(){
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-111-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "222", "010-222-1234"));

		//Ÿ��Ʋ
		vector = new Vector<String>();
		vector.add("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.addElement("�ڵ���");

		model = new DefaultTableModel(vector, 0){
			public boolean isCellEditable(int r, int c){
				return (c!=0) ? true : false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		//������
		for(PersonDTO dto: list){
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());

			model.addRow(v);
		}
		
		//��ư�߰�
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(addBtn); jp.add(delBtn);

		Container c = getContentPane();
		c.add("Center", scroll);
		c.add("South", jp);

		setBounds(400, 400 , 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}//JTableEx2()

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBtn){
			insert();
		}else if(e.getSource() == delBtn){
			delete();
		}
	}//Override

	public void insert(){
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if(id == null || id.length() == 0){
			JOptionPane.showMessageDialog(this, "���̵� �Է����ּž��մϴ�.");
			return;
		}else{
			int check = 0;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getId().equals(id)){
					check = 1;
				}
			}
			if(check == 0){
				String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���.");
				String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���.");
				String tel = JOptionPane.showInputDialog(this, "�ڵ����� �Է��ϼ���.");
				list.add(new PersonDTO(id, name, pwd, tel));
				Vector<String> v = new Vector<String>();
				v.add(id); v.add(name); v.add(pwd); v.add(tel);
				model.addRow(v);
			}else if(check == 1){
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�.");
				return;
			}
		}
		/*for(int i=0; i<model.getRowCount(); i++){
			if(id.equals(model.getValueAt(i,0))){
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�.");
				return;
			}
		}
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���.");
		String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���.");
		String tel = JOptionPane.showInputDialog(this, "�ڵ����� �Է��ϼ���.");
		Vector<String> v= new Vector<String>();
		v.add(id); v.add(name); v.add(pwd); v.add(tel);
		model.addRow(v);*/
	}//insert()

	public void delete(){
		String name = JOptionPane.showInputDialog(this, "������ �̸��� �Է��ϼ���.");
		if(name == null || name.length() == 0){
			JOptionPane.showMessageDialog(this, "�̸��� �Է����ּž��մϴ�.");
			return;
		}else{
			int check = 0;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getName().equals(name)){
					check = 1;
				}
			}//for i -> �˻��� �̸��� �ִ��� ������ �˻� �� !!
			if(check == 0){
				JOptionPane.showMessageDialog(this, "������ �̸��� �����ϴ�.");
				return;
			}else if(check == 1){
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) {
					   list.remove(i);
					   model.removeRow(i);
					   i--;
					}
				}
			}//if - esls if
		}//if - esls if
	}//delete()

	public static void main(String[] args){
		new JTableEx2();
	}//main()
}
