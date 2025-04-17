import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(find(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }

    public static String find(String input) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '(') {
                stack.push(input.charAt(j));
                continue;
            }
            if (stack.isEmpty()) {
                return "NO";
            }
            stack.pop();
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
