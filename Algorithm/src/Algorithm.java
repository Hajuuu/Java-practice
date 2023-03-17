import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int[][] arr = new int[15][14];
		
		for(int i = 0; i < 14; i++) {
			arr[0][i] = i + 1;
		}
		
		for(int i = 0; i < 15; i++) {
			arr[i][0] = 1;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 14; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[k][n-1]).append("\n");
		}
		System.out.println(sb);
		
	}	
}
