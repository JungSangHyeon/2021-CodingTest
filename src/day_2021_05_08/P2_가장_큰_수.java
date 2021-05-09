package day_2021_05_08;

import java.util.Arrays;  
import java.util.Comparator;

public class P2_가장_큰_수 {

	/**
	 * 
	 * 모범 답안보다 어찌되었든 짧다! 기분 좋다!
	 * 
	 * 배운 점
	 * 
	 *  1. 와 문자열 0000은 0으로 바꿔야 되는거 진짜 몰랐다.
	 *  2. Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new); // 배열 변환 각 값을 내 맘대로 변화시키는데 쓸 수 있을 것 같다
	 *  3. Arrays.sort(numberStrings, (String s1, String s2) -> {
			return (Integer.parseInt(s1 + s2) == Integer.parseInt(s2 + s1)) ? 0 : (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) ? -1 : 1;
		});
		sort할 때 Comparator 직접 만드는 법. 유용해 보인다.
		4. 남의 답안 보니, Integer.compare를 쓰면 내 Comparator를 더 줄일 수 있겠다. 자동으로 0, -1, 1로 분류해준다. 해보니 이쁘네!
	 */
	
	public static String solution2(int[] numbers) {
		String[] numberStrings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(numberStrings, (String s1, String s2) -> {return -Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));});
		String result = Arrays.toString(numberStrings).replace(",", "").replace(" ", "").replace("[", "").replace("]", ""); 
		return (result.charAt(0)=='0')? "0":result;
    }
	
	public static String solution(int[] numbers) {
		String[] numberStrings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(numberStrings, (String s1, String s2) -> {
			return (Integer.parseInt(s1 + s2) == Integer.parseInt(s2 + s1)) ? 0 : (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) ? -1 : 1;
		});
		String result = Arrays.toString(numberStrings).replace(",", "").replace(" ", "").replace("[", "").replace("]", ""); 
		return (result.replace("0", "").length()==0)? "0":result;
    }
	
	public static void main(String[] args) {
		int[] numbers = new int[] {0, 6, 10, 2, 330, 101, 32, 0, 70, 1000, 1, 10, 200, 0};
		numbers = new int[1001];
		for(int i=0; i<1001; i++) {
			numbers[i]=i;
		}
		
		System.out.println(solution(numbers));
	}
	
	// 따로 만드는 예시
//	private class a implements Comparator<String>{
//		@Override
//		public int compare(String s1, String s2) {
//			return (Integer.parseInt(s1+s2)>Integer.parseInt(s2+s1))? 1:-1;
//		}
//	}
}
