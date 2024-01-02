import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Double> gradeMapper = new HashMap<>();

    static {
        gradeMapper.put("A+", 4.5);
        gradeMapper.put("A0", 4.0);
        gradeMapper.put("B+", 3.5);
        gradeMapper.put("B0", 3.0);
        gradeMapper.put("C+", 2.5);
        gradeMapper.put("C0", 2.0);
        gradeMapper.put("D+", 1.5);
        gradeMapper.put("D0", 1.0);
        gradeMapper.put("F", 0.0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0.0;
        double totalCredit = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            sum += credit * gradeMapper.get(grade);
            totalCredit += credit;
        }

        double answer = sum / totalCredit;

        System.out.println(answer);

    }
}