package Servidor;

import java.io.IOException;

public class Comando {
    
    public IComando comando;

    public Comando (IComando comando) {
        this.comando = comando;
    }

    public void execute() throws IOException {
        this.comando.execute();
    }
}
