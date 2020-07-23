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
		super("학생 테이블");

		inputBtn = new JButton("입력");
		outputBtn = new JButton("출력");
		searchBtn = new JButton("검색");
		rankBtn = new JButton("순위");
		saveBtn = new JButton("파일저장");
		openBtn = new JButton("파일읽기");
		
		JPanel[] p = new JPanel[TABLE_COLUMN];
		JPanel pl = new JPanel();
		pl.setLayout(new GridLayout(5, 0, 5, 5));
		JLabel[] jl =new JLabel[TABLE_COLUMN];
		String[] title = {"학번", "이름", "국어", "영어", "수학"};
		for(int i=0; i<TABLE_COLUMN; i++){
			p[i] = new JPanel();
			jl[i] = new JLabel(title[i]);
			jtf[i] = new JTextField(20);
			p[i].add(jl[i]);
			p[i].add(jtf[i]);
			pl.add(p[i]);
		}

		Vector<String> v = new Vector<String>();
		v.add("학번");
		v.add("이름");
		v.add("국어");
		v.add("영어");
		v.add("수학");
		v.add("총점");
		v.add("평균");
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
			JOptionPane.showMessageDialog(this, "등록완료!!");
			for(int i=0; i<jtf.length; i++) jtf[i].setText("");
		}else if(e.getSource() == outputBtn){
			score.output(model);
		}else if(e.getSource() == searchBtn){
			String hak = JOptionPane.showInputDialog(this, "학번을 입력하세요.!!");
			if(hak==null || hak.equals("")) return;
			int sw = score.search(model, hak);
			if(sw==0) JOptionPane.showMessageDialog(this, "찾는 학번이 없습니다!");
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
