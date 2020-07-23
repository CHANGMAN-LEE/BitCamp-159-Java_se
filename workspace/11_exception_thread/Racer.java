import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Racer extends Canvas implements Runnable{
	private String name;
	private Image img;
	private int pos;
	private static int rank;

	public Racer(String name){
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("H.gif");
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(img, pos, 0, 30, this.getSize().height, this);
	}
	
	@Override
	public void run(){
		for(int i = 0; i <= 900; i+=((int)(Math.random()*10)+1)){
			pos = i;
			repaint();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		rank++;
		System.out.println(rank+"µî  : "+name);
	}
}
