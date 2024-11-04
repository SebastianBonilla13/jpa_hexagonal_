package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.resultFormatters;

public interface LocationFormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}