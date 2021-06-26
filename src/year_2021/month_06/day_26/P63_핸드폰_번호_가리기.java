package year_2021.month_06.day_26;

public class P63_핸드폰_번호_가리기 {

	/**
	 * 한번 해보고 싶어서ㅎㅎㅎ
	 */
	public static void main(String[] args) {
		System.out.println(solution("1231231231234"));
	}

	public static String solution(String phone_number) {
        return "********************".substring(0, phone_number.length()-4)
        		+ phone_number.substring(phone_number.length()-4, phone_number.length());
    }
}
