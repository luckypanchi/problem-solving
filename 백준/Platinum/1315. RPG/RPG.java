import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] questList;
    static final int LIMIT = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        questList = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                questList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] leftPoint = new int[LIMIT][LIMIT];
        int[][] solvedCount = new int[LIMIT][LIMIT];
        boolean[][] isPossible = new boolean[LIMIT][LIMIT];

        for (int STR = 1; STR < LIMIT; STR++) {
            for (int INT = 1; INT < LIMIT; INT++) {

                int point = 2;
                for (int i = 0; i < n; i++) {
                    if (questList[i][0] <= STR || questList[i][1] <= INT) {
                        point += questList[i][2];
                        solvedCount[STR][INT]++;
                    }
                }

                leftPoint[STR][INT] = point - (STR + INT);

                if (STR == 1 && INT == 1) {
                    isPossible[1][1] = true;
                    continue;
                }

                if ((isPossible[STR - 1][INT] && leftPoint[STR - 1][INT] > 0)
                        || (isPossible[STR][INT - 1] && leftPoint[STR][INT - 1] > 0)) {
                    isPossible[STR][INT] = true;
                }
            }
        }

        int answer = 0;
        for (int STR = 1; STR < LIMIT; STR++) {
            for (int INT = 1; INT < LIMIT; INT++) {
                if (isPossible[STR][INT]) {
                    answer = Math.max(answer, solvedCount[STR][INT]);
                }
            }
        }

        System.out.println(answer);
    }

}