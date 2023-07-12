package com.chapApp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Userview extends JFrame{
	public Userview() //constructor
	{
		setSize(500,500);   //window ka size agar x ko badhaye to horizontal and y-vertikal badhe ga 
		setLocationRelativeTo(null);  //ye desktop per middle me rakhta hai
		//setLocation(100,50);  //ye batata hai ki desktop per kaha hai window
		setVisible(true);  //ye dikhata hai window ko user ko
		setResizable(false); //ye mamimize ka option hata deta hai
		setTitle("Login");
		
		JLabel welcome=new JLabel("Login");  //it will so welcome in window
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		
		Container container=this.getContentPane(); //like div default layout(border layout-center)
		container.setLayout(null);  //so,to off default layout
		welcome.setBounds(100,70,200,60);   //(x,y,width,height)
		container.add(welcome);
		
		JButton button=new JButton("Count");
	    button.addActionListener(new ActionListener(){ //Aanlomous class
	    	@Override
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		
	    	}
	    });
	    
		button.setBounds(100,300,200,50);
		container.add(button);
	}
	
	public static void main(String args[])
	{
		Userview userlook=new Userview();
		
	}
	
	
}
