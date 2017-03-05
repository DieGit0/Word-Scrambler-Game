	
public class EmbaralhadorParImpar implements Embaralhador{
		
		//palavra = "BANANA";
		//BANANA = ABANAN
	    //DIEGO  = IDGEO
		@Override
		//Troca indice Par por Impar
		public String embaralha(String palavra) {
			palavra = "DIEGOM";
			//         012345 
			int palavraTamanho = palavra.length();
			System.out.println("LENGHT "+ palavraTamanho);
			StringBuilder palavraEmbaralhada = new StringBuilder(palavraTamanho);			

			for(int indice=0;indice<palavraTamanho;indice++){
				if(indice % 2 == 0){
					System.out.println("indice par "+ indice);
					System.out.println("ch "+ palavra.charAt(indice));
					indice =(indice == palavraTamanho-1)? indice-1:indice;//4 = 3
					System.out.println("novo indice "+ indice);
				    palavraEmbaralhada.append(palavra.charAt(indice+1)); //Insere Impar
				    indice =(indice+1 == palavraTamanho-1)? indice+1:indice;
				}
				else {
					//"DIEGOM";
					// 012345 
					System.out.println("indice impar "+ indice);
					System.out.println("ch "+ palavra.charAt(indice));
					indice =(indice == palavraTamanho-1)? indice:indice;//6=5
					System.out.println("novo indice "+ indice);
					System.out.println("indice INSERIDO "+ (indice-1));
					palavraEmbaralhada.append(palavra.charAt(indice-1));//insere Par
					indice =(indice == palavraTamanho-1)? indice-1:indice ;
				    }
		}

			return palavraEmbaralhada.toString();
	}
}
