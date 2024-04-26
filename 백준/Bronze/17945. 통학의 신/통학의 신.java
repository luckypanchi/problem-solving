import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int mid = -a;
        int diff = 0;

        while (true) {
            int x1 = -a - diff;
            int x2 = -a + diff;
            if (f(x1) == 0 && f(x2) == 0) {
                if (x1 == x2) {
                    sb.append(x1);
                } else {
                    sb.append(x1).append(" ").append(x2);
                }
                break;
            }
            diff++;
        }

        System.out.println(sb);

    }

    private static int f(int x) {
        return x * x + 2 * a * x + b;
    }
}