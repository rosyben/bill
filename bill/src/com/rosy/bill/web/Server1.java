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
 * 2012-6-17 下午11:06:59
 */
package com.rosy.bill.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.rosy.bill.utils.DateUtils;

public class Server1 extends ServerSocket {
	private static final int SERVER_PORT = 10000;
    
	public Server1() throws IOException {
		super(SERVER_PORT);

		try {
			while (true) {
				Socket socket = accept();
				new CreateServerThread(socket);
			}
		} catch (IOException e) {
		} finally {
			close();
		}
	}

	// --- CreateServerThread
	class CreateServerThread extends Thread {
		private Socket client;
		private BufferedReader in;
		private PrintWriter out;

		public CreateServerThread(Socket s) throws IOException {
			client = s;

			in = new BufferedReader(new InputStreamReader(
					client.getInputStream(), "GB2312"));
			out = new PrintWriter(client.getOutputStream(), true);
			out.println("--- Welcome ---");
			start();
		}

		public void run() {
			try {
				String line = in.readLine();

				while (!line.equals("bye")) {
					String msg = createMessage(line);
					out.println(msg);
					line = in.readLine();
				}
				out.println("--- See you, bye! ---");
				client.close();
			} catch (IOException e) {
			}
		}

		private String createMessage(String line) {
			return  DateUtils.convertNowToString(new Date(System.currentTimeMillis())) + "====" + line;
		}
	}

	public static void main(String[] args) throws IOException {
		new Server1();
	}
}