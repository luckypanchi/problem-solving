import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new ArrayDeque<>();

		for (int i = 1; i < n + 1; i++) {
			que.add(i);
		}

		int num = 0;
		while (true) {
			num = que.poll();
			if (que.isEmpty()) {
				break;
			} else {
				que.add(que.poll());
			}
		}

		System.out.println(num);
	}

}