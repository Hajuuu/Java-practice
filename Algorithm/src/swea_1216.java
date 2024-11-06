import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1216 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			String[] width = new String[100];
			String[] length = new String[100];
			
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				width[i] = str;
			}
			
			for(int i = 0; i < 100; i++) {
				String str = "";
				for(int j = 0; j < 100; j++) {
					str += width[j].charAt(i);
				}
				length[i] = str;
			}
			
			int max = 0;
			
			boolean check = false;
			for(int k = 0; k < 100; k++) {
				check = false;
				for(int i = 100; i > max; i--) {
					for(int j = 0; j < 100 - i; j++) {
						if(findPalindrom(length[k].substring(j, j + i))) {
							max = Math.max(max, i);
							check = true;
							break;
						}
					}
					if(check) {
						break;
					}
				}
			}
			
			
			for(int k = 0; k < 100; k++) {
				check = false;
				for(int i = 100; i > 0; i--) {
					for(int j = 0; j < 100 - i; j++) {
						if(findPalindrom(width[k].substring(j, j + i))) {
							max = Math.max(max, i);
							check = true;
							break;
						}
					}
					if(check) {
						break;
					}
				}
			}
			
			
			
			
			
			sb.append("#" + tc + " " + max + "\n");
		}
		
		System.out.println(sb);
	}

	public static boolean findPalindrom(String str) {
		StringBuffer sb = new StringBuffer(str);
		String str2  = sb.reverse().toString();

		if(str.equals(str2)) {
			return true;
		}
		return false;
		
		
	}
}
