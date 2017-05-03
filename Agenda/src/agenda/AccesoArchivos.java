import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AccesoArchivos {
	private RandomAccessFile lectorArchivo;
	private String Entrada;
	private String Salida;
	private static String terminadorLinea = System.getProperty("line.separator");
	ArrayList<String> listaCadenas;

	public AccesoArchivos(String Entrada, String Salida) {
		listaCadenas = new ArrayList<String>();
		this.Entrada = Entrada;
		this.Salida = Salida;
		
		if (Entrada != null)
			abreArchivo();
		
	}

	public void abreArchivo() {
		File archivoEntrada = new File(Entrada);
		try {
			lectorArchivo = new RandomAccessFile(archivoEntrada, "r");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void guardaArchivo(String datos) {
		try {
			File archivoSalida = new File(Salida);
			PrintWriter flujoSalida = new PrintWriter(archivoSalida);

			flujoSalida.print(datos);
			flujoSalida.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String siguienteLinea() {
		String registro = null;

		try {
			registro = lectorArchivo.readLine();
			// Convertimos a UTF-8
			registro = new String(registro.getBytes("ISO-8859-1"), "UTF-8");

		} catch (Exception e) {
			registro = null;
		}

		return registro;
	}

	protected ArrayList<String> obtieneDatos() {
		String linea;

		try {

			while ((linea = siguienteLinea()) != null) {
				listaCadenas.add(linea);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listaCadenas;
	}

	public static void main(String[] args) {
		AccesoArchivos archivo = new AccesoArchivos("clientes.txt", "clientes2.txt");
		System.out.println(archivo.siguienteLinea());
		System.out.println(archivo.siguienteLinea());
		System.out.println(archivo.siguienteLinea());
		archivo.guardaArchivo("sdfds\nohhhhhhhÑÑÓA");
		
	}

}
