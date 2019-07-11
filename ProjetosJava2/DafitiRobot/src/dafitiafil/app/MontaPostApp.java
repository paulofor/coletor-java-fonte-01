package dafitiafil.app;

import br.com.digicom.lib.dao.DaoException;

public class MontaPostApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MontaPostObj obj = new MontaPostObj();
		try {
			obj.obtemPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
