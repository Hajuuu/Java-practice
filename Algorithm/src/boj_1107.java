import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1107 {

	static int[] num;
	static int length;
	static int[] darr;
	static List<String> channels;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		int length = N.length();
		if(M == 0) {
			int num = Math.abs(Integer.parseInt(N) - 100);
			int answer = Math.min(num, length);
			System.out.println(answer);
			return;
		}
		darr = new int[length + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(Integer.parseInt(N) == 100) {
			System.out.println(0);
			return;
		}
		
		num = new int[10];
		channels = new ArrayList<>();
		while(st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			num[x]++;
		}
		for(int i = 1; i <= length + 1; i++) {
			dfs(0, i);
		}
		int ch = Integer.parseInt(N);
		int min = 500000;
		for(String s: channels) {
			if(min > Math.abs(Integer.parseInt(s) - ch) + String.valueOf(s).length()) {
				min = Math.abs(Integer.parseInt(s) - ch) + String.valueOf(s).length();
			}
		}
		int ch1 = Math.abs(ch - 100);
		int answer = Math.min(ch1, min);
		System.out.println(answer);
		
	}
	
	public static void dfs(int depth, int length) {
		if(depth == length) {
			String answer = "";
			for(int i = 0; i < depth; i++) {
				answer += darr[i];
			}
			channels.add(answer);
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(num[i] == 0) {
				darr[depth] = i;
				dfs(depth + 1, length);
			}
		}
	}

}
