import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

	static int l, c;
	static char[] letters;
	static char[] selected;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		letters = new char[c];
		selected = new char[l];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(letters);

		choose(0, 0);

		System.out.println(sb);
	}

	private static void choose(int cnt, int start) {
		if (cnt == l) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (char s : selected) {
				if (vowels.contains(s)) {
					cnt1++;
				} else {
					cnt2++;
				}
			}

			if (1 <= cnt1 && 2 <= cnt2) {
				sb.append(new String(selected)).append("\n");
			}
			return;

		}

		for (int i = start; i < c; i++) {
			selected[cnt] = letters[i];
			choose(cnt + 1, i + 1);
		}
	}

}