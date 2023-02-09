import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int s, p;
	static String input;
	static Map<Character, Integer> map;
	static int[] counter;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		input = br.readLine();

		map = new HashMap<>();
		String dnas = "ACGT";
		for (int i = 0; i < 4; i++) {
			char dna = dnas.charAt(i);
			map.put(dna, i);
		}

		counter = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			counter[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		int nextIdx = p;
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < p; i++) {
			Character c = input.charAt(i);
			int idx = map.get(c);
			que.add(idx);
			counter[idx]--;
		}
		check();

		while (nextIdx < s) {
			counter[que.poll()]++;
			Character c = input.charAt(nextIdx);
			int idx = map.get(c);
			que.add(idx);
			counter[idx]--;

			check();
			nextIdx++;
		}

		System.out.println(answer);
	}

	private static void check() {
		for (int cnt : counter) {
			if (cnt > 0) {
				return;
			}
		}
		answer += 1;
	}
}