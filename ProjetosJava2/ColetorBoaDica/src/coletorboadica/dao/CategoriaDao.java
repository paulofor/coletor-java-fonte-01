package coletorboadica.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorboadica.dao.basica.*;
import coletorboadica.modelo.Categoria;

public interface CategoriaDao
 extends CategoriaDaoBaseI {

	List ListaParaPesquisa() throws DaoException; 
}
