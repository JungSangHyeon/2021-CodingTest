package year_2021.month_05.pause;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import year_2021.month_05.pause.P28_단속카메라.Route;

public class P28_단속카메라 {

	public static void main(String[] args) {

		System.out.println(solution2(new int[][] {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}

	
	public static int solution2(int[][] routes) { // 구조체를 만들자
		Route[] allRoutes = Arrays.stream(routes).map(r->new Route(r[0], r[1])).toArray(Route[]::new);
		Map<Integer, ArrayList<Route>> road = new HashMap<>();
		ArrayList<Route> crossPointRoutes;
		
		for(Route route : allRoutes) {
			for(int i=route.start; i<route.end+1; i++) {
				crossPointRoutes = road.getOrDefault(i, new ArrayList<>());
				crossPointRoutes.add(route);
				road.put(i, crossPointRoutes);
			}
		}
		
		int cameraCount = 0, maxCrossCount=0, maxCrossCountPoint = 0, realSize = 0;
		while(true) {
			maxCrossCount=0; maxCrossCountPoint = 0;
			for(Integer point : road.keySet()) {
				realSize = 0;
				for(Route route : road.get(point)) {
					if(route.start!=30001) realSize++;
				}
				if(realSize>maxCrossCount) {
					maxCrossCount = realSize;
					maxCrossCountPoint = point;
				}
			}
			System.out.println("maxCrossCount: "+maxCrossCount);
			System.out.println("maxCrossCountPoint: "+maxCrossCountPoint);
			if(maxCrossCount==0) return cameraCount;
			crossPointRoutes = road.get(maxCrossCountPoint);
			for(Route route : road.get(maxCrossCountPoint)) route.start=30001;
			cameraCount++;
		}
    }
	public static class Route {
		public int start, end;
		boolean checked;
		public Route(int start, int end) {this.start=start; this.end=end;}
	}
	
	public static int solution1(int[][] routes) { // 구조체를 만들자
		Map<Integer, ArrayList<int[]>> road = new HashMap<>();
		for(int[] route : routes) {
			ArrayList<int[]> crossPointRoutes = road.getOrDefault(route[0], new ArrayList<>());
			crossPointRoutes.add(route);
			road.put(route[0], crossPointRoutes);
			crossPointRoutes = road.getOrDefault(route[1], new ArrayList<>());
			crossPointRoutes.add(route);
			road.put(route[1], crossPointRoutes);
		}
		
		int cameraCount = 0;
		while(true) {
			int maxCrossCount=0, maxCrossCountPoint = 0; 
			for(Integer point : road.keySet()) {
				if(road.get(point).size()>maxCrossCount) {
					maxCrossCount = road.get(point).size();
					maxCrossCountPoint = point;
				}
			}
			System.out.println("maxCrossCount: "+maxCrossCount);
			System.out.println("maxCrossCountPoint: "+maxCrossCountPoint);
			if(maxCrossCount==0) return cameraCount;
			ArrayList<int[]> crossPointRoutes = road.get(maxCrossCountPoint);
			for(int i=0; i<crossPointRoutes.size(); i++) {
				crossPointRoutes.get(i)[0]=30001;
				crossPointRoutes.get(i)[1]=30001;
			}
			cameraCount++;
		}
    }
}
