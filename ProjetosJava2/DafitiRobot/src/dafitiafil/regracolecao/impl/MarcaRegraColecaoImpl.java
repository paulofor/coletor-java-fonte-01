package dafitiafil.regracolecao.impl;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import dafitiafil.regracolecao.*;
import dafitiafil.dao.*;
import dafitiafil.modelo.*;


public  class MarcaRegraColecaoImpl  extends MarcaRegraColecao { 
	public  Marca ObtemPorNome( DaoConexao conexao )  throws  DaoException{
		MarcaDao dao = getDao();
		dao.setConexao(conexao);
		return dao.obtemPorNome(getFiltro().getNome());
	}
}
