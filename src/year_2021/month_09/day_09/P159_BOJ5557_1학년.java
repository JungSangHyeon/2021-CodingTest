package year_2021.month_09.day_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P159_BOJ5557_1ÇÐ³â {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n-1];
        for(int i=0; i<n-1; i++) numbers[i] = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long[][] memory = new long[21][n-1];
        memory[numbers[0]][0] = 1;
        for(int i=1; i<n-1; i++){
            int nowNum = numbers[i];
            for(int j=0; j<21; j++){
                long sum = 0;
                if(j+nowNum<=20) sum+=memory[j+nowNum][i-1];
                if(0<=j-nowNum) sum+=memory[j-nowNum][i-1];
                memory[j][i] = sum;
            }
        }
        System.out.println(memory[target][n-1-1]);

//        for(int[] arr : memory){
//            System.out.println(Arrays.toString(arr));
//        }
    }
}
