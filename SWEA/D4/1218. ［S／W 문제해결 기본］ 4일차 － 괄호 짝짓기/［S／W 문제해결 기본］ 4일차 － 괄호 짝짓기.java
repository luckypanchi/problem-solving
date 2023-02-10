import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;

		for (int tc = 1; tc < 11; tc++) {
			sb.append("#").append(tc).append(" ");

			int len = Integer.parseInt(br.readLine());
			String input = br.readLine();
			stack = new Stack<>();

			for (int i = 0; i < len; i++) {
				char c = input.charAt(i);
				if (stack.isEmpty()) {
					stack.push(c);
					continue;
				}

				char last = stack.peek();
				if ((c == ')' && last == '(') || (c == ']' && last == '[') || (c == '}' && last == '{') || (c == '>' && last == '<')) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			if (stack.isEmpty()) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

}