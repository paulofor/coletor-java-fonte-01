package dafitiafil.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.basica.OportunidadeDiaDaoBaseI;
import dafitiafil.modelo.OportunidadeDia;

public interface OportunidadeDiaDao
 extends OportunidadeDiaDaoBaseI { 
	
	public void limparTabela() throws DaoException;
	
	public OportunidadeDia obtemProximoPost() throws DaoException;
	public OportunidadeDia obtemProximoPorCategoria(long id, String valorMaximo) throws DaoException;
	public void somaExibicao(long idOportunidadeDia) throws DaoException ;
	public List<OportunidadeDia> listaSemImagem() throws DaoException ;
	public List<OportunidadeDia> listaComIdFacebbok() throws DaoException;
	
	public List<OportunidadeDia> listaPorCategoria(long idCategoria) throws DaoException;
}
