package coletapreco.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceAplicacao extends MySqlDataSource {
	public DataSourceAplicacao() {
		super("jdbc:mysql://DESENV-PC/coletorgeralbd", "coletorgeral", "aspnet");
		//super("jdbc:mysql://DESENV-PC/coletorgeralbd", "coletor", "coletor");
	}
}
