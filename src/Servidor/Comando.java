package Servidor;

public class Comando {
    
    public IComando comando;

    public Comando (IComando comando) {
        this.comando = comando;
    }

    public void execute() {
        this.comando.execute();
    }
}
