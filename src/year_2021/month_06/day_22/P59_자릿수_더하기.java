package year_2021.month_06.day_22;

public class P59_자릿수_더하기 {

	public static void main(String[] args) {

	}

	public int solution(int n) {
		String number = Integer.toString(n);
		char[] numberChars = number.toCharArray();
		int sum = 0;
		for(char numberChar : numberChars) {
			sum+=(numberChar-'0');
		}
        return sum;
    }
}
