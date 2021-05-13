package year_2021.month_05.day_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P8_��������_����_���� {

	/**
	 * �� ��� �ǰ� ������! ��� �����ߴµ� ��� ����̳�. ���� �������� ��¥ ������� �ǽ��� ��.
	 * 
	 *  ���� ��� ��
	 *  1. Map<String, Integer> checkList = new HashMap<>(); // �ؽ���
	 *  2. hm.put(player, hm.getOrDefault(player, 0) + 1); // getOrDefault ������ ��������, ������ 0����! �� ��
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
