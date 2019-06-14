package nl.commerquell.meteo.knmi.model.key;

import java.io.Serializable;

public class DgwnKey implements Serializable {
	private int station;
	private int datum;
	
	public DgwnKey() {
		this(0, 0);
	}
	
	public DgwnKey(int station, int datum) {
		this.station = station;
		this.datum = datum;
	}
	
	public int getStation() {
		return station;
	}
	
	public void setStation(int station) {
		this.station = station;
	}
	
	public int getDatum() {
		return datum;
	}

	public void setDatum(int datum) {
		this.datum = datum;
	}
}
