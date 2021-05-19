package year_2021.month_05.day_19;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P22_체육복 {

	/**
	 * 음 잘 몬푼 것 같다.
	 * 그리디 문제 첨 풀어서 그런가? 앞으로 풀어가면서 보자.
	 * 모든 경우의 수 안 봐도 문제가 풀리나보네? 왜지?
	 */
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2,4}, new int[] {1,3,5}));
//		System.out.println(solution(5, new int[] {2,4}, new int[] {3}));
//		System.out.println(solution(3, new int[] {3}, new int[] {1}));
	}

	/**
	 * @param n 전체 학생의 수 (2~30)
	 * @param lost 체육복 도둑맞은 학생 번호 (1~n)
	 * @param reserve 체육복 여유분 있는(2개인) 학생 번호. 얘네도 도둑맞을 수 있다.
	 * @return 체육 수업을 들을 수 있는 학생의 최댓값
	 */
	public static ArrayList<Student> students;
	public static int solution(int n, int[] lost, int[] reserve) {
		ArrayList<Integer> lostArray = new ArrayList<>(Arrays.stream(lost).boxed().collect(Collectors.toList()));
		ArrayList<Integer> reserveArray = new ArrayList<>(Arrays.stream(reserve).boxed().collect(Collectors.toList()));
		students = new ArrayList<>(IntStream.range(0, n).mapToObj(i->new Student((lostArray.contains(i+1)? 0:1) + (reserveArray.contains(i+1)? 1:0))).collect(Collectors.toList()));
        return check(reserve, 0);
    }
	private static int check(int[] reserve, int nowIndex) {
		if(nowIndex==reserve.length)return students.stream().filter(s->s.clothCount!=0).toArray().length;
		int meIndex = reserve[nowIndex]-1, caseGiveFront=0, caseGiveBack=0, caseDontGive=0;
		boolean canGiveFront = students.get(meIndex).clothCount>1 && meIndex-1>=0 && students.get(meIndex-1).clothCount==0;
		boolean canGiveBack = students.get(meIndex).clothCount>1 && meIndex+1<students.size() && students.get(meIndex+1).clothCount==0;
		if(canGiveFront) {
			students.get(meIndex-1).clothCount++;
			caseGiveFront = check(reserve, nowIndex+1);
			students.get(meIndex-1).clothCount--;
		} 
		if(canGiveBack) {
			students.get(meIndex+1).clothCount++;
			caseGiveBack = check(reserve, nowIndex+1);
			students.get(meIndex+1).clothCount--;
		}
		if(!canGiveFront && !canGiveBack) {
			caseDontGive = check(reserve, nowIndex+1);
		}
		return Collections.max(Arrays.asList(caseGiveFront, caseGiveBack, caseDontGive));
	}
	
	private static class Student {
		public int clothCount;
		public Student(int clothCount) {this.clothCount=clothCount;}
	}
	
	// @@@@@@@@@@@@@
	
//	private static void printStudents() {
//		System.out.println("--------------------");
//		for(int i=0; i<students.size(); i++) {
//			System.out.println(i+", "+students.get(i).clothCount);
//		}
//		System.out.println("--------------------");
//	}
//	private static int check2(int[] reserve, int nowIndex) {
//		if(nowIndex==reserve.length) {
//			System.out.println(reserve.length+"와 같아 돌아가요");
//			printStudents();
//			return students.stream().filter(s->s.clothCount!=0).toArray().length;
//		} 
//		int meIndex = reserve[nowIndex]-1;
//		int meIndexForPrint = reserve[nowIndex];
//		System.out.println("나는 "+meIndexForPrint+" 에요");
//		printStudents();
//		int caseGiveFront=0, caseGiveBack=0, caseDontGive=0;
//		if(students.get(meIndex).clothCount>1 && meIndex-1>=0 && students.get(meIndex-1).clothCount==0) {
//			System.out.println(meIndexForPrint+": 앞친구 줄게연");
//			students.get(meIndex-1).clothCount++;
//			caseGiveFront = check2(reserve, nowIndex+1);
//			students.get(meIndex-1).clothCount--;
//			System.out.println(meIndexForPrint+": 앞친구 준 결과->"+caseGiveFront);
//		} 
//		if(students.get(meIndex).clothCount>1 && meIndex+1<students.size() && students.get(meIndex+1).clothCount==0) {
//			System.out.println(meIndexForPrint+": 뒤친구 줄게연");
//			students.get(meIndex+1).clothCount++;
//			caseGiveBack = check2(reserve, nowIndex+1);
//			students.get(meIndex+1).clothCount--;
//			System.out.println(meIndexForPrint+": 뒤친구 준 결과->"+caseGiveBack);
//		}
//		if(!(meIndex-1>=0 && students.get(meIndex-1).clothCount==0) && !(meIndex+1<students.size() && students.get(meIndex+1).clothCount==0)) {
//			System.out.println(meIndexForPrint+": 안줄게연");
//			caseDontGive = check2(reserve, nowIndex+1);
//			System.out.println(meIndexForPrint+": 안 준 결과->"+caseDontGive);
//		}
//		System.out.println();
//		return Collections.max(Arrays.asList(caseGiveFront, caseGiveBack, caseDontGive));
//	}
}
