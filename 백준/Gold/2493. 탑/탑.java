import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				answer[i] = stack.peek() + 1;
			}
			stack.push(i);

		}

		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);

	}

}