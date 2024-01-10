import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int n, m, k;
    static int[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int answer = bfs();

        System.out.println(answer);


    }

    private static int bfs() {
        Queue<Node> que = new ArrayDeque<>();
        int[][][][] dist = new int[n][m][k + 1][2];

        que.add(new Node(0, 0, 0, 0));
        dist[0][0][0][0] = 1;

        if (checkArrival(0, 0)) {
            return 1;
        }

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (node.time == 1 && dist[node.y][node.x][node.count][1 - node.time] == 0) {
                dist[node.y][node.x][node.count][1 - node.time] = dist[node.y][node.x][node.count][node.time] + 1;
                que.add(new Node(node.y, node.x, node.count, 1 - node.time));
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (!check(ny, nx)) {
                    continue;
                }

                if (board[ny][nx] == 0 && dist[ny][nx][node.count][1 - node.time] == 0) {
                    dist[ny][nx][node.count][1 - node.time] = dist[node.y][node.x][node.count][node.time] + 1;
                    que.add(new Node(ny, nx, node.count, 1 - node.time));
                    if (checkArrival(ny, nx)) {
                        return dist[ny][nx][node.count][1 - node.time];
                    }
                } else if (board[ny][nx] == 1) {
                    if (node.time == 0 && node.count < k && dist[ny][nx][node.count + 1][1 - node.time] == 0) {
                        dist[ny][nx][node.count + 1][1 - node.time] = dist[node.y][node.x][node.count][node.time] + 1;
                        que.add(new Node(ny, nx, node.count + 1, 1 - node.time));
                        if (checkArrival(ny, nx)) {
                            return dist[ny][nx][node.count + 1][1 - node.time];
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static boolean check(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static boolean checkArrival(int y, int x) {
        return y == n - 1 && x == m - 1;
    }

    private static class Node {

        int y, x, count, time;

        public Node(int y, int x, int count, int time) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.time = time;
        }
    }
}