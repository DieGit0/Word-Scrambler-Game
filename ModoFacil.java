import java.util.ArrayList;
import java.util.Scanner;

public class ModoFacil implements MecanicaDoJogo {

	private int pontos = 0;
	private int ajuda  = 5;
	private int tentativas = 5; 
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
		   Scanner in  = new Scanner(System.in);
		   int tamPalavra = palavra.length();
		   int posicao = 0;
		   StringBuilder formatada = new StringBuilder();
		   for(int i=1;i <= tamPalavra; i++)
			   formatada.append('-');
		   do{
				 System.out.println("\nAjuda: " + getAjuda());
				 System.out.println("Palavra: " + palavraEmb);
			     System.out.println("Palavra: " + formatada.toString());
			     System.out.print("Escolha a posição da Letra [1-"+(tamPalavra)+"]:");
				try{
				     posicao = in.nextInt();
				     if(LimiteIndiceTamPalavra(palavra,posicao)){
					     formatada.deleteCharAt(posicao-1);
					     formatada.insert(posicao-1, palavra.charAt(posicao-1));
					     --ajuda;
					     System.out.println("\nAjuda: "   + getAjuda());
					     System.out.println("Palavra: " + palavraEmb);
					     System.out.println("Palavra: " + formatada.toString());
				     }else{
				    	 System.out.println(" ---------------------------------------------------");
				    	 System.out.println("| A posição deve estar dentro do tamanho da palavra |");
				    	 System.out.println(" ---------------------------------------------------");
				    	 };	
				}
				catch(Exception e ){
					 System.out.println(" ------------------------------------------");
			    	 System.out.println("| A posição deve ser um número entre 1 a "+ tamPalavra +" |");
			    	 System.out.println(" ------------------------------------------");	
				}
			 in.nextLine();//limpa o buffer
		     String msgHelp = "";
		     msgHelp = (getAjuda()>0)?"[Pedir ajuda novamente:'H']:":" Sua ajuda Acabou! Arrisque :)";
		     System.out.print("Já sabe o que é?"+ msgHelp);
		     respostaAjuda = in.nextLine();		
		   }while(getAjuda() > 0 && respostaAjuda.equalsIgnoreCase("H"));
		   usouAjuda = true;
		   verificaResposta(respostaAjuda);
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
		  {
			 resp =  "____________________________________\n\n"
				    +"---------- RESPOSTA ERRADA ---------\n\n"
				    +"       A Palavra é: "+ palavra +"   \n"
				    +"____________________________________\n";
			 
			 
			 tentativas = (usouAjuda)? tentativas: --tentativas;
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
	@SuppressWarnings("resource")
	public void Compra(){
		Scanner c = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>(2);
		numeros.add(1); 
		numeros.add(2);
		System.out.print(getCompraAjuda()+"  pontos - Ajuda    [1]\n"+ getCompraTentativa() +" pontos - Tentativa[2]:");
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
		        System.out.println("\nPara escolher digite [1] para Ajuda ou [2] para Tentativas");
		        resp = "";}
	   }
		
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
		return "Fácil";
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
	@Override
	public int getCompraAjuda() {
		return 5;
	}
	@Override
	public int getCompraTentativa() {
		return 10;
	}
	@Override
	public void setAcertoPontos() {
		 this.pontos += 10;
	}
	@Override
	public void setErroPontos() {
		 this.pontos += 0;
	}
}
