/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 *
 * @author erick
 */
public class CSV {

    private final static String SEPARADOR = ",";
    private AccesoArchivos archivos;
    private ArrayList<Persona> listaPersonas;

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    private Persona establecePersona(String datos) {
        Persona persona = new Persona();
        StringTokenizer token = new StringTokenizer(datos, SEPARADOR);

        /*while (token.hasMoreTokens()) {
            System.out.println(token.nextToken().trim());
        }*/
        persona.setApellidoP(token.nextToken().trim());
        persona.setApellidoM(token.nextToken().trim());
        persona.setNombre(token.nextToken().trim());
        persona.setFechaNac(token.nextToken().trim()); //Realizar correctamente esta parte
        persona.setSexo(token.nextToken().trim().charAt(0));
        persona.setEntidad(Entidad.valueOf(token.nextToken().trim())); // Hacer un verificador de ENUM Entidad
        persona.setTel(token.nextToken().trim());

        // El caso en que el e-mail esté vacío
        if (token.hasMoreTokens()) {
            persona.setEmail(token.nextToken().trim());
        } else {
            persona.setEmail("");
        }
        return persona;
    }

    private String personaDatos(Persona p) {
        String datos;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

        datos = p.getApellidoP() + SEPARADOR + p.getApellidoM() + SEPARADOR
                + p.getNombre() + SEPARADOR + sdf.format(p.getFechaNac().getTime()) + SEPARADOR
                + p.getSexo() + SEPARADOR + p.getEntidad().toString() + SEPARADOR
                + p.getTel() + SEPARADOR + p.getEmail();

        return datos;
    }

    public CSV(String entrada, String salida) {
        archivos = new AccesoArchivos(entrada, salida);
        listaPersonas = new ArrayList<>();
    }

    public void cargaCSV() {
        String linea;
        while ((linea = archivos.siguienteLinea()) != null) {
            listaPersonas.add(establecePersona(linea));
        }
    }

    public void guardaCSV() {
        String datosCSV = "";

        for (Persona p : listaPersonas) {
            datosCSV += personaDatos(p) + "\n";
        }
        archivos.guardaArchivo(datosCSV);
    }

    public static void main(String[] args) {

        CSV mio = new CSV("agenda.csv", "agenda.csv");
        ArrayList<Persona> lista = new ArrayList<>();

        Persona persona1 = new Persona("Bello", "Mena", "Luis Raúl", 'H',
                new GregorianCalendar(1992, 3 - 1, 13), Entidad.COLIMA);
        persona1.setTel("123456");
        System.out.println(persona1.getCURP());
        persona1.setEmail("evgom@gmsd.com");
        System.out.println(persona1.getEmail());

        Persona persona2 = new Persona("Osorio", "Merlos", "Erick Victor Gabriel",
                'h', new GregorianCalendar(1987, Calendar.SEPTEMBER, 03), Entidad.DISTRITO_FEDERAL);
        persona2.setTel("55 3025 6550");
        System.out.println(persona2.getCURP());

        lista.add(persona1);
        lista.add(persona2);
        mio.setListaPersonas(lista);
        //mio.guardaCSV();
        mio.cargaCSV();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        System.out.println(sdf.format(mio.getListaPersonas().get(0).getFechaNac().getTime()));
        System.out.println(sdf.format(mio.getListaPersonas().get(1).getFechaNac().getTime()));

    }
}
