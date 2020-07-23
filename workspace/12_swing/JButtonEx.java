import java.awt.*;
import javax.swing.*;

public class JButtonEx extends JFrame{
	private Icon icon1 = new ImageIcon("Swing.gif");
	private Icon icon2 = new ImageIcon("Swing2.gif");
	private Icon icon3 = new ImageIcon("Swing2.gif");
	private Icon icon4 = new ImageIcon("Swing.gif");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();

	public JButtonEx(){
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2, 2));
		for(int i=0; i<4; i++){
			jb[i] = new JRadioButton((i+1) + "번 버튼", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText((i+1) + "번쨰 버튼이다. 눌러...");
			jb[i].setMnemonic(i + 49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);
		}
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new JButtonEx();
	}
}