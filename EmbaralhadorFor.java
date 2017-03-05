import java.util.ArrayList;
import java.util.Random;

public class EmbaralhadorFor implements Embaralhador {
	
	private String palavra;
	//DIEGO = I

	@Override
	//Logica For com geração de indice randomico para cara iteração
	public String embaralha(String palavra) {
		StringBuilder palavraEmbaralhada = new StringBuilder();
		int palavraTamanho = palavra.length();
		Random index       = new Random();
		for(int letra=0;letra < palavraTamanho;){
			posChar =  index.nextInt(palavraTamanho);
			if(naoRepeteIndice(posChar)){
			    palavraEmbaralhada.insert(letra, palavra.charAt(posChar));
			    letra++;
			}
			else{
				posChar = index.nextInt(palavraTamanho);
			}			    	
		}
		return palavraEmbaralhada.toString();
	}
	
	private int posChar;
	// Controle de indices repetidos sorteados pelo Random()
	private ArrayList<Integer> arrayDeIndices = new ArrayList<Integer>();
	public boolean naoRepeteIndice(int indice){
		//System.out.println(arrayDeIndices.toString());
		//System.out.println("Índice: " + indice);
		if(arrayDeIndices.contains(indice)){
			  return false;
			 }
		else{
			  arrayDeIndices.add(indice);
		      return true;
		      }
	}

}


