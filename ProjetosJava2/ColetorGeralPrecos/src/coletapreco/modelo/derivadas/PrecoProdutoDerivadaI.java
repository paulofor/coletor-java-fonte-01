package coletapreco.modelo.derivadas;

import br.com.digicom.lib.*;
import java.util.List;

public interface PrecoProdutoDerivadaI {

	// *** DESNORMALIZACAO *** BIG DATA

	public long getIdLojaVirtual();

	public void setIdLojaVirtual(long id);

	public long getIdNaturezaProduto();

	public void setIdNaturezaProduto(long id);

	public long getIdCategoraLoja();

	public void setIdCategoriaLoja(long id);
	
	public void setPosicao(long pos);
	
	public long getPosicao();
}
