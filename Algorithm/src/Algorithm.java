import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int prime = 0;
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int sum = 0;
			if(a == 1)
				continue;
			
			for(int i = 2; i < a; i++) {
				if(a % i == 0) {
					sum++;
				}
					
			}
			if(sum == 0) {
				prime++;
			}
		}
		
		System.out.println(prime);

	}
}
