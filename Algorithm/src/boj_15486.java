import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15486 {

	static int N;
	static Consulting[] c;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		c = new Consulting[N + 2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			c[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	
		backTracking(1, 0);
		
		System.out.println(answer);
		
	}
	
	public static void backTracking(int day, int price) {
		if(day == N + 1) {
			answer = Math.max(answer, price);
			return;
		}
		if(day > N + 1) {
			return;
		}
		answer = Math.max(answer, price);
		backTracking(day + c[day].T, price + c[day].P);	
		backTracking(day + 1, price);		
	}

}

class Consulting {
	int T;
	int P;
	
	Consulting(int T, int P) {
		this.T = T;
		this.P = P;
	}
}
