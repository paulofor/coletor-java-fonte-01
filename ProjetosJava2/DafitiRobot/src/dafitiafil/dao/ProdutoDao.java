package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.ProdutoDaoBaseI;
import dafitiafil.modelo.Produto;

public interface ProdutoDao
 extends ProdutoDaoBaseI { 
	public Produto obtemPorReferencia(Produto entrada) throws DaoException;
	
	public List<Produto> listaSemImagem() throws DaoException;
	
	public List<Produto> oportunidadesDia(String dataInicial, String percentualMinimo) throws DaoException;

}
