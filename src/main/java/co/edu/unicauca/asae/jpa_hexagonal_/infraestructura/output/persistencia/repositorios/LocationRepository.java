package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.asae.jpa_hexagonal_.dominio.modelos.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT count(*) FROM LocationEntity p  WHERE p.codigo=?1")
    Integer existeLocationPorCodigo(String codigo);
}
