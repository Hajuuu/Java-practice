import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] A = new long[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		int count = 0;
		for(int k = 0; k < N; k++) {
			int i = 0;
			int j = N - 1;
			while(i < j) {
				if(A[i] + A[j] > A[k]) {
					j--;
				}
				else if(A[i] + A[j] < A[k]) {
					i++;
				} else {
					if(i != k && j != k) {
						count++;
						break;
					}
					else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					}
				}
			}
		}
		System.out.println(count);
	}

}
