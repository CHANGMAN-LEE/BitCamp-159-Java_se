import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RunRace extends Frame implements ActionListener{
	private Button btn;
	private int count;
	private Racer[] racer;

	public RunRace(String[] args){
		super("�� ����");

		count = Integer.parseInt(args[0]);
		btn = new Button(" ��� ");
		Panel p = new Panel(new GridLayout(count, 1));
		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		racer = new Racer[count];							//Ŭ������ �ƴ� �迭 ����!!

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

		//�̺�Ʈ ó��
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
			t[i] = new Thread(racer[i]);					//������ ����
			t[i].setPriority((int)(Math.random()*10)+1);		//�켱����
			t[i].start();									//������ ���� - ������ ����(run())
		}
	}

	public static void main(String[] args){
		new RunRace(args);
	}
}
