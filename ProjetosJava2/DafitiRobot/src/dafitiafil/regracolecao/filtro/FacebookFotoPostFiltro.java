
package dafitiafil.regracolecao.filtro;

import java.util.List;
import dafitiafil.modelo.*;




public class FacebookFotoPostFiltro {




      	private long _codigo_idFacebookFanpageEnviadoPara = -1;
		public long getCodigoFacebookFanpageEnviadoPara() {
			return _codigo_idFacebookFanpageEnviadoPara;
		}
		public void setCodigoFacebookFanpageEnviadoPara(long dado) {
			_codigo_idFacebookFanpageEnviadoPara = dado;
		}
      	
      	private long _codigo_idFacebookPerfilEnviadoPara = -1;
		public long getCodigoFacebookPerfilEnviadoPara() {
			return _codigo_idFacebookPerfilEnviadoPara;
		}
		public void setCodigoFacebookPerfilEnviadoPara(long dado) {
			_codigo_idFacebookPerfilEnviadoPara = dado;
		}
      	
      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	

		private OportunidadeDia _Oportunidade;
		public OportunidadeDia getOportunidade () {
			return _Oportunidade ;
		}
		public void setOportunidade (OportunidadeDia value) {
			_Oportunidade  = value;
		}
		private FacebookPerfil _AlvoPostPerfil;
		public FacebookPerfil getAlvoPostPerfil () {
			return _AlvoPostPerfil ;
		}
		public void setAlvoPostPerfil (FacebookPerfil value) {
			_AlvoPostPerfil  = value;
		}
		private String _FacebookIdAlbum;
		public String getFacebookIdAlbum () {
			return _FacebookIdAlbum ;
		}
		public void setFacebookIdAlbum (String value) {
			_FacebookIdAlbum  = value;
		}


		//public String FacebookIdAlbum;

		
}