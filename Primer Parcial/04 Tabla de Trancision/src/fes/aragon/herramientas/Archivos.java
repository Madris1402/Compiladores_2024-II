package fes.aragon.herramientas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Archivos {

	// Variables para la lectura y escritura
	private BufferedReader lector;
	private String linea;
	private int indice = 0;
	private int indiceFilas = 0;
	private boolean lenguajeRegistrado = false;

	// Creamos una lista simple
	String[] token = new String[15];
	public ArrayList<String> documento = new ArrayList<String>();
	int[][] matriz;
	String[] lenguaje;

	// Objetos
	Lexico app = new Lexico();

	public int[][] leerMatriz(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			linea = lector.readLine();
			token = linea.split(" ");
			int i = 0; // Se suma una columna para fin de cadena
			int[][] matriz = new int[Integer.parseInt(token[i])][Integer.parseInt(token[i + 1]) + 1];
			while ((linea = lector.readLine()) != null) {
				token = linea.split(" ");
				if (!lenguajeRegistrado) { // Registra la segunda l�nea del documento en el array lenguaje
					String[] lenguaje = new String[token.length + 1];
					for (i = 0; i < token.length; i++) {
						lenguaje[i] = token[i];
					}
					lenguaje[i] = ";";
					lenguajeRegistrado = true;
					this.lenguaje = lenguaje;
				} else {// Registra el resto de lineas del documento o estados en la matriz
					for (i = 0; i < token.length; i++) {
						matriz[indiceFilas][i] = Integer.parseInt(token[i]);
					}
					indiceFilas++;
				}

			}
			lector.close();
			linea = null;
			this.matriz = matriz;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return matriz;

	}

	private void leerPalabras(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			while ((linea = lector.readLine()) != null) {
				documento.add(linea);
			}
			lector.close();
			linea = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void analizarPalabras() {
		String nombreArchivoM = System.getProperty("user.dir") + File.separator + "matriz.txt";
		String nombreArchivo = System.getProperty("user.dir") + File.separator + "fuente.txt";
		leerMatriz(nombreArchivoM);
		leerPalabras(nombreArchivo);

		while (indice <= documento.size() - 1) {
			app.setToken(documento.get(indice));
			try {
				int verifica = app.inicio(matriz);
				if (verifica == 1) {
					System.out.println(documento.get(indice) + ": Cadena valida");
				} else {
					System.out.println(documento.get(indice) + ": Cadena invalida");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			indice++;
		}

	}

}
