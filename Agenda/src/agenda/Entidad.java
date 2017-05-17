/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author erick
 */
public enum Entidad {
    AGUASCALIENTES("Aguascalientes", "AS"),
    BAJA_CALIFORNIA("Baja California", "BC"),
    BAJA_CALIFORNIA_SUR("Baja California Sur", "BS"),
    CAMPECHE("Campeche", "CC"),
    COAHUILA("Coahuila", "CL"),
    COLIMA("Colima", "CM"),
    CHIAPAS("Chiapas", "CS"),
    CHIHUAHUA("Chihuahua", "CH"),
    DISTRITO_FEDERAL("Distrito Federal", "DF"),
    DURANGO("Durango", "DG"),
    GUANAJUATO("Guanajuato", "GT"),
    GUERRERO("Guerrero", "GR"),
    HIDALGO("Hidalgo", "HG"),
    JALISCO("Jalisco", "JC"),
    MEXICO("México", "MC"),
    MICHOACAN("Michoacán", "MN"),
    MORELOS("Morelos", "MS"),
    NAYARIT("Nayarit", "NT"),
    NUEVO_LEON("Nuevo León", "NL"),
    OAXACA("Oaxaca", "OC"),
    PUEBLA("Puebla", "PL"),
    QUERETARO("Querétaro", "QT"),
    QUINTANA_ROO("Quintana Roo", "QR"),
    SAN_LUIS_POTOSI("San Luis Potosí", "SP"),
    SINALOA("Sinaloa", "SL"),
    SONORA("Sonora", "SR"),
    TABASCO("Tabasco", "TC"),
    TAMAULIPAS("Tamaulipas", "TS"),
    TLAXCALA("Tlaxcala", "TL"),
    VERACRUZ("Veracruz", "VZ"),
    YUCATAN("Yucatán", "YN"),
    ZACATECAS("Zacatecas", "ZS"),
    NACIDO_EN_EL_EXTRANJERO("Nacido en el extranjero", "NE");

    private final String nombre, codigo;

    Entidad(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public static void main(String[] args) {
        //System.out.println(Entidad.AGUASCALIENTES.getCodigo());
        Entidad entidad;
        entidad = Entidad.AGUASCALIENTES;

        System.out.println(entidad.toString() + "\n"
                + entidad.getCodigo() + "\n"
                + entidad.getNombre());

        // entidad = new Entidad(nombre, codigo);
        //for (Entidad tmp: Entidad.values())
        //  System.out.println(tmp.toString());
        entidad = Entidad.valueOf("ZACATECAS");
        System.out.println(entidad.toString() + "\n"
                + entidad.getCodigo() + "\n"
                + entidad.getNombre());
    }

}
