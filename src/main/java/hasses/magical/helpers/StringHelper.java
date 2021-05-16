package hasses.magical.helpers;

public class StringHelper {

	public static boolean isNullOrEmptyOrBlank(String candidate) {

		return candidate == null || candidate.trim().isEmpty();
	}

	public static String toCommaString(Object... object) {

		return toObjArrtoCommaString(object);
	}

	public static String toObjArrtoCommaString(Object[] objects) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < objects.length - 1; i++) {
			b.append(objects[1] + ",");
		}
		b.append(objects.length - 1);
		return b.toString();
	}

	public static boolean anyNullOrEmptyOrBlank(String... candidates) {
		for (String candidate : candidates) {
			if (isNullOrEmptyOrBlank(candidate)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNullOrEmpty(String candidate) {

		return candidate == null || candidate.isEmpty();
	}

	private static String SPLIT_ROW_REGEX = "\\r?\\n";

	/**
	 * @param source
	 * @return splits both Windows and Unix style line break, NOTE that null source is empty array!
	 */
	public static String[] splitInRows(String source) {
		String[] result;
		if (source == null) {
			result = new String[0];
		} else if (source.isEmpty()) {
			result = new String[1];
			result[0] = "";
		} else {
			result = source.split(SPLIT_ROW_REGEX);
		}
		return result;
	}
}
