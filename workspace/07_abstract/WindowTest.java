import java.awt.*;
import java.awt.event.*;

class WindowTest extends Frame {
	public void init(){
		setBounds(700, 100, 300, 400);
		setBackground(new Color(200, 200, 200));
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("kakaoimage.png");
		//g.drawImage(img, 50, 150, this);
		/*g.drawImage(img,
					50,100,250,300,
					454,354,0,0,
					this);*/
		g.drawImage(img,
					50,100,250,300,
					454,0,0,354,
					this);
	}
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		new WindowTest().init();
	}
}
