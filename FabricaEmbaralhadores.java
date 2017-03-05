
import java.util.Random;

public class FabricaEmbaralhadores{

	 static  Embaralhador    Embaralhador;
	 private static Random escolha = new Random();	
	
	public static Embaralhador getEmbaralhador() {
		 if(escolha.nextBoolean())
			 Embaralhador = new EmbaralhadorShuffle();
		 else
			 Embaralhador = new EmbaralhadorAfabetico();  
		 
		 return Embaralhador;
		 }	
}

