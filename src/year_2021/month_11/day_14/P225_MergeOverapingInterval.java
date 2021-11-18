package year_2021.month_11.day_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P225_MergeOverapingInterval {

    public static void main(String[] args){
        for(int[] arr  : new P225_MergeOverapingInterval().merge(new int[][]{{1,4},{4,5}})){
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastElement = temp.get(temp.size()-1);
            if (isOverlapping(lastElement, intervals[i])) lastElement[1] = Math.max(lastElement[1], intervals[i][1]);
            else temp.add(intervals[i]);
        }

        int[][] answer = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) answer[i] = temp.get(i);
        return answer;
    }

    private boolean isOverlapping(int[] intervalFirst, int[] intervalSecond) {
        return intervalFirst[1] >= intervalSecond[0];
    }
}
