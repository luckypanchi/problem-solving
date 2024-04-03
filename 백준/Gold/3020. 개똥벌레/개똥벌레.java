import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, h;
    static int[] bottom, top;
    static int answer, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        bottom = new int[h + 1];
        top = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bottom[height] += 1;
            } else {
                top[height] += 1;
            }
        }

        for (int i = h; i > 1; i--) {
            bottom[i - 1] += bottom[i];
            top[i - 1] += top[i];
        }

        answer = Integer.MAX_VALUE;
        count = 0;
        for (int height = 1; height < h + 1; height++) {
            int breakCount = bottom[height] + top[h - height + 1];

            if (breakCount < answer) {
                answer = breakCount;
                count = 1;
            } else if (breakCount == answer) {
                count += 1;
            }
        }

        sb.append(answer).append(" ").append(count);
        System.out.println(sb);
    }
}