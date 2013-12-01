/**
 * <P>Server.java</P> 
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: Rosy</p>
 *
 * @author Ben
 * @version 1.0
 * 2012-6-17 下午11:33:48
 */
package com.rosy.bill.web;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * @author Ben
 * 
 */
public class Server extends ServerSocket {

	@SuppressWarnings("rawtypes")
	private static ArrayList User_List = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static ArrayList Threader = new ArrayList();
	@SuppressWarnings("rawtypes")
	private static LinkedList Message_Array = new LinkedList();
	private static int Thread_Counter = 0;
	private static boolean isClear = true;
	protected static final int SERVER_PORT = 10000;
	protected FileOutputStream LOG_FILE = new FileOutputStream(
			"d:/connect.log", true);

	/**
	 * @throws IOException
	 */
	public Server() throws IOException {
		super(SERVER_PORT);

		new Broadcast();

		// append connection log
		Calendar now = Calendar.getInstance();
		String str = "[" + now.getTime().toString()
				+ "] Accepted a connection\015\012";
		byte[] tmp = str.getBytes();
		LOG_FILE.write(tmp);

		try {
			while (true) {
				Socket socket = accept();
				new CreateServerThread(socket);
			}
		} finally {
			close();
		}
	}

	// --- Broadcast
	class Broadcast extends Thread {

		public Broadcast() {
			start();
		}

		public void run() {
			while (true) {
				if (!isClear) {
					String tmp = (String) Message_Array.getFirst();

					for (int i = 0; i < Threader.size(); i++) {
						CreateServerThread client = (CreateServerThread) Threader
								.get(i);
						client.sendMessage(tmp);
					}

				}

				Message_Array.removeFirst();
				isClear = Message_Array.size() > 0 ? false : true;
			}
		}
	}

	// --- CreateServerThread
	class CreateServerThread extends Thread {
		private Socket client;
		private BufferedReader in;
		private PrintWriter out;
		private String Username;

		public CreateServerThread(Socket s) throws IOException {
			client = s;
			in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			out.println("--- Welcome to this chatroom ---");
			out.println("Input your nickname:");
			start();
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}

		@SuppressWarnings("unchecked")
		public void run() {
			try {
				int flag = 0;
				Thread_Counter++;
				String line = in.readLine();

				while (!line.equals("bye")) {
					if (line.equals("l")) {
						out.println(listOnlineUsers());
						line = in.readLine();
						continue;
					}

					if (flag++ == 0) {
						Username = line;
						User_List.add(Username);
						out.println(listOnlineUsers());
						Threader.add(this);
						pushMessage("[< " + Username + " come on in >]");
					} else {
						pushMessage("<" + Username + ">" + line);
					}

					line = in.readLine();
				}

				out.println("--- See you, bye! ---");
				client.close();
			} catch (IOException e) {
			} finally {
				try {
					client.close();
				} catch (IOException e) {
				}

				Thread_Counter--;
				Threader.remove(this);
				User_List.remove(Username);
				pushMessage("[< " + Username + " left>]");
			}
		}

		private String listOnlineUsers() {
			String s = "-+- Online list -+-\015\012";

			for (int i = 0; i < User_List.size(); i++) {
				s += "[" + User_List.get(i) + "]\015\012";
			}

			s += "-+---------------------+-";
			return s;
		}

		@SuppressWarnings("unchecked")
		private void pushMessage(String msg) {
			Message_Array.addLast(msg);
			isClear = false;
		}
	}

	public static void main(String[] args) throws IOException {

		String url="JDBC:jtds:sqlserver://localhost:1433/master"; 
		String driver="net.sourceforge.jtds.jdbc.Driver"; 
		try {
		Class.forName(driver); 
		Connection conn=DriverManager.getConnection(url,"sa","System_sa_20111212");
		if (conn.isClosed()== true) 
		  System.out.println("SomeThing goes wrong");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("SomeThing  wrong");
		System.out.println(e);
		//e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	}

}
