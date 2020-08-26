package hasses.magical.helpers;

import java.math.BigDecimal;

public class NumberHelper {

	public static BigDecimal incrementBigDecimal(BigDecimal source) {
		return source.add(new BigDecimal("1"));
	}
}
