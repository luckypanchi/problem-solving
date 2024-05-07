import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;
    static int[][] members;
    static Member[][] roles;
    static boolean[] isRoleSelected, isMemberSelected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        members = new int[n][5];
        roles = new Member[5][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                members[i][j] = Integer.parseInt(st.nextToken());
                roles[j][i] = new Member(i, members[i][j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            Arrays.sort(roles[i]);
        }

        answer = -1;
        isRoleSelected = new boolean[5];
        isMemberSelected = new boolean[n];

        solve(0, 0);

        System.out.println(answer);

    }

    private static void solve(int curr, int prevPoint) {
        if (curr == 5) {
            answer = Math.max(answer, prevPoint);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!isRoleSelected[i]) {
                isRoleSelected[i] = true;
                for (int j = 0; j < n; j++) {
                    Member member = roles[i][j];
                    if (!isMemberSelected[member.index]) {
                        isMemberSelected[member.index] = true;
                        solve(curr + 1, prevPoint + member.point);
                        isMemberSelected[member.index] = false;
                        break;
                    }
                }
                isRoleSelected[i] = false;
            }
        }
    }

    private static class Member implements Comparable<Member> {

        public int index;
        public int point;

        public Member(int index, int point) {
            this.index = index;
            this.point = point;
        }

        @Override
        public int compareTo(Member o) {
            return o.point - this.point;
        }
    }
}