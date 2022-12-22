package controladores;

import org.apache.commons.net.ftp.FTPClient;

import common.DBConnection;
import common.Usuario;
import ftp.VentanaSwingFTP;
import ftp.VistaFTP;
import modelo.ConexionFtp;

public class ControladorMenuEventos {

	private static VentanaSwingFTP vista;
	private static ConexionFtp modelo;
	static FTPClient cliente = new FTPClient();
	private static ControladorLista controlLista;
	private static Usuario usuario;
	private DBConnection conexion;
	
	public ControladorMenuEventos() {
		vista = new VentanaSwingFTP();
		modelo = new ConexionFtp();
		conexion = new DBConnection();
		
		vista.setVisible(true);
		controlLista = new ControladorLista(vista,modelo,cliente,usuario);
		eventos();
	}

	private void eventos() {
		
		
		//Evento Listener de Lista De Archivos del JList FTP
		vista.getListArchivos().addListSelectionListener(new EventoListaArchivos(vista, cliente, modelo, controlLista));
		
		//Evento Botón Subir Archivo FTP
		vista.getBotones().get(0).addActionListener(new SubirArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Bajar Archivo FTP
		vista.getBotones().get(1).addActionListener(new BajarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Borrar Archivo FTP
		vista.getBotones().get(2).addActionListener(new BorrarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Renombrar Archivo FTP
		vista.getBotones().get(3).addActionListener(new RenombrarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Boton Crear Carpeta FTP
		vista.getBotones().get(4).addActionListener(new CrearCarpeta(vista,cliente,modelo,controlLista));
		
		//Evento Botón Borrar Carpeta FTP
		vista.getBotones().get(5).addActionListener(new BorrarCarpeta(vista,cliente,modelo,controlLista));
		
		//Evento Botón Volver FTP
		vista.getBotones().get(6).addActionListener(new EventoVolver(vista,cliente));
		
	}
}
