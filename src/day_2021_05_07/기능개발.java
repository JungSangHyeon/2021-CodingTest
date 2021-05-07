package day_2021_05_07;

import java.util.Arrays;
import java.util.Vector;

public class ��ɰ��� {

	/**
	 * ��� ��
	 * 1. ó������ Ǯ� �����ε� ��մ�!
	 * 2. ����� �������ٰ� �ٷ� �ڵ� ¥�� ����, ���� ����� �����غ���.
	 * 3. Arrays.stream(dayOfend).filter(i -> i!=0).toArray(); // �迭���� Ư�� ������ �����ϴ� �� �� �̾� �迭�� �����. 
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
