
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	private static int escolhaModo;
    
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
    Scanner in=      new Scanner(System.in); 
    Scanner entrada= new Scanner(System.in); 
    
 System.out.println("*********************************");
 System.out.println("* Jogo de Palavras Embaralhadas *");
 System.out.println("*********************************");
 System.out.print("Escolha o Modo:\n Facil  [1]\n Normal [2]\n Dificil[3]\nEscolha:");
 try{
    escolhaModo = in.nextInt(); 
   // Clear();
    ArrayList<Integer> niveis = new ArrayList<Integer>(3);
    niveis.add(1);niveis.add(2);niveis.add(3);
    if(niveis.contains(escolhaModo)){
//--------------------------------------------------------------------
    BancoDePalavras Bp = new BancoDePalavras();
  //Retorna um Embaralhador Aleatório
   FabricaMecanicaDoJogo config = new FabricaMecanicaDoJogo(); 
  //Retorna o nivel de dificuldade escolhido no menu
   MecanicaDoJogo jogo = config.escolhaModo(escolhaModo);

   String tentativa=""; 
   //Laço de Interação do Jogo
  do{  
	  	 //Clear();
  	   String palavra = Bp.getPalavra();
  	   String palavraEmbaralhada = FabricaEmbaralhadores.getEmbaralhador().embaralha(palavra);
  	   jogo.setPalavra(palavra); //Passa a palavra certa no inicio do laço
  	   jogo.setPalavraEmbaralhada(palavraEmbaralhada);
  	   TelaPrincipal(jogo);
  	   System.out.println("Palavra Embaralhada: " + palavraEmbaralhada);
  	   System.out.print("Qual a palavra?");
  	   tentativa = entrada.nextLine(); 	  
  	 
  	   System.out.println(jogo.verificaResposta(tentativa)); //Retorna acerto ou erro;

 	 
  }while( (jogo.getPontos() <99) && (! jogo.getFimDoJogo()) );
         TelaPrincipal(jogo);
    //--------------------------------------------------------------------
    }else{
    	System.out.println("Escolha um nivel de Dificuldade entre 1 e 3");
    }
    
 }catch(Exception e){
	 System.out.println("Escolha Incorreta");
 }
	}
	
	protected static void TelaPrincipal( MecanicaDoJogo jogo){
		 String linhaDoModo  ="";
		 String linhaDoMeio ="";
		 linhaDoModo = (jogo.getModo().equalsIgnoreCase("Fácil")) ? "# Modo:" + jogo.getModo()+"                       #" :
			           (jogo.getModo().equalsIgnoreCase("Normal"))? "# Modo:" + jogo.getModo()+"                      #"  :
			        	                                            "# Modo:" + jogo.getModo()+"                     #"   ;
		 linhaDoMeio = (jogo.getPontos()> 9 && jogo.getPontos() < 99)? "# Pontos:" + jogo.getPontos() + " Ajuda:" + jogo.getAjuda() + " Tentativas:" + jogo.getTentativas()+"   #":
			           (jogo.getPontos()< 0 || jogo.getPontos()> 99)?  "# Pontos:" + jogo.getPontos() + " Ajuda:" + jogo.getAjuda() + " Tentativas:" + jogo.getTentativas()+"  #" :
			        	                                               "# Pontos:" + jogo.getPontos() + " Ajuda:" + jogo.getAjuda() + " Tentativas:" + jogo.getTentativas()+"    #";
		 System.out.println("####################################");
		 System.out.println(linhaDoModo);
		 System.out.println(linhaDoMeio);
		 System.out.println("# Pedir ajuda[Help]                #");
		 System.out.println("# Comprar Ajuda/Tentativa[Compra]  #");
		 System.out.println("####################################");	
		
	}
}

