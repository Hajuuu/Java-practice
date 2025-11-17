import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static char[][] keyboard;
	static int N;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			keyboard = new char[8][8];
			for(int i = 0; i < 8; i++) {
				String str = br.readLine();
				for(int j = 0; j < 8; j++) {
					keyboard[i][j] = str.charAt(j);
				}
			}
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					palindrom1(i, j);
					palindrom2(i, j);
				}
			}
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
	
	public static void palindrom1(int x, int start) {
		String a = "";
		String b = "";
		if(start + N > 8) {
			return;
		}
		for(int i = start; i < start + N / 2; i++) {
			a += keyboard[x][i];
			
		}
		for(int i = start + N - 1; i >= start + N / 2 + (N % 2); i--) {
			b += keyboard[x][i];
			
		}
		if(a.equals(b)) {
			count++;
		}
	}
	
	public static void palindrom2(int x, int start) {
		String a = "";
		String b = "";
		if(start + N > 8) {
			return;
		}
		for(int i = start; i < start + N / 2; i++) {
			a += keyboard[i][x];
			
		}
		for(int i = start + N - 1; i >= start + N / 2 + (N % 2); i--) {
			b += keyboard[i][x];
			
		}
		if(a.equals(b)) {
			count++;
		}
	}

}
