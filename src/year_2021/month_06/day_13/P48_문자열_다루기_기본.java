package year_2021.month_06.day_13;

public class P48_���ڿ�_�ٷ��_�⺻ {

	public static void main(String[] args) {
		System.out.println("a123".replaceAll("[^0-9]", ""));
	}

	public boolean solution(String s) {
		return (s.length()==4 || s.length()==6) && s.replaceAll("[^0-9]", "").length()==s.length();
	}
}
