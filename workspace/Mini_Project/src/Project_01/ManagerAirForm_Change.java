package Project_01;					//�̹̾�

import javax.swing.*; 
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManagerAirForm_Change extends JFrame {
    private JTextField plane, code, start, arrival, date, stime, atime, price, total;
    private JButton inputBtn, changeBtn, cancelBtn;
    private JLabel planeL, codeL, startL, arrivalL, dateL, stimeL, atimeL, priceL, totalL;
   
    public ManagerAirForm_Change() {
         
        planeL = new JLabel("�װ���");
        plane = new JTextField(15);
        add(planeL);
        add(plane);
        planeL.setBounds(60, 15, 80, 35);
        plane.setBounds(120, 15, 160, 35);
        
        codeL = new JLabel("������ڵ�");
        code = new JTextField(15);
        add(codeL);
        add(code);
        codeL.setBounds(50, 60, 80, 35);
        code.setBounds(120, 60, 160, 35);
        
        startL = new JLabel("�����");
        start = new JTextField(15);     
        add(startL);
        add(start);
        startL.setBounds(60, 105, 80, 35);
        start.setBounds(120, 105, 160, 35);
        
        arrivalL = new JLabel("������");
        arrival = new JTextField(15);
        add(arrivalL);
        add(arrival);
        arrivalL.setBounds(60, 150, 80, 35);
        arrival.setBounds(120, 150, 160, 35);
            
        dateL = new JLabel("��¥");
        date = new JTextField(15);
        add(dateL);
        add(date);
        dateL.setBounds(60, 195, 80, 35);
        date.setBounds(120, 195, 160, 35);
             
        stimeL = new JLabel("��߽ð�");
        stime = new JTextField(15);
        add(stimeL);
        add(stime);
        stimeL.setBounds(60, 240, 80, 35);
        stime.setBounds(120, 240, 160, 35);
              
        atimeL = new JLabel("�����ð�");
        atime = new JTextField(15);
        add(atimeL);
        add(atime);
        atimeL.setBounds(60, 285, 80, 35);
        atime.setBounds(120, 285, 160, 35);
      
        priceL = new JLabel("����");
        price = new JTextField(15);
        add(priceL);
        add(price);
        priceL.setBounds(60, 330, 80, 35);
        price.setBounds(120, 330, 160, 35);
        
        totalL = new JLabel("�� �¼���");
        total = new JTextField(15);
        add(totalL);
        add(total);
        totalL.setBounds(60, 375, 80, 35);
        total.setBounds(120, 375, 160, 35);
        
        changeBtn = new JButton("����");
        add(changeBtn);
        changeBtn.setBounds(50, 425, 110, 35);
        
        cancelBtn = new JButton("���");
        add(cancelBtn);
        cancelBtn.setBounds(190, 425, 110, 35);
        
        getContentPane().setBackground(Color.RED);
        setTitle("����");
        setResizable(false);
        setLayout( null );
        setSize(350,500);
        setVisible(true);
        setLocationRelativeTo(null);
    
    }
}