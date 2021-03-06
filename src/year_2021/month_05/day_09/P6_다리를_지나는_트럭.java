package year_2021.month_05.day_09;

import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.Queue;

public class P6_다리를_지나는_트럭 {

	/**
	 * 코드가 좀 길지 않나 싶었는데 모범 답안과 같다!
	 * 딱히 배운 건 없다.
	 */
	
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> truckOnWait = new LinkedList<>();
		ArrayList<Truck> truckOnBridge = new ArrayList<>();
		for(int truckWeight : truck_weights) {truckOnWait.add(new Truck(truckWeight));}
		int time = 1, nowBridgeOnWeight = 0;
		while(truckOnWait.size()!=0 || truckOnBridge.size()!=0) {
			if(truckOnWait.size()>0 && nowBridgeOnWeight + truckOnWait.peek().weight <= weight) {
				nowBridgeOnWeight += truckOnWait.peek().weight;
				truckOnBridge.add(truckOnWait.poll());
			}
			Truck removeTarget = null;
			for(Truck truck : truckOnBridge) {
				if(++truck.move==bridge_length) {removeTarget = truck;}
			}
			if(removeTarget!=null) {
				nowBridgeOnWeight-=removeTarget.weight;
				truckOnBridge.remove(removeTarget);
			}
			time++;
		}
        return time;
    }
	private static class Truck {
		public int weight, move = 0;
		public Truck(int weight) {this.weight=weight;}
	}
}
