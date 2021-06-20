package year_2021.month_06.day_21;

import java.util.ArrayList;

public class P58_다트_게임 {

	public static void main(String[] args) {

		System.out.println(solution("1S2D*3T"));
	}

	public static int solution(String dartResult) {
		ArrayList<Integer> scores = new ArrayList<>();
		char[] dartResultChar = dartResult.toCharArray();
		for (int i = 0; i < dartResultChar.length; i++) {
			int score = 0;
			if(dartResultChar[i]=='1' && dartResultChar[i+1]=='0') { score=10; i++; }
			else score=Integer.valueOf(dartResultChar[i]+""); 
			
			i++;
			switch(dartResultChar[i]) {
			case 'D': score = (int) Math.pow(score, 2); break; 
			case 'T': score = (int) Math.pow(score, 3); break; 
			}
			
			i++;
			if(dartResultChar.length>i) {
				if(dartResultChar[i]=='*') {
					if(scores.size()>0) scores.set(scores.size()-1, scores.get(scores.size()-1)*2);
					score*=2;
				}else if(dartResultChar[i]=='#') score*=-1;
				else i--;
			}
			scores.add(score);
		}

		int sum = 0;
		for(int score : scores) sum+=score;
		return sum;
	}
	
	
	public static int solution1(String dartResult) {
		int sum = 0;
		
		ArrayList<Integer> scores = new ArrayList<>();
		
		char[] dartResultChar = dartResult.toCharArray();
		for (int i = 0; i < dartResultChar.length; i++) {
			int score = 0;
			
			if(dartResultChar[i]=='1' && dartResultChar[i+1]=='0') {
				score=10;
				i++;
			}else {
				score=Integer.valueOf(dartResultChar[i]+"");
			}
			System.out.print(score);
			
			i++;
			if(dartResultChar[i]=='S') {
				System.out.print("^"+1);
			}else if(dartResultChar[i]=='D') {
				score = (int) Math.pow(score, 2);
				System.out.print("^"+2);
			}else if(dartResultChar[i]=='T') {
				score = (int) Math.pow(score, 3);
				System.out.print("^"+3);
			}
			
			i++;
			if(dartResultChar.length>i) {
				if(dartResultChar[i]=='*') {
					if(scores.size()>0) {
						scores.set(scores.size()-1, scores.get(scores.size()-1)*2);
					}
					score*=2;
					System.out.print('*');
				}else if(dartResultChar[i]=='#') {
					System.out.print('#');
					score*=-1;
				}else {
					i--;
				}
			}
			scores.add(score);
			System.out.print(" + ");
		}
		
		for(int s : scores) {
			sum+=s;
		}
		System.out.println();
		return sum;
	}

}
