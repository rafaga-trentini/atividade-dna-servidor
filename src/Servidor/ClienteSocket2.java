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

public class ClienteSocket2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Socket socket;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        while (true) {
        	List<String> command = new ArrayList<String>();
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
            
        }
        assert oos != null;
        oos.close();
        ois.close();
    }

}
