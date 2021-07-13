package year_2021.month_07.day_13;

import java.util.Arrays;

public class P80_ÃÖ´ñ°ª°ú_ÃÖ¼Ú°ª {

	public static void main(String[] args) {

	}

	public String solution(String s) {
		String[] numberStrings = s.split(" ");
		int[] numbers = new int[numberStrings.length];
		for(int i=0; i<numberStrings.length; i++) numbers[i] = Integer.parseInt(numberStrings[i]);
		
		int min = Arrays.stream(numbers).min().getAsInt();
		int max = Arrays.stream(numbers).max().getAsInt();
        return min + " " + max;
    }
}
