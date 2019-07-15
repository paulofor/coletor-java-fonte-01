package dafitiafil.modelo.agregados;


import dafitiafil.modelo.*;

public interface FacebookFotoPostAssembledI
 { 
	public FacebookFanpage getFacebookFanpageEnviadoPara();
	public void setFacebookFanpageEnviadoPara( FacebookFanpage dado );
	public FacebookPerfil getFacebookPerfilEnviadoPara();
	public void setFacebookPerfilEnviadoPara( FacebookPerfil dado );
	public Produto getProdutoReferenteA();
	public void setProdutoReferenteA( Produto dado );
}
