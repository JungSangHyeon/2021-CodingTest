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

public class P1_���� {

	/**
	 * ���� ��ü�� �����ϰ� Ǯ����.
	 * 
	 * �̹��� ��� ��
	 * 1. �̷��� �ֳ�! - ���ε� �Ϸ�
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
				// ���⼭ �� DB �׷��� ó�� ������ ó���ϳ�! ��ġ����, ���� ������
		);
		System.out.println(
				Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], Collectors.counting())))
				.values().toString() // ���� �̳�
		);
		System.out.println(
				Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], Collectors.counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x, y) -> x * (y + 1))).toString() // ���������� DB�� ���� ó���ϳ�. ���� ������ �ϳ��� ��ǥ���� ����� ���±���.
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
