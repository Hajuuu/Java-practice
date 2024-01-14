import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] solutions = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N - 1;
		
		Arrays.sort(solutions);
		int solution1 = 0;
		int solution2 = 0;
		int min = Integer.MAX_VALUE;
		while(start < end) {
			if(solutions[start] + solutions[end] == 0) {
				solution1 = solutions[start];
				solution2 = solutions[end];
				break;
			}
			if(Math.abs(solutions[start] + solutions[end]) < min) {
				min = Math.abs(solutions[start] + solutions[end]);
				solution1 = solutions[start];
				solution2 = solutions[end];
			}
			if(solutions[start] + solutions[end] > 0) {
				end--;
			} else {
				start++;
			}

		}
		
		System.out.println(solution1 + " " + solution2); 
	}

}
