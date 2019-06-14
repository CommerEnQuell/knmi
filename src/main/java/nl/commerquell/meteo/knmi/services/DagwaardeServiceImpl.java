package nl.commerquell.meteo.knmi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import nl.commerquell.meteo.knmi.model.data.Dagwaarde;
import nl.commerquell.meteo.knmi.model.key.DgwnKey;
import nl.commerquell.meteo.knmi.repositories.DagwaardeRepository;

@Service
public class DagwaardeServiceImpl implements DagwaardeService {
	
	private final DagwaardeRepository dagwaardeRepository;
	
	public DagwaardeServiceImpl(DagwaardeRepository dagwaardeRepository) {
		this.dagwaardeRepository = dagwaardeRepository;
	}

	@Override
	public Dagwaarde findById(int station, int datum) {
		DgwnKey dgwnKey = new DgwnKey(station, datum);
		Optional<Dagwaarde> o = this.dagwaardeRepository.findById(dgwnKey);
		Dagwaarde retval = null;
		if (o.isPresent()) {
			retval = o.get();
		}
		return retval;
		
	}

	@Override
	public List<Dagwaarde> findAll() {
		return this.dagwaardeRepository.findAll();
	}

}
