package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket2 {
	
	private static ServerSocket servidor = null;
	
	private static int porta = 7000;
	
	public static void main (String[] args) throws IOException {
		servidor = new ServerSocket(porta);
		try {
			while (true) {
				Socket socket = servidor.accept();
				 new Thread(new ThreadConnection(socket)).start();
			}
		} catch (IOException e) {
			System.out.println("Algo errado aconteceu");
		} finally {
			servidor.close();
		}
		
	}
	
}
