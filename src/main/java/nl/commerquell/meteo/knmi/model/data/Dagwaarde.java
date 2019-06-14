package nl.commerquell.meteo.knmi.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import nl.commerquell.meteo.knmi.model.key.DgwnKey;

@Entity
@IdClass(DgwnKey.class)
@Table(name = "dagwaarden")
public class Dagwaarde {
	
	@Id
	@Column(name="station")
	private int station;
	
	@Id
	@Column(name="datum")
	private int datum;

	@Column(name="jul_datum_1901")
	private int julDatum;
	
	@Column(name="w_richting")
	private Integer windrichting;
	
	@Column(name="w_snelheid_g")
	private Integer gemWindsnelheid;

	@Column(name="w_snelheid_x")
	private Integer maxWindsnelheid;
	
	@Column(name="w_uur_x")
	private Integer maxWindsnelheidUur;

	@Column(name="w_snelheid_n")
	private Integer minWindsnelheid;

	@Column(name="w_uur_n")
	private Integer minWindsnelheidUur;

	@Column(name="w_stoot_x")
	private Integer maxWindstoot;

	@Column(name="w_stoot_uur_x")
	private Integer maxWindstootUur;

	@Column(name="temp_g")
	private int gemTemperatuur;

	@Column(name="temp_g_gefuckt")
	private Integer gemTemperatuurGefuckt;

	@Column(name="temp_n")
	private int minTemperatuur;

	@Column(name="temp_n_gefuckt")
	private Integer minTemperatuurGefuckt;

	@Column(name="temp_n_uur")
	private Integer minTemperatuurUur;

	@Column(name="temp_x")
	private int maxTemperatuur;

	@Column(name="temp_x_gefuckt")
	private Integer maxTemperatuurGefuckt;

	@Column(name="temp_x_uur")
	private Integer maxTemperatuurUur;

	@Column(name="temp_10cm_n")
	private Integer minGrondTemperatuur;

	@Column(name="temp_10cm_n_uur")
	private Integer minGrondTemperatuurUur;

	@Column(name="zon_duur")
	private Integer duurZon;

	@Column(name="zon_perc")
	private Integer percZon;

	@Column(name="straling")
	private Integer straling;

	@Column(name="neersl_duur")
	private Integer duurNeerslag;

	@Column(name="neersl_som")
	private Integer somNeerslag;

	@Column(name="neersl_uursom_x")
	private Integer maxUursomNeerslag;

	@Column(name="neersl_x_uur")
	private Integer uurMaxNeerslag;

	@Column(name="druk_0_nap_g")
	private Integer gemLuchtdrukZeeniveau;

	@Column(name="druk_0_nap_x")
	private Integer maxLuchtdrukZeeniveau;

	@Column(name="druk_x_uur")
	private Integer maxLuchtdrukUur;

	@Column(name="druk_0_nap_n")
	private Integer minLuchtdrukZeeniveau;

	@Column(name="druk_n_uur")
	private Integer minLuchtdrukUur;

	@Column(name="zicht_n")
	private Integer minZicht;

	@Column(name="zicht_n_uur")
	private Integer minZichtUur;

	@Column(name="zicht_x")
	private Integer maxZicht;

	@Column(name="zicht_x_uur")
	private Integer maxZichtUur;

	@Column(name="bewolking_octa")
	private Integer bewolking;

	@Column(name="rel_vocht_g")
	private Integer gemRelVocht;

	@Column(name="rel_vocht_x")
	private Integer maxRelVocht;

	@Column(name="rel_vocht_x_uur")
	private Integer maxRelVochtUur;

	@Column(name="rel_vocht_n")
	private Integer minRelVocht;

	@Column(name="rel_vocht_n_uur")
	private Integer minRelVochtUur;

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

	public int getJulDatum() {
		return julDatum;
	}

	public void setJulDatum(int julDatum) {
		this.julDatum = julDatum;
	}

	public Integer getWindrichting() {
		return windrichting;
	}

	public void setWindrichting(Integer windrichting) {
		this.windrichting = windrichting;
	}

	public Integer getGemWindsnelheid() {
		return gemWindsnelheid;
	}

	public void setGemWindsnelheid(Integer gemWindsnelheid) {
		this.gemWindsnelheid = gemWindsnelheid;
	}

	public Integer getMaxWindsnelheid() {
		return maxWindsnelheid;
	}

	public void setMaxWindsnelheid(Integer maxWindsnelheid) {
		this.maxWindsnelheid = maxWindsnelheid;
	}

	public Integer getMaxWindsnelheidUur() {
		return maxWindsnelheidUur;
	}

	public void setMaxWindsnelheidUur(Integer maxWindsnelheidUur) {
		this.maxWindsnelheidUur = maxWindsnelheidUur;
	}

	public Integer getMinWindsnelheid() {
		return minWindsnelheid;
	}

	public void setMinWindsnelheid(Integer minWindsnelheid) {
		this.minWindsnelheid = minWindsnelheid;
	}

	public Integer getMinWindsnelheidUur() {
		return minWindsnelheidUur;
	}

	public void setMinWindsnelheidUur(Integer minWindsnelheidUur) {
		this.minWindsnelheidUur = minWindsnelheidUur;
	}

	public Integer getMaxWindstoot() {
		return maxWindstoot;
	}

	public void setMaxWindstoot(Integer maxWindstoot) {
		this.maxWindstoot = maxWindstoot;
	}

	public Integer getMaxWindstootUur() {
		return maxWindstootUur;
	}

	public void setMaxWindstootUur(Integer maxWindstootUur) {
		this.maxWindstootUur = maxWindstootUur;
	}

	public int getGemTemperatuur() {
		return gemTemperatuur;
	}

	public void setGemTemperatuur(int gemTemperatuur) {
		this.gemTemperatuur = gemTemperatuur;
	}

	public Integer getGemTemperatuurGefuckt() {
		return gemTemperatuurGefuckt;
	}

	public void setGemTemperatuurGefuckt(Integer gemTemperatuurGefuckt) {
		this.gemTemperatuurGefuckt = gemTemperatuurGefuckt;
	}

	public int getMinTemperatuur() {
		return minTemperatuur;
	}

	public void setMinTemperatuur(int minTemperatuur) {
		this.minTemperatuur = minTemperatuur;
	}

	public Integer getMinTemperatuurGefuckt() {
		return minTemperatuurGefuckt;
	}

	public void setMinTemperatuurGefuckt(Integer minTemperatuurGefuckt) {
		this.minTemperatuurGefuckt = minTemperatuurGefuckt;
	}

	public Integer getMinTemperatuurUur() {
		return minTemperatuurUur;
	}

	public void setMinTemperatuurUur(Integer minTemperatuurUur) {
		this.minTemperatuurUur = minTemperatuurUur;
	}

	public int getMaxTemperatuur() {
		return maxTemperatuur;
	}

	public void setMaxTemperatuur(int maxTemperatuur) {
		this.maxTemperatuur = maxTemperatuur;
	}

	public Integer getMaxTemperatuurGefuckt() {
		return maxTemperatuurGefuckt;
	}

	public void setMaxTemperatuurGefuckt(Integer maxTemperatuurGefuckt) {
		this.maxTemperatuurGefuckt = maxTemperatuurGefuckt;
	}

	public Integer getMaxTemperatuurUur() {
		return maxTemperatuurUur;
	}

	public void setMaxTemperatuurUur(Integer maxTemperatuurUur) {
		this.maxTemperatuurUur = maxTemperatuurUur;
	}

	public Integer getMinGrondTemperatuur() {
		return minGrondTemperatuur;
	}

	public void setMinGrondTemperatuur(Integer minGrondTemperatuur) {
		this.minGrondTemperatuur = minGrondTemperatuur;
	}

	public Integer getMinGrondTemperatuurUur() {
		return minGrondTemperatuurUur;
	}

	public void setMinGrondTemperatuurUur(Integer minGrondTemperatuurUur) {
		this.minGrondTemperatuurUur = minGrondTemperatuurUur;
	}

	public Integer getDuurZon() {
		return duurZon;
	}

	public void setDuurZon(Integer duurZon) {
		this.duurZon = duurZon;
	}

	public Integer getPercZon() {
		return percZon;
	}

	public void setPercZon(Integer percZon) {
		this.percZon = percZon;
	}

	public Integer getStraling() {
		return straling;
	}

	public void setStraling(Integer straling) {
		System.out.println("Straling set to " + straling);
		this.straling = straling;
	}

	public Integer getDuurNeerslag() {
		return duurNeerslag;
	}

	public void setDuurNeerslag(Integer duurNeerslag) {
		this.duurNeerslag = duurNeerslag;
	}

	public Integer getSomNeerslag() {
		return somNeerslag;
	}

	public void setSomNeerslag(Integer somNeerslag) {
		this.somNeerslag = somNeerslag;
	}

	public Integer getMaxUursomNeerslag() {
		return maxUursomNeerslag;
	}

	public void setMaxUursomNeerslag(Integer maxUursomNeerslag) {
		this.maxUursomNeerslag = maxUursomNeerslag;
	}

	public Integer getUurMaxNeerslag() {
		return uurMaxNeerslag;
	}

	public void setUurMaxNeerslag(Integer uurMaxNeerslag) {
		this.uurMaxNeerslag = uurMaxNeerslag;
	}

	public Integer getGemLuchtdrukZeeniveau() {
		return gemLuchtdrukZeeniveau;
	}

	public void setGemLuchtdrukZeeniveau(Integer gemLuchtdrukZeeniveau) {
		this.gemLuchtdrukZeeniveau = gemLuchtdrukZeeniveau;
	}

	public Integer getMaxLuchtdrukZeeniveau() {
		return maxLuchtdrukZeeniveau;
	}

	public void setMaxLuchtdrukZeeniveau(Integer maxLuchtdrukZeeniveau) {
		this.maxLuchtdrukZeeniveau = maxLuchtdrukZeeniveau;
	}

	public Integer getMaxLuchtdrukUur() {
		return maxLuchtdrukUur;
	}

	public void setMaxLuchtdrukUur(Integer maxLuchtdrukUur) {
		this.maxLuchtdrukUur = maxLuchtdrukUur;
	}

	public Integer getMinLuchtdrukZeeniveau() {
		return minLuchtdrukZeeniveau;
	}

	public void setMinLuchtdrukZeeniveau(Integer minLuchtdrukZeeniveau) {
		this.minLuchtdrukZeeniveau = minLuchtdrukZeeniveau;
	}

	public Integer getMinLuchtdrukUur() {
		return minLuchtdrukUur;
	}

	public void setMinLuchtdrukUur(Integer minLuchtdrukUur) {
		this.minLuchtdrukUur = minLuchtdrukUur;
	}

	public Integer getMinZicht() {
		return minZicht;
	}

	public void setMinZicht(Integer minZicht) {
		this.minZicht = minZicht;
	}

	public Integer getMinZichtUur() {
		return minZichtUur;
	}

	public void setMinZichtUur(Integer minZichtUur) {
		this.minZichtUur = minZichtUur;
	}

	public Integer getMaxZicht() {
		return maxZicht;
	}

	public void setMaxZicht(Integer maxZicht) {
		this.maxZicht = maxZicht;
	}

	public Integer getMaxZichtUur() {
		return maxZichtUur;
	}

	public void setMaxZichtUur(Integer maxZichtUur) {
		this.maxZichtUur = maxZichtUur;
	}

	public Integer getBewolking() {
		return bewolking;
	}

	public void setBewolking(Integer bewolking) {
		this.bewolking = bewolking;
	}

	public Integer getGemRelVocht() {
		return gemRelVocht;
	}

	public void setGemRelVocht(Integer gemRelVocht) {
		this.gemRelVocht = gemRelVocht;
	}

	public Integer getMaxRelVocht() {
		return maxRelVocht;
	}

	public void setMaxRelVocht(Integer maxRelVocht) {
		this.maxRelVocht = maxRelVocht;
	}

	public Integer getMaxRelVochtUur() {
		return maxRelVochtUur;
	}

	public void setMaxRelVochtUur(Integer maxRelVochtUur) {
		this.maxRelVochtUur = maxRelVochtUur;
	}

	public Integer getMinRelVocht() {
		return minRelVocht;
	}

	public void setMinRelVocht(Integer minRelVocht) {
		this.minRelVocht = minRelVocht;
	}

	public Integer getMinRelVochtUur() {
		return minRelVochtUur;
	}

	public void setMinRelVochtUur(Integer minRelVochtUur) {
		this.minRelVochtUur = minRelVochtUur;
	}
	

}
