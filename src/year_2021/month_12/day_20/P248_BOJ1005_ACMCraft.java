package year_2021.month_12.day_20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P248_BOJ1005_ACMCraft {

    public static void main(String[] args) throws Exception {
        // Read Value
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseCount = Integer.parseInt(br.readLine());
        for(int t=0; t<testcaseCount; t++){
            // Read Value
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int connectionCount = Integer.parseInt(st.nextToken());

            // Create Node
            st = new StringTokenizer(br.readLine());
            Node[] nodes = new Node[nodeCount];
            for(int i=0; i<nodeCount; i++) {
                int completeTime = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(i, completeTime);
            }

            // Create Graph
            for(int i=0; i<connectionCount; i++) {
                st = new StringTokenizer(br.readLine());
                int beforeId = Integer.parseInt(st.nextToken())-1;
                int afterId = Integer.parseInt(st.nextToken())-1;
                nodes[beforeId].after.add(nodes[afterId]);
                nodes[afterId].before.add(nodes[beforeId]);
            }

            // Read Value
            st = new StringTokenizer(br.readLine());
            int targetNodeId = Integer.parseInt(st.nextToken())-1;

            // Sort
            Queue<Node> queue = new LinkedList<>();
            for(Node node : nodes){
                if(node.before.size()==0) queue.add(node);
            }
            loop:while(!queue.isEmpty()){
                Node node = queue.poll();
                for(Node after : node.after){
                    after.before.remove(node);
                    if(after.beforeMaxTime < node.completeTime){
                        after.beforeMaxTime=node.completeTime;
                    }
                    if(after.before.size()==0) {
                        after.completeTime+=after.beforeMaxTime;
                        if(after.id == targetNodeId) break loop;
                        queue.add(after);
                    }
                }
            }

            // Print
            System.out.println(nodes[targetNodeId].completeTime);
        }
    }

    private static class Node {
        int id, completeTime, beforeMaxTime;
        ArrayList<Node> before = new ArrayList<>();
        ArrayList<Node> after = new ArrayList<>();

        public Node(int id, int completeTime) {
            this.id=id;
            this.completeTime=completeTime;
        }
    }
}
