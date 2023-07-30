import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] list = br.readLine().split("-");
		for(int i = 0; i < list.length; i++) {
			if(list[i].contains("+")) {
				int num = 0;
				String[] plus = list[i].split("\\+");
				for(String str : plus) {
					num += Integer.parseInt(str);
				}
				list[i] = Integer.toString(num);
			}
			
			
		}
		
		int answer = Integer.parseInt(list[0]);
		for(int i = 1; i < list.length; i++) {
			answer -= Integer.parseInt(list[i]);
		}
		System.out.println(answer);
	}

}
