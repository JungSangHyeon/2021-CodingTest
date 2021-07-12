package year_2021.month_07.day_12;

public class P79_2016³â {

	public static void main(String[] args) {

	}

	public String solution(int a, int b) {
		String[] weekDays = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int days[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int elapsedDay = 0;
		for(int i=0; i<a; i++) elapsedDay += days[i];
		elapsedDay += b;
		
		int diffWeekday = elapsedDay % 7;
		
		return weekDays[diffWeekday];
	}

}
