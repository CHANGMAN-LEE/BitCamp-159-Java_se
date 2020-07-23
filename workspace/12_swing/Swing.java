import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing extends JFrame implements ActionListener{
	private JButton newB, exitB;
	private JTextArea area;

	public Swing(){
		newB = new JButton(new ImageIcon("Swing.gif"));
		exitB = new JButton(new ImageIcon("Swing2.gif"));
		area = new JTextArea();
		JPanel p = new JPanel();
		JScrollPane scroll = new JScrollPane(area);

		Container c = this.getContentPane();

		p.add(newB); p.add(exitB);
		c.add("North", p);
		c.add("Center", scroll);

		area.setBackground(new Color(220, 220, 220));
		setResizable(false);
		setBounds(400, 100, 300,400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		newB.addActionListener(this);
		exitB.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				int result = JOptionPane.showConfirmDialog(Swing.this, "종료하시겠습니까?", "종료",
															JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == newB){
			area.setText("");
		}else if(e.getSource() == exitB){
			//System.exit(0);
			int result = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료",
														JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args){
		new Swing();
	}
}
