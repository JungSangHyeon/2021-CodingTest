package day_2021_05_07;

import java.util.Arrays; 
import java.util.LinkedList;
import java.util.Queue;

public class P2_������ {

	/**
	 * ��� ��
	 * 1. ���ø� ���� ��� ã�´ٰ� �ʹ� ������� ����
	 * 2.  Queue<Integer> que // ť �����
	 */
	
	public void test() {
		System.out.println(solution2(new int[] {2,1,3,2 }, 2));
		System.out.println(solution2(new int[] {1, 1, 9, 1, 1, 1 }, 0));
	}
	
	/**
	 * �α� ���� ���� ��� 
	 */
	public int solution3(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
	
	/**
	 * ���� ������ ��� 2
	 * 
	 * �迭�� �� �а� ���� ����, ���� ū �༮(A)�� ã�� ���� -1�� �ٲ۴�
	 * ���� �迭 �б�� A�� �ε������� �Ѵ�.
	 * �̸� �ݺ��ϴٰ� A�� location�� ��� count�� ����
	 */
	public int solution2(int[] priorities, int location) {
		int biggestValue=-1, biggestValueIndex=-1, beforeBiggestValueIndex = 0, count = 0;
		while(biggestValueIndex !=location) {
			count++; biggestValue=-1; biggestValueIndex=-1;
			for(int i=beforeBiggestValueIndex; i<priorities.length; i++) {
				if(priorities[i]>biggestValue) {
					biggestValue = priorities[i];
					biggestValueIndex = i;
				}
			}
			for(int i=0; i<beforeBiggestValueIndex; i++) {
				if(priorities[i]>biggestValue) {
					biggestValue = priorities[i];
					biggestValueIndex = i;
				}
			}
			priorities[biggestValueIndex] = -1;
			beforeBiggestValueIndex = biggestValueIndex;
		}
		return count;
	}
	
	/**
	 * ���� ������ ���
	 * 
	 * �ᱹ �� �������� �߿��� ���� ���� ������, �� �������� �߿����� ���� ���� ���߿� ������. �׷��ϱ� (�߿��� ������ ����(A) + ����
	 * �߿䵵���� �� ������ ������ ����(B))�� �˸� �ȴ�. B�� �� ������ �߿䵵 ���� ���� ������ ������ ����(C)���� ������ �ȴ�. Ex
	 * ) 1, 1, 2, 1 �̸� 2, 3, X, 1 ��
	 */
	public int solution(int[] priorities, int location) {
		int myPriority = priorities[location];
		int[] biggerPriorities = Arrays.stream(priorities).filter(i -> i > myPriority).toArray();
		if (biggerPriorities.length == 0) {
			return Arrays.stream(Arrays.copyOfRange(priorities, 0, location)).filter(i -> i == myPriority).toArray().length + 1;
		}
		Arrays.sort(biggerPriorities);
		int minBiggerPriority = biggerPriorities[0];
		int behindMinBiggerPriorityMinePriorityCount = 0, lastMinBiggerPriorityIndex = 0;
		for (int i = priorities.length - 1; i >= 0; i--) {
			if (priorities[i] == minBiggerPriority) {
				lastMinBiggerPriorityIndex = i;
				break;
			} else if (priorities[i] == myPriority) {
				behindMinBiggerPriorityMinePriorityCount++;
			}
		}
		if (location > lastMinBiggerPriorityIndex) {
			return biggerPriorities.length + Arrays.stream(Arrays.copyOfRange(priorities, lastMinBiggerPriorityIndex, location)).filter(i -> i == myPriority).toArray().length+1;
		} else {
			return biggerPriorities.length +Arrays.stream(Arrays.copyOfRange(priorities, 0, location)).filter(i -> i == myPriority).toArray().length + behindMinBiggerPriorityMinePriorityCount + 1;
		}
	}
}
