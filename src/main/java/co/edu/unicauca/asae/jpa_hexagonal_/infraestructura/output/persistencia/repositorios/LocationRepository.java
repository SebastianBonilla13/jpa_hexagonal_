package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    @Query("SELECT count(*) FROM LocationEntity p  WHERE p.id=?1")
    Integer existeLocationPorCodigo(String id);
}
