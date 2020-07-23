import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

class ScoreForm extends JFrame implements ActionListener{
	private final static int TABLE_COLUMN = 5;

	private JButton inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, openBtn;
	private JTextField[] jtf = new JTextField[TABLE_COLUMN];
	private DefaultTableModel model;
	private JTable table;
	//private ScoreImpl impl;
	private Score score;

	public ScoreForm(){
		super("�л� ���̺�");

		inputBtn = new JButton("�Է�");
		outputBtn = new JButton("���");
		searchBtn = new JButton("�˻�");
		rankBtn = new JButton("����");
		saveBtn = new JButton("��������");
		openBtn = new JButton("�����б�");
		
		JPanel[] p = new JPanel[TABLE_COLUMN];
		JPanel pl = new JPanel();
		pl.setLayout(new GridLayout(5, 0, 5, 5));
		JLabel[] jl =new JLabel[TABLE_COLUMN];
		String[] title = {"�й�", "�̸�", "����", "����", "����"};
		for(int i=0; i<TABLE_COLUMN; i++){
			p[i] = new JPanel();
			jl[i] = new JLabel(title[i]);
			jtf[i] = new JTextField(20);
			p[i].add(jl[i]);
			p[i].add(jtf[i]);
			pl.add(p[i]);
		}

		Vector<String> v = new Vector<String>();
		v.add("�й�");
		v.add("�̸�");
		v.add("����");
		v.add("����");
		v.add("����");
		v.add("����");
		v.add("���");
		model = new DefaultTableModel(v, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane();
		scroll = new JScrollPane(table);

		score = new ScoreImpl();

		JPanel pd = new JPanel();
		pd.setLayout(new GridLayout(1, 5, 5, 5));
		pd.add(inputBtn);
		pd.add(outputBtn);
		pd.add(searchBtn);
		pd.add(rankBtn);
		pd.add(saveBtn);
		pd.add(openBtn);

		JPanel pc = new JPanel();
		pc.setLayout(new GridLayout(1,2));
		pc.add(pl);
		pc.add(scroll);

		Container c = getContentPane();
		c.add("Center", pc);
		c.add("South", pd);

		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void event(){
		inputBtn.addActionListener(this);
		outputBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == inputBtn){
			ScoreDTO dto = new ScoreDTO();
			dto.setHak(jtf[0].getText());
			dto.setName(jtf[1].getText());
			dto.setKor(Integer.parseInt(jtf[2].getText()));
			dto.setEng(Integer.parseInt(jtf[3].getText()));
			dto.setMath(Integer.parseInt(jtf[4].getText()));
			dto.calc();
			score.input(dto);
			JOptionPane.showMessageDialog(this, "��ϿϷ�!!");
			for(int i=0; i<jtf.length; i++) jtf[i].setText("");
		}else if(e.getSource() == outputBtn){
			score.output(model);
		}else if(e.getSource() == searchBtn){
			String hak = JOptionPane.showInputDialog(this, "�й��� �Է��ϼ���.!!");
			if(hak==null || hak.equals("")) return;
			int sw = score.search(model, hak);
			if(sw==0) JOptionPane.showMessageDialog(this, "ã�� �й��� �����ϴ�!");
		}else if(e.getSource() == rankBtn){
			score.to_desc();
			score.output(model);
		}else if(e.getSource() == saveBtn){
			score.save();
		}else if(e.getSource() == openBtn){
			score.load();
			score.output(model);
		}
	}
}
