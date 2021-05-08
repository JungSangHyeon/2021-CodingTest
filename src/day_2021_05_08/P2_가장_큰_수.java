package day_2021_05_08;

import java.util.Arrays; 
import java.util.Comparator;

public class P2_����_ū_�� {

	/**
	 * 
	 * ��� ��Ⱥ��� ����Ǿ��� ª��! ��� ����!
	 * 
	 * ��� ��
	 * 
	 *  1. �� ���ڿ� 0000�� 0���� �ٲ�� �Ǵ°� ��¥ ������.
	 *  2. Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new); // �迭 ��ȯ �� ���� �� ����� ��ȭ��Ű�µ� �� �� ���� �� ����
	 *  3. Arrays.sort(numberStrings, (String s1, String s2) -> {
			return (Integer.parseInt(s1 + s2) == Integer.parseInt(s2 + s1)) ? 0 : (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) ? -1 : 1;
		});
		sort�� �� Comparator ���� ����� ��. ������ ���δ�.
		4. ���� ��� ����, Integer.compare�� ���� �� Comparator�� �� ���� �� �ְڴ�. �ڵ����� 0, -1, 1�� �з����ش�. �غ��� �̻ڳ�!
	 */
	
	public static String solution2(int[] numbers) {
		String[] numberStrings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(numberStrings, (String s1, String s2) -> {return -Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));});
		String result = Arrays.toString(numberStrings).replace(",", "").replace(" ", "").replace("[", "").replace("]", ""); 
		return (result.charAt(0)=='0')? "0":result;
    }
	
	public static String solution(int[] numbers) {
		String[] numberStrings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(numberStrings, (String s1, String s2) -> {
			return (Integer.parseInt(s1 + s2) == Integer.parseInt(s2 + s1)) ? 0 : (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) ? -1 : 1;
		});
		String result = Arrays.toString(numberStrings).replace(",", "").replace(" ", "").replace("[", "").replace("]", ""); 
		return (result.replace("0", "").length()==0)? "0":result;
    }
	
	public static void main(String[] args) {
		int[] numbers = new int[] {0, 6, 10, 2, 330, 101, 32, 0, 70, 1000, 1, 10, 200, 0};
		numbers = new int[1001];
		for(int i=0; i<1001; i++) {
			numbers[i]=i;
		}
		
		System.out.println(solution(numbers));
	}
	
	// ���� ����� ����
//	private class a implements Comparator<String>{
//		@Override
//		public int compare(String s1, String s2) {
//			return (Integer.parseInt(s1+s2)>Integer.parseInt(s2+s1))? 1:-1;
//		}
//	}
}
