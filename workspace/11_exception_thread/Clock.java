import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Clock extends Frame implements Runnable{
	public Clock(){
		setForeground(Color.RED);
		setFont(new Font("Consolas", Font.BOLD, 30));
		setResizable(false);
		setBounds(900, 100, 300, 200);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});

		Thread t = new Thread(this);		//나를 쓰레드로 만들어라!!
		t.start();							//쓰레드 시작
	}

	@Override
	public void paint(Graphics g){
		SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss");
		g.drawString(sdf.format(new Date()), 50, 110);
	}

	@Override
	public void run() {
		while(true){
			repaint();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		new Clock();
	}
}
