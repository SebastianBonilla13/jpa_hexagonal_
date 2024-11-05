package co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.jpa_hexagonal_.infraestructura.output.persistencia.entidades.LocationEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    @Query("SELECT count(*) FROM LocationEntity p  WHERE p.id=?1")
    Integer existeLocationPorCodigo(String id);

    @Query("""
                SELECT l FROM LocationEntity l
                WHERE l.name LIKE %:pattern%
                AND l.capacity >= :capacity
                ORDER BY l.name ASC
            """)
    List<LocationEntity> findAllLocationsCustom(@Param("pattern") String pattern, @Param("capacity") Integer capacity);

}
