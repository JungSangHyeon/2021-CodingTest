package year_2021.month_06.day_17;

import java.util.Arrays;

public class P53_����_����_��_�����ϱ� {

	public static void main(String[] args) {

	}

	public int[] solution(int[] arr) {
		if(arr.length==1) return new int[] {-1};
		int minValue = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i->i!=minValue).toArray();
    }
	
}
