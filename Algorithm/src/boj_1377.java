import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1377 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		data[] arr = new data[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = new data(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(max < arr[i].index - i) {
				max = arr[i].index - i;
			}
		}
		
		System.out.println(max + 1);
	}
	
	
	
}

class data implements Comparable<data>{
	int value;
	int index;
	
	public data(int value, int index) {
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(data o) {
		return this.value - o.value;
	}
	
}