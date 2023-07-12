package com.chapApp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.chatApp.utils.Configreader;

public class Client {
	Socket socket1;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException
	{
		int PORT=Integer.parseInt(Configreader.getValue("PORTNO"));
		socket1=new Socket(Configreader.getValue("SERVER_IP"),PORT);
		out=socket1.getOutputStream();
		in=socket1.getInputStream();
		this.textArea=textArea;
		readMessages();
		
		
		/*System.out.println("Client Comes");
		System.out.println("Enter the Message Send to the Server.....");
		Scanner scanner=new Scanner(System.in);
		String message=scanner.nextLine();
		OutputStream out=socket1.getOutputStream();
		out.write(message.getBytes());
		System.out.println("Message Send to Server");
		out.close();
		socket1.close();*/
	}
	
	public void sendMessage(String message) throws IOException
	{
		message=message + "\n";
		out.write(message.getBytes());
	}

	public void readMessages()
	{
		worker =new ClientWorker(in,textArea);  //calling a read thread
		worker.start();
	}
	/*public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
          Client client1=new Client();
	}*/

}
