package year_2021.month_08.day_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P138_BOJ1904_01≈∏¿œ {

    private static int[] memory;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = Integer.parseInt(br.readLine());
        memory = new int[maxLength+1];
        memory[0] = 1;
        memory[1] = 1;
        System.out.println(getPossibleBinary(maxLength));
    }

    private static int getPossibleBinary(int maxLength){
        if(maxLength<0) return 0;
        else {
            if(memory[maxLength]==0){
                memory[maxLength] = (getPossibleBinary(maxLength-1) + getPossibleBinary(maxLength-2))%15746;
            }
            return memory[maxLength];
        }
    }
}
