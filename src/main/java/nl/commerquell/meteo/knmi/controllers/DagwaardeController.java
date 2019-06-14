package nl.commerquell.meteo.knmi.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.commerquell.meteo.knmi.KnmiApplication;
import nl.commerquell.meteo.knmi.model.data.Dagwaarde;
import nl.commerquell.meteo.knmi.model.data.StationMetadata;
import nl.commerquell.meteo.knmi.services.DagwaardeService;
import nl.commerquell.meteo.knmi.services.StationMetadataService;
import nl.commerquell.meteo.knmi.utils.KnmiUtils;

@RestController
@RequestMapping(DagwaardeController.BASE_URL)
public class DagwaardeController {
	public static final String BASE_URL = "/v1/api/knmi";
	public static final Logger log = Logger.getLogger(DagwaardeController.class.getName());
	
	private final DagwaardeService dagwaardeService;
	private final StationMetadataService stationMetadataService;
	
	public DagwaardeController(DagwaardeService dagwaardeService, StationMetadataService stationMetadataService) {
		this.dagwaardeService = dagwaardeService;
		this.stationMetadataService = stationMetadataService;
	}

	@GetMapping({"", "/"})
	List<nl.commerquell.meteo.knmi.objectviews.Dagwaarde> getAlleDagwaarden() {
		List<Dagwaarde> dagwaarden = dagwaardeService.findAll();
		List<nl.commerquell.meteo.knmi.objectviews.Dagwaarde> retval = new ArrayList<nl.commerquell.meteo.knmi.objectviews.Dagwaarde>();
		for (Dagwaarde dw : dagwaarden) {
			retval.add(new nl.commerquell.meteo.knmi.objectviews.Dagwaarde(dw));
		}
		return retval;
	}
	
	@GetMapping("/{station}/{datum}")
	public nl.commerquell.meteo.knmi.objectviews.Dagwaarde getDagwaarde(@PathVariable Integer station, @PathVariable Integer datum) {
		Dagwaarde dw = dagwaardeService.findById(station, datum);
		nl.commerquell.meteo.knmi.objectviews.Dagwaarde retval = new nl.commerquell.meteo.knmi.objectviews.Dagwaarde(dw);
		return retval;
	}
	
	@GetMapping("{station}/{maand}/{dagOfJaar}")
	public List<nl.commerquell.meteo.knmi.objectviews.Dagwaarde> getReeks(@PathVariable Integer station, @PathVariable Integer maand, @PathVariable Integer dagOfJaar) {
		int[] data = getData(station.intValue(), maand.intValue(), dagOfJaar.intValue());
		List<nl.commerquell.meteo.knmi.objectviews.Dagwaarde> retval = new ArrayList<nl.commerquell.meteo.knmi.objectviews.Dagwaarde>();
		for (int i = 0; i < data.length; i++) {
			retval.add(new nl.commerquell.meteo.knmi.objectviews.Dagwaarde(dagwaardeService.findById(station, data[i])));
		}
		return retval;
	}
	
	@GetMapping("/images/{imageName}")
	public byte[] getImage(@PathVariable String imageName) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(KnmiApplication.class.getResourceAsStream("images/" + imageName));
		byte[] buf = new byte[1024768];
		byte[] theImage = new byte[0];
		int bytesRead = bis.read(buf);
		bis.close();
		if (bytesRead > 0) {
			theImage = new byte[bytesRead];
			System.arraycopy(buf, 0, theImage, 0, bytesRead);
		}
		log.info("File " + imageName + " read (" + bytesRead + " bytes)");
		return theImage;
	}
	
	@GetMapping("/metadata")
	public List<StationMetadata> getMetadata() {
		List<StationMetadata> retval = stationMetadataService.findAll();
		return retval;
	}
	
	private int[] getData(int station, int maand, int dagOfJaar) {
		boolean maandoverzicht = (dagOfJaar > 1000);
		int[] retval;
		if (maandoverzicht) {
			int dpm = KnmiUtils.getDagenPerMaand(maand, dagOfJaar);
			retval = new int[dpm];
			for (int i = 0; i < dpm; i++) {
				retval[i] = 10000 * dagOfJaar + 100 * maand + i + 1;
			}
		} else {
			StationMetadata metadatum = null;
			for (StationMetadata elem : stationMetadataService.findAll()) {
				if (elem.getStation() == station) {
					metadatum = elem;
					break;
				}
			}
			int begin = metadatum.getDatumVan() - (metadatum.getDatumVan() % 10000) + 100 * maand + dagOfJaar;
			int einde = metadatum.getDatumTot() - (metadatum.getDatumTot() % 10000) + 100 * maand + dagOfJaar;
			log.info("Dagwaarden voor " + dagOfJaar + "." + maand + " van " + begin + " t/m " + einde);
			int datum = begin;
			List<Integer> datumList = new ArrayList<Integer>();
			while (datum <= einde) {
				if (datum < metadatum.getDatumVan()) {
					datum += 10000;
					continue;
				}
				if (datum > metadatum.getDatumTot()) {
					break;
				}
				if (maand == 2 && dagOfJaar == 29) {
					int jaar = ((datum - (datum % 10000)) / 10000);
					if (jaar % 4 != 0) {
						datum += 10000 * (4 - (jaar % 4));
						continue;
					}
				}
				datumList.add(Integer.valueOf(datum));
				datum += 10000;
			}
			retval = new int[datumList.size()];
			for (int i = 0; i < datumList.size(); i++) {
				retval[i] = datumList.get(i).intValue();
			}
		}
		
		return retval;
	}
}
