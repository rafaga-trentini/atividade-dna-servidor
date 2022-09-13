package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Notify implements IComando {
    
	private Map<String, Thread> storage;
	private String nome;
	private Socket conexao;
	ObjectOutputStream saida = null;

    public Notify(String nome, Socket conexao) {
        this.nome = nome;
        this.conexao = conexao;
    }

    @Override
    public void execute() {
    	try {
			saida = new ObjectOutputStream(conexao.getOutputStream());
			try{
	        	
	            Thread thread = this.storage.get(nome);
	            synchronized (thread){
	                thread.notify();
	            }
	            saida.writeObject("Resumindo thread "+nome);
	        }catch (NullPointerException e){
	        	saida.writeObject("Thread ["+ nome + "] inexistente.");
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public boolean addThread(String name, Thread thread) {
    	this.storage = new ConcurrentHashMap<>();
    	if (this.storage.get(name) != null) {
            return false;
        }
        this.storage.put(name, thread);
        return true;
    }

}
