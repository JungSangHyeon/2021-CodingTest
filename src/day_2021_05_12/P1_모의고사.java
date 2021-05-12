package day_2021_05_12;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class P1_모의고사 {

	/**
	 * 나쁘지 않은 답 인 것 같넹
	 * 
	 * 배운 점
	 * 1. 써보니 IntStream 좋다!
	 * 2. temp.stream().mapToInt(i->i).toArray(); 으로 Array를 []로
	 * 
	 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5 / 1, 2, 3, 4, 5, ... 
	 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5 / 2, 1, 2, 3, 2, 4, 2, 5, ... 
	 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 / 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	 */
	public static void main(String[] args) {
		solution(new int[] {1,3,2,4,2});
	}

	public static int[] solution(int[] answers) {
		int student1Score = getScore(answers, new int[] {1, 2, 3, 4, 5});
		int student2Score = getScore(answers, new int[] {2, 1, 2, 3, 2, 4, 2, 5});
		int student3Score = getScore(answers, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
		int maxScore = Math.max(student1Score, Math.max(student2Score, student3Score));
		
		ArrayList<Integer> temp = new ArrayList<>();
		if(student1Score == maxScore) temp.add(1);
		if(student2Score == maxScore) temp.add(2);
		if(student3Score == maxScore) temp.add(3);
		return temp.stream().mapToInt(i->i).toArray();
	}
	private static int getScore(int[] answers, int[] pattern) {
		return IntStream.range(0, answers.length).map(i -> ((answers[i]==pattern[i%pattern.length])? 1:0)).sum();
	}
}
