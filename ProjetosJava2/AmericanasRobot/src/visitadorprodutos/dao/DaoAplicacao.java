package visitadorprodutos.dao;

import br.com.digicom.lib.dao.DaoBase;

public abstract class DaoAplicacao extends DaoBase {

	public DaoAplicacao() {
		super(DaoBase.MY_SQL);
	}
	public String getSenha() {
		// TODO Auto-generated method stub
		return "aspnet";
	}

	public String getUrlConexao() {
		// TODO Auto-generated method stub
		return "jdbc:mysql://localhost/visitador";
	}

	public String getUser() {
		// TODO Auto-generated method stub
		return "visitador";
	}

}
