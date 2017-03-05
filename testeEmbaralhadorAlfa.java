
public class testeEmbaralhadorAlfa {

	public static void main(String[] args) {
		
		EmbaralhadorAfabetico alfa = new EmbaralhadorAfabetico();
		String palavra = "UOIEA";
		
		String palavraAlfa = alfa.embaralha(palavra);
		
		//System.out.println(palavraAlfa);
		//------------------------------------------------------
		
		EmbaralhadorParImpar imparPar= new EmbaralhadorParImpar();
		String palav = "DIEGO";
		
		String str = imparPar.embaralha(palav);
		
		System.out.println(str);
		

	}
}

