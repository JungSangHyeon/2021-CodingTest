package year_2021.month_09.day_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P156_BOJ1309_µ¿¹°¿ø {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] memory = new int[n];
        memory[0] = 3;
        if(n>1) memory[1] = 7;

        for(int i=2; i<n; i++){
            memory[i] = (memory[i-1]*2 + memory[i-2])%9901;
        }
        System.out.println(memory[n-1]);
    }
}
