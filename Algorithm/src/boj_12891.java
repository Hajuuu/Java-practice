import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891 {

	static int check;
	static int[] min;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		char[] DNA = new char[S];
		for(int i = 0; i < S; i++) {
			DNA[i] = str.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		check = 0;
		min = new int[4];
		count = new int[4];
		
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
			if(min[i] == 0) {
				check++;
			}
		}
		
		for(int i = 0; i < P; i++) {
			add(DNA[i]);
		}
		if(check == 4) {
			answer++;
		}
		
		for(int i = P; i < S; i++) {
			int j = i - P;
			add(DNA[i]);
			remove(DNA[j]);
			if(check == 4) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void add(char c) {
		switch(c) {
			case 'A' :
				count[0]++;
				if(min[0] == count[0]) {
					check++;
				}
				break;
			case 'C' :
				count[1]++;
				if(min[1] == count[1]) {
					check++;
				}
				break;
			case 'G' :
				count[2]++;
				if(min[2] == count[2]) {
					check++;
				}
				break;
			case 'T' :
				count[3]++;
				if(min[3] == count[3]) {
					check++;
				}
				break;
			
		}
	}
	
	public static void remove(char c) {
		switch(c) {
		case 'A' :
			if(min[0] == count[0]) {
				check--;
			}
			count[0]--;
			break;
		case 'C' :
			if(min[1] == count[1]) {
				check--;
			}
			count[1]--;
			break;
		case 'G' :
			if(min[2] == count[2]) {
				check--;
			}
			count[2]--;
			break;
		case 'T' :
			if(min[3] == count[3]) {
				check--;
			}
			count[3]--;
			break;
		
		}
	}

}
