/**
 * 
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.DBConnection;
import common.Usuario;

/**
 * @author Israel
 *
 */
public class ListenerBtnSelector implements ActionListener {
	private DBConnection conn;
	private Usuario user;
	private VistaSelector view;
	private VistaLogin preview;
	
	public ListenerBtnSelector(DBConnection conn, Usuario user, VistaSelector view, VistaLogin preview) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.user = user;
		this.view = view;
		this.preview = preview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getText()) {
		case "FTP":
			view.setVisible(false);
//			new ControladorMenuEventos(conn, user);
			break;
		case "eMail":
			view.setVisible(false);
//			new ControladorEmail(conn, user);
			break;
		case "Manual":
			view.setVisible(false);
			break;
		case "Volver":
			view.dispose();
			preview.getUserText().setText("");
			preview.getPasswordText().setText("");
			preview.setVisible(true);
			break;
		default:
			break;
		}
	}

}