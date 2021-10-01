package year_2021.month_10;

public class P181_위클리_8주차 {

    public int solution(int[][] sizes) {
        int bigMax = 0, smallMax = 0;
        for(int[] size : sizes){
            int big = Math.max(size[0], size[1]);
            if(bigMax < big) bigMax = big;

            int small = Math.min(size[0], size[1]);
            if(smallMax < small) smallMax = small;
        }
        return bigMax*smallMax;
    }

}
