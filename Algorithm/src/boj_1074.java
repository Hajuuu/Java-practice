import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {

	static int[][] arr;
	static int count = 0;
	static int r, c;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		int length = (int) Math.pow(2, N);
		
		number(length, 0, 0);
		System.out.println(sb);
		
	}
	
	public static void number(int N, int x, int y) {

		if(N == 1) {
			count++;
			return;
		}
		
		int size = N / 2;
		for(int i = x; i < x + N; i += size) {
			for(int j = y; j < y + N; j += size) {
				
				if(i == r && j == c) {
					sb.append(count);
					return;
				}
				number(size, i, j);
			}
		}
	}
}
