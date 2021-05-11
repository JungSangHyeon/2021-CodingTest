package day_2021_05_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
import static java.util.stream.Collectors.*;

public class P1_위장 {

	/**
	 * 문제 자체는 이지하게 풀었다.
	 * 
	 *이런게 있네!
	 * return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}

	public static int solution2(String[][] clothes) {
		return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
	
	public static int solution(String[][] clothes) {
		HashMap<String, ArrayList<String>> clothesHash = new HashMap<>();
		for(String[] cloth : clothes) {
			if(!clothesHash.containsKey(cloth[1])) {clothesHash.put(cloth[1], new ArrayList<>());}
			clothesHash.get(cloth[1]).add(cloth[0]);
		}
        int answer = 1;
        for(Entry<String, ArrayList<String>> entry : clothesHash.entrySet()) {
        	answer*=(entry.getValue().size()+1);
        }
        return answer-1;
    }
}
