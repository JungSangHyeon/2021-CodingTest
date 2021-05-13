package year_2021.month_05.day_10;

import java.util.Arrays;
import java.util.HashSet;

public class P11_��ȭ��ȣ_��� { // 11��°!

	/**
	 * �ؽð� �ͼ�ġ �ʾƼ��ΰ� �� �𸣰ڳ� 
	 * 
	 * ��� ��
	 * 1. String.startWith("asd"); �� �̷� �� �� �ֳ�
	 * 2. number.addAll(Arrays.asList(phone_book)); // �̷��� �ϸ� �� ���� �� �ֳ�!
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
	}

	public static boolean solution(String[] phone_book) { // �̰� �� ȿ���� ����?����
		HashSet<String> numbers = new HashSet<>();
		numbers.addAll(Arrays.asList(phone_book));
		for(String number : numbers) {
			for(int i=1; i<number.length(); i++) {
				if(numbers.contains(number.substring(0,  i))) return false;
			}
		}
		return true;
	}
}
