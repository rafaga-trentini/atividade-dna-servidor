package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

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
			
			ObjectInputStream ois = new ObjectInputStream(this.conexao.getInputStream());
            List<String> texto = (List<String>) ois.readObject();
			
			IComando comandoInterface = this.comandos.execute(texto.get(0), texto.get(1), conexao);
			comandoInterface.execute();
			
			if (!(comandoInterface instanceof New)) {
                this.conexao.close();
                entrada.close();
                saida.close();
            }
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
