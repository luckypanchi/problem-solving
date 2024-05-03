import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static String[] inequalityList;
    static boolean[] isSelected;
    static long min = Long.MAX_VALUE;
    static String minAnswer = "";
    static long max = Long.MIN_VALUE;
    static String maxAnswer = "";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        isSelected = new boolean[10];
        inequalityList = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            inequalityList[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            isSelected[i] = true;
            solve(1, String.valueOf(i));
            isSelected[i] = false;
        }

        System.out.println(maxAnswer);
        System.out.println(minAnswer);

    }

    private static void solve(int curr, String prev) {
        if (curr == k + 1) {
            long number = Long.parseLong(prev);
            if (max < number) {
                max = number;
                maxAnswer = prev;
            }
            if (number < min) {
                min = number;
                minAnswer = prev;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isSelected[i]) {
                continue;
            }

            int lastNumber = Integer.parseInt(prev.substring(curr - 1));

            if ((inequalityList[curr - 1].equals("<") && lastNumber < i)
                    || (inequalityList[curr - 1].equals(">") && lastNumber > i)) {
                isSelected[i] = true;
                solve(curr + 1, prev + i);
                isSelected[i] = false;
            }
        }
    }
}