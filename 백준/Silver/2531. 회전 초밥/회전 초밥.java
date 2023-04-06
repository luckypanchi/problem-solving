import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.w3c.dom.ls.LSOutput;

public class Main {

	static int n, d, k, c;
	static int[] orders;
	static Map<Integer, Integer> selected;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		orders = new int[2 * n];
		for (int i = 0; i < n; i++) {
			orders[i] = Integer.parseInt(br.readLine());
			orders[n + i] = orders[i];
		}

		selected = new HashMap<>();
		selected.put(c, 1);
		for (int i = 0; i < k; i++) {
			int sushi = orders[i];
			if (!selected.containsKey(sushi)) {
				selected.put(sushi, 0);
			}
			selected.put(sushi, selected.get(sushi) + 1);
		}

		int left = 0;
		int right = k - 1;
		int answer = Integer.MIN_VALUE;

		while (left < n) {

			answer = Math.max(answer, selected.keySet().size());

			int removed = orders[left];
			selected.put(removed, selected.get(removed) - 1);
			if (selected.get(removed) == 0) {
				selected.remove(removed);
			}

			left ++;
			right ++;

			int target = orders[right];
			if (!selected.containsKey(target)) {
				selected.put(target, 0);
			}
			selected.put(target, selected.get(target) + 1);

		}

		System.out.println(answer);

	}

}