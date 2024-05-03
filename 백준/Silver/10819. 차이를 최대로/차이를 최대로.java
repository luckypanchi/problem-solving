import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static boolean[] isSelected;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        isSelected = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            isSelected[i] = true;
            solve(1, array[i], 0);
            isSelected[i] = false;
        }

        System.out.println(answer);

    }

    private static void solve(int curr, int prev, int sum) {
        if (curr == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                solve(curr + 1, array[i], sum + Math.abs(prev - array[i]));
                isSelected[i] = false;
            }
        }
    }
}