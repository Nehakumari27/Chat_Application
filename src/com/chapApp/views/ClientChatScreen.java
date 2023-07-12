package com.chapApp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.chapApp.network.Client;
import com.chatApp.utils.UserInfo;
import java.awt.Color;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField textField;
	private Client client;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args){
		
			try {
				ClientChatScreen frame = new ClientChatScreen();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void sendIt()
	{
		String message=textField.getText();
		try
		{
			client.sendMessage(UserInfo.USER_NAME+" - "+message);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea=new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		client=new Client(textArea);
		setTitle("WeChat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 580, 300);
		contentPane.add(scrollPane);
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 348, 421, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		setVisible(true);
		
		JButton send_button = new JButton("Send ");
		send_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		send_button.setFont(new Font("Arial", Font.BOLD, 17));
		send_button.setBounds(466, 347, 135, 38);
		contentPane.add(send_button);
		setVisible(true);
	}
}
