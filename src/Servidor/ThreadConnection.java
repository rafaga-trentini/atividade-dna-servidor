package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadConnection implements Runnable{
	
	Socket conexao;
	BufferedReader entrada = null;
	
	public ThreadConnection(Socket conexao) {
		this.conexao = conexao;
	}


	@Override
	public void run() {
		try {
			
			entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			do {
				String texto = entrada.readLine();
				if (texto == null) {
					break;
				}
				Thread dnaThread = new Thread(new atividadeDNAThread(texto, conexao));
				dnaThread.start();
			}while(!"sair".equals(entrada.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
