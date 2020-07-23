package studentManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm {
	private JButton inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, loadBtn;
	private JTextField numT, nameT, korT, engT, mathT;
	private JLabel numL, nameL, korL, engL, mathL;
	private ArrayList<ScoreDTO> array;

	public ScoreForm() {
		array = new ArrayList<ScoreDTO>();

		JFrame frame = new JFrame();

		// ---------------------------센터 레프트 패널---------------------------
		JPanel[] ps = new JPanel[5];
		JTextField[] jts = { numT, nameT, korT, engT, mathT };
		JLabel[] jlb = { numL, nameL, korL, engL, mathL };
		String[] jlbNames = { "학번", "이름", "국어", "영어", "수학" };
		JPanel centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(5, 1));

		for (int i = 0; i < jts.length; i++) {
			ps[i] = new JPanel();
			jlb[i] = new JLabel(jlbNames[i]);
			ps[i].add(jlb[i]);
			jts[i] = new JTextField(20);
			ps[i].add(jts[i]);
			centerLeft.add(ps[i]);
		}
		// ---------------------------센터 레프트 패널 끝---------------------------

		// ---------------------------센터 라이트 패널---------------------------
		JPanel centerRight = new JPanel();
		centerRight.setLayout(new GridLayout(1, 1, 1, 1));
		String[] header = { "학번", "이름", "국어", "영어", "수학", "총점", "평균" };
		String[][] list = new String[array.size()][header.length];// {{"1","2","3","4","5","6","7"},{"1","2","3","4","5","6","7"},{"1","2","3","4","5","6","7"}};
		// ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

		DefaultTableModel model2 = new DefaultTableModel(header, array.size());
		DefaultTableModel model = new DefaultTableModel(list, header);
		JTable table = new JTable(model2);
		JScrollPane scroll = new JScrollPane(table);
		centerRight.add(scroll);
		scroll.setBounds(9, 0, 295, 200);

		// ---------------------------센터 라이트 패널 끝---------------------------

		// ---------------------------센터 패널 ---------------------------
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2, 5, 5));
		center.add(centerLeft);
		center.add(centerRight);

		// ---------------------------센터 패널 끝---------------------------

		// ---------------------------사우스 패널 ---------------------------
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 6, 5, 5));
		JButton[] jbs = { inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, loadBtn };
		String[] jbsNames = { "입력", "출력", "학번검색", "순위", "파일저장", "파일열기" };
		for (int i = 0; i < jbs.length; i++) {
			jbs[i] = new JButton(jbsNames[i]);
			south.add(jbs[i]);
		}

		// ---------------------------사우스 패널 끝---------------------------

		// ---------------------------ContentPane---------------------------
		frame.getContentPane().add("North", new JPanel());
		frame.getContentPane().add("Center", center);
		frame.getContentPane().add("South", south);
		// ---------------------------ContentPane끝---------------------------

		// ---------------------------frame----------------------------------
		frame.pack();
		frame.setTitle("성적관리 시스템");
		frame.setSize(600, 400);
		frame.setLocation(1200, 50);
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int sel = JOptionPane.showConfirmDialog(frame, "종료 전 저장하시겠습니까?", "종료 전 저장 여부", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				switch (sel) {
				case JOptionPane.YES_OPTION:
					if (array == null || array.size() == 0) {
						JOptionPane.showMessageDialog(frame, "목록이 비어있습니다.");
						return;
					}
					JFileChooser chooser = new JFileChooser();
					chooser.showSaveDialog(frame);
					File file = chooser.getSelectedFile();

					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file));
						bw.write("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
						for (int i = 0; i < array.size(); i++) {
							bw.write(array.get(i).getNum() + "\t");
							bw.write(array.get(i).getName() + "\t");
							bw.write(array.get(i).getKor() + "\t");
							bw.write(array.get(i).getEng() + "\t");
							bw.write(array.get(i).getMath() + "\t");
							bw.write(array.get(i).getTot() + "\t");
							bw.write(array.get(i).getAvg() + "\t\n");

						}
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, file + "저장 완료");
					System.exit(0);
				case JOptionPane.NO_OPTION:
					System.exit(0);
				case JOptionPane.CANCEL_OPTION:
					return;
				}
			}
		});
		// ---------------------------End of frame----------------------------------

		// ---------------------------버튼 구현 시작----------------------------------

		// inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, loadBtn;
		// numT, nameT, korT, engT, mathT;

		// 입력
		jbs[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jts[0].getText() == null || jts[1].getText() == null || jts[2].getText() == null
						|| jts[3].getText() == null || jts[4].getText() == null || jts[0].getText().length() == 0
						|| jts[1].getText().length() == 0 || jts[2].getText().length() == 0
						|| jts[3].getText().length() == 0 || jts[4].getText().length() == 0) {
					JOptionPane.showMessageDialog(frame, "입력하지 않은 값이 있습니다.");
					return;
				}

				int num = Integer.parseInt(jts[0].getText());
				String name = jts[1].getText();
				int kor = Integer.parseInt(jts[2].getText());
				int eng = Integer.parseInt(jts[3].getText());
				int math = Integer.parseInt(jts[4].getText());

				ScoreDTO dto = new ScoreDTO(num, name, kor, eng, math);
				array.add(dto);

				JOptionPane.showMessageDialog(frame, "입력 완료");
				jts[0].setText("");
				jts[1].setText("");
				jts[2].setText("");
				jts[3].setText("");
				jts[4].setText("");
			}
		});

		// 출력
		jbs[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (array == null || array.size() == 0) {
					JOptionPane.showMessageDialog(frame, "출력할 내용이 없습니다.");
					return;
				}

				// model2.setRowCount(model2.getRowCount()+array.size());

				model2.setNumRows(0);
				for (int i = 0; i < array.size(); i++) {
					Object[] o = { array.get(i).getNum(), array.get(i).getName(), array.get(i).getKor(),
							array.get(i).getEng(), array.get(i).getMath(), array.get(i).getTot(),
							array.get(i).getAvg() };
					model2.addRow(o);
				}
			}
		});

		// 학번검색
		jbs[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (array == null || array.size() == 0) {
					JOptionPane.showMessageDialog(frame, "목록이 비어있습니다.");
					return;
				}
				String findNum = JOptionPane.showInputDialog(frame, "검색할 학번을 입력하세요");
				int sw = 0;
				for (int i = 0; i < array.size(); i++) {
					if (Integer.parseInt(findNum) == array.get(i).getNum()) {
						model2.setNumRows(0);
						Object[] o = { array.get(i).getNum(), array.get(i).getName(), array.get(i).getKor(),
								array.get(i).getEng(), array.get(i).getMath(), array.get(i).getTot(),
								array.get(i).getAvg() };
						model2.addRow(o);
						sw = 1;
					}
				}
				if (sw == 0) {
					JOptionPane.showMessageDialog(frame, "찾으시는 학번이 존재하지 않습니다.");
					return;
				}
			}
		});

		// 순위
		jbs[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (array == null || array.size() == 0) {
					JOptionPane.showMessageDialog(frame, "목록이 비어있습니다.");
					return;
				}
				model2.setNumRows(0);
				for (int i = 0; i < array.size(); i++) {
					Object[] o = { array.get(i).getNum(), array.get(i).getName(), array.get(i).getKor(),
							array.get(i).getEng(), array.get(i).getMath(), array.get(i).getTot(),
							array.get(i).getAvg() };
					model2.addRow(o);
				}
				Collections.sort(array);
			}
		});

		// 저장
		jbs[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (array == null || array.size() == 0) {
					JOptionPane.showMessageDialog(frame, "목록이 비어있습니다.");
					return;
				}
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(frame);
				File file = chooser.getSelectedFile();

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
					for (int i = 0; i < array.size(); i++) {
						bw.write(array.get(i).getNum() + "\t");
						bw.write(array.get(i).getName() + "\t");
						bw.write(array.get(i).getKor() + "\t");
						bw.write(array.get(i).getEng() + "\t");
						bw.write(array.get(i).getMath() + "\t");
						bw.write(array.get(i).getTot() + "\t");
						bw.write(array.get(i).getAvg() + "\t\n");

					}
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, file + "저장 완료");
			}
		});

		// 열기
		jbs[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int sel = JOptionPane.showConfirmDialog(frame, "현 목록에 추가하시겠습니까?", "열기 옵션 선택",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				switch (sel) {
				case JOptionPane.YES_OPTION:
					JFileChooser chooser = new JFileChooser();
					int sel2 = chooser.showOpenDialog(frame);
					if (sel2 == chooser.APPROVE_OPTION) {
						try {
							File file = chooser.getSelectedFile();
							BufferedReader br = new BufferedReader(new FileReader(file));
							String line = null;
							while ((line = br.readLine()) != null) {
								String[] str = line.split("\t");
								// public ScoreDTO(int num, String name, int kor, int eng, int math) {
								if(str[0].equals("학번")) {
								}else {
									int num = Integer.parseInt(str[0]);
									String name = str[1];
									int kor = Integer.parseInt(str[2]);
									int eng = Integer.parseInt(str[3]);
									int math = Integer.parseInt(str[4]);
									ScoreDTO dto = new ScoreDTO(num, name, kor, eng, math);
									array.add(dto);
								}
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						model2.setRowCount(0);
						for (int i = 0; i < array.size(); i++) {
							Object[] o = { array.get(i).getNum(), array.get(i).getName(), array.get(i).getKor(),
									array.get(i).getEng(), array.get(i).getMath(), array.get(i).getTot(),
									array.get(i).getAvg() };
							model2.addRow(o);
						}
						break;
					} else {
						return;
					}

				case JOptionPane.NO_OPTION:

					JFileChooser chooser2 = new JFileChooser();
					int sel3 = chooser2.showOpenDialog(frame);

					if (sel3 == chooser2.APPROVE_OPTION) {
						array = new ArrayList<ScoreDTO>();
						try {

							File file = chooser2.getSelectedFile();
							BufferedReader br = new BufferedReader(new FileReader(file));
							String line = null;
							while ((line = br.readLine()) != null) {
								String[] str = line.split("\t");
								
								if(str[0].equals("학번")) {
									
								}else {
								ScoreDTO dto = new ScoreDTO(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]),
										Integer.parseInt(str[3]), Integer.parseInt(str[4]));
								array.add(dto);
								}
				
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						model2.setRowCount(0);
						for (int i = 0; i < array.size(); i++) {
							Object[] o = { array.get(i).getNum(), array.get(i).getName(), array.get(i).getKor(),
									array.get(i).getEng(), array.get(i).getMath(), array.get(i).getTot(),
									array.get(i).getAvg() };
							model2.addRow(o);
						}
						break;
					} else {
						return;
					}

				case JOptionPane.CANCEL_OPTION:
					return;
				}
			}
		});
		//열기 끝
	}
	// Constructor ScoreForm

	public static void main(String[] args) {
		new ScoreForm();
	}
	// main method
}
//class ScoreForm 
