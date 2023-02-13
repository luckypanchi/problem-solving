import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[n];
		int cnt = 0;
		int check = 0;
		int idx = 0;
		while (cnt < n) {
			if (!visited[idx]) {
				check++;
				if (check == k) {
					visited[idx] = true;
					sb.append(idx + 1).append(", ");
					cnt += 1;
					check = 0;
				}
			}
			idx = (idx + 1) % n;
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}

}