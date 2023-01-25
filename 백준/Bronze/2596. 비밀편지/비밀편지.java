import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
    static String[] codes = {
            "000000",
            "001111",
            "010011",
            "011100",
            "100110",
            "101001",
            "110101",
            "111010"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = "";
            for (int j = 0; j < 6; j++) {
                stringArray[i] += str.charAt(6 * i + j);    
            }
        }

        String answer = "";

        for (int i = 0; i < n; i++) {
            char result = getChar(stringArray[i]);
            if (result == 'z') {
                System.out.println(i + 1);
                System.exit(0);
            }
            answer += result;
        }

        System.out.println(answer);

    }

    static char getChar(String input) {
        char result = 'z';
        for (int i = 0; i < 8; i++) {
            int cnt = 0;
            for (int j = 0; j < 6; j++) {
                if(codes[i].charAt(j) == input.charAt(j)) cnt ++;
            }
            if (cnt == 6) return chars[i];
            if (cnt == 5) result = chars[i];
        }
        return result;
    }
}