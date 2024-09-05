import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(start <= N && end <= N) {
			if(sum >= S) {
				min = Math.min(min, end - start);
			}

			if(sum < S) {
				sum += num[end++];			
			} else {
				sum -= num[start++];
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		} 
		System.out.println(min);
	} 

}
