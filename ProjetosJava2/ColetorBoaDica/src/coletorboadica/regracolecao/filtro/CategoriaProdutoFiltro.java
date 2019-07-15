
package coletorboadica.regracolecao.filtro;

import java.util.List;
import coletorboadica.modelo.*;
import javax.swing.JTextArea;



public class CategoriaProdutoFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}

      	private long _codigo_idProdutoComumAssociada = -1;
		public long getCodigoProdutoComumAssociada() {
			return _codigo_idProdutoComumAssociada;
		}
		public void setCodigoProdutoComumAssociada(long dado) {
			_codigo_idProdutoComumAssociada = dado;
		}
      	
      	private long _codigo_idCategoriaAssociada = -1;
		public long getCodigoCategoriaAssociada() {
			return _codigo_idCategoriaAssociada;
		}
		public void setCodigoCategoriaAssociada(long dado) {
			_codigo_idCategoriaAssociada = dado;
		}
      	




		
}