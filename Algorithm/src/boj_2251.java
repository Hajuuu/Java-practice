import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[C + 1];
		if(C > A && C > B) {
			check[A] = true;
			check[B] = true;
			check[C] = true;
			check[C - A] = true;
			check[C - B] = true;
		}
		
		if(C < A && C < B) {
			check[C] = true;
		}
		
		if(C == B && C < A || C == A && C < B) {
			check[C] = true;
		}
		
		if(C == A && C > B || C == B && C > A) {
			check[C] = true;
			int min = Math.min(A, Math.min(B, C));
			check[C - min] = true;
		}
		
		for(int i = 0; i < C + 1; i++) {
			if(check[i]) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
		
	}

}
