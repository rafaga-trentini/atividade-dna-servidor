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
	private Comando comandos = new Comando();

	public ThreadConnection(Socket conexao) {
		this.conexao = conexao;
	}


	@Override
	public void run() {
		
		try {
			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			String texto = entrada.readLine();

			saida.writeObject("Informe a info");
			String info = entrada.readLine();
			
			IComando comandoInterface = this.comandos.execute(texto, info, conexao);
			comandoInterface.execute();
			
			if (!(comandoInterface instanceof New)) {
                this.conexao.close();
                entrada.close();
                saida.close();
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
