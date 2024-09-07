import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2437 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(numbers);
		 
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 1 < numbers.get(i)) {
				break;
			}
			sum += numbers.get(i);
		}
		System.out.println(sum + 1);
 	}

}
