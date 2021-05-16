package year_2021.month_05.day_16;

import java.util.PriorityQueue;

public class P20_디스크_컨트롤러 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[][] jobs) {
		// 우선순위 = 웨이팅+소요시간 = Math.max(요청시간-현재시간, 0)+소요시간 
		// 우선순위가 작은 순으로 실행.
		// 현재 시간이 변화하는 것은 어떻게 하면 되나.
        int answer = 0;
        int time = 0;
        PriorityQueue<Integer[]> reversedPriorityQueue = new PriorityQueue<>(
    		(Integer[] task1, Integer[] task2) -> Math.max(task1[0]-time, 0)+task1[1] >= Math.max(task2[0]-time, 0)+task2[1]? 1:-1
        );
        time++;
        return answer;
    }
}
