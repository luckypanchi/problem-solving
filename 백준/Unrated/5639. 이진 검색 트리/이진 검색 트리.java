import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            list.add(Integer.parseInt(input));
        }

        Node head = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            head.insert(list.get(i));
        }

        head.postOrder();

        System.out.println(sb);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }

        public void postOrder() {
            if (left != null) {
                left.postOrder();
            }
            if (right != null) {
                right.postOrder();
            }
            sb.append(value).append("\n");
        }

    }
}