package Project_01;					//지예린
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
 
public class Manager_Form extends JFrame implements ActionListener {
    private JButton exitBtn, infoBtn, backbtn;
    private JTable table;
    private DefaultTableModel model;
 
    public Manager_Form() {
        setLayout(null);
 
        // JButton
        infoBtn = new JButton("회원상세정보");
        infoBtn.setBounds(755, 420, 220, 35);
        backbtn = new JButton("뒤로");
        backbtn.setBounds(755, 460, 220, 35);
        exitBtn = new JButton("종료");
        exitBtn.setBounds(755, 500, 220, 35);
 
        // JTable
        Object data[][] = {};
        String[] title = { "아이디", "이름", "연락처", "이메일", "거주지역" };
        model = new DefaultTableModel(data, title);
        table = new JTable(model);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(5,7,730,560);
        add(scroll);
        
        Container c = getContentPane();
        c.add(infoBtn);
        c.add(backbtn);
        c.add(exitBtn);
        c.add(scroll);
        
        setTitle("관리자페이지_회원관리");
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(new Color(199,199,199));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        // 이벤트
        infoBtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = "";

        if (e.getSource() == infoBtn) {
               while(true) {
                   name = JOptionPane.showInputDialog("회원 아이디를 입력해주세요.");
                   if(name != null && !name.equals("")) {
                	   new Manager_MemberInfo();
                   }else if(name == null || name.equals("")) {
                	   JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
               }
        } else if (e.getSource() == exitBtn) {    
           int choice = JOptionPane.showConfirmDialog(this, "로그아웃하시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	           if(choice==JOptionPane.YES_OPTION) { 
	        	   setVisible(false);
	        	   //다시 로그인 창으로
				}else if(choice==JOptionPane.NO_OPTION) {
					return;
				}
        } else if (e.getSource() == backbtn) {
            new Manager_();
            setVisible(false);
        }
    }//actionPerformed
 
}