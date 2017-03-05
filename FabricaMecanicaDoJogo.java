
public class FabricaMecanicaDoJogo {
	
public MecanicaDoJogo escolhaModo(int modo) {
	MecanicaDoJogo modoEscolhido = (modo ==1)? new ModoFacil() :
		                           (modo ==2)? new ModoNormal(): 
		                        	           new ModoDificil();
	return modoEscolhido;
}

 
	
}
