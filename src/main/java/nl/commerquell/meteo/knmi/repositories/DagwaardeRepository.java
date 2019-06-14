package nl.commerquell.meteo.knmi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.commerquell.meteo.knmi.model.data.Dagwaarde;
import nl.commerquell.meteo.knmi.model.key.DgwnKey;

public interface DagwaardeRepository extends JpaRepository<Dagwaarde, DgwnKey> {

}
