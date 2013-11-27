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
 * 2012-6-17 下午09:57:29
 */
package com.rosy.bill.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Ben
 * 
 */
public class ServerSingle {

	private static final int SERVER_PORT = 10000;

	private ServerSocket ss;

	private Socket socket;

	private BufferedReader in;

	private PrintWriter out;

	public ServerSingle() {
		try {
			ss = new ServerSocket(10000);

			while (true) {
				socket = ss.accept();
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream());

				String line = in.readLine();
				out.println("you input is:" + line);
				System.out.println("you input is a: " + line);
				out.close();
				in.close();
				socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (ss != null)
				ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerSingle();
	}

}
