package coletapreco.modelo.derivadas;

import br.com.digicom.lib.*;

import coletapreco.modelo.*;

public class PrecoProdutoDerivada implements PrecoProdutoDerivadaI {

	private long posicao;
	
	private long idLojaVirtual;
	private long idNaturezaProduto;
	private long idCategoriaLoja;

	private PrecoProduto principal;

	public PrecoProdutoDerivada(PrecoProduto itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public long getIdLojaVirtual() {
		return idLojaVirtual;
	}

	@Override
	public void setIdLojaVirtual(long id) {
		idLojaVirtual = id;
	}

	@Override
	public long getIdNaturezaProduto() {
		return this.idNaturezaProduto;
	}

	@Override
	public void setIdNaturezaProduto(long id) {
		this.idNaturezaProduto = id;
	}

	@Override
	public long getIdCategoraLoja() {
		return this.idCategoriaLoja;
	}

	@Override
	public void setIdCategoriaLoja(long id) {
		this.idCategoriaLoja = id;
	}
	
	@Override
	public long getPosicao() {
		return this.posicao;
	}

	@Override
	public void setPosicao(long pos) {
		this.posicao = pos;
	}
}
