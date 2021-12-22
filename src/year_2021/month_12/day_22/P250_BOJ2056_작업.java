package year_2021.month_12.day_22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P250_BOJ2056_ÀÛ¾÷ {

    public static void main(String[] args) throws Exception {
        // Read Value
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        // Create Node
        Node[] nodes = new Node[nodeCount];
        for(int i=0; i<nodeCount; i++) {
            nodes[i] = new Node();
        }

        // Create Graph
        for(int i=0; i<nodeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i].completeTime = Integer.parseInt(st.nextToken());
            int beforeCount = Integer.parseInt(st.nextToken());
            for(int j=0; j<beforeCount; j++){
                int beforeId = Integer.parseInt(st.nextToken())-1;
                nodes[beforeId].after.add(nodes[i]);
                nodes[i].before.add(nodes[beforeId]);
            }
        }

        // Sort
        Queue<Node> queue = new LinkedList<>();
        for(Node node : nodes){
            if(node.before.size()==0) queue.add(node);
        }
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(Node after : node.after){
                after.before.remove(node);
                if(after.beforeMaxTime < node.completeTime){
                    after.beforeMaxTime=node.completeTime;
                }
                if(after.before.size()==0) {
                    after.completeTime+=after.beforeMaxTime;
                    queue.add(after);
                }
            }
        }

        // Print
        int max = 0;
        for(Node node : nodes){
            max = Math.max(max, node.completeTime);
        }
        System.out.print(max);
    }

    private static class Node {
        int completeTime, beforeMaxTime;
        ArrayList<Node> before = new ArrayList<>();
        ArrayList<Node> after = new ArrayList<>();
    }
}
