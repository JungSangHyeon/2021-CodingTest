package year_2021.month_06.day_05;

import java.util.ArrayList;
import java.util.TreeSet;

public class P40_�޴�_������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a = new A();
		a.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
	}

	// ���� ������ �̾Ƴ���. �ٸ� ������ ������ ���� ��.
	// course�� ���� 2 �̻�
	// menu = A~Z
	
	private static class A {
		private String[] orders;
		private int maxHaveCount =0;
		private ArrayList<String> answerOfThisNum = new ArrayList<>();
		private String nowCombination = "";
		private Character[] usingChars;
		
		public String[] solution(String[] orders, int[] course) {
			this.orders=orders;
			
			TreeSet<Character> chars = new TreeSet<>();
			for(String order : orders) {
				for(char c : order.toCharArray()) chars.add(c);
			}
			usingChars = chars.toArray(Character[]::new);
			
			TreeSet<String> answer = new TreeSet<>();
			for(int menuNum : course) {
				maxHaveCount =0;
				answerOfThisNum.clear();
				getCombination(menuNum, 0);
				if(maxHaveCount>=2) answer.addAll(answerOfThisNum);
			}
			System.out.println(answer.toString());
			return answer.toArray(String[]::new);
		}
		
		public void getCombination(int r, int index) { // nCr
			if(nowCombination.length()==r) { process(); return; }
			for(int i=index; i<usingChars.length; i++) {
				String temp = nowCombination;
				nowCombination+= usingChars[i];
				getCombination(r, i+1);
				nowCombination = temp;
			}
		}
		
		public void process() {
			int tempHaveCount = 0;
			char[] nowCombinationCharArray = nowCombination.toCharArray();
			for(String order : orders) {
				boolean havePattern = true;
				if(order.length()<nowCombination.length()) continue;
				for(char c : nowCombinationCharArray) {
					if(order.indexOf(c)==-1) havePattern=false;
				}
				if(havePattern)	tempHaveCount++;	
			}
			if(tempHaveCount>maxHaveCount) {
				answerOfThisNum.clear();
				answerOfThisNum.add(nowCombination);
				maxHaveCount=tempHaveCount;
			}else if(tempHaveCount==maxHaveCount) {
				answerOfThisNum.add(nowCombination);
			}
		}
	}
	
}
