import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int start = 0;
			int end = N - 1;
			int num = Integer.parseInt(st.nextToken());
			boolean find = false;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(A[mid] == num) {
					find = true;
					break;
				}
				else if(A[mid] > num) {
					end = mid - 1;
				} else if(A[mid] < num){
					start = mid + 1;
				}
			}
			
			if(find) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}

		
		System.out.println(sb);
	}

}
