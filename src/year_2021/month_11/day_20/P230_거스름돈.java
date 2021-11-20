package year_2021.month_11.day_20;

public class P230_°Å½º¸§µ· {

    public static void main(String[] args){
        System.out.println(new P230_°Å½º¸§µ·().solution(4));
    }

    private int[] memory;

    public int solution(int n) {
        this.memory = new int[n+1];
        this.memory[0] = 1;
        this.memory[1] = 1;
        for(int i=2; i<n; i++) dfs(i);
        return dfs(n);
    }

    private int dfs(int n) {
        if(n<0) return 0;
        if(this.memory[n]==0) this.memory[n] = dfs(n-1) + dfs(n-2);
        return this.memory[n] % 1_000_000_007;
    }

}
