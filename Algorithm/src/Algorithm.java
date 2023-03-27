import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		while(true) {			
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				break;
			}
			int max = Math.max(a, b);
			int max1 = Math.max(max, c);
			
			if(max1 >= (a + b + c - max1)) {
				sb.append("Invalid\n");
				continue;
			}
				
			
			if(a == b && b == c && a == c) {
				sb.append("Equilateral\n");
			} else if(a == b || b == c || a == c) {
				sb.append("Isosceles\n");
			} else {
				sb.append("Scalene\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
