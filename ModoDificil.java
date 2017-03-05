import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//******************************************************
//* Não mostra a palavra certa depois de errar na ajuda
//* O indice da letra é escolhido randomicamente
//* A cada erro perde-se o dobro de pontos que poderiam ser ganhos
//* Só consegue comprar uma Ajuda se valor positivo permitir
//******************************************************

public class ModoDificil implements MecanicaDoJogo {

	private int pontos = 0;
	private int ajuda  = 3;
	private int tentativas = 3; 
	private String  respostaAjuda = ""; 
	private String  palavra    = "";
	private String  palavraEmb = "";
	private String  resp       ="";
	private boolean usouAjuda  = false;
	private boolean fimDoJogo  = false;
		
	public MecanicaDoJogo escolhaModo(int modo) {
		return null;
		// TODO Auto-generated method stub		
	}
	
	private boolean LimiteIndiceTamPalavra(String p,int indice){
		if(indice < 1 || indice > p.length())	
			return false;
		else
		    return true;
	}
	
	public void pedeAjuda(){
		if(ajuda == 0){
			System.out.println("\n* Você não possui mais ajuda :/ *");
			usouAjuda = true;
			resp = "";
		}
		else{
		   Scanner in = new Scanner(System.in);
		   int tamPalavra = palavra.length();
		   int posicao = 0;
		   StringBuilder formatada = new StringBuilder();
		   for(int i=1;i <= tamPalavra; i++)
			   formatada.append('-');
		   do{
			 --ajuda;
			 Random aleatorio = new Random();
			 System.out.println("Ajuda: " + getAjuda());
			 System.out.println("Palavra: " + palavraEmb);
			 posicao = aleatorio.nextInt(tamPalavra);
			 for(int i=0;i<1;i++)
			    if(naoRepeteIndice(posicao))
		           formatada.setCharAt(posicao, palavra.charAt(posicao));
			    else{
				   posicao = aleatorio.nextInt(tamPalavra);
				   --i;// repetir decremento pra voltar no laço
			        }
		     System.out.println("Palavra: " + formatada.toString());
		     String msgHelp = "";
		     msgHelp = (getAjuda()>0)?"[Pedir ajuda novamente:'H']:":" Sua ajuda Acabou! Arrisque :)";	    
		     System.out.println("Já sabe o que é?"+ msgHelp);
		     respostaAjuda = in.nextLine();
		   }while(getAjuda() > 0 && respostaAjuda.equalsIgnoreCase("H"));
		   usouAjuda = true;
		   verificaResposta(respostaAjuda);
		   }	
	}
	@SuppressWarnings("resource")
	public void Compra(){
		if(getPontos() >= getCompraAjuda()){
		   Scanner c = new Scanner(System.in);
	       ArrayList<Integer> numeros = new ArrayList<Integer>(2);
		   numeros.add(1); 
		   numeros.add(2);
		   System.out.print(getCompraAjuda()+" pontos - Ajuda    [1]\n"+ getCompraTentativa() +" pontos - Tentativa[2]:");
		   int escolha = c.nextInt();
		   if(numeros.contains(escolha)){
			   if(escolha == 1){
				   ajuda++;
				   pontos -= getCompraAjuda();
				   resp ="";
		       }else{
			       tentativas++;
			       pontos -= getCompraTentativa();
			       resp ="";
		      }
	      }else{
	    	System.out.println("\n*******************************************************");
		    System.out.println("Para escolher digite [1] para Ajuda ou [2] para Tentativas");
		    System.out.println("*********************************************************");
		    resp = "";
		 }
		}else{
			System.out.println("\n***************************");
			System.out.println(" Você não possue créditos");
			System.out.println("***************************");
		}
		   }
	@Override
	public String verificaResposta(String tentativa) {
		if(tentativa.trim().equalsIgnoreCase("help"))
			pedeAjuda();
		else
		 if(tentativa.trim().equalsIgnoreCase("Compra"))
			 Compra();
		else
		 if(tentativa.trim().equalsIgnoreCase(palavra.trim())){
			setAcertoPontos();
			ajuda = ((pontos % 15) == 0)? ++ajuda:ajuda;
			resp =(pontos <99)?   "____________________________________\n\n"
					            + "********* RESPOSTA CERTA! **********\n"
					            + "____________________________________\n":"\n"
					            + "#########################\n"
					            + "#      FIM DO JOGO      #\n"
					            + "# Parabéns Você Venceu! #\n"
					            + "#########################\n";
		   }
		 else
		  {  setErroPontos();
			 resp =  "____________________________________\n\n"
				    +"---------- RESPOSTA ERRADA ---------\n"
				    +"____________________________________\n";
			 
			 
			 //tentativas = (usouAjuda)? tentativas: --tentativas;
			 --tentativas;
			 usouAjuda = false;
			 if(tentativas ==0){
			     resp = "#########################\n"
				       + "#       GAME OVER       #\n"
				       + "#      VOCÊ PERDEU      #\n"
				       + "#########################\n";
			     fimDoJogo = true;
			    }
		  }
		return resp;
	}

	// Controle de indices repetidos sorteados pelo Random()
	private int posChar;
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
	
// Getters and Setters	
	@Override
	public int getPontos() {
		return pontos;
	}
	@Override
	public int getAjuda() {
		return ajuda;
	}
	@Override
	public String getModo() {
		return "Difícil";
	}
	@Override
	public int getTentativas() {
		return this.tentativas;
	}
	@Override
	public void setPalavra(String pa){
		this.palavra = pa;
	}
	@Override
	public void setPalavraEmbaralhada(String palavraEmb){
		this.palavraEmb = palavraEmb;		
	}
	@Override
	public boolean getFimDoJogo() {
		return fimDoJogo;
	}
	public int getCompraAjuda() {
		return 15;
	}
	public int getCompraTentativa() {
		return 20;
	}
	@Override
	public void setAcertoPontos() {
		this.pontos += 5;
		
	}
	@Override
	public void setErroPontos() {
		this.pontos -= 10;
		
	}
}
