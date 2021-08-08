package year_2021.month_08.day_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class P125_Æ©ÇÃ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
	}

	public static int[] solution(String s) {
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken("{},"));
			int count = map.getOrDefault(num, 0);
			map.put(num, count + 1);
		}

		ArrayList<Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}
		});

		int[] answer = new int[entries.size()];
		for(int i=0; i<entries.size(); i++) {
			answer[i] = entries.get(i).getKey();
		}
        return answer;
    }
}
