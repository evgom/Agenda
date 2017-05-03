/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author erick
 */
public class Persona {

    private String apellidoP, apellidoM, nombre, CURP, email;
    private Date fechaNac;
    private char sexo;
    private Entidad entidad;
    private int tel;

    public Persona(String apellidoP, String apellidoM, String nombre, char sexo,
            Date fechaNac, Entidad entidad) {
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.entidad = entidad;
        calculaCURP();
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
        calculaCURP();
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
        calculaCURP();
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
        calculaCURP();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        calculaCURP();
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
        calculaCURP();
    }

    public String getCURP() {
        return CURP;
    }

    private void calculaCURP() {
        CURP = new CURP().calculaCURP(getApellidoP(), getApellidoM(), getNombre(),
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
