package visitadorprodutos.dao;


import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;


import visitadorprodutos.modelo.*;


public  class UsuarioDao  extends DaoAplicacao implements UsuarioDaoI { 
	private MontadorDaoI _montador;
	public MontadorDaoI getMontador() {
		if (_montador==null) _montador = new UsuarioMontador();
		return _montador;
	}
	public String camposOrdenados() {
		String camposSaida = null;
		camposSaida = " usuario.id_usuario";
		return camposSaida;
	}
	public String tabelaSelect() {
		return " usuario" ;
	}
	public void cria( Usuario item )  throws  DaoException{
		String query = null;
		query = " insert into usuario () values ()";
		getDataSource().executaSql(query);
	}
}
