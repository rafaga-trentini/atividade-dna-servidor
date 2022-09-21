package Servidor;

import java.io.IOException;
import java.net.Socket;

public class Comando {

    public IComando execute(String texto, String info, Socket conexao) throws IOException {
    	switch (texto) {
			case "sleep": {
				return new Sleep(info, conexao);
			}
			case "wait": {
				return new Wait(info);
			}
			case "notify": {
				return new Notify(info, conexao);
			}
			case "new": {
				return new New(info, conexao);
			}
			default:
				return null;
		}
    }
}
