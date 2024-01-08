import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] count;
    static boolean[] visited;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        for (int i = 1; i < n + 1; i++) {
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i < n + 1; i++) {
            if (count[i] == max) {
                System.out.print(i + " ");
            }
        }

    }

    private static void bfs(int start) {
        que = new ArrayDeque<>();
        visited = new boolean[n + 1];

        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (Integer i : list[curr]) {
                if (!visited[i]) {
                    visited[i] = true;
                    que.add(i);
                    count[i]++;
                }
            }
        }
    }
}