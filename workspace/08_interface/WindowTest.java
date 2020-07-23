import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class WindowTest extends Frame implements MouseListener, MouseMotionListener, KeyListener{

	private int x, y;

	public void init(){
		setBounds(900,100,300,400);
		setVisible(true);

		//�̺�Ʈ ó��
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(new WindowExit());
	}

	public void paint(Graphics g){
		g.drawString("X : " + x + ", " + "Y : " + y, x, y);
	}

	//MouseListener Override - callback method
	public void mouseClicked(MouseEvent e){
		x = e.getX();
		y = e.getY();
		System.out.println("���콺 Ŭ��!!");
		System.out.println("X : " + x + ", " + "Y : " + y);
		repaint();
	}
	public void mouseEntered(MouseEvent e){System.out.println("���콺 IN!!");}
	public void mouseExited(MouseEvent e){System.out.println("���콺 OUT!!");}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	//MouseMotionListener Override - callback method
	public void mouseDragged(MouseEvent e){System.out.println("���콺 �巡��!!");}
	public void mouseMoved(MouseEvent e){}
	
	//KeyListener Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);	//���α׷� ���� ����
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}



	public static void main(String[] args){
		new WindowTest().init();
	}
}