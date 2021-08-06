package year_2021.month_08.day_06;

public class P123_2개_이하로_다른_비트 {

	// 10점 개꿀!
	
	public static void main(String[] args) {
		
		int max = 100;
		long[] arr = new long[max];
		for(int i=0; i<max; i++) arr[i]=i;
		
		solution(arr);
	}

	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		
		for(int i=0; i< numbers.length; i++) {
			long number = numbers[i];
			StringBuilder sb = new StringBuilder(Long.toBinaryString(number));
			
			int index = sb.lastIndexOf("0");
			if(index==-1) {
				sb.setCharAt(0, '0');
				sb.insert(0, '1');
			}else {
				sb.setCharAt(index, '1');
				if(index+1 < sb.length()) sb.setCharAt(index+1, '0');
			}
			answer[i] = Long.parseLong(sb.toString(), 2);
		}
		
		return answer;
	}
}
