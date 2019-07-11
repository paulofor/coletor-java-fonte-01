package dafitiafil.regracolecao.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;

import dafitiafil.dao.FacebookFotoPostDao;
import dafitiafil.log.DatasUtils;
import dafitiafil.modelo.FabricaVo;
import dafitiafil.modelo.FacebookFotoPost;
import dafitiafil.modelo.OportunidadeDia;
import dafitiafil.regracolecao.FabricaRegra;
import dafitiafil.regracolecao.FacebookFotoPostRegraColecao;
import dafitiafil.regracolecao.OportunidadeDiaRegraColecao;


public  class FacebookFotoPostRegraColecaoImpl  extends FacebookFotoPostRegraColecao {

	
	boolean retiraLink = false;
	OportunidadeDiaRegraColecao oportunidadeSrv = FabricaRegra.getInstancia().getOportunidadeDiaRegraColecao();
	
	@Override
	public FacebookFotoPost EnviaFotoPost(DaoConexao conexao)
			throws DaoException {
		FacebookFotoPost post = null;
		OportunidadeDia oportunidade = this.getProximaOportunidade(conexao);
		FacebookFotoPostDao dao = getDao();
		dao.setConexao(conexao);
		try {
			post = enviaFotoPost(oportunidade);
			oportunidade.setCodigoFacebook(post.getFacebookId());
			oportunidade.setQuantidadeExibicao(oportunidade.getQuantidadeExibicao()+1);
			oportunidadeSrv.getFiltro().setItemComCodigoFb(oportunidade);
			oportunidadeSrv.RegistraPostRealizado(conexao);
			dao.insereItem(post);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return post;
	} 
	
	public void EnviaPostSemLink() {
		String id = getFiltro().getFacebookIdAlbum();
		String token = getFiltro().getAlvoPostPerfil().getTokenAcesso();
		
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		String mensagem = "Buscador Descontos é um serviço que monitora preços e oferece as melhores oportunidade para você";
		FacebookType publishMessageResponse1 =
				facebookClient.publish("me/feed", 
				  FacebookType.class,
				  Parameter.with("message", mensagem)
				  );
	}
	
	
	private FacebookFotoPost enviaFotoPost(OportunidadeDia oportunidade) throws FileNotFoundException {
		FacebookFotoPost post = FabricaVo.criaFacebookFotoPost();
		if (oportunidade==null) {
			System.out.println("Oportunidade = null");
		}
		File imageFile = new File(ProdutoRegraColecaoImpl.diretorioDownload	+ "\\" + oportunidade.getCodigoImagemLocal());
		FileInputStream fis = new FileInputStream(imageFile);
		String mensagem = this.getMensagem(oportunidade);
		
		String id = getFiltro().getFacebookIdAlbum();
		String token = getFiltro().getAlvoPostPerfil().getTokenAcesso();
		//mensagem = this.getMensagemSemLink(oportunidade);
		FacebookClient facebookClient = new DefaultFacebookClient(token);
		System.out.println("Post..." + oportunidade.getNomeProduto() + " Album:" + id + ") - [" + DatasUtils.getHora() + "] ");
		FacebookType publishMessageResponse = null;
		try {
			publishMessageResponse =
				facebookClient.publish(id + "/photos", 
						  FacebookType.class,
						  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
						  Parameter.with("message", mensagem),
						  Parameter.with("caption", oportunidade.getNomeProduto())
						  );
			retiraLink = false;
		} catch (FacebookOAuthException e) {
			System.out.println("Retirando link");
			retiraLink = true;
			//mensagem = this.getMensagemSemLink(oportunidade);
			//publishMessageResponse =
			//		facebookClient.publish(id + "/photos", 
			//				  FacebookType.class,
			//				  BinaryAttachment.with(oportunidade.getCodigoImagemLocal(), fis),
			//				  Parameter.with("message", mensagem),
			//				  Parameter.with("caption", oportunidade.getNomeProduto())
			//				  );
		}
		System.out.println(publishMessageResponse.getId());
		post.setIdFacebookPerfilEp(getFiltro().getAlvoPostPerfil().getIdObj());
		post.setFacebookId(publishMessageResponse.getId());
		post.setQtdeClick(0);
		post.setIdProdutoRa(oportunidade.getIdProdutoRa());
		post.setIdFacebookFanpageEp(0);
		post.setDataHora(DatasUtils.getDataDD_MM_AAAA() + " " + DatasUtils.getHora());
		post.setPrecoConsumidor(oportunidade.getValorConsumidorAtual());
		post.setMensagem(mensagem);
		return post;
	}

	
	private OportunidadeDia getProximaOportunidade(DaoConexao conexao) throws DaoException {
		OportunidadeDia oportunidade = null;
		long idCategoria = getFiltro().getAlvoPostPerfil().getIdCategoriaProdutoRa();
		oportunidadeSrv.getFiltro().setCodigoCategoriaProduto(idCategoria);
		oportunidade =  oportunidadeSrv.ObtemProximoPorCategoria();
		return oportunidade;
	}
	
	
	private String getMensagem2(OportunidadeDia oportunidade) { 
		String preco = "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " + oportunidade.getQuantidadeParcelaAnterior() + 
				" x R$ " + oportunidade.getValorParcelaAnteriorFormatada() + " = R$ " + oportunidade.getValorConsumidorAnteriorFormatada() +
				"\nEm " + datas(oportunidade.getDataInicioPrecoAtual()) + ": " + oportunidade.getQuantidadeParcelaAtual() + 
				" x R$ " + oportunidade.getValorParcelaAtualFormatada() + " = R$ " + oportunidade.getValorConsumidorAtualFormatada();
		String justificativa =  "Buscador de descontos é um serviço independente que monitora lojas virtuais e oferece as melhores oportunidades de preço em calçados femininos para você.";
		String mensagem = oportunidade.getNomeMarca() + " - " + oportunidade.getNomeProduto() + "\n\n" + preco;
		String link = oportunidade.getUrlAfiliado();
		if (!retiraLink)
			mensagem = mensagem + "\n\n" + "Compre na Dafiti => " + link;
		mensagem += "\n\n" + justificativa;
		return mensagem;
	}
	private String getMensagem(OportunidadeDia oportunidade) { 
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
		if (!retiraLink) {
			saida += "\n\n" + link; 
		}
		return saida;
	}
	
	
	private String getMensagemSemLink(OportunidadeDia oportunidade) { 
		String preco = "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " + oportunidade.getQuantidadeParcelaAnterior() + 
				" x R$ " + oportunidade.getValorParcelaAnteriorFormatada() + " = R$ " + oportunidade.getValorConsumidorAnteriorFormatada() +
				"\nEm " + datas(oportunidade.getDataInicioPrecoAtual()) + ": " + oportunidade.getQuantidadeParcelaAtual() + 
				" x R$ " + oportunidade.getValorParcelaAtualFormatada() + " = R$ " + oportunidade.getValorConsumidorAtualFormatada();
		String mensagem = oportunidade.getNomeMarca() + "\n" + oportunidade.getNomeProduto() + "\n\n" + preco;
		String link = oportunidade.getUrlAfiliado();
		return mensagem;
	}
	
	
		
	private String decimal(float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}
	private String datas(String dataEnt) {
		return dataEnt.replaceAll("-", "/");
	}

	@Override
	public FacebookFotoPost ApagarTodos(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}	
		
}
