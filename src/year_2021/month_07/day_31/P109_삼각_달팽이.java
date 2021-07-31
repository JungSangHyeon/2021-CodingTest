package year_2021.month_07.day_31;

import java.util.Arrays;
import java.util.stream.Stream;

public class P109_ªÔ∞¢_¥ﬁ∆ÿ¿Ã {

	public static void main(String[] args) {
		solution(5);
	}
	
	public static int[] solution(int n) {
		MyArray[] triangleSnail = new MyArray[n];
		for(int i=0; i<n; i++) triangleSnail[i] = new MyArray(i+1);
		
		int totalIndex = (1+n)*n/2;
		int first = 0, last = n-1;
		for(int i=1; i<=totalIndex;) {
			for(int j=first; j<last; j++) triangleSnail[j].addToFirst(i++);
			first++;
			while(! triangleSnail[last].isFullFilled()) triangleSnail[last].addToFirst(i++);
			last--;
			for(int j=last; j>=first; j--) triangleSnail[j].addToLast(i++);
			first++;
		}
		
        Integer[] answer = {};
        for(MyArray myArray : triangleSnail) {
        	answer = Stream.of(answer, myArray.array).flatMap(Stream::of).toArray(Integer[]::new);
        }
        return Arrays.stream(answer).mapToInt(i -> i).toArray();
    }

	private static class MyArray {
		Integer[] array;
		int nowFilled, first, last;

		public MyArray(int length) {
			array = new Integer[length];
			last = length-1;
		}
		public void addToFirst(int i) {
			array[first] = i;
			nowFilled++;
			first++;
		}
		public void addToLast(int i) {
			array[last] = i;
			nowFilled++;
			last--;
		}
		public boolean isFullFilled() {
			return array.length == nowFilled;
		}
	}
}
