/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author erick
 */
public class CURP {

    public static String calculaCURP(String apellidoP, String apellidoM, String nombre, char sexo,
            GregorianCalendar fechaNac, Entidad entidad) {

        // Inicializa elementos
        String CURP = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

        // Convertimos a mayúsculas.
        apellidoP = apellidoP.toUpperCase();
        apellidoM = apellidoM.toUpperCase();
        nombre = nombre.toUpperCase();
        sexo = Character.toUpperCase(sexo);

        try {
            CURP += apellidoP.charAt(0);

            // Busca primera vocal en apellido paterno
            CURP += buscaVocal(apellidoP);

            CURP += apellidoM.charAt(0);
            CURP += nombre.charAt(0);
            CURP += sdf.format(fechaNac.getTime());
            CURP += sexo;
            CURP += entidad.getCodigo();

            // Busca primera consonante en apellidos y nombre, y que no sea la primera letra.
            CURP += buscaConsonante(apellidoP);
            CURP += buscaConsonante(apellidoM);
            CURP += buscaConsonante(nombre);

            // Homoclave
            //CURP += (int)(Math.random() * 99);
            CURP += 01;
        } catch (Exception e) {
            //System.out.println(e.toString());
            CURP = "Datos incompletos o inválidos.";
        }

        return CURP;
    }

    private static char buscaConsonante(String palabra) {
        char caracter = 0;

        for (int i = 1; i < palabra.length(); i++) {
            if (!(palabra.charAt(i) == 'A' || palabra.charAt(i) == 'E'
                    || palabra.charAt(i) == 'I' || palabra.charAt(i) == 'O'
                    || palabra.charAt(i) == 'U')) {
                caracter = palabra.charAt(i);
                break;
            }
        }
        return caracter;
    }

    private static char buscaVocal(String palabra) {
        char caracter = 0;

        for (int i = 1; i < palabra.length(); i++) {
            if ((palabra.charAt(i) == 'A' || palabra.charAt(i) == 'E'
                    || palabra.charAt(i) == 'I' || palabra.charAt(i) == 'O'
                    || palabra.charAt(i) == 'U')) {
                caracter = palabra.charAt(i);
                break;
            }
        }
        return caracter;
    }
}
