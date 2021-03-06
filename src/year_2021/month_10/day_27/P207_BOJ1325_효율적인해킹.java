package year_2021.month_10.day_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P207_BOJ1325_효율적인해킹 {

    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] visited = new int[10001];
    static int[] ans = new int[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        ans = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        String[] inputs = new String[2];
        for (int i = 1; i <= M; i++) {
            input = br.readLine();
            inputs = input.split(" ");
            list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
        }
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            bfs(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = 1;
        while (queue.isEmpty() == false) {
            node = queue.remove();
            for (int next : list[node]) {
                if (visited[next] == 0) {
                    ans[next]++;
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}
