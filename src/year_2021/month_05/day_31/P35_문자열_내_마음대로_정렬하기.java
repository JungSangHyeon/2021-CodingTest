package year_2021.month_05.day_31;

import java.util.Arrays;

public class P35_문자열_내_마음대로_정렬하기 {

	public static void main(String[] args) {
	}

	public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1,s2)-> (s1.charAt(n)-s2.charAt(n)==0)? s1.compareTo(s2):s1.charAt(n)-s2.charAt(n));
        return strings;
    }
	
}
