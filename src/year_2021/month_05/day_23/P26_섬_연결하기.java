package year_2021.month_05.day_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class P26_섬_연결하기 {

	public static void main(String[] args) {
		System.out.println(solution5(4, new int[][] {{0,1,1},{0,2,1},{0,3,1},{3,1,1},{3,2,1},{1,2,1}}));//3
		System.out.println(solution5(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));//4
		System.out.println(solution5(5, new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}})); // 15 XOO
		System.out.println(solution5(5, new int[][] {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}})); // 8 OXO
		System.out.println(solution5(4, new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}})); // 9 XOO
		System.out.println(solution5(5, new int[][] {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}})); // 104 XOO
		System.out.println(solution5(6, new int[][] {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}})); // 11 OXO
		System.out.println(solution5(5, new int[][] {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}})); // 6 OXO
		System.out.println(solution5(5, new int[][] {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}})); // 8 XXX
		System.out.println(solution5(5, new int[][] {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}})); // 8 OXO
	}

	public static int solution5(int n, int[][] costs) {
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr2[2], arr1[2]));
		int maxCost = costs[0][2];
		
		HashSet<Integer> islands = new HashSet<>(); // 섬이 전부 들어있나 확인 용
		ArrayList<int[]> bridges = new ArrayList<>(); // 섬이 전부 연결되었나 확인 용
		
		for(int cost=1; cost<=maxCost; cost++) {
			final int fianlCost = cost;
			for(int i=0; i<costs.length; i++) {
				int[] bridge = costs[i];
				if(bridge[2]==fianlCost && !islands.contains(bridge[0]) && !islands.contains(bridge[1])) {
					islands.add(bridge[0]);
					islands.add(bridge[1]);
					bridges.add(bridge);
					if(isAllConnected(n, bridges)) return getSumOfCost(bridges);
				}
			}
			for(int i=0; i<costs.length; i++) {
				int[] bridge = costs[i];
				if(bridge[2]==fianlCost && !bridges.contains(bridge) &&
						((!islands.contains(bridge[0]) && islands.contains(bridge[1])) || 
						islands.contains(bridge[0]) && !islands.contains(bridge[1])) ) {
					islands.add(bridge[0]);
					islands.add(bridge[1]);
					bridges.add(bridge);
					if(isAllConnected(n, bridges)) return getSumOfCost(bridges);
				}
			}
		}
		for(int cost=1; cost<=maxCost; cost++) {
			for(int i=0; i<costs.length; i++) {
				int[] bridge = costs[i];
				if(bridge[2]==cost && !bridges.contains(bridge)) {
					bridges.add(bridge);
					if(isAllConnected(n, bridges)) {return getSumOfCost(bridges);}
					else {bridges.remove(bridge);}
				}
			}
		}
		return -1;
	}
	public static int getSumOfCost(ArrayList<int[]> bridges) {
		int answer = 0;
		for(int[] bridge : bridges) answer+=bridge[2];
		return answer;
	}
	public static boolean isAllConnected(int n, ArrayList<int[]> bridges) {
		HashSet<Integer> connect = new HashSet<>();
		connect.add(bridges.get(0)[0]);
		for(int i=0; i<n; i++) {
			for(int[] bridge : bridges) {
				if(connect.contains(bridge[0]) || connect.contains(bridge[1])) {
					connect.add(bridge[0]);
					connect.add(bridge[1]);
				}
				if(connect.size()==n) {return true;}
			}
		}
		return false;
	}
	
	public static int solution4(int n, int[][] costs) {
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr2[2], arr1[2]));
		int maxCost = costs[0][2];
		
		HashSet<Integer> islands = new HashSet<>(); // 섬이 전부 들어있나 확인 용
		ArrayList<int[]> bridges = new ArrayList<>(); // 섬이 전부 연결되었나 확인 용
		
		for(int cost=1; cost<=maxCost; cost++) {
			boolean allConnected = false;
			final int fianlCost = cost;
			System.out.println("2 non Ptint @@@@@@@@@@@@@@@");
			for(int i=0; i<costs.length; i++) {
				int[] bridge = costs[i];
				if(bridge[2]==fianlCost && !islands.contains(bridge[0]) && !islands.contains(bridge[1])) {
					System.out.println("Add Bridge: "+ bridge[0]+", " +bridge[1]);
					islands.add(bridge[0]);
					islands.add(bridge[1]);
					bridges.add(bridge);
					allConnected = isAllConnected(n, bridges);
					if(allConnected) break;
				}else {
					System.out.println(islands.toString());
					System.out.println("No Add Bridge: "+ bridge[0]+", " +bridge[1]);
					System.out.println("Cost Equal: "+(bridge[2]==fianlCost));
					System.out.println("0 Not Contain: "+(!islands.contains(bridge[0])));
					System.out.println("1 Not Contain: "+(!islands.contains(bridge[1])));
				}
				System.out.println();
			}
			if(allConnected) break;
			
			System.out.println("1 non Ptint @@@@@@@@@@@@@@@");
			for(int i=0; i<costs.length; i++) {
				int[] bridge = costs[i];
				if(bridge[2]==fianlCost && !bridges.contains(bridge)) {
					System.out.println("Add Bridge: "+ bridge[0]+", " +bridge[1]);
					islands.add(bridge[0]);
					islands.add(bridge[1]);
					bridges.add(bridge);
					allConnected = isAllConnected(n, bridges);
					if(allConnected) break;
				}else {
					System.out.println(islands.toString());
					System.out.println("No Add Bridge: "+ bridge[0]+", " +bridge[1]);
					System.out.println("Cost Equal: "+(bridge[2]==fianlCost));
					System.out.println("0 Not Contain: "+(!islands.contains(bridge[0])));
					System.out.println("1 Not Contain: "+(!islands.contains(bridge[1])));
				}
				System.out.println();
			}
			if(allConnected) break;
		}
		
		int answer = 0;
		for(int[] bridge : bridges) answer+=bridge[2];
		return answer;
	}
	public static boolean isAllConnected2(int n, ArrayList<int[]> bridges) {
		System.out.println("Connection Check @@@@@@@@@@@@@@@");
		HashSet<Integer> connect = new HashSet<>();
		connect.add(bridges.get(0)[0]);
		for(int i=0; i<n; i++) {
			for(int[] bridge : bridges) {
				if(connect.contains(bridge[0]) || connect.contains(bridge[1])) {
					if(connect.contains(bridge[0])) {System.out.println(bridge[0]+", "+bridge[1]+"은 "+bridge[0]+"을 가짐");}
					if(connect.contains(bridge[1])) {System.out.println(bridge[0]+", "+bridge[1]+"은 "+bridge[1]+"을 가짐");}
					
					if(connect.contains(bridge[0])) {System.out.println(bridge[1]+"을 추가함");}
					if(connect.contains(bridge[1])) {System.out.println(bridge[0]+"을 추가함");}
					System.out.println(connect.toString());
					connect.add(bridge[0]);
					connect.add(bridge[1]);
				}
				if(connect.size()==n) {break;}
			}
		}
		System.out.println(n+"개임? "+(connect.size()==n));
		return connect.size()==n;
	}
	
	public static int solution3(int n, int[][] costs) {
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr2[2], arr1[2]));
		int maxCost = costs[0][2];
		
		
		
		System.out.println(Arrays.deepToString(costs));
		Map<Integer, ArrayList<Integer[]>> costMap = new HashMap<>(); // 코스트별로 분류
		for(int[] cost : costs) { 
			ArrayList<Integer[]> temp = costMap.getOrDefault(cost[2], new ArrayList<>());
			temp.add(Arrays.stream(cost).boxed().toArray(Integer[]::new));
			costMap.put(cost[2], temp);
		}

		HashSet<Integer> islands = new HashSet<>(); // 섬이 전부 들어있나 확인 용
		ArrayList<Integer[]> bridges = new ArrayList<>();
		int answer = 0;
		
		for(int cost=1; cost<=maxCost; cost++) {
			final int fianlCost = cost;
			bridges.addAll(Arrays.asList(Arrays.stream(costs).filter(
					bridge-> bridge[2]==fianlCost && !islands.contains(bridge[0]) && !islands.contains(bridge[1])
					).toArray(Integer[][]::new)));
			bridges.addAll(Arrays.asList(Arrays.stream(costs).filter(
					bridge-> bridge[2]==fianlCost && (!islands.contains(bridge[0]) || !islands.contains(bridge[1]))
					).toArray(Integer[][]::new)));
		}
		
		for(Entry<Integer, ArrayList<Integer[]>> cost : costMap.entrySet()) { // 코스트 낮은 순으로
			ArrayList<Integer[]> temp = cost.getValue();
			for(int k=0; k<temp.size(); k++) { // 둘다 안 들어 있는 경우 먼저 추가
				if(!islands.contains(temp.get(k)[0]) && !islands.contains(temp.get(k)[1])) {
					islands.add(temp.get(k)[0]);
					islands.add(temp.get(k)[1]);
					answer+=temp.get(k)[2];
				}
			}
			for(int k=0; k<temp.size(); k++) { // 하나만 안 들어 있는 경우 추가
				if(!islands.contains(temp.get(k)[0]) || !islands.contains(temp.get(k)[1])) {
					islands.add(temp.get(k)[0]);
					islands.add(temp.get(k)[1]);
					answer+=temp.get(k)[2];
				}
			}
			if(islands.size()==n) break; // 전부 연결되면 탈출
		}
		return answer;
	}
	
	public static int solution2(int n, int[][] costs) {
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr1[2], arr2[2]));
		HashSet<Integer> set = new HashSet<>();
		int answer = 0;
		for(int i=0; set.size()<n; i++) {
			if(!set.contains(costs[i][0]) || !set.contains(costs[i][1])) {
				set.add(costs[i][0]);
				set.add(costs[i][1]);
				answer+=costs[i][2];
			}
		}
		return answer;
	}
	
	public static int solution(int n, int[][] costs) {
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr1[2], arr2[2]));
		System.out.println(Arrays.deepToString(costs));
		
		HashSet<Integer> set = new HashSet<>();
		int answer = 0, index=0;
		while(set.size()<n) {
			System.out.println("Size: "+set.size());
			
			if(!set.contains(costs[index][0]) || !set.contains(costs[index][1])) {
				set.add(costs[index][0]);
				if(!set.contains(costs[index][0])) System.out.println("Add "+costs[index][0]);
				set.add(costs[index][1]);
				if(!set.contains(costs[index][1])) System.out.println("Add "+costs[index][1]);
				answer+=costs[index][2];
				System.out.println("Add Answer "+costs[index][2]);
				System.out.println(set.toString()+"\r\n");
				index++;
			}
		}
		
		return answer;
	}
}
