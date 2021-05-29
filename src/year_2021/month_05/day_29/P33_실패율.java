package year_2021.month_05.day_29;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P33_실패율 {

	/**
	 * 모범 답안으로 풀었당 핳
	 */
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(5, new int[] {4,4,4,4})));
	}

	/**
	 * 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	 * @param N: 전체 스테이지의 개수
	 * @param stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
	 * @return  실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
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
