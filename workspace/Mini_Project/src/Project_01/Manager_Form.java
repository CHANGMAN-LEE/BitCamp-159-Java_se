package Project_01;					//������
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
        infoBtn = new JButton("ȸ��������");
        infoBtn.setBounds(755, 420, 220, 35);
        backbtn = new JButton("�ڷ�");
        backbtn.setBounds(755, 460, 220, 35);
        exitBtn = new JButton("����");
        exitBtn.setBounds(755, 500, 220, 35);
 
        // JTable
        Object data[][] = {};
        String[] title = { "���̵�", "�̸�", "����ó", "�̸���", "��������" };
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
        
        setTitle("������������_ȸ������");
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(new Color(199,199,199));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        // �̺�Ʈ
        infoBtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = "";

        if (e.getSource() == infoBtn) {
               while(true) {
                   name = JOptionPane.showInputDialog("ȸ�� ���̵� �Է����ּ���.");
                   if(name != null && !name.equals("")) {
                	   new Manager_MemberInfo();
                   }else if(name == null || name.equals("")) {
                	   JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���̵� �����ϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
               }
        } else if (e.getSource() == exitBtn) {    
           int choice = JOptionPane.showConfirmDialog(this, "�α׾ƿ��Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	           if(choice==JOptionPane.YES_OPTION) { 
	        	   setVisible(false);
	        	   //�ٽ� �α��� â����
				}else if(choice==JOptionPane.NO_OPTION) {
					return;
				}
        } else if (e.getSource() == backbtn) {
            new Manager_();
            setVisible(false);
        }
    }//actionPerformed
 
}