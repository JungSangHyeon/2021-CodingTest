package day_2021_05_07;

import java.util.Arrays; 
import java.util.LinkedList;
import java.util.Queue;

public class P2_프린터 {

	/**
	 * 배운 점
	 * 1. 괜시리 좋은 방법 찾는다고 너무 고민하지 말자
	 * 2.  Queue<Integer> que // 큐 만들기
	 */
	
	public void test() {
		System.out.println(solution2(new int[] {2,1,3,2 }, 2));
		System.out.println(solution2(new int[] {1, 1, 9, 1, 1, 1 }, 0));
	}
	
	/**
	 * 인기 제일 많은 답안 
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
	 * 내가 생각한 방법 2
	 * 
	 * 배열을 쭉 읽고 가장 앞의, 가장 큰 녀석(A)을 찾아 값을 -1로 바꾼다
	 * 다음 배열 읽기는 A의 인덱스부터 한다.
	 * 이를 반복하다가 A가 location인 경우 count를 리턴
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
	 * 내가 생각한 방법
	 * 
	 * 결국 내 문서보다 중요한 것은 먼저 나가고, 내 문서보다 중요하지 않은 것은 나중에 나간다. 그러니까 (중요한 문서의 개수(A) + 같은
	 * 중요도에서 내 문서의 나가는 순서(B))를 알면 된다. B는 내 문서의 중요도 보다 높은 문서의 마지막 순서(C)부터 읽으면 된다. Ex
	 * ) 1, 1, 2, 1 이면 2, 3, X, 1 순
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
