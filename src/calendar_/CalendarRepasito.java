package calendar_;

import java.io.PrintStream;
import java.util.Calendar;

public class CalendarRepasito {

	public static void main(String[] args) {

		PrintStream ps = System.out;
		Calendar nacimiento = Calendar.getInstance();
		Calendar actual = Calendar.getInstance();
		
		nacimiento.set(1998, 9, 25, 14, 22);
		
		ps.println(CalendarDiff.diff(nacimiento, actual, CalendarDiff.DATES));
		
	}

}

//		1000; milisegundos
//		milisegundos / 1000; segundos
//		milisegundos / 1000 * 60; minutos
//		milisegundos / 1000 * 60 * 60; horas
//		milisegundos / 1000 * 60 * 60 * 24; dias
abstract class CalendarDiff{
	
	public static final int MINUTES = 2;
	public static final int HOURS = 3;
	public static final int DATES = 4;
	
	private static final long MINUTESDIVISOR = 60000;
	private static final long HOURSDIVISOR = 3600000;
	private static final long DATESDIVISOR = 86400000;
	
	public static long diffMinutes(Calendar oldestDate, Calendar recentDate) {
		return executeDiff(oldestDate.getTimeInMillis(), recentDate.getTimeInMillis(), MINUTESDIVISOR);
	}
	
	public static long diffHours(Calendar oldestDate, Calendar recentDate) {
		return executeDiff(oldestDate.getTimeInMillis(), recentDate.getTimeInMillis(), HOURSDIVISOR);	
	}
	
	public static long diffDates(Calendar oldestDate, Calendar recentDate) {
		return executeDiff(oldestDate.getTimeInMillis(), recentDate.getTimeInMillis(), DATESDIVISOR);
	}
	
	public static long diff(Calendar oldestDate, Calendar recentDate, int DIVISOR) {
		long diff = -1;
		long millisecondsOldestDate = oldestDate.getTimeInMillis();
		long millisecondsRecentDate = recentDate.getTimeInMillis();
		switch(DIVISOR) {
			case MINUTES:
				diff = executeDiff(millisecondsOldestDate, millisecondsRecentDate, MINUTESDIVISOR);
				break;
			case HOURS:
				diff = executeDiff(millisecondsOldestDate, millisecondsRecentDate, HOURSDIVISOR);
				break;
			case DATES:
				diff = executeDiff(millisecondsOldestDate, millisecondsRecentDate, DATESDIVISOR);
				break;
		}
		return diff;	
	}
	
	private static long executeDiff(long millisecondsOldestDate, long millisecondsRecentDate, long DIVISOR) {
		long diffMilliseconds = millisecondsRecentDate - millisecondsOldestDate;
		return Math.abs(diffMilliseconds / DIVISOR);
	}
}