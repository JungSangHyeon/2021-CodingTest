package year_2021.month_07.day_22;

import java.util.Arrays;

public class P96_쿼드압축_후_개수_세기 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } })));
	}

	public static int[] solution(int[][] arr) {
        return check(arr, 0, 0, arr.length);
    }

	private static int[] check(int[][] arr, int startX, int startY, int size) {
		int[] answer = new int[2];
		
		boolean needSlice = false;
		int representativeValue = arr[startX][startY]; // 0 || 1
		for(int x=startX; x<startX+size; x++) {
			for(int y=startY; y<startY+size; y++) {
				if (representativeValue != arr[x][y]) {
					needSlice = true;
					break;
				}
			}
		}
		
		if(!needSlice || size==1) {
			answer[representativeValue] = 1;
		}else {
			int[] area1 = check(arr, startX, startY, size/2);
			int[] area2 = check(arr, startX+size/2, startY, size/2);
			int[] area3 = check(arr, startX, startY+size/2, size/2);
			int[] area4 = check(arr, startX+size/2, startY+size/2, size/2);
			answer[0] = area1[0] + area2[0] + area3[0] + area4[0];
			answer[1] = area1[1] + area2[1] + area3[1] + area4[1];
		}
		
		return answer;
	}
}
