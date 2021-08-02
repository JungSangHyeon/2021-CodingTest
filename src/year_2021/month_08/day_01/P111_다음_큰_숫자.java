package year_2021.month_08.day_01;

public class P111_다음_큰_숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));
	}

	public static int solution(int n) {
		int targetOneCount = getOneCountOfBinary(n);
        int next = n+1;
        while(getOneCountOfBinary(next) != targetOneCount) next++;
        return next;
    }
	
	public static int getOneCountOfBinary(int n) {
		String binaryN = Integer.toBinaryString(n);
		int oneCount = 0;
		for(char c : binaryN.toCharArray()) {
			if(c=='1') oneCount++;
		}
		return oneCount;
	}
}
