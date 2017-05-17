package agenda;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoArchivos {

    private RandomAccessFile lectorArchivo;
    private String Entrada;
    private String Salida;
    private static final String TERMINADORDELINEA = System.getProperty("line.separator");

    public AccesoArchivos(String Entrada, String Salida) {
        this.Entrada = Entrada;
        this.Salida = Salida;

        if (Entrada != null) {
            abreArchivo();
        }

    }

    public void abreArchivo() {
        File archivoEntrada = new File(Entrada);
        try {
            lectorArchivo = new RandomAccessFile(archivoEntrada, "r");
        } catch (Exception e1) {
            try {
                // Crea archivo en caso de ser necesario.
                PrintWriter writer = new PrintWriter(archivoEntrada);
                writer.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    protected void guardaArchivo(String datos) {
        try {
            File archivoSalida = new File(Salida);
            try (PrintWriter flujoSalida = new PrintWriter(archivoSalida, "UTF-8")) {
                flujoSalida.print(datos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String siguienteLinea() {
        String registro;

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
        ArrayList<String> listaCadenas = new ArrayList<>();
        String linea;
        try {
            lectorArchivo.seek(0);
        } catch (IOException ex) {
            Logger.getLogger(AccesoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        AccesoArchivos archivo = new AccesoArchivos("clientes2.txt", "clientes2.txt");
        System.out.println(archivo.siguienteLinea());
        System.out.println(archivo.siguienteLinea());
        System.out.println(archivo.siguienteLinea());
        archivo.guardaArchivo("sdfds\nohhhhhhhÑÑÓA");
        System.out.println(archivo.obtieneDatos().get(0));

    }

}
