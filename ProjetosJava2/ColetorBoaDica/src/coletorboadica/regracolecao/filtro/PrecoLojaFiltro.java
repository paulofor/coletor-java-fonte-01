
package coletorboadica.regracolecao.filtro;

import java.util.List;
import coletorboadica.modelo.*;
import javax.swing.JTextArea;



public class PrecoLojaFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoComumReferenteA = -1;
		public long getCodigoProdutoComumReferenteA() {
			return _codigo_idProdutoComumReferenteA;
		}
		public void setCodigoProdutoComumReferenteA(long dado) {
			_codigo_idProdutoComumReferenteA = dado;
		}
      	

		private PrecoLoja _Item;
		public PrecoLoja getItem () {
			return _Item ;
		}
		public void setItem (PrecoLoja value) {
			_Item  = value;
		}
		
		public PrecoLoja validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		



		
}