package dafitiafil.parse.dados.custom;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.dao.DBB;
import dafitiafil.dao.ProdutoDao;
import dafitiafil.log.ArquivoLog;
import dafitiafil.parse.dados.ProdutoDadosParse;

public class ProdutoDadosParseCustom extends ProdutoDadosParse{

	ProdutoDao produtoSrv = null;
	
	public ProdutoDadosParseCustom() {
		super();
		produtoSrv = DBB.getInstancia().getProdutoDao();
	}
	
	public String getUrlDetalhe() {
		String url = "http://www.integracaoafiliados.com.br/validador/dafiti.php?" +
				"id_afiliado=paulofore&op=validar&url=" + getItemDetalhe().getUrl();
 		return url;
 	}

	@Override
	public void finalizacaoOkDetalhe() {
		super.finalizacaoOkDetalhe();
		produtoSrv.setConexao(getConexao());
		try {
			produtoSrv.alteraItem(getItemDetalhe());
		} catch (DaoException e) {
			ArquivoLog.getInstancia().salvaErro(e);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/*
	public List getListaPost() {
		List lista = new ArrayList();
		lista.add(new CampoPost("op","validar"));
		lista.add(new CampoPost("id_afiliado","paulofore"));
		lista.add(new CampoPost("url","http://www.dafiti.com.br/" + getItemDetalhe().getUrl()));
		return lista;
	}
	*/

}