package americanasrobot.aplicacao;

import visitadorprodutos.modelo.CategoriaSite;
import br.com.digicom.parse.callback.IDadosParse;

public interface CategoriaSiteManipuladorI extends IDadosParse{

	public void setCategoriaSite(CategoriaSite item);
	public String getUrl();
}
