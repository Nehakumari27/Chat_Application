package com.chapApp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.chatApp.utils.Configreader;

public class Server {
	ServerSocket serversocket1;
	ArrayList<ServerWorker> workers=new ArrayList<>();      //contains all the client sockets
	public Server() throws IOException
	{
		int PORT=Integer.parseInt(Configreader.getValue("PORTNO"));
		serversocket1=new ServerSocket(PORT);
		System.out.println("Server Start and Waiting for the Clients to join...");
		handleclientrequest();
	}
	
	//multiple client handshaking
	public void handleclientrequest() throws IOException
	{
		while(true)
		{
		Socket socket1=serversocket1.accept();  //Handshaking
		//per client per thread
		ServerWorker serverworker1=new ServerWorker(socket1,this);    //creating a new worker/thread
		workers.add(serverworker1);
		serverworker1.start();
		}
	}
	
	
	/* For Single client
	public Server() throws IOException
	{
		int PORT=Integer.parseInt(Configreader.getValue("PORTNO"));
		serversocket1=new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the client Connection...");
		Socket socket1=serversocket1.accept();  //Handshaking
		System.out.println("Client joins the Server");
		InputStream in=socket1.getInputStream();  //read bytes from the network
		byte arr[]=in.readAllBytes();
		String str=new String(arr);//bytes convert to string
		System.out.println("Message Rec From the client  :-" + str);
		in.close();
		socket1.close();
	}*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Server server1=new Server();
	}

}
