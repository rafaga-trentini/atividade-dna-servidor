package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadConnection implements Runnable{
	
	BufferedReader entrada = null;
	ObjectOutputStream saida = null;
	private Socket conexao;

	public ThreadConnection(Socket conexao) {
		this.conexao = conexao;
	}


	@Override
	public void run() {
		
		try {
			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			do {
				String texto = entrada.readLine();
				if (texto == null) {
					break;
				}
				
				switch (texto) {
					case "sleep": {
						saida.writeObject("Informe o tempo a ser utilizado no sleep");
						String delayedTime = entrada.readLine();
						Sleep sleep = new Sleep(delayedTime, conexao);
						sleep.execute();
					}
					case "wait": {
						saida.writeObject("Informe o nome");
						String nome = entrada.readLine();
						Wait wait = new Wait(nome);
					}
					case "notify": {
						saida.writeObject("Informe o nome");
						String nome = entrada.readLine();
						Notify notify = new Notify(nome, conexao);
					}
					case "new": {
						saida.writeObject("Informe o dna");
						String dna = entrada.readLine();
						New newClasse = new New(dna, conexao);
						newClasse.execute();
					}
					default:
						saida.writeObject("Informe um dos seguintes comandos: -sleep\n-wait\n-notify\n-new\n-sair");
				}
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
