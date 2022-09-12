package Servidor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Wait implements IComando {
    
	
	private Map<String, Thread> storage;
	private String nome;

    public Wait(String nome) {
        this.nome = nome;
    }

    @Override
    public void execute() {
        if(this.storage.containsKey(nome) &&
                this.storage.get(nome).getState().equals(Thread.State.WAITING)){
            throw new RuntimeException("Thread [" + nome + "] já está em estado de espera");
        }
        var t = new WaitThread(nome);
        addThread(nome, t);
        t.start();
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
