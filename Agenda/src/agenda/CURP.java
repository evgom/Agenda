/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author erick
 */
public class CURP {

    public static String calculaCURP(String apellidoP, String apellidoM, String nombre, char sexo,
            Date fechaNac, Entidad entidad) {

        // Inicializa elementos
        String CURP = "";
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaNac);

        // Convertimos a mayúsculas.
        apellidoP = apellidoP.toUpperCase();
        apellidoM = apellidoM.toUpperCase();
        nombre = nombre.toUpperCase();
        sexo = Character.toUpperCase(sexo);

        CURP += apellidoP.charAt(0);

        // Busca primera vocal en apellido paterno
        CURP += buscaVocal(apellidoP);

        CURP += apellidoM.charAt(0);
        CURP += nombre.charAt(0);
        CURP += String.valueOf(calendario.get(Calendar.YEAR)).substring(2, 4);
        CURP += String.format("%02d", calendario.get(Calendar.MONTH));
        CURP += String.format("%02d", calendario.get(Calendar.DAY_OF_MONTH));
        CURP += sexo;
        CURP += entidad.getCodigo();

        // Busca primera consonante en apellidos y nombre, y que no sea la primera letra.
        CURP += buscaConsonante(apellidoP);
        CURP += buscaConsonante(apellidoM);
        CURP += buscaConsonante(nombre);
        
        // Homoclave
        CURP += (int)(Math.random() * 99);

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
