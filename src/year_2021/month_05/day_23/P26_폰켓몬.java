package year_2021.month_05.day_23;

import java.util.HashSet;

public class P26_���ϸ� {

	/**
	 * �� �ϴٰ� ���Ƹ� �ð� �� �Ǽ�...
	 * �� ��ƶ�
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 3 }));
	}

	public static int solution(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) set.add(num);
		return Math.min(nums.length / 2, set.size());
	}
}
