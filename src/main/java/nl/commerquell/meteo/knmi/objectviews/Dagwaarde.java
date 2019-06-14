package nl.commerquell.meteo.knmi.objectviews;

import java.io.Serializable;
import java.math.BigDecimal;

import nl.commerquell.meteo.knmi.utils.KnmiUtils;

@ObjectView(primaryEntity=nl.commerquell.meteo.knmi.model.data.Dagwaarde.class)
public class Dagwaarde implements Serializable {

	private int station;
	private int jaar;
	private int maand;
	private int dag;
	private int julDatum;
	private Integer windrichting;
	private BigDecimal gemWindsnelheid;
	private BigDecimal maxWindsnelheid;
	private Integer maxWindsnelheidUur;
	private BigDecimal minWindsnelheid;
	private Integer minWindsnelheidUur;
	private BigDecimal maxWindstoot;
	private Integer maxWindstootUur;
	private BigDecimal gemTemperatuur;
	private BigDecimal gemTemperatuurGefuckt;
	private BigDecimal minTemperatuur;
	private BigDecimal minTemperatuurGefuckt;
	private Integer minTemperatuurUur;
	private BigDecimal maxTemperatuur;
	private BigDecimal maxTemperatuurGefuckt;
	private Integer maxTemperatuurUur;
	private BigDecimal minGrondTemperatuur;
	private Integer minGrondTemperatuurUur;
	private BigDecimal duurZon;
	private Integer percZon;
	private Integer straling;
	private BigDecimal duurNeerslag;
	private BigDecimal somNeerslag;
	private BigDecimal maxUursomNeerslag;
	private Integer uurMaxNeerslag;
	private BigDecimal gemLuchtdrukZeeniveau;
	private BigDecimal maxLuchtdrukZeeniveau;
	private Integer maxLuchtdrukUur;
	private BigDecimal minLuchtdrukZeeniveau;
	private Integer minLuchtdrukUur;
	private String minZicht;
	private Integer minZichtUur;
	private String maxZicht;
	private Integer maxZichtUur;
	private Integer bewolking;
	private Integer gemRelVocht;
	private Integer maxRelVocht;
	private Integer maxRelVochtUur;
	private Integer minRelVocht;
	private Integer minRelVochtUur;
	
	public Dagwaarde(nl.commerquell.meteo.knmi.model.data.Dagwaarde that) {
		this.station = that.getStation();
		this.jaar = that.getDatum() / 10000;
		this.maand = (that.getDatum() % 10000) / 100;
		this.dag = that.getDatum() % 100;
		this.julDatum = that.getJulDatum();
		this.windrichting = that.getWindrichting();
		this.gemWindsnelheid = KnmiUtils.toBigDecimal(that.getGemWindsnelheid(), 1);
		this.maxWindsnelheid = KnmiUtils.toBigDecimal(that.getMaxWindsnelheid(), 1);
		this.maxWindsnelheidUur = that.getMaxWindsnelheidUur();
		this.minWindsnelheid = KnmiUtils.toBigDecimal(that.getMinWindsnelheid(), 1);
		this.minWindsnelheidUur = that.getMinWindsnelheidUur();
		this.maxWindstoot = KnmiUtils.toBigDecimal(that.getMaxWindstoot(), 1);
		this.maxWindstootUur = that.getMaxWindstootUur();
		this.gemTemperatuur = KnmiUtils.toBigDecimal(that.getGemTemperatuur(), 1);
		this.gemTemperatuurGefuckt = KnmiUtils.toBigDecimal(that.getGemTemperatuurGefuckt(), 1);
		this.minTemperatuur = KnmiUtils.toBigDecimal(that.getMinTemperatuur(), 1);
		this.minTemperatuurGefuckt = KnmiUtils.toBigDecimal(that.getMinTemperatuurGefuckt(), 1);
		this.minTemperatuurUur = that.getMinTemperatuurUur();
		this.maxTemperatuur = KnmiUtils.toBigDecimal(that.getMaxTemperatuur(), 1);
		this.maxTemperatuurGefuckt = KnmiUtils.toBigDecimal(that.getMaxTemperatuurGefuckt(), 1);
		this.maxTemperatuurUur = that.getMaxTemperatuurUur();
		this.minGrondTemperatuur = KnmiUtils.toBigDecimal(that.getMinGrondTemperatuur(), 1);
		this.minGrondTemperatuurUur = that.getMinGrondTemperatuurUur();
		this.duurZon = KnmiUtils.toBigDecimal(that.getDuurZon(), 1);
		this.percZon = that.getPercZon();
		this.straling = that.getStraling();
		this.duurNeerslag = KnmiUtils.toBigDecimal(that.getDuurNeerslag(), 1);
		this.somNeerslag = KnmiUtils.toBigDecimal(that.getSomNeerslag(), 1);
		this.maxUursomNeerslag = KnmiUtils.toBigDecimal(that.getMaxUursomNeerslag(), 1);
		this.uurMaxNeerslag = that.getUurMaxNeerslag();
		this.gemLuchtdrukZeeniveau = KnmiUtils.toBigDecimal(that.getGemLuchtdrukZeeniveau(), 1);
		this.maxLuchtdrukZeeniveau = KnmiUtils.toBigDecimal(that.getMaxLuchtdrukZeeniveau(), 1);
		this.maxLuchtdrukUur = that.getMaxLuchtdrukUur();
		this.minLuchtdrukZeeniveau = KnmiUtils.toBigDecimal(that.getMinLuchtdrukZeeniveau(), 1);
		this.minLuchtdrukUur = that.getMinLuchtdrukUur();
		this.minZicht = getZicht(that.getMinZicht());
		this.minZichtUur = that.getMinZichtUur();
		this.maxZicht = getZicht(that.getMaxZicht());
		this.maxZichtUur = that.getMaxZichtUur();
		this.bewolking = that.getBewolking();
		this.gemRelVocht = that.getGemRelVocht();
		this.maxRelVocht = that.getMaxRelVocht();
		this.maxRelVochtUur = that.getMaxRelVochtUur();
		this.minRelVocht = that.getMinRelVocht();
		this.minRelVochtUur = that.getMinRelVochtUur();
	}
	
	public String getZicht(Integer idx) {
		String retval = "";
		if (idx == null) {
			return retval;
		}
		int i = idx.intValue();
		if (i == 0) {
			retval = "< 100 m";
		} else if (i > 0 && i < 50) {
			int near = 100 * i;
			int far = near + 100;
			retval = near + "-" + far + " m";
		} else if (i == 50) {
			retval = "5-6 km";
		} else if (i < 80) {
			int near = i - 50;
			int far = near + 1;
			retval = near + "-" + far + " km";
		} else if (i < 89) {
			int near = 5 * i - 370;
			int far = near + 5;
			retval = near + "-" + far + " km";
		} else if (i == 89)  {
			retval = "> 75 km";
		} else  {
			retval = "?";
		}
		
		return retval;
	}

	public int getStation() {
		return station;
	}

	public int getJaar() {
		return jaar;
	}

	public int getMaand() {
		return maand;
	}

	public int getDag() {
		return dag;
	}

	public int getJulDatum() {
		return julDatum;
	}

	public Integer getWindrichting() {
		return windrichting;
	}

	public BigDecimal getGemWindsnelheid() {
		return gemWindsnelheid;
	}

	public BigDecimal getMaxWindsnelheid() {
		return maxWindsnelheid;
	}

	public Integer getMaxWindsnelheidUur() {
		return maxWindsnelheidUur;
	}

	public BigDecimal getMinWindsnelheid() {
		return minWindsnelheid;
	}

	public Integer getMinWindsnelheidUur() {
		return minWindsnelheidUur;
	}

	public BigDecimal getMaxWindstoot() {
		return maxWindstoot;
	}

	public Integer getMaxWindstootUur() {
		return maxWindstootUur;
	}

	public BigDecimal getGemTemperatuur() {
		return gemTemperatuur;
	}

	public BigDecimal getGemTemperatuurGefuckt() {
		return gemTemperatuurGefuckt;
	}

	public BigDecimal getMinTemperatuur() {
		return minTemperatuur;
	}

	public BigDecimal getMinTemperatuurGefuckt() {
		return minTemperatuurGefuckt;
	}

	public Integer getMinTemperatuurUur() {
		return minTemperatuurUur;
	}

	public BigDecimal getMaxTemperatuur() {
		return maxTemperatuur;
	}

	public BigDecimal getMaxTemperatuurGefuckt() {
		return maxTemperatuurGefuckt;
	}

	public Integer getMaxTemperatuurUur() {
		return maxTemperatuurUur;
	}

	public BigDecimal getMinGrondTemperatuur() {
		return minGrondTemperatuur;
	}

	public Integer getMinGrondTemperatuurUur() {
		return minGrondTemperatuurUur;
	}

	public BigDecimal getDuurZon() {
		return duurZon;
	}

	public Integer getPercZon() {
		return percZon;
	}

	public Integer getStraling() {
		return straling;
	}

	public BigDecimal getDuurNeerslag() {
		return duurNeerslag;
	}

	public BigDecimal getSomNeerslag() {
		return somNeerslag;
	}

	public BigDecimal getMaxUursomNeerslag() {
		return maxUursomNeerslag;
	}

	public Integer getUurMaxNeerslag() {
		return uurMaxNeerslag;
	}

	public BigDecimal getGemLuchtdrukZeeniveau() {
		return gemLuchtdrukZeeniveau;
	}

	public BigDecimal getMaxLuchtdrukZeeniveau() {
		return maxLuchtdrukZeeniveau;
	}

	public Integer getMaxLuchtdrukUur() {
		return maxLuchtdrukUur;
	}

	public BigDecimal getMinLuchtdrukZeeniveau() {
		return minLuchtdrukZeeniveau;
	}

	public Integer getMinLuchtdrukUur() {
		return minLuchtdrukUur;
	}

	public String getMinZicht() {
		return minZicht;
	}

	public Integer getMinZichtUur() {
		return minZichtUur;
	}

	public String getMaxZicht() {
		return maxZicht;
	}

	public Integer getMaxZichtUur() {
		return maxZichtUur;
	}

	public Integer getBewolking() {
		return bewolking;
	}

	public Integer getGemRelVocht() {
		return gemRelVocht;
	}

	public Integer getMaxRelVocht() {
		return maxRelVocht;
	}

	public Integer getMaxRelVochtUur() {
		return maxRelVochtUur;
	}

	public Integer getMinRelVocht() {
		return minRelVocht;
	}

	public Integer getMinRelVochtUur() {
		return minRelVochtUur;
	}

}
