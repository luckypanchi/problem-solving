import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String inputString = br.readLine();
        boolean flag = false;
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if(c == '<' || c == '>' || flag || c == ' ') {
                if(c == '<' || c == '>') flag = !flag;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

    }
}
