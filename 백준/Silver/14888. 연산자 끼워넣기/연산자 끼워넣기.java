import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;
    static int[] operators;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);

    }

    private static void solve(int curr, int prev) {
        if (curr == n) {
            min = Math.min(min, prev);
            max = Math.max(max, prev);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        solve(curr + 1, prev + numbers[curr]);
                        break;
                    case 1:
                        solve(curr + 1, prev - numbers[curr]);
                        break;
                    case 2:
                        solve(curr + 1, prev * numbers[curr]);
                        break;
                    case 3:
                        solve(curr + 1, prev / numbers[curr]);
                        break;
                    default:
                        break;
                }
                operators[i]++;
            }
        }
    }
}