package year_2021.month_10.day_08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P188_위클리9주차 {

    public int solution(int n, int[][] wires) {
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++) nodes[i] = new Node(i);

        for(int[] wire : wires) {
            int nodeAIndex = wire[0] - 1, nodeBIndex = wire[1] - 1;
            nodes[nodeAIndex].childNodes.add(nodes[nodeBIndex]);
            nodes[nodeBIndex].childNodes.add(nodes[nodeAIndex]);
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(nodes[0]);
        while(!nodeQueue.isEmpty()){
            Node pollNode = nodeQueue.poll();
            for(Node child : pollNode.childNodes){
                child.childNodes.remove(pollNode);
                nodeQueue.add(child);
            }
        }

        nodes[0].getTreeSize();

        int minDiff = Integer.MAX_VALUE;
        nodeQueue = new LinkedList<>();
        nodeQueue.add(nodes[0]);
        while(!nodeQueue.isEmpty()){
            Node pollNode = nodeQueue.poll();
            for(Node child : pollNode.childNodes){
                int groupA = nodes.length - child.treeSize;
                int groupB = child.treeSize;
                int diff = Math.abs(groupA - groupB);
                if(minDiff > diff) minDiff = diff;
                nodeQueue.add(child);
            }
        }

        return minDiff;
    }

    private static class Node {
        int index, treeSize;
        ArrayList<Node> childNodes = new ArrayList<>();
        public Node (int index){ this.index=index; }

        public int getTreeSize(){
            this.treeSize = 1; // self
            for(Node child : childNodes) treeSize += child.getTreeSize();
            return treeSize;
        }
    }
}
