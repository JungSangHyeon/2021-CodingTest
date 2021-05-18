package year_2021.month_05.day_18;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class P21_���߿켱����ť {

	/**
	 * �� �� �ǳ�, �ߺ� �������� ������ �� �˾Ҵµ�, ť���� �ߺ� ���� �־ �ϳ��� ���� �ϳ�?
	 * �� ��ư �����
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"I 7","I 5","I 5","D -1"})));
//		System.out.println(Arrays.toString(solution(new String[] {"I 16","D 1"})));
//		System.out.println(Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // 0,0
//		System.out.println(Arrays.toString(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // 333,-45
//		System.out.println(Arrays.toString(solution(new String[] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}))); //6,5
	}

	public static int[] solution3(String[] operations) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(String operation : operations) {
			if(operation.equals("D 1")) {minQueue.remove(maxQueue.poll());}
			else if(operation.equals("D -1")) {maxQueue.remove(minQueue.poll());}
			else {
				int value = Integer.valueOf(operation.replaceAll("[I ]", ""));
				minQueue.add(value);
				maxQueue.add(value);
			}
		}
		if(maxQueue.peek()==null || minQueue.peek()==null) {return new int[] {0,0};}
        return IntStream.of(maxQueue.peek(), minQueue.peek()).toArray();
    }
	
	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		int numCount = 0;
		for(String operation : operations) {
			if(operation.equals("D 1")) {
				System.out.println("�ִ밪�� �����մϴ�. ���: "+maxQueue.peek());
				minQueue.remove(maxQueue.poll());
			}else if(operation.equals("D -1")) {
				System.out.println("�ּҰ��� �����մϴ�. ���: "+minQueue.peek());
				maxQueue.remove(minQueue.poll());
			}else {
				numCount++;
				int value = Integer.valueOf(operation.replaceAll("[I ]", ""));
				System.out.println("���� �߰��մϴ�. ���: "+value);
				minQueue.add(value);
				maxQueue.add(value);
			}
			System.out.println("minQueue: "+minQueue.toString()); 
			System.out.println("maxQueue: "+maxQueue.toString()); 
			System.out.println();
		}
//		if(numCount >= maxQueue.size()+minQueue.size() || maxQueue.peek()==null || minQueue.peek()==null) {return new int[] {0,0};}
		if(maxQueue.peek()==null || minQueue.peek()==null) {return new int[] {0,0};}
        return IntStream.of(maxQueue.peek(), minQueue.peek()).toArray();
    }
	
}
