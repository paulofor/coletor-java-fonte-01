
package dafitiafil.regracolecao.filtro;

import java.util.List;
import dafitiafil.modelo.*;




public class OportunidadeDiaFiltro {




      	private long _codigo_idProdutoReferenteA = -1;
		public long getCodigoProdutoReferenteA() {
			return _codigo_idProdutoReferenteA;
		}
		public void setCodigoProdutoReferenteA(long dado) {
			_codigo_idProdutoReferenteA = dado;
		}
      	

		private long _CodigoCategoriaProduto;
		public long getCodigoCategoriaProduto () {
			return _CodigoCategoriaProduto ;
		}
		public void setCodigoCategoriaProduto (long value) {
			_CodigoCategoriaProduto  = value;
		}
		private OportunidadeDia _ItemComCodigoFb;
		public OportunidadeDia getItemComCodigoFb () {
			return _ItemComCodigoFb ;
		}
		public void setItemComCodigoFb (OportunidadeDia value) {
			_ItemComCodigoFb  = value;
		}


		//public long CodigoCategoriaProduto;

		
}