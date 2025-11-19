import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= tc; t++) {
			String str = br.readLine();
			int count = 0;
			int[] bit = new int[str.length()];
			int[] start = new int[str.length()];
			for(int i = 0; i < bit.length; i++) {
				bit[i] = str.charAt(i) - '0';
			}
			for(int i = 0; i < bit.length; i++) {
				if(start[i] != bit[i]) {
					for(int j = i; j < bit.length; j++) {
						start[j] = bit[i];
					}
					count++;
				}
			}
			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}

}
