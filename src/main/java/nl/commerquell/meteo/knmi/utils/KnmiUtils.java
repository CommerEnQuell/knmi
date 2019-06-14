package nl.commerquell.meteo.knmi.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class KnmiUtils {
	private static int[] dagenPerMaand = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static BigDecimal toBigDecimal(Integer unscaledValue, int scale) {
		if (unscaledValue == null) {
			return null;
		}
		return new BigDecimal(BigInteger.valueOf(unscaledValue.longValue()), scale);
	}
	
	public static int getDagenPerMaand(int maand, int jaar) {
		if (maand < 1 || maand > 12) {
			return 0;
		}
		boolean schrikkeljaar = (jaar % 4 == 0);
		int retval = dagenPerMaand[maand - 1];
		if (maand == 2 && schrikkeljaar) {
			retval = 29;
		}
		return retval;
	}
}
