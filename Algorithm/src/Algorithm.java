import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		int tail = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.charAt(0) == 'p'  && str.charAt(1) == 'u') {
				String[] st = str.split(" ");
				queue.add(Integer.parseInt(st[1]));
				tail = Integer.parseInt(st[1]);
			} else if(str.charAt(0) == 'p') {
				if(queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.poll() + "\n");
				}
			
			} else if(str.charAt(0) == 's') {
				sb.append(queue.size() + "\n");
				
			} else if(str.charAt(0) == 'e') {
				if(queue.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if(str.charAt(0) == 'f') {
				if(queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.peek() + "\n");
				}
				
			} else {
				if(queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(tail + "\n");
				}
			}
			
		}
		
		System.out.println(sb);
	}
	
	
} 
