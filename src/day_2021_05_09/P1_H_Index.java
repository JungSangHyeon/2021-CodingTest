package day_2021_05_09;

import java.util.Arrays;
import java.util.Collections;

public class P1_H_Index {

	/**
	 * 새로 배운 코드는 딱히 없고, 몇 문제 풀어본 것을 활용하여 풀었다.
	 * 
	 * 배운 점
	 * 1. 어렵게 생각하지 않고, 그냥 풀었는데, 더 효율적인 방법을 생각해 보는 것도 좋겠다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("결과: "+solution(new int[]{2}));

	}

	public static int solution2(int[] citations) {
		int result = 0;
		for(int h=0; h<1001; h++) {
			final int fh = h;
			int biggerThenHcount = Arrays.stream(citations).filter(j->j>=fh).toArray().length;
			if(h<=biggerThenHcount) {result = h;} else {break;}
		}
		return result;
    }
	
	public static int solution(int[] citations) { 
		Integer[] citationsCopy = Arrays.stream(citations).mapToObj(Integer::valueOf).toArray(Integer[]::new);
		Arrays.sort(citationsCopy, Collections.reverseOrder());
		System.out.println(Arrays.toString(citationsCopy));
		for(int i=0; i<citationsCopy.length; i++) {
			System.out.println("현재 값: "+citationsCopy[i]+", 얘 포함 해서 얘보다 이상인 값의 수: "+(i+1));
			if(i+1>=citationsCopy[i]) return citationsCopy[i];
		}
        return (citationsCopy[citationsCopy.length-1]>citationsCopy.length)? citationsCopy.length:0;
    }
}
