import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		String str = "";
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		
		while(queue.size() > 1) {
			for(int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll());
			sb.append(", ");
			
		}
		sb.append(queue.poll());
		sb.append(">");
		
		System.out.println(sb);
	}
	
	
} 
