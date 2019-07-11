
package dafitiafil.regracolecao.filtro;

import java.util.List;
import dafitiafil.modelo.*;




public class ProdutoFiltro {




      	private long _codigo_idMarcaPertenceA = -1;
		public long getCodigoMarcaPertenceA() {
			return _codigo_idMarcaPertenceA;
		}
		public void setCodigoMarcaPertenceA(long dado) {
			_codigo_idMarcaPertenceA = dado;
		}
      	

		private String _DataInicioOportunidade;
		public String getDataInicioOportunidade () {
			return _DataInicioOportunidade ;
		}
		public void setDataInicioOportunidade (String value) {
			_DataInicioOportunidade  = value;
		}
		private float _PercentualMinimoOportunidade;
		public float getPercentualMinimoOportunidade () {
			return _PercentualMinimoOportunidade ;
		}
		public void setPercentualMinimoOportunidade (float value) {
			_PercentualMinimoOportunidade  = value;
		}
		private long _CodigoCategoriaProduto;
		public long getCodigoCategoriaProduto () {
			return _CodigoCategoriaProduto ;
		}
		public void setCodigoCategoriaProduto (long value) {
			_CodigoCategoriaProduto  = value;
		}
		private Produto _Item;
		public Produto getItem () {
			return _Item ;
		}
		public void setItem (Produto value) {
			_Item  = value;
		}


		//public String DataInicioOportunidade;
		//public float PercentualMinimoOportunidade;
		//public long CodigoCategoriaProduto;

		
}