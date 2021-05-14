package year_2021.month_05.day_14;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P17_Ä«Æê {

	/**
	 * 	EZ ÇÏ±º
		public int[] solution(int brown, int red) {
	        int a = (brown+4)/2;
	        int b = red+2*a-4;
	        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
	        return answer;
	    } 
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
	}

	public static int[] solution(int brown, int yellow) {
        for(int yellowW=1; yellowW<=yellow; yellowW++) {
        	if(yellow%yellowW!=0||yellow/yellowW>yellowW) continue;
        	if((yellowW+2)*(yellow/yellowW+2)-yellow==brown) return IntStream.of(yellowW+2, yellow/yellowW+2).toArray();
        }
        return null;
    }
}
