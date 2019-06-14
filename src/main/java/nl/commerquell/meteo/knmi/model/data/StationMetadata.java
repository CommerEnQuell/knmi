package nl.commerquell.meteo.knmi.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="station_meta")
public class StationMetadata {
	
	@Column(name="station")
	@Id
	private int station;
	
	@Column(name="naam")
	private String naam;
	
	@Column(name="datum_n")
	private int datumVan;
	
	@Column(name="datum_x")
	private int datumTot;

	public int getStation() {
		return station;
	}

	public String getNaam() {
		return naam;
	}

	public int getDatumVan() {
		return datumVan;
	}

	public int getDatumTot() {
		return datumTot;
	}
}
