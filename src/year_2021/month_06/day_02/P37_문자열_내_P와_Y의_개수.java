package year_2021.month_06.day_02;

public class P37_���ڿ�_��_P��_Y��_���� {

	/**
	 * ��� ��Ⱥ��� ���� ����
	 */
	public static void main(String[] args) {
	}

	boolean solution(String s) {
		return s.replaceAll("p|P", "").length() == s.replaceAll("y|Y", "").length();
	}
}
