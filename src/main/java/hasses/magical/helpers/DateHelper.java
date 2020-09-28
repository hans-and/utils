package hasses.magical.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	private static SimpleDateFormat SL_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final String DATABASE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSX";

	private static final SimpleDateFormat DATABASE_DATE = new SimpleDateFormat(DATABASE_FORMAT);

	private static final SimpleDateFormat USER_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * @param slDate example 2020-04-18 22:38:00
	 * @throws ParseException
	 * 
	 */
	public static Date parseSLDate(String slDate) throws ParseException {
		return SL_DATE.parse(slDate);
	}

	public static String dateToMagicDateTimeString(Date pDate) throws ParseException {
		return USER_DATE.format(pDate);
	}

	public static boolean moreThan5MinSince(Date past) {
		return moreThanXMinSince(5, past);
	}

	public static boolean moreThanXMinSince(int min, Date past) {
		long millisecondsSincePast = millisecondSincePast(past);
		long minToMillSekond = minToMillisec(min);
		return minToMillSekond < millisecondsSincePast;
	}

	public static long millisecondSincePast(Date past) {
		return new Date().getTime() - past.getTime();
	}

	public static int month(Date pDate) {
		LocalDate localDate = pDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getMonthValue();
	}

	public static boolean monthDiffer(Date pADate, Date pAnotherDate) {
		return !isSameMonth(pADate, pAnotherDate);
	}

	public static boolean isSameMonth(Date pADate, Date pAnotherDate) {
		return month(pADate) == month(pAnotherDate);
	}

	public static long millisecondBetween(Date before, Date after) {
		return after.getTime() - before.getTime();
	}

	public static long millisecondToFloorMin(long millisec) {
		return millisec / 60000;
	}

	private static long minToMillisec(int min) {
		return min * 60000;
	}

	public static Date getGetTodaysDateWithNoTime() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		return Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant());
	}

	/**
	 * @param from between 0-23
	 * @param to   > from between 1-24
	 * @return
	 */
	public static boolean currentHourIsBetween(int from, int to) {
		if (from < 0 || from > 23 || to < 1 || to > 24 || to < from) {
			throw new IllegalArgumentException("From must be between 0-23 to 1-24 an to must be greate than from");
		}
		Date now = new Date();

		
		Date fromDate = addHoursToJavaUtilDate(getGetTodaysDateWithNoTime(), from);
		Date toDate = addHoursToJavaUtilDate(getGetTodaysDateWithNoTime(), to);
		return fromDate.before(now) && now.before(toDate);

	}

	public static Date addHoursToJavaUtilDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}
	
	public static Date addMinutesToJavaUtilDate(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
}
