import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = 0;
		int p = 0;
		int q = 0;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(max <= num) {
					max = num;
					p = i + 1;
					q = j + 1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(p + " " + q);
	}
	
	
}
