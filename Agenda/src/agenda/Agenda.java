/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Date;

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
                new Date(1992, 3, 13), Entidad.COLIMA );
        System.out.println(persona1.getCURP());
        persona1.setEmail("evgom@gmsd.com");
        System.out.println(persona1.getEmail());
        
        Persona persona2 = new Persona("Osorio", "Merlos", "Erick Victor Gabriel",
                'h', new Date(1987, 9, 03), Entidad.DISTRITO_FEDERAL);
        System.out.println(persona2.getCURP());

        
    }
    
}
