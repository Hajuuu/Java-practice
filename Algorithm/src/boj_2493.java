import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Top> stack1 = new ArrayDeque<>();
		Deque<Top> stack2 = new ArrayDeque<>();
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			stack1.push(new Top(i, Integer.parseInt(st.nextToken())));
		}
		
		while(!stack1.isEmpty()) {
			Top next = stack1.pop();
			while(!stack2.isEmpty()) {
				Top now = stack2.pop();
				if(now.height < next.height) {
					answer[now.num] = next.num + 1;
				} else {
					stack2.push(new Top(now.num, now.height));
					break;
				}
			}
			stack2.push(new Top(next.num, next.height));
		}
		
		for(int i : answer) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}

}

class Top {
	int num;
	int height;
	
	Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}