package year_2021.month_07.day_09;

public class P76_����_������������_��ġ�ϱ� {

	public static void main(String[] args) {
		solution(10183720);
	}

	public static long solution(long n) {
		char[] chars = Long.toString(n).toCharArray();
		
		String resultString = "";
		for(int i=9; i>-1; i--) {
			for(int j=0; j<chars.length; j++) {
				if(chars[j]-'0'==i) {
					resultString+=i;
					chars[j]='X';
				}
			}
		}
		
		return Long.parseLong(resultString);
	}
}
