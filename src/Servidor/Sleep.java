package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sleep implements IComando {
    
	private String delayTime;
	private Socket conexao;

	ObjectOutputStream saida = null;
	
	public Sleep(String delayTime, Socket conexao) {
        this.delayTime = delayTime;
        this.conexao = conexao;
    }
	
	@Override
    public void execute() {
		try {
			saida = new ObjectOutputStream(conexao.getOutputStream());
			int delay = this.getDelayTime();
	        saida.writeObject("Iniciando execu��o do comando Sleep com " + delay);
	        try {
				Thread.sleep(this.getDelayTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        saida.writeObject("Finalizado execu��o do comando Sleep com " + delay);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        }

    private int getDelayTime() {
        try {
            return Integer.parseInt(delayTime);
        } catch (RuntimeException e) {
            throw new RuntimeException("Comando sleep deve especificar um tempo de delay");
        }
    }

}
