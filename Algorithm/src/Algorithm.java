import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] x = new int[1001];
		int[] y = new int[1001];
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[Integer.parseInt(st.nextToken())]++;
			y[Integer.parseInt(st.nextToken())]++;
		}
		
		for(int i = 1; i < 1001; i++) {
			if(x[i] == 1) {
				sb.append(i);
			}
		}
		for(int i = 1; i < 1001; i++) {
			if(y[i] == 1) {
				sb.append(" " + i);
			}
		}	
		System.out.println(sb);
		
	}
}
