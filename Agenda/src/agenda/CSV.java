/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author erick
 */
public class CSV {

    private final static String SEPARADOR = ", ";
    private AccesoArchivos archivos;
    private ArrayList<Persona> listaPersonas;

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    /*private String obtieneDatosPersonas() {
        String datosPersonas = null;

        StringTokenizer token = new StringTokenizer(datos, SEPARADOR, true);

        persona.setApellidoP(token.nextToken());
        persona.setApellidoM(token.nextToken());
        persona.setNombre(token.nextToken());
        persona.setFechaNac(token.nextToken());
        persona.setSexo(token.nextToken().charAt(0));
        persona.setEntidad(Entidad.valueOf(token.nextToken())); // Hacer un verificador de ENUM Entidad
        persona.setTel(Integer.parseInt(token.nextToken()));
        persona.setEmail(token.nextToken());

        return datosPersonas;
    }*/
    private String personaDatos(Persona p) {
        String datos;

        datos = p.getApellidoP() + SEPARADOR + p.getApellidoM() + SEPARADOR
                + p.getNombre() + SEPARADOR + p.getFechaNac().toString() + SEPARADOR
                + p.getSexo() + SEPARADOR + p.getEntidad().getCodigo() + SEPARADOR
                + p.getTel() + SEPARADOR + p.getEmail();

        return datos;
    }

    public CSV(String entrada, String salida) {
        archivos = new AccesoArchivos(entrada, salida);
        listaPersonas = new ArrayList<>();
    }

    public void cargaCSV() {

    }

    public void guardaCSV() {
        String datosCSV = "";

        for (Persona p : listaPersonas) {
            datosCSV += personaDatos(p) + "\n";
        }
        archivos.guardaArchivo(datosCSV);
    }

    public static void main(String[] args) {

        CSV mio = new CSV("agenda.txt", "agenda.txt");
        ArrayList<Persona> lista = new ArrayList<>();

        Persona persona1 = new Persona("Bello", "Mena", "Luis Raúl", 'H',
                new Date(1992, 3, 13), Entidad.COLIMA);
        //System.out.println(persona1.getCURP());
        persona1.setEmail("evgom@gmsd.com");
        //System.out.println(persona1.getEmail());

        Persona persona2 = new Persona("Osorio", "Merlos", "Erick Victor Gabriel",
                'h', new Date(1987, 9, 03), Entidad.DISTRITO_FEDERAL);
        persona2.setEmail("evgom.sid@gmail.com");
        //System.out.println(persona2.getCURP());

        lista.add(persona1);
        lista.add(persona2);
        mio.setListaPersonas(lista);
        mio.guardaCSV();

    }

}
