package year_2021.month_08.day_07;

import java.util.ArrayList;

public class P124_¹è´Þ {

	public static void main(String[] args) {

		System.out.println(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
		System.out.println(solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
	}

	static boolean[] isDeliveryAvailables;
	static ArrayList<String> visited;
	static int[][] roads;
	
	public static int solution(int N, int[][] road, int K) {
		isDeliveryAvailables = new boolean[N+1];
		isDeliveryAvailables[1] = true;
		visited = new ArrayList<>();
		roads=road;
		
		check(1, K);
		
		int deliveryAvailableCount = 0;
		for(boolean isDeliveryAvailable : isDeliveryAvailables) {
			if(isDeliveryAvailable) deliveryAvailableCount++;
		}
		return deliveryAvailableCount;
	}

	private static void check(int nowVilage, int leftDistance) {
		String key = nowVilage+","+leftDistance;
		if(!visited.contains(key)) {
			visited.add(key);
			for(int[] road : roads) {
				if(road[0]==nowVilage && leftDistance>=road[2]) {
					isDeliveryAvailables[road[1]] = true;
					check(road[1], leftDistance-road[2]);
				}else if(road[1]==nowVilage && leftDistance>=road[2]) {
					isDeliveryAvailables[road[0]] = true;
					check(road[0], leftDistance-road[2]);
				}
			}
		}
	}

}
