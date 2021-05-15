package year_2021.month_05.day_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class P18_��_�ʰ� {

	/**
	 * �׳� ®���� ȿ�������� Ż���ؼ� ���� ã�� ����ߴ�.
	 * ���� ���� ���ΰ� �ʿ����� ������.
	 * �׸��� �ڵ�� ������ �ְ��.
	 */
	
	public static void main(String[] args) {
		System.out.println(solution2(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}

	public static int solution(int[] scoville, int K) {
		ArrayList<Integer> scovilles = new ArrayList<>();
		for(int sco : scoville) {scovilles.add(sco);}
		Collections.sort(scovilles);
		
		int count = 0;
		while(scovilles.get(0)<K) {
			if(scovilles.size()==1) {return -1;}
			int sco1 = scovilles.get(0), sco2 = scovilles.get(1);
			int newSco = sco1 + sco2*2;
			scovilles.remove(0);
			scovilles.remove(0);
			scovilles.add(newSco);
			Collections.sort(scovilles);
			count++;
		}
        return count;
    }
	public static int solution2(int[] scoville, int K) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int sco : scoville) {minHeap.add(sco);}
		
		int count = 0;
		while(minHeap.peek()<K) {
			if(minHeap.size()==1) {return -1;}
			minHeap.add(minHeap.poll() + minHeap.poll()*2);
			count++;
		}
		return count;
	}
	
}
