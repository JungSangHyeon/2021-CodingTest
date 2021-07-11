package year_2021.month_07.day_11;

public class P78_숫자_문자열과_영단어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	
	public int solution(String s) {
		for(int i=0; i<words.length; i++) s = s.replaceAll(words[i], Integer.toString(i));
        return Integer.parseInt(s);
    }
}
