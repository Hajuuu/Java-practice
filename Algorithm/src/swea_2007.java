import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String pattern = str.charAt(0) + "";
			String cutStr = "";
			for(int i = 1; i < str.length(); i++) {
				cutStr = str.replaceAll(pattern, "");
				if(cutStr.isEmpty() || pattern.contains(cutStr)) {
					break;
				}
				pattern += str.charAt(i);
				
			}
			sb.append("#" + tc + " " + pattern.length() + "\n");
		}
		System.out.println(sb);
	}

}
