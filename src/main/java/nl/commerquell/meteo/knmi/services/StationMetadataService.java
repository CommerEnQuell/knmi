package nl.commerquell.meteo.knmi.services;

import java.util.List;

import nl.commerquell.meteo.knmi.model.data.StationMetadata;

public interface StationMetadataService {
	List<StationMetadata> findAll();
}
