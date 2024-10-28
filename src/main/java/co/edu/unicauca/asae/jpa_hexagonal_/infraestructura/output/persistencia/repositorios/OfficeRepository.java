package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Office;

public interface OfficeRepository extends JpaRepository<OfficeEntity, Integer> {

}
