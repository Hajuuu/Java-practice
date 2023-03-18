import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(factor(a, b));

	}	
	
	public static int factor(int a, int b) {
		int[] arr = new int[a];
		int j = 1;
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				arr[j] = i;
				j++;
			}
		}
		return arr[b];
	}
}
