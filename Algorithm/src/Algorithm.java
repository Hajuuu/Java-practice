import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n]++;
		}
		
		for(int i = 1; i < 10001; i++) {
			for(int j = 1; j <= arr[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
} 
