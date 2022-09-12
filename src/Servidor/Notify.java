package Servidor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Notify implements IComando {
    
	private Map<String, Thread> storage;
	private String nome;

    public Notify(String nome) {
        this.nome = nome;
    }

    @Override
    public void execute() {
        try{
            Thread thread = this.storage.get(nome);
            synchronized (thread){
                thread.notify();
            }
            System.out.println("Resumindo thread "+nome);
        }catch (NullPointerException e){
            System.out.println("Thread ["+ nome + "] inexistente.");
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
