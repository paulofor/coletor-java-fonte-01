package dafitiafil.obj;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.digicom.lib.dao.DaoException;
import dafitiafil.regracolecao.CategoriaProdutoRegraColecao;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;
import dafitiafil.regracolecao.ProdutoRegraColecao;

public class AcessaSitePrecoProdutoDafitiObj implements Job {
	
	public void principal() throws DaoException {
		atualizaCategoria();
		apagarImagensPostadas();
		encontrarOportunidades();
		baixarImagens();
		criaCodigoDafitiPorCategoria();
	}

	public void apagarImagensPostadas() throws DaoException {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		System.out.println("Inicio exclusao de imagens");
		oportunidadeSrv.ExcluiImagensDia();
		System.out.println("Final exclusao de imagens");
	}
	
	public void atualizaCategoria() throws DaoException {
		System.out.println("Inicio atualiza categoria");
		CategoriaProdutoRegraColecao categoriaSrv = FabricaRegra.getInstancia().getCategoriaProdutoRegraColecao();
		System.out.println("Detalhe Categoria");
		categoriaSrv.AtualizaDetalhe();
		System.out.println("Finalizou Parser...");
	}
	
	public void encontrarOportunidades() throws DaoException {
		OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
		System.out.println("Inicializando montagem de oportunidades...");
		oportunidadeSrv.CalculaOportunidadeDiaCorrente();
		System.out.println("Finalizando montagem de oportunidades...");
	}
	
	public void baixarImagens() throws DaoException {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		System.out.println("Inicializando coleta de imagens...");
		produtoSrv.BaixarImagens();
		System.out.println("Finalizando coleta de imagens...");
	}
	
	public void criaCodigoDafitiPorCategoria() throws DaoException {
		ProdutoRegraColecao produtoSrv = FabricaRegra.getInstancia().getProdutoRegraColecao();
		System.out.println("Codigo Dafiti...");
		produtoSrv.CriaCodigoDafitiPorCategoriaOportunidade();
		System.out.println("Finalizando Codigo Dafiti...");

	}
	
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Ola Mundo");
			principal();
			System.out.println("Execução finalizada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
