package year_2021.month_08.day_13;

public class P131_이진_변환_반복하기 {

	public static void main(String[] args) {

	}
	
	public int[] solution(String s) {
		int processCount = 0, removedZeroCount = 0;
		while(!s.equals("1")) {
			processCount++;	
			removedZeroCount += getNumberOfChar(s, '0');
			s = Integer.toBinaryString(getNumberOfChar(s, '1'));
		}
        return new int[] {processCount, removedZeroCount};
    }

	private int getNumberOfChar(String s, char c) {
		int numberOfChar = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) numberOfChar++;
		}
		return numberOfChar;
	}
	
}
