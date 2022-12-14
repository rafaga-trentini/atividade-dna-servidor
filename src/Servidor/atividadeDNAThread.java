package Servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atividadeDNAThread implements Runnable{
	
	String str;
	Socket conexao;
	
	public atividadeDNAThread(String str, Socket conexao) {
		this.str = str;
		this.conexao = conexao;
	}
	
	@Override
	public void run() {
		
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
	   this.str = resultadoDnaComplementar;
		try {
			ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
			saida.writeObject(this.str);
		} catch (IOException e) {
			e.printStackTrace();
		}

	   Thread.currentThread();
	   Thread.yield();
		
		
	}

	public String getStr() {
		return str;
	}
	
}
