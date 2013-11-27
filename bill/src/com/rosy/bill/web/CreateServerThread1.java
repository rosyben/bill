/**
 * <P>CreateServerThread.java</P> 
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
 * 2012-6-17 下午11:12:57
 */
package com.rosy.bill.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * @author Ben
 *
 */
public class CreateServerThread1 extends Thread {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;

	public CreateServerThread1(Socket s) throws IOException {
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
		return " xxxxxxxxx";
	}
}
