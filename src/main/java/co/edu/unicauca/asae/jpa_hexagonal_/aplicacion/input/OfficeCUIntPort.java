package co.edu.unicauca.asae.jpa_hexagonal_.aplicacion.input;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;

import java.util.List;

public interface OfficeCUIntPort {
    public Office createOffice(Office newOffice);

    public List<Office> getAllOffices();
}
