package year_2021.month_05.day_22;

import java.util.ArrayList;
import java.util.Arrays;

public class P25_구명보트 {

	/**
	 * ArrayList 안 쓰고 index로 같은 기능을 할 수 있제
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		ArrayList<Integer> peopleWeights = new ArrayList<>();
		for(int peopleWeight: people) peopleWeights.add(peopleWeight);
		
		int answer = 0;
		while(peopleWeights.size()!=0) {
			if(peopleWeights.size()==1) {
				peopleWeights.remove(0);
			}else {
				int maxWeight = peopleWeights.get(peopleWeights.size()-1);
				int minWeight = peopleWeights.get(0);
				if(maxWeight+minWeight<=limit) {
					peopleWeights.remove(peopleWeights.size()-1);
					peopleWeights.remove(0);
				}else {
					peopleWeights.remove(peopleWeights.size()-1);
				}
			}
			answer++;
		}
        return answer;
    }
}
