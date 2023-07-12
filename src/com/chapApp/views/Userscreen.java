package com.chapApp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.chatApp.dao.userdao;
import com.chatApp.dto.userdto;
import com.chatApp.utils.UserInfo;

public class Userscreen  extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordtxt;
		
	public static void main(String[] args) {
		Userscreen window=new Userscreen();
	}
	
	userdao userdao1=new userdao();
	private void doLogin() throws Exception
	{
		String userid=useridtxt.getText();
		char[] password=passwordtxt.getPassword(); //password print in this way className@HashCode(in hexadecimal)we donot use gettext because it show the password to devloper
		//userdao userdao1=new userdao();
		userdto userdto1=new userdto(userid,password);
		try {
			String message="";
			if(userdao1.isLogin(userdto1))
			{
				message="Welcome " +userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashboard=new DashBoard(message);
				dashboard.setVisible(true);
			}
			else
			{
				message="Invalid Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			//JOptionPane.showMessageDialog(this, message);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{	
			e.printStackTrace();     //where is the Exception
		}
		
		
	}
	private void register()
	{
		String userid=useridtxt.getText();
		char[] password=passwordtxt.getPassword(); //password print in this way className@HashCode(in hexadecimal)we donot use gettext because it show the password to devloper
		//userdao userdao1=new userdao();
		userdto userdto1=new userdto(userid,password);
		try
		{
		    int result=userdao1.add(userdto1);
		    if(result>0)
		    {
		    	//System.out.println("Record Added...");
		    	JOptionPane.showMessageDialog(this, "Register SuccessFully");
		    }
		    else
		    {
		    	//System.out.println("Record not Added...");
		    	JOptionPane.showMessageDialog(this, "Register Failed");
		    }
		}
		catch(ClassNotFoundException |SQLException ex)
		{
			System.out.print("DB Issue...");
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Some Generic exception Raised...");
			ex.printStackTrace();     //where is the Exception
		}
		System.out.println("userid " + userid+"password" +password + " " +password.toString());
	}
	/**
	 * Create the application.
	 */
	public Userscreen() {
		setResizable(false);
		getContentPane().setBackground(new Color(241, 237, 218));
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("WeChat");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(401, 12, 186, 63);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Userscreen.class.getResource("/img/chat.png")));
		lblNewLabel_1.setBounds(357, 0, 48, 61);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(230, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon(Userscreen.class.getResource("/img/user.jpg")));
		lblNewLabel_2.setBounds(10, 10, 325, 387);
		getContentPane().add(lblNewLabel_2);
		
		JLabel Userid = new JLabel("UserId");
		Userid.setFont(new Font("Arial", Font.PLAIN, 24));
		Userid.setBounds(345, 118, 89, 22);
		getContentPane().add(Userid);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 19));
		password.setBounds(345, 173, 99, 22);
		getContentPane().add(password);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(469, 118, 118, 22);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(469, 177, 118, 22);
		getContentPane().add(passwordtxt);
		
		JButton btlogin = new JButton("Login");
		btlogin.setForeground(new Color(0, 0, 0));
		btlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					doLogin();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btlogin.setFont(new Font("Arial", Font.BOLD, 16));
		btlogin.setBounds(363, 255, 89, 32);
		getContentPane().add(btlogin);
		
		JButton btregister = new JButton("Register");
		btregister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btregister.setFont(new Font("Arial", Font.BOLD, 14));
		btregister.setBounds(488, 256, 99, 32);
		getContentPane().add(btregister);
		setTitle("Login");
		setSize(674, 444);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	

}
