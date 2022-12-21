package controladores;

import org.apache.commons.net.ftp.FTPClient;

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
	
	public ControladorMenuEventos() {
		vista = new VentanaSwingFTP();
		modelo = new ConexionFtp();
		
		vista.setVisible(true);
		controlLista = new ControladorLista(vista,modelo,cliente,usuario);
		eventos();
	}

	private void eventos() {
		
		
		//Evento Listener de Lista De Archivos del JList FTP
		vista.getListArchivos().addListSelectionListener(new EventoListaArchivos(vista, cliente, modelo, controlLista));
		
		//Evento Botón Subir Archivo FTP
		vista.getBtnSubir().addActionListener(new SubirArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Bajar Archivo FTP
		vista.getBtnBajar().addActionListener(new BajarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Borrar Archivo FTP
		vista.getBtnBorrarAr().addActionListener(new BorrarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Botón Renombrar Archivo FTP
		vista.getBtnRenombrar().addActionListener(new RenombrarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Boton Crear Carpeta FTP
		vista.getBtnCrearCarpeta().addActionListener(new CrearCarpeta(vista,cliente,modelo,controlLista));
		
		//Evento Botón Borrar Carpeta FTP
		vista.getBtnBorrarCarpeta().addActionListener(new BorrarCarpeta(vista,cliente,modelo,controlLista));
		
		//Evento Botón Volver FTP
		vista.getBtnVolver().addActionListener(new EventoVolver(vista,cliente));
		
	}
}