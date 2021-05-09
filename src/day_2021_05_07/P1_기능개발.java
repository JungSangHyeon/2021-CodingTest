package day_2021_05_07;

import java.util.Arrays; 
import java.util.Vector;

public class P1_기능개발 {

	/**
	 * 배운 점
	 * 1. 처음으로 풀어본 문제인데 재밌다!
	 * 2. 방법이 생각난다고 바로 코드 짜지 말고, 여러 방법을 생각해보자.
	 * 3. Arrays.stream(dayOfend).filter(i -> i!=0).toArray(); // 배열에서 특정 조건을 만족하는 것 만 뽑아 배열로 만들기. 
	 */
	
    public int[] solution(int[] progresses, int[] speeds) {

        int top = 0, bottom = progresses.length; // Working Variable
        Vector<Integer> popCountVector = new Vector<>(); // Component
        
        while(top!=bottom) {
        	// Add Daily Progress
        	for(int i=0; i<progresses.length; i++) {
    			progresses[i]+=speeds[i];
    		}
        	
        	// Daily Pop
        	int dailyPopCount = 0;
        	for(int i=top; i<bottom; i++) {
        		if(progresses[i]>=100) {
        			top++;
        			dailyPopCount++;
        		}else {
        			break;
        		}
        	}
        	if(dailyPopCount!=0) {
        		popCountVector.add(dailyPopCount);
        	}
        }
        
        // Create Answer Array
        int[] answer = new int[popCountVector.size()];
        for(int i=0; i<popCountVector.size(); i++) {
        	answer[i] = popCountVector.get(i);
        }
        
        return answer;
    }
    
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
