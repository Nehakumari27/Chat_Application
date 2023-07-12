package com.chapApp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*Thread==Worker
 worker need a job to perform
 For job u give runnable
 Once job is created via Runnable so write the job logic inside a run function
 Assign the job to a thread/worker*/
 
public class ServerWorker extends Thread
{
	private Socket socket1;    //socket1 is clientsocket
	private InputStream in;
	private OutputStream out;
	private Server server1;
	public ServerWorker(Socket socket1,Server server1) throws IOException
	{
		this.server1=server1;
		this.socket1=socket1;
		in=socket1.getInputStream();  //client data read
		out=socket1.getOutputStream();  //client data write
		System.out.println("New Client Comes");
		
	}
	
	@Override
	public void run()
	{
		//Read Data from the client and broadcast the data to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line;
		try
		{
			while(true)
			{
				line=br.readLine();
				System.out.println("Line Read..." +line);
				if(line.equalsIgnoreCase("quit"))
					{
					        break;   //client chat end
					}
				//out.write(line.getBytes());    //client send
				
			    //broadcast to all clients
				for(ServerWorker serverworker:server1.workers)
				{
					line=line + "\n";
					serverworker.out.write(line.getBytes());
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(br!=null)
					br.close();
				if(in!=null)
					in.close();
				if(out!=null)
					out.close();
				if(socket1!=null)
				{
					socket1.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
























































//for understanding purpose

//public class ServerWorker implements Runnable{
 /*public class ServerWorker extends Thread{
	@Override
	public void run()
	{
		//job to perform
		//logic
		for(int i=1;i<=5;i++)
		{
			System.out.println("Run I is "+i+" "+Thread.currentThread());
			try {
			    Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		//ServerWorker job=new ServerWorker();
		    //Assign the job to a thread/worker
		//Thread worker=new Thread(job,"worker1");
		//worker.start();   //Internally it call run()
		ServerWorker worker=new ServerWorker();
		worker.start();
		for(int j=1;j<=5;j++)
		{
			System.out.println("Main "+j +" "+Thread.currentThread());
		}
	}

}*/
