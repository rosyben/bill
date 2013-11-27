/**
 * <P>Client.java</P> 
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
 * 2012-6-17 下午10:21:41
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
public class Client {

	private Socket socket;

	private BufferedReader in;

	private PrintWriter out;

	public Client(String s) {
		try {
			socket = new Socket("192.168.1.2", 10000);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader line = new BufferedReader(new InputStreamReader(
					System.in));

			out.println(line.readLine());

			line.close();
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client("");
	}

}
