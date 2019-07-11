package dafitiafil.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceAplicacao extends MySqlDataSource {
	public DataSourceAplicacao() {
		super("jdbc:mysql://localhost/dafitibd", "dafiti", "aspnet");
	}
}
