import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

class TimerTest extends JFrame implements Runnable{
	private JButton startB, stopB;
	private JLabel label;
	private boolean bb = true;
	private static int ii;
	DecimalFormat df = new DecimalFormat("##.##");

	public TimerTest(){
		startB = new JButton("Ω√¿€");
		stopB = new JButton("∏ÿ√„");
		label = new JLabel("0");
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		p.add(startB); p.add(stopB);
		add("Center", label);
		add("South", p);

		label.setFont(new Font("Consolas", Font.BOLD, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		setResizable(false);
		setBounds(400, 150, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		startB.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = true;
				new Thread(TimerTest.this).start();
				startB.setEnabled(false);
				stopB.setEnabled(true);
			}
		});
		stopB.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				bb = false;
				startB.setEnabled(true);
				stopB.setEnabled(false);
			}
		});
	}

	@Override
	public void run(){
		for(int i=1; i<=50; i++){
			label.setText(i + "");
			if(!bb) break;
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		startB.setEnabled(true);
		stopB.setEnabled(false);
	}

	public static void main(String[] args){
		new TimerTest();
	}
}
