import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_16910 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int k = 0; k < T; k++) {
			int N = Integer.parseInt(br.readLine());
			int count = 1;
			int n = N * N;
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N; j++) {
					if(((i * i) + (j * j)) > n) {
						break;
					}
					if(i == 0 || j == 0) {
						count += 4;
						continue;
					} 
					
					if(i == j) {
						count += 4;
						continue;
					}
					count += 8;
					
					
				}
			}
			sb.append("#" + (k + 1) + " " + count + "\n");
		}
		
		System.out.println(sb);
		
	}

}
