/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.StringTokenizer;

/**
 *
 * @author erick
 */
public class CSV {

    private final static String separador = ", ";
    private AccesoArchivos archivo;
    private String datos;
    private Persona persona;

    public void CSV(String datos) {
        this.datos = datos;

        StringTokenizer token = new StringTokenizer(datos, separador, true);

        persona.setApellidoP(token.nextToken());
        persona.setApellidoM(token.nextToken());
        persona.setNombre(token.nextToken());
        persona.setFechaNac(token.nextToken());
        persona.setSexo(token.nextToken().charAt(0));
        persona.setEntidad(Entidad.valueOf(token.nextToken())); // Hacer un verificador de ENUM Entidad
        persona.setTel(Integer.parseInt(token.nextToken()));
        persona.setEmail(token.nextToken());

    }

    public void CSV(Persona p) {
        persona = p;
        datos = p.getApellidoP() + separador + p.getApellidoM() + separador
                + p.getNombre() + separador + p.getFechaNac().toString() + separador
                + p.getSexo() + separador + p.getEntidad().getCodigo() + separador
                + p.getTel() + separador + p.getEmail();
    }

}
