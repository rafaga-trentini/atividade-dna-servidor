package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
				ObjectInputStream dna = new ObjectInputStream(cliente.getInputStream());
				System.out.println("DNA Complementar: " + dna.readObject());
			}while(!"sair".equals(texto));
		} catch (IOException e) {
			System.out.println("Algo errado aconteceu");
		} finally {
			cliente.close();
		}
	}

}
