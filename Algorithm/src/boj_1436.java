import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		int num = 666;
		int i = 1;
		while(i <= 10000) {
			String n = Integer.toString(num);
			int count = 0;
			for(int j = 1; j < n.length(); j++) {
				if(n.contains("666")) {
					count++;
				}
			}
			if(count >= 1) {
				arr[i] = num;
				i++;
			}
			
			num++;
		}
		
		System.out.println(arr[N]);
	}

}
