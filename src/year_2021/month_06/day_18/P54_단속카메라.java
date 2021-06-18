package year_2021.month_06.day_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class P54_단속카메라 {

	/**
	 * 해결 방법 자체를 찾기가 어렵네... 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}})); // 2		
		System.out.println(solution(new int[][]{{0,2},{2,3},{3,4},{4,6}})); // 2
	}

	public static int solution(int[][] routes) {
		ArrayList<int[]> routeArray = new ArrayList<>();
		for(int[] route : routes) routeArray.add(route);
		routeArray.sort((arr1, arr2)->Integer.compare(arr1[1], arr2[1]));
		
		int answer = 0;
		while(!routeArray.isEmpty()) {
			answer++;
			int road = routeArray.get(0)[1];
			for(int i=0; i<routeArray.size(); i++) {
				if(routeArray.get(i)[0]<=road && road<=routeArray.get(i)[1]) {
					routeArray.remove(i);
					i--;
				} 
			}
		}
		return answer;
	}
	public static int solution4(int[][] routes) {
		TreeSet<Integer> allValueSet = new TreeSet<>();
		for(int[] route : routes) {
			for(int road : route) allValueSet.add(road);
		}
		Integer[] allValueArray = allValueSet.toArray(Integer[]::new);
		
		// Create Route ArrayList
		ArrayList<Route> routeArray = new ArrayList<Route>();
		for(int[] route : routes) routeArray.add(new Route(route));
		
		ArrayList<Route> shareRouteList = new ArrayList<>();
		int count=0;
		while(routeArray.size()!=0) {
			count++;
			// Find Max Share
			int maxShareCount=-1;
			for(int value : allValueArray) {
				ArrayList<Route> temp = new ArrayList<>();
				int shareCount = 0;
				for(Route route : routeArray) {
					if(route.start<=value && value<=route.end) {
						shareCount++;
						temp.add(route);
					}
				}
				if(maxShareCount<shareCount) {
					maxShareCount = shareCount;
					shareRouteList.clear();
					shareRouteList.addAll(temp);
				}
			}
			
			// Remove Routes 
			routeArray.removeAll(shareRouteList);
		}
		
		return count;
	}
	public static int solution3(int[][] routes) {
		TreeSet<Integer> allValueSet = new TreeSet<>();
		for(int[] route : routes) {
			for(int road : route) allValueSet.add(road);
		}
		Integer[] allValueArray = allValueSet.toArray(Integer[]::new);
		
		ArrayList<Route> routeArray = new ArrayList<Route>();
		for(int[] route : routes) routeArray.add(new Route(route));
		
		int count=0;
		while(routeArray.size()!=0) {
			count++;
			
			int maxShareValue=-1, maxShareCount=-1;
			for(int value : allValueArray) {
				int shareCount = 0;
				for(Route route : routeArray) {
					if(route.start<=value && value<=route.end) shareCount++;
				}
				if(maxShareCount<shareCount) {
					maxShareValue = value;
					maxShareCount = shareCount;
				}
			}
			
			for(int i=0; i<routeArray.size(); i++) {
				Route route = routeArray.get(i);
				if(route.start<=maxShareValue && maxShareValue<=route.end) { routeArray.remove(i); i--; }
			}
		}
		
		return count;
	}
	
	public static int solution2(int[][] routes) {
		ArrayList<Route> routeArray = new ArrayList<Route>();
		for(int[] route : routes) routeArray.add(new Route(route));
		routeArray.sort((r1, r2)->{
			int lengthCompare = Integer.compare(r1.length, r2.length);
			int startCompare = Integer.compare(r1.start, r2.start);
			return lengthCompare==0? lengthCompare:startCompare;
		});
		int i;
		for(i=0; i<routeArray.size(); i++) {
			Route shareRoute = new Route(routeArray.get(i).route);
			for(int j=i+1; j<routeArray.size(); j++) {
				Route checkRoute = routeArray.get(j);
				boolean startPointIn = checkRoute.start <= shareRoute.start && shareRoute.start <= checkRoute.end;
				boolean endPointIn = checkRoute.start <= shareRoute.end && shareRoute.end <= checkRoute.end;
				if(startPointIn) shareRoute.end=checkRoute.end;
				else if(endPointIn) shareRoute.start=checkRoute.start;
				if(startPointIn || endPointIn) {routeArray.remove(j); j--;}
			}
		}
		return i;
	}
	public static int solution1(int[][] routes) {
		ArrayList<Route> routeArray = new ArrayList<Route>();
		for(int[] route : routes) routeArray.add(new Route(route));
		routeArray.sort((r1, r2)->{
			int lengthCompare = Integer.compare(r1.length, r2.length);
			int startCompare = Integer.compare(r1.start, r2.start);
			return lengthCompare!=0? lengthCompare:startCompare;
		});
		int i;
		for(i=0; i<routeArray.size(); i++) {
			Route shareRoute = new Route(routeArray.get(i).route);
			for(int j=i+1; j<routeArray.size(); j++) {
				Route checkRoute = routeArray.get(j);
				System.out.println("현재 공유 루트: ["+shareRoute.start+", "+shareRoute.end+"]");
				System.out.println("현재 체크 루트: ["+checkRoute.start+", "+checkRoute.end+"]");
				boolean startPointIn = checkRoute.start <= shareRoute.start && shareRoute.start <= checkRoute.end;
				boolean endPointIn = checkRoute.start <= shareRoute.end && shareRoute.end <= checkRoute.end;
				boolean allPointIn = startPointIn && endPointIn;
				if(allPointIn) {
					routeArray.remove(j); j--;
					System.out.println("완전 곂칩니다.");
				}else if(startPointIn) {
					shareRoute.end=checkRoute.end;
					routeArray.remove(j); j--;
					System.out.println("일부 곂칩니다. 공유 루트 변경");
					System.out.println("현재 공유 루트: ["+shareRoute.start+", "+shareRoute.end+"]");
				}else if(endPointIn) {
					shareRoute.start=checkRoute.start;
					routeArray.remove(j); j--;
					System.out.println("일부 곂칩니다. 공유 루트 변경");
					System.out.println("현재 공유 루트: ["+shareRoute.start+", "+shareRoute.end+"]");
				}
				System.out.println();
			}
		}
		return i;
	}
	
	private static class Route {
		public int[] route;
		public int start, end, length;
		public Route(int[] route) {
			this.route=route;
			this.start=route[0];
			this.end=route[1];
			this.length = this.end-this.start;
		}
	}
}
