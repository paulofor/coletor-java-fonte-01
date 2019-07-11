package americanasrobot.aplicacao;

import java.util.Collection;
import java.util.Iterator;

import visitadorprodutos.americanas.parser.FacadeVisitaCategoria;
import visitadorprodutos.modelo.CategoriaSite;
import visitadorprodutos.modelo.PlanejamentoVisita;
import visitadorprodutos.regracolecao.FabricaRegra;
import visitadorprodutos.regracolecao.base.LojaSiteRegraColecao;

public class AmericanasRobotApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmericanasRobotApp aplicacao = new AmericanasRobotApp();
		aplicacao.executePorPlanejamento();
	}
	
	public AmericanasRobotApp() {
		
	}
	
	public void execute() {
		Collection listaCategorias = FabricaRegra.getInstancia().getCategoriaSiteRegraColecao().Pendentes();
		Iterator iterador = listaCategorias.iterator();
		CategoriaSiteManipuladorI manipulador = new CategoriaSiteManipulador();
		FacadeVisitaCategoria visitador = new FacadeVisitaCategoria();
		while (iterador.hasNext()) {
			CategoriaSite categoria = (CategoriaSite) iterador.next();
			manipulador.setCategoriaSite(categoria);
			visitador.acessaCategoria(manipulador);
		}
	}
	
	public void executePorPlanejamento() {
		Collection listaPlanejamentoVisita = FabricaRegra.getInstancia().getPlanejamentoVisitaRegraColecao().Pendentes();
		Iterator itPlanejamentoVisita = listaPlanejamentoVisita.iterator();
		while (itPlanejamentoVisita.hasNext()) {
			PlanejamentoVisita planejamentoVisita = (PlanejamentoVisita) itPlanejamentoVisita.next();
			LojaSiteRegraColecao regraColecao = FabricaRegra.getInstancia().getLojaSiteRegraColecao();
			regraColecao.getFiltro().setCodigoPlanejamentoVisita(planejamentoVisita.getIdPlanejamentoVisita());
			Collection listaLojaSite = regraColecao.ListaPorPlanejamentoVisita();
			Iterator itLojaSite = listaLojaSite.iterator();
			while (itLojaSite.hasNext()) {
				LojaSite lojaSite = (LojaSite) itLojaSite.next();
			}
		}
		Collection listaVisitaCategoria = 
		CategoriaSiteManipuladorI manipulador = new CategoriaSiteManipulador();
		FacadeVisitaCategoria visitador = new FacadeVisitaCategoria();
		while (iterador.hasNext()) {
			CategoriaSite categoria = (CategoriaSite) iterador.next();
			manipulador.setCategoriaSite(categoria);
			visitador.acessaCategoria(manipulador);
		}
	}

}
