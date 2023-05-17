import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for(int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;
			int count = 0;
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					count += arr[j][k];
				}
				max = Math.max(max, count);
				count = 0;
			}
			
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					count += arr[k][j];
				}
				max = Math.max(max, count);
				count = 0;
			}
			
			int count2 = 0;
			for(int j = 0; j < 100; j++) {
				count += arr[j][j];
				count2 += arr[99 - j][j];
			}
			max = Math.max(max, Math.max(count, count2));
			
			sb.append("#" + i + " " + max + "\n");
			
		}
		System.out.println(sb);
	}

}
