package bit0506;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;

	public ChatClientObject() {
		setTitle("ChatClient");

		output = new JTextArea();
		output.setFont(new Font("����ü", Font.BOLD, 20));
		output.setEditable(false);
		input = new JTextField();
		sendBtn = new JButton("������");

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add("Center", input);
		panel.add("East", sendBtn);

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		Container container = this.getContentPane();
		container.add("Center", scroll);
		container.add("South", panel);

		setBounds(400, 150, 300, 300);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				InfoDTO infoDTO = new InfoDTO();
				infoDTO.setCommand(Info.EXIT);
				try {
					writer.writeObject(infoDTO);
					writer.flush();
				} catch (IOException ee) {
					ee.printStackTrace();
				}
			}
		});
	}

	public void service() {
		// ����IP �Է� �ޱ�
		// String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "����IP",
		// JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���", "192.168.0.143");
		if (serverIP == null || serverIP.length() == 0) {
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�.");
			System.exit(0);
		}

		// �г��� �ޱ�
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���.", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}

		// ���ϻ���
		try {
			socket = new Socket(serverIP, 9500);
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		}

		// ������ �г��� ������
		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setCommand(Info.JOIN);
		infoDTO.setNickName(nickName);
		try {
			writer.writeObject(infoDTO);
			writer.flush();
		} catch (IOException ee) {
			ee.printStackTrace();
		}

		// ������ ����
		Thread t = new Thread(this);
		t.start();

		input.addActionListener(this);
		sendBtn.addActionListener(this);
	}

	@Override
	public void run() {
		// �����κ��� �ޱ�
		InfoDTO infoDTO = null;
		while (true) {
			try {
				infoDTO = (InfoDTO) reader.readObject();
				if (infoDTO.getCommand() == Info.EXIT) {
					reader.close();
					writer.close();
					socket.close();
					System.exit(0);
				} else if (infoDTO.getCommand() == Info.SEND) {
					output.append(infoDTO.getMessage() + "\n");
					int pos = output.getText().length(); // ��ũ�� �ڵ�
					output.setCaretPosition(pos);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} // while
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ������ ������
		String data;
		data = input.getText();
		InfoDTO infoDTO = new InfoDTO();
		if (data.equals("exit")) {
			infoDTO.setCommand(Info.EXIT);
		} else {
			infoDTO.setCommand(Info.SEND);
			infoDTO.setMessage(data);
		}
		try {
			writer.writeObject(infoDTO);
			writer.flush();
		} catch (IOException ee) {
			ee.printStackTrace();
		}
		input.setText("");
	}

	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
