import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			if(arr[i][0] < minX)
				minX = arr[i][0];
			if(arr[i][0] > maxX)
				maxX = arr[i][0];
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[i][1] < minY)
				minY = arr[i][1];
			if(arr[i][1] > maxY)
				maxY = arr[i][1];
		}
		
		System.out.println((maxX - minX) * (maxY - minY));
	}
}
