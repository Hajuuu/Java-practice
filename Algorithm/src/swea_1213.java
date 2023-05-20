import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String search = br.readLine();
			String str = br.readLine();
			boolean check = false;
			int count = 0;
			for(int i = 0; i <= str.length() - search.length(); i++) {
				if(str.charAt(i) == search.charAt(0)) {
					check = true;
					for(int j = 1; j < search.length(); j++) {
						if(str.charAt(i + j) != search.charAt(j)) {
							check = false;
							break;
						}
					}
					if(check) {
						count++;
					}
				}
			}
			
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}

}
