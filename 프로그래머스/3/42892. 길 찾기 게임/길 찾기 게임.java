import java.util.*;


class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nodeinfo[i][1], nodeinfo[i][0], i + 1));
        }
        
        Collections.sort(pairs);
        
        Node root = new Node(pairs.get(0).nodeNumber, pairs.get(0).x);
        for (int i = 1; i < n; i++) {
            root.addNewNode(pairs.get(i).nodeNumber, pairs.get(i).x);
        }
       
        int[][] answer = new int[2][n];
        
        List<Integer> preorderResult = root.preorder();
        List<Integer> postorderResult = root.postorder();
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorderResult.get(i);
            answer[1][i] = postorderResult.get(i);
        }
        
        return answer;
    }
    
    private class Pair implements Comparable<Pair> {
        int y, x, nodeNumber;
        
        public Pair(int y, int x, int nodeNumber) {
            this.y = y; 
            this.x = x;
            this.nodeNumber = nodeNumber;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return o.y - this.y;
        }
    }
    
    private class Node {
        int nodeNumber, x;
        Node left;
        Node right;
        
        public Node(int nodeNumber, int x) {
            this.nodeNumber = nodeNumber;
            this.x = x;
        }
       
        void addNewNode(int nodeNumber, int x) {
            if (this.x < x) {
                if (this.right == null) {
                	this.right = new Node(nodeNumber, x);
                } else {
                    this.right.addNewNode(nodeNumber, x);
                }
            } else {
                if (this.left == null) {
                    this.left = new Node(nodeNumber, x);
                } else {
            		this.left.addNewNode(nodeNumber, x);
                }
            }
        }
        
        List<Integer> preorder() {
            List<Integer> list = new ArrayList<>();
            list.add(this.nodeNumber);
            if (left != null) {
               list.addAll(left.preorder());
            }
            if (right != null) {
                list.addAll(right.preorder());
            }
            return list;
        }
        
        List<Integer> postorder() {
            List<Integer> list = new ArrayList<>();
            if (left != null) {
                list.addAll(left.postorder());
            }
            if (right != null) {
                list.addAll(right.postorder());
            }
            list.add(this.nodeNumber);
            return list;
        }
    }
}