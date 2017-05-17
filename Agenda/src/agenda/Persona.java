/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author erick
 */
public class Persona {

    private String apellidoP, apellidoM, nombre, email;
    private GregorianCalendar fechaNac;
    private char sexo;
    private Entidad entidad;
    private int tel;

    public Persona() {
        this.apellidoP = "";
        this.apellidoM = "";
        this.nombre = "";
        this.sexo = 0;
        this.fechaNac = new GregorianCalendar(1900, Calendar.JANUARY, 1);
        this.entidad = Entidad.NACIDO_EN_EL_EXTRANJERO;
    }

    public Persona(String apellidoP, String apellidoM, String nombre, char sexo,
            GregorianCalendar fechaNac, Entidad entidad) {
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.entidad = entidad;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        int[] elementos = new int[3];
        StringTokenizer token = new StringTokenizer(fechaNac, " ");

        for (int i = 0; i <= 2; i++) {
            elementos[i] = Integer.parseInt(token.nextToken());
        }

        // Se quita un elemento al mes porque los meses se cuentan de 0-11
        this.fechaNac = new GregorianCalendar(elementos[0], elementos[1] - 1, elementos[2]);
    }

    public String getCURP() {
        return agenda.CURP.calculaCURP(getApellidoP(), getApellidoM(), getNombre(),
                getSexo(), getFechaNac(), getEntidad());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern regExpEmail = Pattern.compile(PATTERN_EMAIL);
        if (regExpEmail.matcher(email).matches()) {
            this.email = email;
        } else {
            this.email = "";
        }
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        if (tel > 0) {
            this.tel = tel;
        } else {
            this.tel = 0;
        }
    }

}
