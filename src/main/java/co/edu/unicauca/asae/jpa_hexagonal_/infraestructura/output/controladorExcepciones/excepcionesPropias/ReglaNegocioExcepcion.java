package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;

public class ReglaNegocioExcepcion extends GestionClientesRuntimeException {

    private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

    private String reglaNegocio;

    public ReglaNegocioExcepcion(String reglaNegocio) {
        super(CodigoError.VIOLACION_REGLA_DE_NEGOCIO);
        this.reglaNegocio = reglaNegocio;
    }

    @Override
    public String formatException() {
        return String.format(FORMATO_EXCEPCION, codigoError.getCodigo(), reglaNegocio);
    }
}
