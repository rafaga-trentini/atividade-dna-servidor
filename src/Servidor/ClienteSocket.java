package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner entrada = new Scanner(System.in);
		
		String texto = "";
		
		Socket cliente = null;
		
		PrintStream saida= null;
		
		ObjectInputStream comando = null;
		
		try {
			
			while(true) {
				texto = entrada.nextLine();
				
				if (texto.equalsIgnoreCase("exit")) {
	                break;
	            }
				cliente = new Socket("127.0.0.1",7000);
				saida = new PrintStream(cliente.getOutputStream());
				comando = new ObjectInputStream(cliente.getInputStream());
				System.out.println(comando.readObject());
				
				if (texto.toLowerCase().contains("new")) {
					comando = new ObjectInputStream(cliente.getInputStream());
	                String message = (String) comando.readObject();
	                System.out.println("Message: " + message);
	            }
			}
		} catch (IOException e) {
			System.out.println("Algo errado aconteceu");
		}
	}

}
