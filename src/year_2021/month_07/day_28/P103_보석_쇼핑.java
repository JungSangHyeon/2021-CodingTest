package year_2021.month_07.day_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P103_보석_쇼핑 {

	public static void main(String[] args) {
		String[][] test = {
				{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
				{"AA", "AB", "AC", "AA", "AC"},
				{"XYZ", "XYZ", "XYZ"},
				{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
		};
		
		for(String[] testcase : test) {
			System.out.println(Arrays.toString(solution2(testcase)));
		}
	}

	public static int[] solution2(String[] gems) {
		ArrayList<String> kindOfGems = new ArrayList<>();
		
		for(int i=0; i<gems.length; i++) {
			if(!kindOfGems.contains(gems[i])) {
				kindOfGems.add(gems[i]);
			}
		}
		
		HashSet<String> testSet = new HashSet<>();
		int beforeStartIndex = -1;
		int minLength = Integer.MAX_VALUE, lowIndex = 0, highIndex = 0;

		for(int i=0; i<gems.length; i++) {
			testSet.add(gems[i]);
			if(testSet.size()==kindOfGems.size()) { // all kind of gem added
				testSet.clear();
				for(int j=i; j>beforeStartIndex; j--) {
					testSet.add(gems[j]);
					if(testSet.size()==kindOfGems.size()) {
						if(minLength>i-j) {
							minLength = i-j;
							lowIndex = j;
							highIndex = i;
						}
						i = beforeStartIndex = j;
					}
				}
				// testSet.clear(); // 이거 빼먹었는데 운 좋게 돌아가네
			}
		}
		
		return new int[] {lowIndex+1, highIndex+1};
	}

}
