package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.output.LocationFormateadorResultadosIntPort;

@Service
public class FormateadorResultadosImplAdapter implements LocationFormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        // TODO Auto-generated method stub

    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        // TODO Auto-generated method stub

    }

}