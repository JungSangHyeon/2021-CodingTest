package year_2021.month_06.day_12;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P47_문자열_내림차순으로_배치하기 {

	/**
	 * new StringBuilder(new String(sol)).reverse().toString();
	 * String Builder에 이런게 있구나
	 */
	
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
	
	
	public static String solution(String s) {
        return getString(s, "[A-Z]") + getString(s, "[a-z]");
    }
	public static String getString(String s, String regex) {
		List<Character> smalls = s.replaceAll(regex, "").chars().mapToObj(e->(char)e).collect(Collectors.toList());
		smalls.sort(Collections.reverseOrder());
		return smalls.toString().replaceAll("\\[|,|\\]| ", "");
	} 
}
