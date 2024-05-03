import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static int[] array;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        solve(0, 0);

        if (s == 0) {
            answer--;
        }

        System.out.println(answer);

    }

    private static void solve(int curr, int prev) {
        if (curr == n) {
            if (prev == s) {
                answer++;
            }
            return;
        }

        solve(curr + 1, prev + array[curr]);
        solve(curr + 1, prev);
    }
}