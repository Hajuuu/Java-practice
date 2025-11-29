import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int count = 0;
			boolean check = true;
			for(int j = 0; j < N; j++) {
				int num = (arr[j] / M) * K - 1 - count;
				if(num < 0) {
					check = false;
					break;
				}
				count += 1;
			}
			
			if(check) {
				sb.append("#" + i + " Possible\n");
			} else {
				sb.append("#" + i + " Impossible\n");
			}
		}
		
		System.out.println(sb);
	}

}
