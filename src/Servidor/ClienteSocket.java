package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteSocket {

//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Scanner entrada = new Scanner(System.in);
//		
//		String texto = "";
//		
//		Socket cliente = null;
//		
//		PrintStream saida= null;
//		
//		ObjectInputStream comando = null;
//		
//		try {
//			
//			while(true) {
//				texto = entrada.nextLine();
//				
//				if (texto.equalsIgnoreCase("exit")) {
//	                break;
//	            }
//				cliente = new Socket("127.0.0.1",7000);
//				saida = new PrintStream(cliente.getOutputStream());
//				comando = new ObjectInputStream(cliente.getInputStream());
//				System.out.println(comando.readObject());
//				
//				if (texto.toLowerCase().contains("new")) {
//					comando = new ObjectInputStream(cliente.getInputStream());
//	                String message = (String) comando.readObject();
//	                System.out.println("Message: " + message);
//	            }
//			}
//		} catch (IOException e) {
//			System.out.println("Algo errado aconteceu");
//		}
//	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Socket socket;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        List<String> command = new ArrayList<String>();
        while (true) {
            System.out.println("Entre com o comando (sleep, new, wait, notify): ");
            command.add(scanner.nextLine());
            if (command.get(0).equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Informe a info:");
            command.add(scanner.nextLine());
            
            socket = new Socket("127.0.0.1",7000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            oos.writeObject(command);
            
            if (command.get(0).toLowerCase().contains("new")) {
                ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Dna complementar: " + ois.readObject());
            }
        }
        assert oos != null;
        oos.close();
        ois.close();
    }

}
