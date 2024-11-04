package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output;

public interface ResultFormatterIntPort {

    public void returnResponseErrorEntityExists(String mensaje);

    public void returnResponseErrorBusinessRule(String mensaje);

}