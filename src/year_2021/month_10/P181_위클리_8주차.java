package year_2021.month_10;

public class P181_��Ŭ��_8���� {

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
