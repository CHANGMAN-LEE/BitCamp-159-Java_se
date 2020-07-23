import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Pacman extends Frame implements Runnable, KeyListener{
	Random random = new Random();
	private Image img;
	private Image img2;
	private int sel=2, x=225, y=255;
	private int[] ranX = new int[5]; 
	private int[] ranY = new int[5];
	//private int apple = 5;
	private int eat = 5;

	public Pacman(){
		img = Toolkit.getDefaultToolkit().getImage("Pacman.png");
		img2 = Toolkit.getDefaultToolkit().getImage("foodImg.png");
			
		setResizable(false);
		setBounds(900, 150, 500, 500);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		//this.addKeyListener(this);
		//this.addKeyListener(this);
		//this.addKeyListener(this);
		//this.addKeyListener(this);
		//this.addKeyListener(this);
		this.addKeyListener(this);

		Thread t = new Thread(this);
		t.start();
	}

	//¿ÃπÃ¡ˆ
	@Override
	public void paint(Graphics g){
		for(int i=0; i<5; i++){
			g.drawImage(img2, ranX[i],ranY[i],ranX[i]+20,ranY[i]+20, 0,0,20,20, this);
		}

		g.drawImage(img, x,y,x+50,y+50, sel*50,0,sel*50+50,50, this);

		for(int i=0; i<5; i++){
			if (ranX[i]+30 >= x+25 && x+25 >= ranX[i]-10 && ranY[i]+30 >= y+25 && y+25 >= ranY[i]-10){
            ranX[i] = 0;
            ranY[i] = 0;
            eat++;
			}
		}

		if (eat == 5){
			for(int i=0; i<5; i++){
				ranX[i] = (int)(Math.random()*401)+40;
				ranY[i] = (int)(Math.random()*401)+40;
				}
			eat = 0;
			//apple++;
		}
	}
	
	@Override
	public void run() {
		while(true){
			if(sel%2 == 0) sel++;
			else sel--;
			repaint();
			if(sel == 0 || sel == 1){
				x-=20;
				if(x<1){
					sel=2;
				}
				repaint();
			}else if(sel == 4 || sel == 5){
				y-=20;
				if(y<41){
					sel=6;
				}
				repaint();
			}else if(sel == 6 || sel == 7){
				y+=20;
				if(y>449){
					sel=4;
				}
				repaint();
			}else if(sel == 2 || sel == 3){
				x+=20;
				if(x>449){
					sel=0;
				}
				repaint();
			}
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	//KeyListener Override
	@Override
	public void keyPressed(KeyEvent e){
		//System.out.println(x + "  " + y);
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			sel = 0;
			x-=5;
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			sel = 4;
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			sel = 6;
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			sel = 2;
			repaint();
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

	public static void main(String[] args){
		new Pacman();
	}
}
