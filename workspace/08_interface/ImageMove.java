//import java.awt.*;
//import java.awt.event.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
<span style="color: red; font-size: 8pt;">
	이미지를 이동하는 클래스.
</span>
*/
class ImageMove extends Frame implements KeyListener, WindowListener, ActionListener{
	
	private Button setBtn, leftBtn, upBtn, downBtn, rightBtn;
	/**
	<span style="color: red; font-size: 8pt;">
		x는 이미지의 시작위치
	</span>
	*/
	private int x = 150;
	/**
	<span style="color: red; font-size: 8pt;">
		y는 이미지의 시작위치
	</span>
	*/
	private int y = 150;


	/**
	<span style="color: red; font-size: 8pt;">
		버튼을 생성하고 Frame크기를 설정
	</span>
	*/
	//init
	public void init(){
		setBtn = new Button("Set");
		leftBtn = new Button("Left");
		upBtn = new Button("Up");
		downBtn = new Button("Down");
		rightBtn = new Button("Right");
		Panel p = new Panel();

		p.add(setBtn); p.add(leftBtn); p.add(upBtn); p.add(downBtn); p.add(rightBtn);

		add("North", p);

		p.setBackground(new Color(200,200,200));
		setResizable(false);
		setBounds(700,100,500,500);
		setVisible(true);

		this.addWindowListener(this);

		//this.addKeyListener(this);
		setBtn.addKeyListener(this);
		leftBtn.addKeyListener(this);
		upBtn.addKeyListener(this);
		downBtn.addKeyListener(this);
		rightBtn.addKeyListener(this);

		setBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "Set"){
			x = 150;
			y = 150;
			repaint();
		}else if(e.getActionCommand() == "Left"){
			x-=10;
			if(x<-140){
				x = 450;
			}
			repaint();
		}else if(e.getActionCommand() == "Up"){
			y-=10;
			if(y<-100){
				y = 440;
			}
			repaint();
		}else if(e.getActionCommand() == "Down"){
			y+=10;
			if(y>440){
				y = -100;
			}
			repaint();
		}else if(e.getActionCommand() == "Right"){
			x+=10;
			if(x>450){
				x = -140;;
			}
			repaint();
		}
	}
	
	//KeyListener Override
	public void keyPressed(KeyEvent e){
		System.out.println(x + "  " + y);
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x-=10;
			if(x<-140){
				x = 450;
			}
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			y-=10;
			if(y<-100){
				y = 440;
			}
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y+=10;
			if(y>440){
				y = -100;
			}
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			x+=10;
			if(x>450){
				x = -140;;
			}
			repaint();
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
 	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	//이미지
	public void paint(Graphics g){
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage("kakaoimage.png");
		Image img = Toolkit.getDefaultToolkit().getImage("kakaoimage2.jpg");
		g.drawImage(img, x,y,x+200,y+200, 0,0,308,276, this);
	}

	//main
	public static void main(String[] args) {
		new ImageMove().init();
	}
}