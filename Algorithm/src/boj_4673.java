

public class boj_4673 {

	static boolean[] check;
	public static void main(String[] args) {
		check = new boolean[10001];
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 10001; i++) {
			if(!check[i]) {
				selfNum(i);
			}
		}
		
		for(int i = 1; i < 10001; i++) {
			if(!check[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void selfNum(int start) {
		while(true) {
			start = number(start);
			if(start > 10000) {
				return;
			}
			check[start] = true;
		}
	}
	
	public static int number(int n) {
		int answer = n;
		String str = Integer.toString(n);
		for(int i = 0; i < str.length(); i++) {
			answer += str.charAt(i) - '0';
		}
		
		return answer;
	}

}
