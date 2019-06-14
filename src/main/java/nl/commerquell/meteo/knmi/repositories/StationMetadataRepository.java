package nl.commerquell.meteo.knmi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.commerquell.meteo.knmi.model.data.StationMetadata;

public interface StationMetadataRepository extends JpaRepository<StationMetadata, Integer> {

}
