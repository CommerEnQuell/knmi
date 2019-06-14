package nl.commerquell.meteo.knmi.services;

import java.util.List;

import nl.commerquell.meteo.knmi.model.data.Dagwaarde;

public interface DagwaardeService {
	Dagwaarde findById(int station, int datum);
	List<Dagwaarde> findAll();
}

