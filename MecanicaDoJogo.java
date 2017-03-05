
public interface MecanicaDoJogo {

	public MecanicaDoJogo escolhaModo(int modo);

	public String verificaResposta(String tentativa);
	
	public int getPontos();
	
	public void setAcertoPontos();
	
	public void setErroPontos();

	public int getAjuda();
	
	public int getTentativas();
	
	public String getModo();
	
	public boolean getFimDoJogo();
	
	public void pedeAjuda();

	public void setPalavra(String palavra);
	
	public void setPalavraEmbaralhada(String palavra);
	
	public int getCompraAjuda();
	
	public int getCompraTentativa();
	

	
}
