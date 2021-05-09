package day_2021_05_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P4_완주하지_못한_선수 {

	/**
	 * 이 방법 되게 구리다! 라고 생각했는데 모범 답안이네. 슬슬 모범답안이 진짜 모범인지 의심이 되.
	 * 
	 *  새로 배운 것
	 *  1. Map<String, Integer> checkList = new HashMap<>(); // 해쉬맵
	 *  2. hm.put(player, hm.getOrDefault(player, 0) + 1); // getOrDefault 있으면 가져오고, 없으면 0으로! 인 듯
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"leo", "kiki"}));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = null;
		Map<String, Integer> checkList = new HashMap<>();
		for (String name : participant) {
			checkList.put(name, checkList.containsKey(name) ? checkList.get(name) + 1 : 1);
		}
		for (String name : completion) {
			checkList.put(name, checkList.get(name).intValue() - 1);
		}
		for (Entry<String, Integer> name : checkList.entrySet()) {
			if (name.getValue() != 0) {
				answer = name.getKey();
				break;
			}
		}
        return answer;
    }

}
