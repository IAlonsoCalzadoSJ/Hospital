package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class BajarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;

	public BajarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista) {
		this.cliente = cliente;
		this.controlLista = controlLista;
		this.cliente = cliente;
		this.modelo = modelo;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = modelo.getDirecSelec();
		if (!modelo.getDirecSelec().equals("/")) {
			directorio = directorio + "/";
		};

		if (!modelo.getFicheroSelec().equals("")) {
			bajarArchivo(directorio + modelo.getFicheroSelec(), modelo.getFicheroSelec());
			modelo.setFicheroSelec("");
		};

	}

	private void bajarArchivo(String fichero, String nombreFichero) {
		File file;
		String destino = "";
		String carpetaDestino = "";
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle("Selecciona la carpeta donde descargar el archivo");

		int val = chooser.showDialog(chooser, "Descargar");
		if (val == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			carpetaDestino = file.getAbsolutePath().toString();
			destino = carpetaDestino + File.separator + nombreFichero;
			try {
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destino));
				if (cliente.retrieveFile(nombreFichero, out)) {
					JOptionPane.showMessageDialog(null, nombreFichero + " Se ha descargado");
				} else {
					JOptionPane.showMessageDialog(null, nombreFichero + " No se ha podido descargar");
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}