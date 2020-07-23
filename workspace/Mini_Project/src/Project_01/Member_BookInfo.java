package Project_01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Member_BookInfo extends JFrame implements ActionListener{
	private JButton bookBtn, exitBtn, bkDetailBtn, editBtn, logOutBtn ;
	private JLabel myInfoL, nameL, idL, pwdL, phoneL, addressL;
	private JTextField departureS, arrivalS, dateS, idT, pwdT, nameT,  phoneT, addressT;
	private JPanel bookP, myInfo;
	private JTabbedPane sideTab;
	private Vector<String> airline;
    private DefaultTableModel model;
    private JTable aTable;

	public Member_BookInfo(){
        setLayout(null);
//MAIN ========
		//Vector ------------------------------------------
		airline = new Vector<String>();
		airline.add("�װ���");
		airline.add("������ڵ�");
		airline.add("�����");
		airline.add("������");
		airline.add("��¥");
		airline.add("��߽ð�");
		airline.add("�����ð�");
		airline.add("�� �¼� ��");
        model = new DefaultTableModel(airline, 0){
            public boolean isCellEditable(int r, int c){ //model���׸� ������ -> �͸�Ŭ������ �־ 
                return false; 
            }
        };
        aTable = new JTable(model);
        JScrollPane aMain = new JScrollPane(aTable);
        aMain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aMain.setBounds(5, 7, 730, 560);
        //------------------------------------------ Vector
//======== MAIN

//SIDE ========
//Tab 1 --------------------------------------------
        //SearchField
        bookP = new JPanel();
        bookP.setLayout(null);
        
        JLabel search = new JLabel("�װ� �˻�");
        search.setFont(new Font("�������ü", Font.BOLD, 16));
        search.setBounds(90, 5, 120, 35);
        
        JLabel departure = new JLabel("�����");
        departure.setBounds(14, 50, 120, 35);
        departureS = new JTextField();
        departureS.setBounds(14, 85, 220, 35);
        
        JLabel arrival = new JLabel("������");
        arrival.setBounds(14, 125, 220, 35 );
        arrivalS = new JTextField();
        arrivalS.setBounds(14, 155, 220, 35);
        
        JLabel date = new JLabel("��¥");
        date.setBounds(14, 195, 220, 35);
        
        bookBtn = new JButton("�����ϱ�");
        bookBtn.setBounds(14, 428, 220, 35);
        exitBtn = new JButton("����");
        exitBtn.setBounds(14, 482, 220, 35);
        
        bookP.add(search);
        bookP.add(departure);
        bookP.add(departureS);
        bookP.add(arrival);
        bookP.add(arrivalS);
        bookP.add(date);
        
        bookP.add(bookBtn);
        bookP.add(exitBtn);

//-------------------------------------------- Tab 1
        
//Tab 2 --------------------------------------------
        //myInfo ------------------------------------------
        myInfo = new JPanel();
        myInfo.setLayout(null);

        myInfoL = new JLabel("���� ����");
        myInfoL.setFont(new Font("�������ü", Font.BOLD, 16));
        myInfoL.setBounds(90, 5, 120, 35);

        idL = new JLabel("���̵�");
        idL.setBounds(14, 50, 35, 30);
        idT = new JTextField(17);
        idT.setEditable(false);
        idT.setBounds(14, 75, 220, 30);
 
        pwdL = new JLabel("��й�ȣ");
        pwdL.setBounds(14, 105, 45, 30);
        pwdT = new JTextField(17);
        pwdT.setEditable(false);
        pwdT.setBounds(14, 130, 220, 30);

        nameL = new JLabel("�̸�");
        nameL.setBounds(14, 160, 25, 30);
        nameT = new JTextField(17);
        nameT.setEditable(false);
        nameT.setBounds(14, 185, 220, 30);
        
        phoneL = new JLabel("����ó");
        phoneL.setBounds(14, 215, 45, 30);
        phoneT = new JTextField(17);
        phoneT.setEditable(false);
        phoneT.setBounds(14, 240, 220, 30);
        
        addressL = new JLabel("�ּ�");
        addressL.setBounds(14, 270, 25, 30);
        addressT = new JTextField(17);
        addressT.setEditable(false);
        addressT.setBounds(14, 295, 220, 30);
        
        bkDetailBtn = new JButton("����Ȯ��");
        bkDetailBtn.setBounds(14, 410, 110, 65);
        editBtn = new JButton("����");
        editBtn.setBounds(130, 410, 110, 65);
        
        logOutBtn = new JButton("�α׾ƿ�");
        logOutBtn.setBounds(14, 482, 220, 35);
 
        myInfo.add(myInfoL);
        myInfo.add(idL); myInfo.add(idT);
        myInfo.add(pwdL); myInfo.add(pwdT);
        myInfo.add(nameL); myInfo.add(nameT);
        myInfo.add(phoneL); myInfo.add(phoneT);
        myInfo.add(addressL); myInfo.add(addressT);

        myInfo.add(bkDetailBtn); myInfo.add(editBtn);
        myInfo.add(logOutBtn);

        //------------------------------------------ myInfo
        
//-------------------------------------------- Tab 2

        //JTabbedPane
        sideTab = new JTabbedPane(SwingConstants.TOP);
        sideTab.setBounds(740, 4, 250, 563);
        sideTab.addTab("    �˻�    ", bookP);
        sideTab.addTab("  MyPage  ", myInfo);

//======== SIDE

        //Container
        Container c = getContentPane();
        add(aMain);
        add(sideTab);

        getContentPane().setBackground(Color.RED);
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void event() {
		editBtn.addActionListener(this);
		bookBtn.addActionListener(this);
		bkDetailBtn.addActionListener(this);
		logOutBtn.addActionListener(this);
	}

	//ActionListener Override
    @Override
    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == editBtn) {
    		String id = idT.getText();
    		String pwd = pwdT.getText();
    		String name = nameT.getText();
    		String phone = phoneT.getText();
    		String address = addressT.getText();
    		
			new Member_InfoEdit(id, pwd, name, phone, address);
    	}else if(e.getSource() == bookBtn) {
    		//new BookingP();
    	}else if(e.getSource() == bkDetailBtn) {
    		//new BookDetail();
    	}else if(e.getSource() == exitBtn) {
    		
    	}else if(e.getSource() == logOutBtn) {
    		
    	}
    }
}