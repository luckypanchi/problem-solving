import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, L, R, X;
    static int[] array;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        solve(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        System.out.println(answer);

    }

    private static void solve(int index, int count, int min, int max, int sum) {
        if (index == n) {
            if (2 <= count && L <= sum && sum <= R && X <= max - min) {
                answer++;
            }
            return;
        }

        solve(index + 1, count + 1, Math.min(min, array[index]), Math.max(max, array[index]), sum + array[index]);
        solve(index + 1, count, min, max, sum);
    }
}