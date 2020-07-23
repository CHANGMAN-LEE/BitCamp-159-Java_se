package Project_01;					//�̹̾�

import javax.swing.*; 
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerAirForm_ extends JFrame implements ActionListener {
    private JButton inputBtn, changeBtn,  deleteBtn, exitBtn;
    private JTable table;
    private JLabel managerL, imgL;
    private ImageIcon image1;
    
    public ManagerAirForm_() {
        
        managerL = new JLabel("O O O ������ �� �α���");
        
        image1 = new ImageIcon("lion.jpg");
        imgL = new JLabel(image1);
   
        inputBtn = new JButton("���");
        changeBtn = new JButton("����");
        deleteBtn = new JButton("����");
        exitBtn = new JButton("����");
        
        add(managerL);
        managerL.setBounds(800, 20, 220, 35);
        
        add(imgL);
        imgL.setBounds(750, 70, 220, 220);
        
        add(inputBtn);
        inputBtn.setBounds(755, 380, 220, 35);
        
        add(changeBtn);
        changeBtn.setBounds(755, 420, 220, 35);
        
        add(deleteBtn);
        deleteBtn.setBounds(755, 460, 220, 35);
        
        add(exitBtn);
        exitBtn.setBounds(755, 500, 220, 35);
               
        String header[] = {"�װ���","������ڵ�","�����","������","��¥","��߽ð�","�����ð�","����","�� �¼���"};
        String contents[][] = {};
        table = new JTable (contents,header);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(5, 7, 730, 560);
        add(scroll);
        
        Container c = getContentPane();
        c.add("Center",scroll);
        
        getContentPane().setBackground(Color.RED);
        setTitle("�װ��� ����");
        setSize(1000,600);
        setLayout( null );
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        
        
        inputBtn.addActionListener(this); 
        changeBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    
    }
    
    public void actionPerformed(ActionEvent e) {   
        
        if(e.getSource() == inputBtn) {
            new ManagerAirForm_Input();  
          
        } else if (e.getSource() == changeBtn) {
            new ManagerAirForm_Change(); 
            
        }else if (e.getSource() == deleteBtn) { 
            String code;
            code = JOptionPane.showInputDialog(null,"���� �ϰڽ��ϱ�?","����",JOptionPane.INFORMATION_MESSAGE);
            
        } else if (e.getSource() == exitBtn) {
           
           JOptionPane.showConfirmDialog(null, "�α׾ƿ� �Ͻðڽ��ϱ�?","�α׾ƿ�",JOptionPane.YES_NO_OPTION);
            
        } 
        
    }
}
