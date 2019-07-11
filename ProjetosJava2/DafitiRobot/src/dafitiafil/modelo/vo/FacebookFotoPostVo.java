package dafitiafil.modelo.vo;

import java.util.List;
import java.text.*;
import dafitiafil.modelo.*;
import dafitiafil.modelo.agregado.*;
import dafitiafil.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class FacebookFotoPostVo implements FacebookFotoPost
{
		
	public long getIdObj()
    {
       return idFacebookFotoPost;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdFacebookFotoPost\" : \"" + idFacebookFotoPost + "\" "
		+ ", \"DataHora\" : \"" + dataHora + "\" "
		+ ", \"FacebookId\" : \"" + facebookId + "\" "
		+ ", \"QtdeClick\" : \"" + qtdeClick + "\" "
		+ ", \"Mensagem\" : \"" + mensagem + "\" "
		+ ", \"PrecoConsumidor\" : \"" + precoConsumidor + "\" "
		+ ", \"IdFacebookFanpageEp\" : \"" + idFacebookFanpageEp + "\" "
		+ ", \"IdFacebookPerfilEp\" : \"" + idFacebookPerfilEp + "\" "
		+ ", \"IdProdutoRa\" : \"" + idProdutoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private FacebookFotoPostDerivada derivada = null;
	private FacebookFotoPostDerivada getDerivada() {
		if (derivada==null) {
			derivada = new FacebookFotoPostDerivada(this);
		}
		return derivada;
	}

	private FacebookFotoPostAgregado agregado = null;
	private FacebookFotoPostAgregado getAgregado() {
		if (agregado==null) {
			agregado = new FacebookFotoPostAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public FacebookFanpage getFacebookFanpageEnviadoPara()
	{
		return getAgregado().getFacebookFanpageEnviadoPara(); 
	} 
	public void setFacebookFanpageEnviadoPara(FacebookFanpage value) 
	{
		getAgregado().setFacebookFanpageEnviadoPara(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookFanpage_EnviadoPara(FacebookFanpage value)
	{
		getAgregado().setFacebookFanpageEnviadoPara(value); 
	} 
	public FacebookFanpage getCorrenteFacebookFanpage_EnviadoPara()
	{
		return getAgregado().getFacebookFanpageEnviadoPara(); 
	} 
	
	
	// Montador Tradicional
	public FacebookPerfil getFacebookPerfilEnviadoPara()
	{
		return getAgregado().getFacebookPerfilEnviadoPara(); 
	} 
	public void setFacebookPerfilEnviadoPara(FacebookPerfil value) 
	{
		getAgregado().setFacebookPerfilEnviadoPara(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaFacebookPerfil_EnviadoPara(FacebookPerfil value)
	{
		getAgregado().setFacebookPerfilEnviadoPara(value); 
	} 
	public FacebookPerfil getCorrenteFacebookPerfil_EnviadoPara()
	{
		return getAgregado().getFacebookPerfilEnviadoPara(); 
	} 
	
	
	// Montador Tradicional
	public Produto getProdutoReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	public void setProdutoReferenteA(Produto value) 
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	
	// Montador Alternativo e Tradicional
	public void addListaProduto_ReferenteA(Produto value)
	{
		getAgregado().setProdutoReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getProdutoReferenteA(); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	//public void setConexaoCarregador(DaoConexao conexao) {
	//	getAgregado().setConexaoCarregador(conexao);
	//}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idFacebookFotoPost;
	public long getIdFacebookFotoPost()
	{
		return idFacebookFotoPost;
	}
	public  void setIdFacebookFotoPost(long value)
	{
		idFacebookFotoPost = value; 
	}
	
	
	
	
	
	private String dataHora;
	public String getDataHora()
	{
		return dataHora;
	}
	public  void setDataHora(String value)
	{
		dataHora = value; 
	}
	
	
	
	
	
	private String facebookId;
	public String getFacebookId()
	{
		return facebookId;
	}
	public  void setFacebookId(String value)
	{
		facebookId = value; 
	}
	
	
	
	
	
	private long qtdeClick;
	public long getQtdeClick()
	{
		return qtdeClick;
	}
	public  void setQtdeClick(long value)
	{
		qtdeClick = value; 
	}
	
	
	
	
	
	private String mensagem;
	public String getMensagem()
	{
		return mensagem;
	}
	public  void setMensagem(String value)
	{
		mensagem = value; 
	}
	
	
	
	public String getPrecoConsumidorFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoConsumidor);
	}
	
	
	
	private float precoConsumidor;
	public float getPrecoConsumidor()
	{
		return precoConsumidor;
	}
	public  void setPrecoConsumidor(float value)
	{
		precoConsumidor = value; 
	}
	
	
	
	
		
	private long idFacebookFanpageEp;
	public long getIdFacebookFanpageEp() {
		// relacionamento
		if (idFacebookFanpageEp==0 && this.getFacebookFanpageEnviadoPara()!=null) 
			return getFacebookFanpageEnviadoPara().getIdObj();
		else
			return idFacebookFanpageEp;
	}
	public void setIdFacebookFanpageEp(long _valor) {
		idFacebookFanpageEp = _valor;
	}
	
	
	
	
		
	private long idFacebookPerfilEp;
	public long getIdFacebookPerfilEp() {
		// relacionamento
		if (idFacebookPerfilEp==0 && this.getFacebookPerfilEnviadoPara()!=null) 
			return getFacebookPerfilEnviadoPara().getIdObj();
		else
			return idFacebookPerfilEp;
	}
	public void setIdFacebookPerfilEp(long _valor) {
		idFacebookPerfilEp = _valor;
	}
	
	
	
	
		
	private long idProdutoRa;
	public long getIdProdutoRa() {
		// relacionamento
		if (idProdutoRa==0 && this.getProdutoReferenteA()!=null) 
			return getProdutoReferenteA().getIdObj();
		else
			return idProdutoRa;
	}
	public void setIdProdutoRa(long _valor) {
		idProdutoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
