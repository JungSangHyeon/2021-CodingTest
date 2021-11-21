package year_2021.month_11.day_21;

import java.util.ArrayList;

public class P231_네트워크 {

    public int solution(int n, int[][] computers) {

        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++){
            nodes[i] = new Node();
        }

        for(int i=0; i<computers.length; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1){
                    nodes[i].connectedNodes.add(nodes[j]);
                }
            }
        }

        int count = 0;
        for(Node node : nodes){
            if(!node.checked){
                count++;
                node.checked=true;
                dfs(node);
            }
        }

        return count;
    }

    private void dfs(Node node) {
        for(Node n : node.connectedNodes){
            if(!n.checked){
                n.checked=true;
                dfs(n);
            }
        }
    }

    private class Node {
        ArrayList<Node> connectedNodes = new ArrayList<>();
        boolean checked = false;
    }


}
