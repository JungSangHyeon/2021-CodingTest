package day_2021_05_11;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class P1_위장 {

	/**
	 * 문제 자체는 이지하게 풀었다.
	 * 
	 * 이번에 배운 것
	 * 1. 이런게 있네! - 공부도 완료
	 * return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	 */
	public static void main(String[] args) {
		System.out.println(solution2(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}

	public static int solution2(String[][] clothes) {
		System.out.println(
				Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], Collectors.counting()))).toString() 
				// 여기서 그 DB 그룹핑 처럼 데이터 처리하네! 합치던가, 개수 세던가
		);
		System.out.println(
				Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], Collectors.counting())))
				.values().toString() // 값만 뽑넹
		);
		System.out.println(
				Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], Collectors.counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x, y) -> x * (y + 1))).toString() // 마찬가지로 DB와 같이 처리하넹. 여러 값으로 하나의 대표값을 만들어 내는구나.
		);
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
