package year_2021.month_08.day_09;

import java.util.*;

public class P127_꽃피우기 {

	public static void main(String[] args) {
		int[][] garden1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ret1 = solution(garden1);

		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int[][] garden2 = { { 1, 1 }, { 1, 1 } };
		int ret2 = solution(garden2);

		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
	}
	
	public static int solution(int[][] garden) {
		boolean finished = false;
		int answer = 0;
		
		while(!finished) {
			finished = true;
			for(int i=0; i<garden.length; i++) {
				for(int j=0; j<garden.length; j++) {
					if(garden[i][j]==0) {
						finished = false;
						break;
					}
				}
			}
			
			if(!finished) {
				int[][] copy = new int[garden.length][garden.length];
				for(int i=0; i<garden.length; i++) {
					for(int j=0; j<garden.length; j++) {
						copy[i][j]=garden[i][j];
					}
				}
				
				for(int i=0; i<garden.length; i++) {
					for(int j=0; j<garden.length; j++) {
						if(copy[i][j]==1) {
							if(i>0) garden[i-1][j]=1;
							if(j>0) garden[i][j-1]=1;
							if(garden.length-1>i) garden[i+1][j]=1;
							if(garden.length-1>j) garden[i][j+1]=1;
						}
					}
				}
				answer++;
			}
		}
		return answer;
	}
}
