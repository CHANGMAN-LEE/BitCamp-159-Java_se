import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarEx extends JFrame implements ActionListener, Runnable{
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton jbt = new JButton("����");
	private JButton jbt1 = new JButton("����");

	public JProgressBarEx(){
		super("Test");

		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("�̰��� ���α׷��� ��!!"));
		con.add("Center", jpb);
		jpb.setString("0%");
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(jbt); jp.add(jbt1);
		con.add("South", jp);

		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jbt.addActionListener(this);
		jbt1.addActionListener(this);
	}

	private boolean bb = true;
	private static int ii;
	public void run(){
		if(ii == 100) ii = 0;
		for(int i=ii; i<=100; i++){
			if(!bb) break;
			try{
				Thread.sleep(50);
			}catch(InterruptedException ee){}
			jpb.setValue(i);
			ii = i;
			jpb.setString(i + "%");
		}
		jbt.setEnabled(true);
		jbt1.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == jbt){
			bb = true;
			new Thread(this).start();
			jbt.setEnabled(false);
			jbt1.setEnabled(true);
		}else if(e.getSource() == jbt1){
			bb = false;
			jbt.setEnabled(true);
			jbt1.setEnabled(false);
		}
	}

	public static void main(String[] args){
		new JProgressBarEx();
	}
}
