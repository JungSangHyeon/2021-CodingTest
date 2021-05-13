package year_2021.month_05.day_09;

import java.util.Arrays; 
import java.util.Collections;

public class P5_H_Index {

	/**
	 * ���� ��� �ڵ�� ���� ����, �� ���� Ǯ� ���� Ȱ���Ͽ� Ǯ����.
	 * 
	 * ��� ��
	 * 1. ��ư� �������� �ʰ�, �׳� Ǯ���µ�, �� ȿ������ ����� ������ ���� �͵� ���ڴ�.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���: "+solution(new int[]{2}));

	}

	public static int solution2(int[] citations) {
		int result = 0;
		for(int h=0; h<1001; h++) {
			final int fh = h;
			int biggerThenHcount = Arrays.stream(citations).filter(j->j>=fh).toArray().length;
			if(h<=biggerThenHcount) {result = h;} else {break;}
		}
		return result;
    }
	
	public static int solution(int[] citations) { 
		Integer[] citationsCopy = Arrays.stream(citations).mapToObj(Integer::valueOf).toArray(Integer[]::new);
		Arrays.sort(citationsCopy, Collections.reverseOrder());
		System.out.println(Arrays.toString(citationsCopy));
		for(int i=0; i<citationsCopy.length; i++) {
			System.out.println("���� ��: "+citationsCopy[i]+", �� ���� �ؼ� �꺸�� �̻��� ���� ��: "+(i+1));
			if(i+1>=citationsCopy[i]) return citationsCopy[i];
		}
        return (citationsCopy[citationsCopy.length-1]>citationsCopy.length)? citationsCopy.length:0;
    }
}
