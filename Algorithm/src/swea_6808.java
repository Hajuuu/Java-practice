import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6808 {

	static int[] card;
	static int winA;
	static int winB;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			card = new int[9];
			check = new boolean[19];
			for(int i = 0; i < 9; i++) {
				card[i] = Integer.parseInt(st.nextToken());
				check[card[i]] = true;
			}
			winA = 0;
			winB = 0;
			game(0, 0, 0);
			sb.append("#" + tc + " " + winA + " " + winB + "\n");
		}
		System.out.println(sb);
	
	}
	
	public static void game(int depth, int a, int b) {
		if(depth == 9) {
			if(a > b) {
				winA++;
			} else {
				winB++;
			}
			return;
		}
		
		for(int i = 1; i <= 18; i++) {
			if(card[depth] == i || check[i]) {
				continue;
			}
			check[i] = true;
			if(card[depth] > i) {
				game(depth + 1, a + card[depth] + i, b);
			} else {
				game(depth + 1, a, b + card[depth] + i);
			}
			
			check[i] = false;
		}
		
	}

}
