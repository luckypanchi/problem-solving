import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static double s, e, q;
  static HashMap<String, ArrayList<Double>> history = new HashMap<>();
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    s = Double.parseDouble(st.nextToken().replace(':', '.'));
    e = Double.parseDouble(st.nextToken().replace(':', '.'));
    q = Double.parseDouble(st.nextToken().replace(':', '.'));

    String input;
    while ((input = br.readLine()) != null) {
      st = new StringTokenizer(input);
      double time = Double.parseDouble(st.nextToken().replace(':', '.'));
      String name = st.nextToken();
      if (!history.containsKey(name)) {
        history.put(name, new ArrayList<>());
      }
      history.get(name).add(time);
    }

    for (String key : history.keySet()) {
      boolean flag1 = false;
      boolean flag2 = false;
      for (double time : history.get(key)) {
        if (0.0 < time && time <= s) {
          flag1 = true;
        }
        if (e <= time && time <= q) {
          flag2 = true;
        }
      }
      if (flag1 && flag2) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
