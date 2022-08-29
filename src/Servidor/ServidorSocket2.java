package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket2 {
	
	public static void main (String[] args) throws IOException {
		
		ServerSocket servidor = null;
		
		Socket conexao = null;
		
		try {
			while (true) {
				servidor = new ServerSocket(7000);
				Thread minhaThread = new Thread(new ThreadConnection(servidor.accept()));
				minhaThread.start();
			}
		} catch (IOException e) {
			System.out.println("Algo errado aconteceu");
		} finally {
			servidor.close();
		}
		
	}
	
}
