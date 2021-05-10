package day_2021_05_10;

import java.util.Arrays;
import java.util.HashSet;

public class P2_전화번호_목록 { // 11번째!

	/**
	 * 해시가 익숙치 않아서인가 좀 모르겠네 
	 * 
	 * 배운 것
	 * 1. String.startWith("asd"); 와 이런 것 도 있네
	 * 2. number.addAll(Arrays.asList(phone_book)); // 이렇게 하면 다 넣을 수 있네!
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
	}

	public static boolean solution(String[] phone_book) { // 이게 더 효율이 좋아?ㅋㅋ
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
