package year_2021.month_05.day_16;

import java.util.PriorityQueue;

public class P20_��ũ_��Ʈ�ѷ� {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[][] jobs) {
		// �켱���� = ������+�ҿ�ð� = Math.max(��û�ð�-����ð�, 0)+�ҿ�ð� 
		// �켱������ ���� ������ ����.
		// ���� �ð��� ��ȭ�ϴ� ���� ��� �ϸ� �ǳ�.
        int answer = 0;
        int time = 0;
        PriorityQueue<Integer[]> reversedPriorityQueue = new PriorityQueue<>(
    		(Integer[] task1, Integer[] task2) -> Math.max(task1[0]-time, 0)+task1[1] >= Math.max(task2[0]-time, 0)+task2[1]? 1:-1
        );
        time++;
        return answer;
    }
}
