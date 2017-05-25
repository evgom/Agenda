/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author erick
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1 = new Persona("Bello", "Mena", "Luis Raúl", 'H',
                new GregorianCalendar(1992, 3 - 1, 13), Entidad.COLIMA);
        System.out.println(persona1.getCURP());
        persona1.setEmail("evgom@gmsd.com");
        System.out.println(persona1.getEmail());

        Persona persona2 = new Persona("Osorio", "Merlos", "Erick Victor Gabriel",
                'h', new GregorianCalendar(1987, Calendar.SEPTEMBER, 03), Entidad.DISTRITO_FEDERAL);
        System.out.println(persona2.getCURP());

        GregorianCalendar calendario = new GregorianCalendar(1987, Calendar.SEPTEMBER, 03);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        System.out.println(sdf.format(calendario.getTime()));

        persona1.setTel("55");
        persona1.setTel(" 55");
        persona1.setTel(" 55 33");
        persona1.setTel("AA");
        persona1.setTel("55*");

    }

}
