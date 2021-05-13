package year_2021.month_05.day_11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class P14_로또의_최고_순위와_최저_순위 {

	/**
	 * array, list, set, map 이 뭔지 한번 봐야겠다.
	 * stream이 뭔지 공부해 봐야겠다.
	 * return LongStream.of( // 이게 뭘까. ~Stream은 배열 만드는 도구? 같은데.
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 })));
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		List<Integer> lottoNumList = Arrays.asList(Arrays.stream(lottos).mapToObj(Integer::valueOf).toArray(Integer[]::new));
		
		int zeroCount = Arrays.stream(lottos).filter(i->i==0).toArray().length, matchCount = 0;
		for(int winNum : win_nums) {
			if(lottoNumList.contains(winNum)) matchCount++;
		}
		
		int maxRank = Math.min(6, Math.abs(7 - (zeroCount+matchCount)));
		int minRank = Math.min(6, Math.abs(7 - matchCount));
		
		return new int[] {maxRank, minRank};
	}
	
	public static int[] solution2(int[] lottos, int[] win_nums) {
		return LongStream.of( // 이게 뭘까
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
	}

}
