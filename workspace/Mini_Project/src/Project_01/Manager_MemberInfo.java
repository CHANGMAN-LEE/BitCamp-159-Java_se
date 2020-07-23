package Project_01;					//������
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class Manager_MemberInfo extends JFrame implements ActionListener {
    private JButton exitBtn, updateBtn;
    private JLabel idL, pwdL, nameL, phoneL, emailL, areaL;
    private JTextField idF, pwdF, nameF, phoneF, emailF, areaF;
 
    public Manager_MemberInfo() {
        setLayout(null);
       
            //JButton
            updateBtn = new JButton("����");
            updateBtn.setBounds(30, 390, 130, 35);
            exitBtn = new JButton("����");
            exitBtn.setBounds(190, 390, 130, 35);
            
            //JLabel
            idL = new JLabel("���̵�");
            idL.setBounds(40,40, 80, 35);
            pwdL = new JLabel("��й�ȣ");
            pwdL.setBounds(40,95, 80, 35);
            nameL = new JLabel("�̸�");
            nameL.setBounds(40,150, 80, 35);
            phoneL = new JLabel("����ó");
            phoneL.setBounds(40,205, 100, 35);
            emailL = new JLabel("�̸���");
            emailL.setBounds(40,260, 80, 35);
            areaL = new JLabel("��������");
            areaL.setBounds(40,315, 80, 35);
            
            
            //JTextField
            idF = new JTextField();
            idF.setBounds(130, 40, 180, 35);
            pwdF = new JTextField();
            pwdF.setBounds(130, 95, 180, 35);
            nameF = new JTextField();
            nameF.setEnabled(false);
            nameF.setBounds(130, 150, 180, 35);
            phoneF = new JTextField();
            phoneF.setEnabled(false);
            phoneF.setBounds(130, 205, 180, 35);
            emailF = new JTextField();
            emailF.setEnabled(false);
            emailF.setBounds(130, 260, 180, 35);
            areaF = new JTextField();
            areaF.setEnabled(false);
            areaF.setBounds(130, 315, 180, 35);
            
            Container c = getContentPane();
            c.add(updateBtn);
            c.add(exitBtn);
            c.add(idL);
            c.add(pwdL);
            c.add(nameL);
            c.add(phoneL);
            c.add(emailL);
            c.add(areaL);
            c.add(idF);
            c.add(pwdF);
            c.add(nameF);
            c.add(phoneF);
            c.add(emailF);
            c.add(areaF);
            //add("Center", c);
            
            setTitle("ȸ��������");
            setSize(350, 500);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            //�̺�Ʈ
            exitBtn.addActionListener(this);
            updateBtn.addActionListener(this);
 
    }// MemberInfo()
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            setVisible(false);
        } else if (e.getSource() == updateBtn) {
            int choice = JOptionPane.showConfirmDialog(this, "ȸ�������� �����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
                    setVisible(false);
                }
            } else if (choice == JOptionPane.NO_OPTION) {
                setVisible(false);
            }
        } // updateBtn
    }
}