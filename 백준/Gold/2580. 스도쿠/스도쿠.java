import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];
    static boolean[][] rowCheck = new boolean[9][10];
    static boolean[][] columnCheck = new boolean[9][10];
    static boolean[][] squareCheck = new boolean[9][10];
    static List<Node> blanks;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        blanks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0) {
                    blanks.add(new Node(i, j));
                } else {
                    rowCheck[j][board[i][j]] = true;
                    columnCheck[i][board[i][j]] = true;
                    squareCheck[3 * (i / 3) + j / 3][board[i][j]] = true;
                }
            }
        }

        solve(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static boolean solve(int curr) {
        if (curr == blanks.size()) {
            return true;
        }

        Node node = blanks.get(curr);
        List<Integer> candidates = new ArrayList<>();
        int[] numberCounts = new int[10];

        int squareIndex = 3 * (node.y / 3) + node.x / 3;
        for (int i = 1; i < 10; i++) {
            if (!rowCheck[node.x][i]) {
                numberCounts[i]++;
            }
            if (!columnCheck[node.y][i]) {
                numberCounts[i]++;
            }
            if (!squareCheck[squareIndex][i]) {
                numberCounts[i]++;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (numberCounts[i] == 3) {
                candidates.add(i);
            }
        }

        for (int number : candidates) {
            rowCheck[node.x][number] = true;
            columnCheck[node.y][number] = true;
            squareCheck[squareIndex][number] = true;

            board[node.y][node.x] = number;
            if (solve(curr + 1)) {
                return true;
            }
            board[node.y][node.x] = 0;

            rowCheck[node.x][number] = false;
            columnCheck[node.y][number] = false;
            squareCheck[squareIndex][number] = false;
        }

        return false;
    }

    private static class Node {

        public int y;
        public int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}