package year_2021.month_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P151_BOJ2156_������_�ý� {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] podojuice = new int[n+1];
        for(int i=1; i<n+1; i++) podojuice[i] = Integer.parseInt(br.readLine());

        int[] memory = new int[n+1];
        memory[1] = podojuice[1];
        if(n>1) memory[2] = podojuice[1] + podojuice[2];
        for(int i=3; i<=n; i++){
            memory[i] = Math.max(memory[i-2], memory[i-3] + podojuice[i-1] ) + podojuice[i];
            memory[i] = Math.max(memory[i-1], memory[i]);
        }

        System.out.println(memory[n]);
    }

}
