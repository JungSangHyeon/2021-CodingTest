package year_2021.month_05.day_25;

import java.util.Arrays;
import java.util.HashSet;


public class P28_두_개_뽑아서_더하기 {

	/**
	 * HashSet이 아닌 TreeSet을 사용하면 add하면서 정렬도 같이 됩니당.
	 * 오 안태웅님 ㄳ
	 * 알고리즘 강의를 듣긴 해야겠는뎅
	 */
	public static void main(String[] args) {

		System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1})));
		System.out.println(Arrays.toString(solution(new int[] {5,0,2,7})));
	}

	public static int[] solution(int[] numbers) {
		HashSet<Integer> sums = new HashSet<>();
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				sums.add(numbers[i]+numbers[j]);
			}
		}
		int[] result = sums.stream().mapToInt(Number::intValue).toArray();
		Arrays.parallelSort(result);
		return result;
	}

}
