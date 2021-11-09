package year_2021.month_11.day_05;

import java.util.*;

class P216_n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[][] array = new int[n][n];
        for(int i=n; i>=0; i--){
            for(int j=0; j<i; j++){
                for(int k=0; k<i; k++){
                    array[j][k] = i;
                }
            }
        }

        ArrayList<Integer> array2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(left<=n*i + j && n*i + j<=right){
                    array2.add(array[j][i]);
                }
            }
        }

        return array2.stream().mapToInt(i->i).toArray();
    }
}