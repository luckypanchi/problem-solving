import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, answer;
    static boolean[] columnCheck, daegakCheck1, daegakCheck2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        columnCheck = new boolean[n];
        daegakCheck1 = new boolean[2 * n + 1];
        daegakCheck2 = new boolean[2 * n + 1];

        answer = 0;

        solve(0);

        System.out.println(answer);

    }

    private static void solve(int y) {
        if (y == n) {
            answer++;
            return;
        }

        for (int x = 0; x < n; x++) {
            if (check(y, x)) {
                mark(y, x, true);
                solve(y + 1);
                mark(y, x, false);
            }
        }
    }

    private static boolean check(int y, int x) {
        if (columnCheck[x] || daegakCheck1[x + y] || daegakCheck2[n + x - y]) {
            return false;
        }
        return true;
    }

    private static void mark(int y, int x, boolean tf) {
        columnCheck[x] = tf;
        daegakCheck1[x + y] = tf;
        daegakCheck2[n + x - y] = tf;
    }
}