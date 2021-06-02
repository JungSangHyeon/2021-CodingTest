package year_2021.month_06.day_02;

public class P37_문자열_내_P와_Y의_개수 {

	/**
	 * 모범 답안보다 나아 보임
	 */
	public static void main(String[] args) {
	}

	boolean solution(String s) {
		return s.replaceAll("p|P", "").length() == s.replaceAll("y|Y", "").length();
	}
}
