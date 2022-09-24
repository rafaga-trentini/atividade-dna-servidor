package Servidor;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class New implements IComando {
    
	
	private final Socket socket;
	private final String dna;

    public New(String dna, Socket socket) {
        this.dna = dna;
        this.socket = socket;
    }
    
    
    @Override
    public void execute(){
    	new Thread(() -> {
            String result = dnaCompolementar(dna);
            Thread.currentThread();
     	   	Thread.yield();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(this.socket.getOutputStream());
                System.out.println(result);
                oos.writeObject(result);
                oos.close();
                this.socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ).start();
    }
    
    public String dnaCompolementar(String str) {
    	List<String> dnaComplementar = new ArrayList<String>();
 	   
 	   String line = str;
 	   line.toCharArray();
 	   for (int j=0; j<= line.length()-1; j++) {
 		   String dna = String.valueOf(line.charAt(j));
 		   if ( dna.equalsIgnoreCase("A")) {
 			   dnaComplementar.add("T");
 		   } else if (dna.equalsIgnoreCase("T")) {
 			   dnaComplementar.add("A");
 		   } else if (dna.equalsIgnoreCase("C")) {
 			   dnaComplementar.add("G");
 		   } else if (dna.equalsIgnoreCase("G")) {
 			   dnaComplementar.add("C");
 		   }
 	   }
 	   String resultadoDnaComplementar = "";
 	   resultadoDnaComplementar = String.join(resultadoDnaComplementar, dnaComplementar);
 	   return resultadoDnaComplementar;
 	  
    }

}
