import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = Math.min(n / 2, m);

        n -= 2 * answer;
        m -= answer;

        k -= n + m;
        while (k > 0) {
            k -= 3;
            answer -= 1;
        }

        System.out.println(answer);

    }
}