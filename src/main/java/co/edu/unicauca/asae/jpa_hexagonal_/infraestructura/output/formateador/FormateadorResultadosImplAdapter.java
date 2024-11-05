package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.ResultFormatterIntPort;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class FormateadorResultadosImplAdapter implements ResultFormatterIntPort {

    @Override
    public void returnResponseErrorEntityExists(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void returnResponseErrorBusinessRule(String mensaje) {
        throw new ReglaNegocioExcepcion(mensaje);
    }

}