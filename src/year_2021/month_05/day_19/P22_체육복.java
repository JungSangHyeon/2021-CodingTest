package year_2021.month_05.day_19;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P22_ü���� {

	/**
	 * �� �� ��Ǭ �� ����.
	 * �׸��� ���� ÷ Ǯ� �׷���? ������ Ǯ��鼭 ����.
	 * ��� ����� �� �� ���� ������ Ǯ��������? ����?
	 */
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2,4}, new int[] {1,3,5}));
//		System.out.println(solution(5, new int[] {2,4}, new int[] {3}));
//		System.out.println(solution(3, new int[] {3}, new int[] {1}));
	}

	/**
	 * @param n ��ü �л��� �� (2~30)
	 * @param lost ü���� ���ϸ��� �л� ��ȣ (1~n)
	 * @param reserve ü���� ������ �ִ�(2����) �л� ��ȣ. ��׵� ���ϸ��� �� �ִ�.
	 * @return ü�� ������ ���� �� �ִ� �л��� �ִ�
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
//			System.out.println(reserve.length+"�� ���� ���ư���");
//			printStudents();
//			return students.stream().filter(s->s.clothCount!=0).toArray().length;
//		} 
//		int meIndex = reserve[nowIndex]-1;
//		int meIndexForPrint = reserve[nowIndex];
//		System.out.println("���� "+meIndexForPrint+" ����");
//		printStudents();
//		int caseGiveFront=0, caseGiveBack=0, caseDontGive=0;
//		if(students.get(meIndex).clothCount>1 && meIndex-1>=0 && students.get(meIndex-1).clothCount==0) {
//			System.out.println(meIndexForPrint+": ��ģ�� �ٰԿ�");
//			students.get(meIndex-1).clothCount++;
//			caseGiveFront = check2(reserve, nowIndex+1);
//			students.get(meIndex-1).clothCount--;
//			System.out.println(meIndexForPrint+": ��ģ�� �� ���->"+caseGiveFront);
//		} 
//		if(students.get(meIndex).clothCount>1 && meIndex+1<students.size() && students.get(meIndex+1).clothCount==0) {
//			System.out.println(meIndexForPrint+": ��ģ�� �ٰԿ�");
//			students.get(meIndex+1).clothCount++;
//			caseGiveBack = check2(reserve, nowIndex+1);
//			students.get(meIndex+1).clothCount--;
//			System.out.println(meIndexForPrint+": ��ģ�� �� ���->"+caseGiveBack);
//		}
//		if(!(meIndex-1>=0 && students.get(meIndex-1).clothCount==0) && !(meIndex+1<students.size() && students.get(meIndex+1).clothCount==0)) {
//			System.out.println(meIndexForPrint+": ���ٰԿ�");
//			caseDontGive = check2(reserve, nowIndex+1);
//			System.out.println(meIndexForPrint+": �� �� ���->"+caseDontGive);
//		}
//		System.out.println();
//		return Collections.max(Arrays.asList(caseGiveFront, caseGiveBack, caseDontGive));
//	}
}
