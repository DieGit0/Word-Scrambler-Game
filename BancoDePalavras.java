import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BancoDePalavras {	
	
	private int qtdLinhas =0;
	
	public String getPalavra(){
	 // Quantidade de palavras no arquivo de texto = index.nextInt(5)
		palavra = listaPalavras.get(index.nextInt(qtdLinhas));
	    return palavra;
}	
	private ArrayList<String> listaPalavras = new ArrayList<String>();
	private String palavra      ="";
	private static Random index = new Random();{
	File file = new File("palavras.txt");

	try{
	    //file.createNewFile();
	    FileReader fread      = new FileReader(file);
	    BufferedReader frbuff = new BufferedReader(fread); 
	    String linha = frbuff.readLine();
	    
	    while(linha != null){
	      //System.out.println(linha);
	      //adiciono cada palavra a ArrayList
	       listaPalavras.add(linha);
	       linha = frbuff.readLine();
	       ++qtdLinhas;
	    }
	}
	catch(IOException e){
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
	finally{
		file.exists();		
	}	
	}
}