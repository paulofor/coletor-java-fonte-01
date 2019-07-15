package coletapreco.modelo.derivadas;


import br.com.digicom.lib.*;


import coletapreco.modelo.*;


public  class ProdutoDerivada   implements ProdutoDerivadaI { 
  private Produto principal;
      public ProdutoDerivada( Produto itemPrincipal )
      {
      principal = itemPrincipal;
	}
      
    //private long posicao;
      
	@Override
	public long getPosicao() {
		return principal.getPosicaoProduto();
	}
	@Override
	public void setPosicao(long dado) {
		principal.setPosicaoProduto(dado);
	}
	
	@Override
	public String getCodigoImagemLocal() {
		return "img-" + String.format("%09d",principal.getIdProduto()) + ".jpg";
	}
	@Override
	public void setCodigoImagemLocal(String dado) {
		throw new RuntimeException("Implementar metodo");
	}
}
