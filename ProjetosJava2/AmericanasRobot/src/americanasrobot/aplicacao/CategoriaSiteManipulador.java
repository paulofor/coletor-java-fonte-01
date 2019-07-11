package americanasrobot.aplicacao;

import br.com.digicom.parse.callback.IDadosParse;
import visitadorprodutos.modelo.CategoriaSite;

public class CategoriaSiteManipulador implements CategoriaSiteManipuladorI{

	private CategoriaSite _categoriaSite;
	
	public void setCategoriaSite(CategoriaSite item) {
		this._categoriaSite = item;
	}

	public void setServidor(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return _categoriaSite.getUrl();
	}
	
	
}
