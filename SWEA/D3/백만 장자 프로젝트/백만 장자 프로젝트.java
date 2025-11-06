import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long max = Long.MIN_VALUE;
			long answer = 0;
			long cost = 0;
			int count = 0;
			for(int i = arr.length - 1; i >= 0; i--) {
				if(arr[i] > max) {
					answer += (max * count - cost);
					max = arr[i];
					cost = 0;
					count = 0;
				} else {
					cost += arr[i];
					count++;
				}
			}
			answer += (max * count - cost);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
	

}
