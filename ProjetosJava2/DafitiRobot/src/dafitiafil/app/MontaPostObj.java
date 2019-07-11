package dafitiafil.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import dafitiafil.log.DatasUtils;
import dafitiafil.modelo.FabricaVo;
import dafitiafil.modelo.FacebookFotoPost;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;
import dafitiafil.regracolecao.impl.ProdutoRegraColecaoImpl;

public class MontaPostObj {

	
	OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
	
	public void obtemPost() throws DaoException, FileNotFoundException {
		OportunidadeDia oportunidade = getProximaOportunidade();
		enviaFotoPost(oportunidade);
		System.out.println("update oportunidade_dia set quantidade_exibicao = 1 where id_oportunidade_dia = " + oportunidade.getIdObj());
	}
	
	private OportunidadeDia getProximaOportunidade() throws DaoException {
		OportunidadeDia oportunidade = null;
		long idCategoria = 1;
		oportunidadeSrv.getFiltro().setCodigoCategoriaProduto(idCategoria);
		oportunidade =  oportunidadeSrv.ObtemProximoPorCategoria();
		return oportunidade;
	}
	
	private void enviaFotoPost(OportunidadeDia oportunidade) throws FileNotFoundException {
		if (oportunidade==null) {
			System.out.println("Oportunidade = null");
		}
		File imageFile = new File(ProdutoRegraColecaoImpl.diretorioDownload	+ "\\" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		String mensagem = this.getMensagem(oportunidade);
		
		System.out.println(imageFile.getAbsolutePath());
		System.out.println(mensagem);
	}

	private String getMensagem2(OportunidadeDia oportunidade) { 
		String mensagem = "Este produto estava sendo vendido na Dafiti até o dia " + datas(oportunidade.getDataUltimaPrecoAnterior())  + 
				" por R$ " + oportunidade.getValorConsumidorAnteriorFormatada() + " ( " + oportunidade.getQuantidadeParcelaAnterior() + 
				" parcelas de R$ " + oportunidade.getValorParcelaAnteriorFormatada() + "). Hoje está saindo por R$ " +
				 oportunidade.getValorConsumidorAtualFormatada() + " ( " + oportunidade.getQuantidadeParcelaAtual() + 
				" parcelas de R$ " + oportunidade.getValorParcelaAtualFormatada() + " ) " +
				" com redução de " + decimal(oportunidade.getPercentualAjusteAtual()) + " %.";
		String link = "Para aproveitar o preço clique no link ao lado => " + oportunidade.getUrlAfiliado();
		String nomeProduto = oportunidade.getNomeMarca() + " - " + oportunidade.getNomeProduto();
		
		String saida = nomeProduto;
		saida += "\n\n" + mensagem;
		//if (!retiraLink) {
			saida += "\n\n" + link; 
		//}
		return saida;
	}
	
	private String getMensagem(OportunidadeDia oportunidade) { 
		String mensagem = "Preço em " + datas(oportunidade.getDataUltimaPrecoAnterior())  + 
				" : R$ " + oportunidade.getValorConsumidorAnteriorFormatada() + " ( " + oportunidade.getQuantidadeParcelaAnterior() + 
				" parcelas de R$ " + oportunidade.getValorParcelaAnteriorFormatada() + ").\nPreço Atual : R$ " +
				 oportunidade.getValorConsumidorAtualFormatada() + " ( " + oportunidade.getQuantidadeParcelaAtual() + 
				" parcelas de R$ " + oportunidade.getValorParcelaAtualFormatada() + " ) " +
				" com redução de " + decimal(oportunidade.getPercentualAjusteAtual()) + " %.";
		String link = "Para aproveitar o preço clique no link ao lado => " + oportunidade.getUrlAfiliado();
		String nomeProduto = oportunidade.getNomeMarca() + " - " + oportunidade.getNomeProduto();
		
		String saida = nomeProduto;
		saida += "\n\n" + mensagem;
		//if (!retiraLink) {
			saida += "\n\n" + link; 
		//}
		return saida;
	}
	
	
	private String decimal(float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	private String datas(String dataEnt) {
		return dataEnt.replaceAll("-", "/");
	}
}
