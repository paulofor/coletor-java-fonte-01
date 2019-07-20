package br.com.digicom.lib.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import br.com.digicom.lib.DCIObjetoDominio;

public class MontadorDaoComposite implements MontadorDaoI {

	private List classes;
	private List montadores;
	private List propriedades;

	public MontadorDaoComposite() {
		classes = new LinkedList();
		montadores = new LinkedList();
		propriedades = new LinkedList();
	}

	public void adicionaMontador(MontadorDaoI montador, String nomePropriedade) {
		montadores.add(montador);
		propriedades.add(nomePropriedade);
	}

	// public delegate void SetObjeto(DCIObjetoDominio objeto);
	private Object montaObjetoPrincipal(ResultadoLista resultadoLista,
			DCIObjetoDominio objeto) throws DaoException {
		Object objFinal = null;
		// Objeto Principal
		int posicao = 1;
		String propriedade = null;
		MontadorDaoI oi = (MontadorDaoI) this.montadores.get(0);
		objeto = oi.extraiRegistro(resultadoLista);
		posicao += oi.quantidadeCampos();
		for (int i = 1; i < this.montadores.size(); i++) {
			propriedade = (String) this.propriedades.get(i);
			oi = (MontadorDaoI) this.montadores.get(i);
			try {

				Class classeVo = obtemClasseVo(objeto);
				DCIObjetoDominio dominio2 = oi.extraiRegistro(resultadoLista,
						posicao);
				Class classeDominio2 = obtemClasseInterface(dominio2);
				Method metodo = classeVo.getMethod("set" + propriedade,
						new Class[] { classeDominio2 });
				metodo.invoke(objeto, dominio2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// PropertyInfo info = this.posicionaObjeto(objeto, propriedade,
			// objFinal);
			// info.SetValue(objFinal, dominio2, null);

			posicao += oi.quantidadeCampos();
		}
		return objFinal;
	}

	public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista,
			DCIObjetoDominio objeto, int posicao) throws DaoException {
		return null;
	}

	public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista) throws DaoException {
		
		MontadorDaoI montador = (MontadorDaoI) montadores.get(0);
		DCIObjetoDominio saida = montador.extraiRegistro(resultadoLista);
		int campo = montador.quantidadeCampos() + 1;
		try {
			for (int i=1;i<montadores.size();i++) {
				montador = (MontadorDaoI) montadores.get(i);
				DCIObjetoDominio obj2 = montador.extraiRegistro(resultadoLista, campo);
				if (obj2.getIdObj()!=0) {
					String prop = this.propriedades.get(i).toString();
					try {
						this.setObjetoInterno(saida, obj2, "set" + prop);
					} catch (NoSuchMethodException e) {
						this.setObjetoInterno(saida, obj2, "addLista" + prop);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return saida;
	}

	public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista,
			int posicao) throws DaoException {
		return null;
	}

	public int quantidadeCampos() {
		return 0;
	}

	private Class obtemClasseVo(Object objeto) throws ClassNotFoundException {
		return objeto.getClass();
	}

	private Class obtemClasseInterface(Object objeto)
			throws ClassNotFoundException {
		Class classe = objeto.getClass();
		String nome = classe.getName();
		String nome2 = nome.replace(".vo", "");
		String nomeVo = nome2.replaceAll("Vo", "");
		Class classeVo = Class.forName(nomeVo);
		return classeVo;
	}


	public DaoItemRetorno extraiRegistroListaInterna(
			ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
			throws DaoException, ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		DaoItemRetorno itemRetorno = new DaoItemRetorno();
		boolean saida = false;

		Object objAux = null;
		if (objeto == null) {
			// Objeto Principal - Inicial
			int posicao = 1;
			String propriedade = null;
			MontadorDaoI oi = (MontadorDaoI) this.montadores.get(0);
			// Obtem o primeiro objeto
			objeto = oi.extraiRegistro(paramResultadoLista);
			posicao += oi.quantidadeCampos();
			for (int i = 1; i < this.montadores.size(); i++) {
				// loop nos montadores
				propriedade = (String) this.propriedades.get(i);
				oi = (MontadorDaoI) this.montadores.get(i);
				// posiciona objeto que vai ter o metodo set acionado
				objAux = posicionaObjeto(objeto, propriedade);
				// novo objeto
				DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista,posicao);
				posicao += oi.quantidadeCampos();
				// seta objeto
				Class classeVo = obtemClasseVo(objAux);
				Class classeDominio2 = obtemClasseInterface(obj2);

				Method metodo = null;
				try {
					metodo = classeVo.getMethod( "set" + propriedade,	new Class[] { classeDominio2 });
					metodo.invoke(objAux, obj2);
				} catch (NoSuchMethodException e) {
					try {
						metodo = classeVo.getMethod( "add" + propriedade,	new Class[] { classeDominio2 });
						metodo.invoke(objAux, obj2);
					} catch (NoSuchMethodException e2) {
						metodo = classeVo.getMethod( "addLista" + propriedade,	new Class[] { classeDominio2 });
						metodo.invoke(objAux, obj2);
					}
				}
				
 
				// Inser��o
				saida = true;
			}
		} else {
			// Ja existe um objeto
			int posicao = 1;
			String propriedade = null;
			MontadorDaoI oi = (MontadorDaoI) this.montadores.get(0);
			// Obteve primeiro objeto do pr�ximo registro
			DCIObjetoDominio objetoNovo = oi.extraiRegistro(paramResultadoLista);
			if (objetoNovo.getIdObj() == objeto.getIdObj()) {
				// Se for o mesmo significa que � um objeto para adicionar em
				// lista
				posicao += oi.quantidadeCampos();
				for (int i = 1; i < this.montadores.size(); i++) {
					// posiciona objeto que vai ter o metodo set acionado
					
					propriedade = (String) this.propriedades.get(i);
					oi = (MontadorDaoI) this.montadores.get(i);
					objAux = posicionaObjeto(objeto, propriedade);	
					// novo objeto
					DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista, posicao);
					// seta objeto dentro do que ja esta na lista
					Class classeVo = obtemClasseVo(objAux);
					Class classeDominio2 = obtemClasseInterface(obj2);
					Method metodo = null;
					try {
						// esse arqui nao tinha set
						metodo = classeVo.getMethod("set" + propriedade,	new Class[] { classeDominio2 }); // trocar set por add 
						metodo.invoke(objAux, obj2);
					} catch (NoSuchMethodException e) {
						try {
							metodo = classeVo.getMethod( "add" + propriedade,	new Class[] { classeDominio2 });
							metodo.invoke(objAux, obj2);
						} catch (NoSuchMethodException e2) {
							metodo = classeVo.getMethod( "addLista" + propriedade,	new Class[] { classeDominio2 });
							metodo.invoke(objAux, obj2);
						}
					}

					posicao += oi.quantidadeCampos();
				}
				saida = false;
			} else {
				// � um novo objeto principal para ser incluido na lista
				objeto = objetoNovo;
				posicao += oi.quantidadeCampos();
				for (int i = 1; i < this.montadores.size(); i++) {
					propriedade = (String) this.propriedades.get(i);
					oi = (MontadorDaoI) this.montadores.get(i);
					// posiciona objeto que vai ter o metodo set acionado
					objAux = posicionaObjeto(objeto, propriedade);
					// novo objeto
					DCIObjetoDominio obj2 = oi.extraiRegistro(paramResultadoLista, posicao);
					// seta objeto
					Class classeVo = obtemClasseVo(objAux);
					Class classeDominio2 = obtemClasseInterface(obj2);
					Method metodo = null;
					try {
						metodo = classeVo.getMethod("set" + propriedade,	new Class[] { classeDominio2 });
						metodo.invoke(objAux, obj2);
					} catch (NoSuchMethodException e) {
						try {
							metodo = classeVo.getMethod( "add" + propriedade,	new Class[] { classeDominio2 });
							metodo.invoke(objAux, obj2);
						} catch (NoSuchMethodException e2) {
							metodo = classeVo.getMethod( "addLista" + propriedade,	new Class[] { classeDominio2 });
							metodo.invoke(objAux, obj2);
						}
					}
					posicao += oi.quantidadeCampos();
				}
				saida = true;
			}

		}
		itemRetorno.setInsere(saida);
		itemRetorno.setObjeto(objeto);
		return itemRetorno;
	}


	public DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista,
			DCIObjetoDominio objeto) throws DaoException {
		
		return null;
	}

	private Object posicionaObjeto(Object objetoRaiz, String propriedade)
			throws ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		// Percorrendo a arvore de objetos at� chegar no desejado.
		DCIObjetoDominio proximoObjeto;
		Object saida = objetoRaiz;
		if (propriedade==null)  return saida;
		String[] prop = propriedade.split(".");
		for (int i = 0; i < prop.length; i++) {
			String propCorrente = prop[i];
			Class objetoVo = obtemClasseVo(saida);
			Class objetoI = obtemClasseInterface(saida);
			Method metodo = objetoVo.getMethod("get" + propriedade);
			saida = metodo.invoke(objetoVo);
		}

		return saida;

	}
	
	
	private void setObjetoInterno(Object objetoRaiz, Object objInsert, String propriedade) throws ReflectiveOperationException, SecurityException {
		Class objetoVo = obtemClasseVo(objetoRaiz);
		Class classeDominio2 = obtemClasseInterface(objInsert);
		Method metodo = objetoVo.getMethod(propriedade,	new Class[] { classeDominio2 });
		metodo.invoke(objetoRaiz, objInsert);
	}
	
	private Object posicionaObjetoComItemUnico(Object objetoRaiz, String propriedade)
			throws ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		// Percorrendo a arvore de objetos at� chegar no desejado.
		DCIObjetoDominio proximoObjeto;
		Object saida = objetoRaiz;
		if (propriedade==null)  return saida;
		String[] prop = propriedade.split(".");
		if (prop.length == 0) {
			prop = new String[1];
			prop[0] = propriedade;
		}
		for (int i = 0; i < prop.length; i++) {
			String propCorrente = prop[i];
			Class objetoVo = obtemClasseVo(saida);
			Class objetoI = obtemClasseInterface(saida);
			Method metodo = objetoVo.getMethod("get" + propriedade);
			saida = metodo.invoke(objetoVo);
		}

		return saida;

	}


}

/*
 * Location: D:\Java-Recuperacao\daolib.jar Qualified Name:
 * br.com.digicom.lib.dao.MontadorDaoComposite JD-Core Version: 0.6.0
 */