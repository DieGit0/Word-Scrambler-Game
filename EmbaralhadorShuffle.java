import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorShuffle implements Embaralhador{
	
	StringBuilder palavraEmbaralhada = new StringBuilder();

	@Override
	public String embaralha(String palavra) {
		List<String> palabra = Arrays.asList(palavra.split(""));
		Collections.shuffle(palabra);
		for(String ch: palabra)
			palavraEmbaralhada.append(ch);
		return palavraEmbaralhada.toString();
		
	}
}
