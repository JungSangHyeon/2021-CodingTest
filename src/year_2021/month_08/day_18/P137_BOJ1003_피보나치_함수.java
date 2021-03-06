package year_2021.month_08.day_18;

import java.io.*;
import java.util.*;

public class P137_BOJ1003_피보나치_함수 {

    private static Map<Integer, int[]> memory = new HashMap<>();

    public static void main(String[] args) throws Exception {
        memory.put(0, new int[] {1, 0});
        memory.put(1, new int[] {0, 1});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        for(int i=0; i<testCaseCount; i++) {
            int testCase = Integer.parseInt(br.readLine());
            int[] result = check0And1Count(testCase);
            System.out.println(result[0]+" "+result[1]);
        }
    }

    private static int[] check0And1Count(int num){
        if( ! memory.containsKey(num)){
            int[] arr1 = check0And1Count(num-1);
            int[] arr2 = check0And1Count(num-2);
            memory.put(num, new int[]{arr1[0]+arr2[0], arr1[1]+arr2[1]});
        }
        return memory.get(num);
    }
}
