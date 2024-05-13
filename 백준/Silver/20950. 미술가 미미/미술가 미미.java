import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] colors;
    static int[] gomduri;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        colors = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gomduri = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gomduri[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 0, 0, 0);

        System.out.println(answer);

    }

    private static void solve(int curr, int count, int r, int g, int b) {
        if (count == 7 || curr == n) {
            if (count < 2) {
                return;
            }

            r /= count;
            g /= count;
            b /= count;

            answer = Math.min(answer, Math.abs(r - gomduri[0]) + Math.abs(g - gomduri[1]) + Math.abs(b - gomduri[2]));
            return;
        }

        solve(curr + 1, count + 1, r + colors[curr][0], g + colors[curr][1], b + colors[curr][2]);
        solve(curr + 1, count, r, g, b);
    }
}