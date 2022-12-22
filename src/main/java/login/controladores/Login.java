/**
 * 
 */
package login.controladores;

import common.DBConnection;
import login.listeners.LogBtnListener;
import login.vistas.VistaLogin;

/**
 * @author Israel
 *
 */
public class Login {
	DBConnection conn = new DBConnection();
	VistaLogin view;
	
	public Login() {
		conn.crearConexion();
		view = new VistaLogin();
		LogBtnListener list = new LogBtnListener(conn, view);
		view.getLoginBoton().addActionListener(list);
		view.setVisible(true);
	}
}