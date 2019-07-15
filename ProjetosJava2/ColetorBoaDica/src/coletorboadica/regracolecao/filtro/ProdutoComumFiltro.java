
package coletorboadica.regracolecao.filtro;

import java.util.List;
import coletorboadica.modelo.*;
import javax.swing.JTextArea;



public class ProdutoComumFiltro {

		private JTextArea texto = null;
		public void setTextArea(JTextArea dado) {
			texto = dado;
		}
		public JTextArea getTextArea() {
			return texto;
		}


		private ProdutoComum _Item;
		public ProdutoComum getItem () {
			return _Item ;
		}
		public void setItem (ProdutoComum value) {
			_Item  = value;
		}
		
		public ProdutoComum validaItem() {
			
			if (_Item == null) {
				throw new RuntimeException("Item eh nulo");
			}
			
			return getItem ();
		}
		
		private String _NomeModelo;
		public String getNomeModelo () {
			return _NomeModelo ;
		}
		public void setNomeModelo (String value) {
			_NomeModelo  = value;
		}
		
		public String validaNomeModelo() {
			
			if (_NomeModelo == null) {
				throw new RuntimeException("NomeModelo eh nulo");
			}
			
			return getNomeModelo ();
		}
		
		private Categoria _CategoriaItem;
		public Categoria getCategoriaItem () {
			return _CategoriaItem ;
		}
		public void setCategoriaItem (Categoria value) {
			_CategoriaItem  = value;
		}
		
		public Categoria validaCategoriaItem() {
			
			if (_CategoriaItem == null) {
				throw new RuntimeException("CategoriaItem eh nulo");
			}
			
			return getCategoriaItem ();
		}
		


		//public String NomeModelo;

		
}