import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushrooms = new int[10];
        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int point = 0;
        for (int i = 0; i < 10; i++) {
            if (point + mushrooms[i] >= 100) {
                if (Math.abs(point + mushrooms[i] - 100) <= Math.abs(point - 100)) {
                    point += mushrooms[i];
                }
                break;
            }
            point += mushrooms[i];
        }

        System.out.println(point);
    }
}