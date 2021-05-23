package year_2021.month_05.day_24;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class P27_섬_연결하기 {

	/**
	 * 크루스칼 알고리즘: 최소 신장 트리 구하는 알고리즘!
	 * 알고리즘 수업 왜 듣는지 알겠다.
	 * 이런거 배워다 쓰라는거고만.
	 */
	
	public static void main(String[] args) {
//		System.out.println(solution9(4, new int[][] {{0,1,1},{0,2,1},{0,3,1},{3,1,1},{3,2,1},{1,2,1}})); // 3
//		System.out.println(solution9(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); // 4
//		System.out.println(solution9(5, new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}})); // 15 XOO
//		System.out.println(solution9(5, new int[][] {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}})); // 8 OXO
//		System.out.println(solution9(4, new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}})); // 9 XOO
//		System.out.println(solution9(5, new int[][] {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}})); // 104 XOO
//		System.out.println(solution9(6, new int[][] {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}})); // 11 OXO
//		System.out.println(solution9(5, new int[][] {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}})); // 6 OXO
//		System.out.println(solution9(5, new int[][] {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}})); // 8 XXX
//		System.out.println(solution9(5, new int[][] {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}})); // 8 OXO
//		System.out.println(solution9(5, new int[][] {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}})); // 15
//		System.out.println(solution9(5, new int[][] {{0,1,2}, {1,4,1}, {1,2,5}, {0,3,3}, {2,3,1},{3,4,4}})); // 7
		System.out.println(solution9(6, new int[][] {{0, 1, 1}, {2, 3, 2}, {4, 5, 2}, {2, 4, 3}, {1, 5, 4}})); // 12
	}

	public static int solution9(int n, int[][] costs) {
		boolean[] visitedIslandCheck = new boolean[n];
		ArrayList<HashSet<Integer>> islandGroups = new ArrayList<>();
		Arrays.sort(costs, (arr1, arr2)->Integer.compare(arr1[2], arr2[2]));

		int sum = 0, count =0;
		for(int[] cost : costs) {
			boolean cycle = false;
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(cost[0]) && islandGroup.contains(cost[1])) {cycle = true; break;}
			}
			
			if(!cycle) {
				visitedIslandCheck[cost[0]] = true;
				visitedIslandCheck[cost[1]] = true;
				sum+=cost[2];
				count++;
				
				boolean added = false; 
				ArrayList<HashSet<Integer>> sameAddedGroup = new ArrayList<>();
				for(HashSet<Integer> islandGroup : islandGroups) {
					if(islandGroup.contains(cost[0]) || islandGroup.contains(cost[1])) {
						islandGroup.add(cost[0]);
						islandGroup.add(cost[1]);
						sameAddedGroup.add(islandGroup);
						added=true;
					}
				}
				if(sameAddedGroup.size()>1) {
					HashSet<Integer> compound = new HashSet<>();
					for(HashSet<Integer> islandGroup : sameAddedGroup) {
						compound.addAll(islandGroup);
						islandGroups.remove(islandGroup);
					}
					islandGroups.add(compound);
				}
				if(!added) {
					HashSet<Integer> islandGroup = new HashSet<>();
					islandGroup.add(cost[0]);
					islandGroup.add(cost[1]);
					islandGroups.add(islandGroup);
				}
			}
			if(count==n-1) break;
		}
		return sum;
	}
	
	public static int solution8(int n, int[][] costs) {
		ArrayList<HashSet<Integer>> islandGroups = new ArrayList<>();
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			boolean alreadyAddedIsland = false; // 이미 추가된 섬이면 넘어간다.
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(i)) {alreadyAddedIsland=true; break;}
			}
			if(alreadyAddedIsland) continue;
			
			int minCost = Integer.MAX_VALUE, minCostIndex = -1; // 섬을 추가하는 다리 중 가장 저렴한 것을 찾는다.
			for(int ci=0; ci<costs.length; ci++) {
				if((costs[ci][0]==i || costs[ci][1]==i) && costs[ci][2]<minCost) {
					minCostIndex = ci;
					minCost=costs[ci][2];
				}
			}
			sum +=costs[minCostIndex][2];
			
			boolean added = false; // 섬을 연결된 그룹별로 추가한다.
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(costs[minCostIndex][0]) || islandGroup.contains(costs[minCostIndex][1])) {
					islandGroup.add(costs[minCostIndex][0]);
					islandGroup.add(costs[minCostIndex][1]);
					added=true;
				}
			}
			if(!added) {
				HashSet<Integer> islandGroup = new HashSet<>();
				islandGroup.add(costs[minCostIndex][0]);
				islandGroup.add(costs[minCostIndex][1]);
				islandGroups.add(islandGroup);
			}
		}
		
		if(islandGroups.size()>1) {
			ArrayList<int[]> groupBridges = new ArrayList<>();
			for(int i=0; i<islandGroups.size(); i++) { // 그룹을 연결하는 가장 저렴한 그룹 간 다리들을 찾는다.
				for(int k=i+1; k<islandGroups.size(); k++) {
					int minCost = Integer.MAX_VALUE, minCostIndex = -1;
					for(int ci=0; ci<costs.length; ci++) {
						boolean case1 = islandGroups.get(i).contains(costs[ci][0]) && islandGroups.get(k).contains(costs[ci][1]);
						boolean case2 = islandGroups.get(i).contains(costs[ci][1]) && islandGroups.get(k).contains(costs[ci][0]);
						if((case1||case2) && costs[ci][2]<minCost) {
							minCostIndex = ci;
							minCost=costs[ci][2];
						}
					}
					if(minCostIndex==-1) continue;
					groupBridges.add(costs[minCostIndex]);
					costs[minCostIndex][0]=i;
					costs[minCostIndex][1]=k;
				}
			}
			
			ArrayList<HashSet<Integer>> islandGroupGroups = new ArrayList<>();
			for(int i=0; i<islandGroups.size(); i++) {
				boolean alreadyAddedIslandGroup = false; // 이미 추가된 그룹이면 넘어간다.
				for(HashSet<Integer> islandGroupGroup : islandGroupGroups) {
					if(islandGroupGroup.contains(i)) {alreadyAddedIslandGroup=true; break;}
				}
				if(alreadyAddedIslandGroup) continue;
				
				int minCost = Integer.MAX_VALUE, minCostIndex = -1; // 그룹을 추가하는 다리 중 가장 저렴한 것을 찾는다.
				for(int ci=0; ci<groupBridges.size(); ci++) {
					if((groupBridges.get(ci)[0]==i || groupBridges.get(ci)[1]==i) && groupBridges.get(ci)[2]<minCost) {
						minCostIndex = ci;
						minCost=groupBridges.get(ci)[2];
					}
				}
				sum +=groupBridges.get(minCostIndex)[2];
				
				boolean added = false; // 섬을 연결된 그룹별로 추가한다.
				for(HashSet<Integer> islandGroupGroup : islandGroupGroups) {
					if(islandGroupGroup.contains(costs[minCostIndex][0]) || islandGroupGroup.contains(costs[minCostIndex][1])) {
						islandGroupGroup.add(costs[minCostIndex][0]);
						islandGroupGroup.add(costs[minCostIndex][1]);
						added=true;
					}
				}
				if(!added) {
					HashSet<Integer> islandGroupGroup = new HashSet<>();
					islandGroupGroup.add(costs[minCostIndex][0]);
					islandGroupGroup.add(costs[minCostIndex][1]);
					islandGroupGroups.add(islandGroupGroup);
				}
			}
		}
		return sum;
	}
	public static int solution7(int n, int[][] costs) {
		ArrayList<HashSet<Integer>> islandGroups = new ArrayList<>();
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			boolean alreadyAddedIsland = false; // 이미 추가된 섬이면 넘어간다.
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(i)) {alreadyAddedIsland=true; break;}
			}
			if(alreadyAddedIsland) continue;
			
			int minCost = Integer.MAX_VALUE, minCostIndex = -1; // 섬을 추가하는 다리 중 가장 저렴한 것을 찾는다.
			for(int ci=0; ci<costs.length; ci++) {
				if((costs[ci][0]==i || costs[ci][1]==i) && costs[ci][2]<minCost) {
					minCostIndex = ci;
					minCost=costs[ci][2];
				}
			}
			System.out.printf(i+" 섬을 연결하는 다리 중 제일 싼 것의 정보: %d, %d, %d\r\n", 
					costs[minCostIndex][0], costs[minCostIndex][1], costs[minCostIndex][2]);
			sum +=costs[minCostIndex][2];
			System.out.println(sum);
			
			boolean added = false; // 섬을 연결된 그룹별로 추가한다.
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(costs[minCostIndex][0]) || islandGroup.contains(costs[minCostIndex][1])) {
					islandGroup.add(costs[minCostIndex][0]);
					islandGroup.add(costs[minCostIndex][1]);
					added=true;
				}
			}
			if(!added) {
				HashSet<Integer> islandGroup = new HashSet<>();
				islandGroup.add(costs[minCostIndex][0]);
				islandGroup.add(costs[minCostIndex][1]);
				islandGroups.add(islandGroup);
			}
		}
		
		if(islandGroups.size()>1) {
			
			ArrayList<int[]> groupBridges = new ArrayList<>();
			for(int i=0; i<islandGroups.size(); i++) { // 그룹을 연결하는 가장 저렴한 그룹 간 다리들을 찾는다.
				for(int k=i+1; k<islandGroups.size(); k++) {
					int minCost = Integer.MAX_VALUE, minCostIndex = -1;
					for(int ci=0; ci<costs.length; ci++) {
						boolean case1 = islandGroups.get(i).contains(costs[ci][0]) && islandGroups.get(k).contains(costs[ci][1]);
						boolean case2 = islandGroups.get(i).contains(costs[ci][1]) && islandGroups.get(k).contains(costs[ci][0]);
						if((case1||case2) && costs[ci][2]<minCost) {
							minCostIndex = ci;
							minCost=costs[ci][2];
						}
					}
					if(minCostIndex==-1) continue;
					groupBridges.add(costs[minCostIndex]);
					costs[minCostIndex][0]=i;
					costs[minCostIndex][1]=k;
				}
			}
			
			ArrayList<HashSet<Integer>> islandGroupGroups = new ArrayList<>();
			for(int i=0; i<islandGroups.size(); i++) {
				boolean alreadyAddedIslandGroup = false; // 이미 추가된 그룹이면 넘어간다.
				for(HashSet<Integer> islandGroupGroup : islandGroupGroups) {
					if(islandGroupGroup.contains(i)) {alreadyAddedIslandGroup=true; break;}
				}
				if(alreadyAddedIslandGroup) continue;
				
				int minCost = Integer.MAX_VALUE, minCostIndex = -1; // 그룹을 추가하는 다리 중 가장 저렴한 것을 찾는다.
				for(int ci=0; ci<groupBridges.size(); ci++) {
					if((groupBridges.get(ci)[0]==i || groupBridges.get(ci)[1]==i) && groupBridges.get(ci)[2]<minCost) {
						minCostIndex = ci;
						minCost=groupBridges.get(ci)[2];
					}
				}
				System.out.printf(i+" 그룹을 연결하는 다리 중 제일 싼 것의 정보: %d, %d, %d\r\n", 
						groupBridges.get(minCostIndex)[0], groupBridges.get(minCostIndex)[1], groupBridges.get(minCostIndex)[2]);
				sum +=groupBridges.get(minCostIndex)[2];
				System.out.println(sum);
				
				boolean added = false; // 섬을 연결된 그룹별로 추가한다.
				for(HashSet<Integer> islandGroupGroup : islandGroupGroups) {
					if(islandGroupGroup.contains(costs[minCostIndex][0]) || islandGroupGroup.contains(costs[minCostIndex][1])) {
						islandGroupGroup.add(costs[minCostIndex][0]);
						islandGroupGroup.add(costs[minCostIndex][1]);
						added=true;
					}
				}
				if(!added) {
					HashSet<Integer> islandGroupGroup = new HashSet<>();
					islandGroupGroup.add(costs[minCostIndex][0]);
					islandGroupGroup.add(costs[minCostIndex][1]);
					islandGroupGroups.add(islandGroupGroup);
				}
			}
		}
		
		// 그룹을 연결하는 가장 저렴한 그룹 간 다리를 선택한다.
		
		
		return sum;
	}
	public static int solution6(int n, int[][] costs) {
		ArrayList<HashSet<Integer>> islandGroups = new ArrayList<>();
		ArrayList<int[]> bridgeGroups = new ArrayList<>();
		
		for(int i=0; i<n; i++) {// 추가되어 있으면 패스 할 것
			boolean alreadyAddedIsland = false;
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(i)) {alreadyAddedIsland=true; break;}
			}
			if(alreadyAddedIsland) {
				continue;
			}
			
			int minCost = Integer.MAX_VALUE, minCostIndex = -1;
			for(int ci=0; ci<costs.length; ci++) {
				if((costs[ci][0]==i || costs[ci][1]==i) && costs[ci][2]<minCost) {
					minCostIndex = ci;
					minCost=costs[ci][2];
				}
			}
			// 없는 것 처리
			System.out.printf(i+" 섬을 연결하는 다리 중 제일 싼 것의 정보: %d, %d, %d\r\n", 
					costs[minCostIndex][0], costs[minCostIndex][1], costs[minCostIndex][2]);
			bridgeGroups.add(costs[minCostIndex]);
			
			boolean added = false;
			for(HashSet<Integer> islandGroup : islandGroups) {
				if(islandGroup.contains(costs[minCostIndex][0]) || islandGroup.contains(costs[minCostIndex][1])) {
					islandGroup.add(costs[minCostIndex][0]);
					islandGroup.add(costs[minCostIndex][1]);
					added=true;
				}
			}
			if(!added) {
				HashSet<Integer> islandGroup = new HashSet<>();
				islandGroup.add(costs[minCostIndex][0]);
				islandGroup.add(costs[minCostIndex][1]);
				islandGroups.add(islandGroup);
			}
		}
		
		for(int i=0; i<islandGroups.size(); i++) {
			for(int k=i+1; k<islandGroups.size(); k++) {
				int minCost = Integer.MAX_VALUE, minCostIndex = -1;
				for(int ci=0; ci<costs.length; ci++) {
					boolean case1 = islandGroups.get(i).contains(costs[ci][0]) && islandGroups.get(k).contains(costs[ci][1]);
					boolean case2 = islandGroups.get(i).contains(costs[ci][1]) && islandGroups.get(k).contains(costs[ci][0]);
					if((case1||case2) && costs[ci][2]<minCost) {
						minCostIndex = ci;
						minCost=costs[ci][2];
					}
				}
				System.out.printf(
						islandGroups.get(i).toString()+" / "+islandGroups.get(k).toString()+
						" 그룹을 연결하는 다리 중 제일 싼 것의 정보: %d, %d, %d\r\n",
						costs[minCostIndex][0], costs[minCostIndex][1], costs[minCostIndex][2]);
				bridgeGroups.add(costs[minCostIndex]);
			}
		}
		
		int sumOfCost = 0;
		for(int[] bridge : bridgeGroups) {
			sumOfCost+= bridge[2];
		}
		return sumOfCost;
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
