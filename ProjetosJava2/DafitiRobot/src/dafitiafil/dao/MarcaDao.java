package dafitiafil.dao;


import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.MarcaDaoBaseI;
import dafitiafil.modelo.Marca;

public interface MarcaDao
 extends MarcaDaoBaseI { 
	
	public Marca obtemPorNome(String nome) throws DaoException;
}
