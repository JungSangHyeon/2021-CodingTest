package year_2021.month_05.day_29;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P33_������ {

	/**
	 * ��� ������� Ǯ���� �K
	 */
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(5, new int[] {4,4,4,4})));
	}

	/**
	 * ������: ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
	 * @param N: ��ü ���������� ����
	 * @param stages: ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages
	 * @return  �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭
	 */
	public static int[] solution(int N, int[] stages) {
		Map<Integer, Float> stageAndInfoMap = new HashMap<>();
		for(int i=1; i<N+1; i++) stageAndInfoMap.put(i, 0f);
		for(int stage : stages) { // info is count of block player
			if(stage>N) continue;
			stageAndInfoMap.put(stage, stageAndInfoMap.get(stage)+1);
		}
		System.out.println(stageAndInfoMap.toString());
		
		int sumOfBlockedPlayer = 0;
		for(int i=1; i<N+1; i++) {
			System.out.println(stageAndInfoMap.get(i)+" / "+(stages.length-sumOfBlockedPlayer));
			
			int challengerCount = stages.length-sumOfBlockedPlayer;
			float failPercent = (challengerCount==0)? 0:stageAndInfoMap.get(i)/challengerCount;
			sumOfBlockedPlayer+=stageAndInfoMap.get(i);
			stageAndInfoMap.put(i, failPercent);
		}
		System.out.println(stageAndInfoMap.toString());

        List<Map.Entry<Integer, Float>> entries = new LinkedList<>(stageAndInfoMap.entrySet());
        Collections.sort(entries, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        int[] answer = new int[N];
        for(int i=0; i<N; i++) answer[i]=entries.get(i).getKey();
        return answer;
    }
	
	public static int[] solution2(int N, int[] stages) {
		Map<Integer, Float> stageAndInfoMap = new HashMap<>();
		for(int i=1; i<N+1; i++) stageAndInfoMap.put(i, 0f);
		for(int stage : stages) { // info is count of block player
			if(stage>N) continue;
			stageAndInfoMap.put(stage, stageAndInfoMap.get(stage)+1);
		}
		
		int sumOfBlockedPlayer = 0;
		for(int i=1; i<N+1; i++) {
			int challengerCount = stages.length-sumOfBlockedPlayer;
			float failPercent = (challengerCount==0)? 0:stageAndInfoMap.get(i)/challengerCount;
			sumOfBlockedPlayer+=stageAndInfoMap.get(i);
			stageAndInfoMap.put(i, failPercent);
		}
		
		List<Map.Entry<Integer, Float>> entries = new LinkedList<>(stageAndInfoMap.entrySet());
		Collections.sort(entries, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
		int[] answer = new int[N];
		for(int i=0; i<N; i++) answer[i]=entries.get(i).getKey();
		return answer;
	}
	
	
	
	public static int[] solution1(int N, int[] stages) {
		Map<Integer, Float> stageAndInfoMap = new HashMap<>();
		for(int stage : stages) { // info is count of block player
			if(stage>N) continue;
			stageAndInfoMap.put(stage, stageAndInfoMap.getOrDefault(stage, 0f)+1);
		}
		
		int sumOfBlockedPlayer = 0;
		for(int i=1; i<N+1; i++) { // info is failPercent
			float failPercent = stageAndInfoMap.getOrDefault(i, 0f)/(stages.length-sumOfBlockedPlayer);
			sumOfBlockedPlayer+=stageAndInfoMap.getOrDefault(i, 0f);
			stageAndInfoMap.put(i, failPercent);
		}
		
		List<Map.Entry<Integer, Float>> entries = new LinkedList<>(stageAndInfoMap.entrySet());
		Collections.sort(entries, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
		int[] answer = new int[N];
		for(int i=0; i<N; i++) answer[i]=entries.get(i).getKey();
		return answer;
	}
	
}
