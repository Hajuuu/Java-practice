import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		int[] peace = {1, 1, 2, 2, 2, 8};
		
		for(int i = 0; i < 6; i++) {
			int p = Integer.parseInt(st.nextToken());
			sb.append(peace[i] - p).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
}
