package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output;

public interface LocationFormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}