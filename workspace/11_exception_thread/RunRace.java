import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RunRace extends Frame implements ActionListener{
	private Button btn;
	private int count;
	private Racer[] racer;

	public RunRace(String[] args){
		super("말 경주");

		count = Integer.parseInt(args[0]);
		btn = new Button(" 출발 ");
		Panel p = new Panel(new GridLayout(count, 1));
		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		racer = new Racer[count];							//클래스가 아닌 배열 생성!!

		for(int i=0; i<racer.length; i++){
			racer[i] = new Racer(args[i+1]);
			p.add(racer[i]);
		}
		p2.add(btn);
		
		add("Center", p);
		add("South", p2);

		//setResizable(false);
		setBounds(400, 150, 900, 500);
		setVisible(true);

		//이벤트 처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		btn.addActionListener(this);
	}//RunRace()

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		btn.setEnabled(false);
		Thread[] t = new Thread[count];
		for(int i=0; i<count; i++){
			t[i] = new Thread(racer[i]);					//스레드 생성
			t[i].setPriority((int)(Math.random()*10)+1);		//우선순위
			t[i].start();									//스레드 시작 - 스레드 실행(run())
		}
	}

	public static void main(String[] args){
		new RunRace(args);
	}
}
