package nl.commerquell.meteo.knmi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nl.commerquell.meteo.knmi.model.data.StationMetadata;
import nl.commerquell.meteo.knmi.repositories.StationMetadataRepository;

@Service
public class StationMetadataServiceImpl implements StationMetadataService {
	private final StationMetadataRepository stationMetadataRepository;
	
	public StationMetadataServiceImpl(StationMetadataRepository stationMetadataRepository) {
		this.stationMetadataRepository = stationMetadataRepository;
	}
	
	@Override
	public List<StationMetadata> findAll() {
		return this.stationMetadataRepository.findAll();
	}

}
