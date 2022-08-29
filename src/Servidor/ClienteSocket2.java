package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket2 {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		
		String texto = "";
		
		Socket cliente = null;
		
		PrintStream saida= null;
		
		try {
			cliente = new Socket("127.0.0.1",7000);
			
			saida = new PrintStream(cliente.getOutputStream());
			
			
			do {
				texto = entrada.nextLine();
				saida.println(texto);
				
			}while(!"sair".equals(texto));
		} catch (IOException e) {
			System.out.println("Algo errado aconteceu");
		} finally {
			cliente.close();
		}
	}

}
