import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		if(x == 1 || x == 10) {
			if(y % 7 == 1) {
				System.out.println("MON");
			} else if(y % 7 == 2) {
				System.out.println("TUE");
			} else if(y % 7 == 3) {
				System.out.println("WED");
			} else if(y % 7 == 4) {
				System.out.println("THU");
			} else if(y % 7 == 5) {
				System.out.println("FRI");
			} else if(y % 7 == 6) {
				System.out.println("SAT");
			} else if(y % 7 == 0) {
				System.out.println("SUN");
			}
		} else if(x == 2 || x == 3 || x == 11) {
			if(y % 7 == 5) {
				System.out.println("MON");
			} else if(y % 7 == 6) {
				System.out.println("TUE");
			} else if(y % 7 == 0) {
				System.out.println("WED");
			} else if(y % 7 == 1) {
				System.out.println("THU");
			} else if(y % 7 == 2) {
				System.out.println("FRI");
			} else if(y % 7 == 3) {
				System.out.println("SAT");
			} else if(y % 7 == 4) {
				System.out.println("SUN");
			}
		} else if(x == 4 || x == 7) {
			if(y % 7 == 2) {
				System.out.println("MON");
			} else if(y % 7 == 3) {
				System.out.println("TUE");
			} else if(y % 7 == 4) {
				System.out.println("WED");
			} else if(y % 7 == 5) {
				System.out.println("THU");
			} else if(y % 7 == 6) {
				System.out.println("FRI");
			} else if(y % 7 == 0) {
				System.out.println("SAT");
			} else if(y % 7 == 1) {
				System.out.println("SUN");
			}
		} else if(x == 5) {
			if(y % 7 == 0) {
				System.out.println("MON");
			} else if(y % 7 == 1) {
				System.out.println("TUE");
			} else if(y % 7 == 2) {
				System.out.println("WED");
			} else if(y % 7 == 3) {
				System.out.println("THU");
			} else if(y % 7 == 4) {
				System.out.println("FRI");
			} else if(y % 7 == 5) {
				System.out.println("SAT");
			} else if(y % 7 == 6) {
				System.out.println("SUN");
			}
		} else if(x == 6) {
			if(y % 7 == 4) {
				System.out.println("MON");
			} else if(y % 7 == 5) {
				System.out.println("TUE");
			} else if(y % 7 == 6) {
				System.out.println("WED");
			} else if(y % 7 == 0) {
				System.out.println("THU");
			} else if(y % 7 == 1) {
				System.out.println("FRI");
			} else if(y % 7 == 2) {
				System.out.println("SAT");
			} else if(y % 7 == 3) {
				System.out.println("SUN");
			}
		} else if(x == 8) {
			if(y % 7 == 6) {
				System.out.println("MON");
			} else if(y % 7 == 0) {
				System.out.println("TUE");
			} else if(y % 7 == 1) {
				System.out.println("WED");
			} else if(y % 7 == 2) {
				System.out.println("THU");
			} else if(y % 7 == 3) {
				System.out.println("FRI");
			} else if(y % 7 == 4) {
				System.out.println("SAT");
			} else if(y % 7 == 5) {
				System.out.println("SUN");
			}
		} else if(x == 9 || x == 12) {
			if(y % 7 == 3) {
				System.out.println("MON");
			} else if(y % 7 == 4) {
				System.out.println("TUE");
			} else if(y % 7 == 5) {
				System.out.println("WED");
			} else if(y % 7 == 6) {
				System.out.println("THU");
			} else if(y % 7 == 0) {
				System.out.println("FRI");
			} else if(y % 7 == 1) {
				System.out.println("SAT");
			} else if(y % 7 == 2) {
				System.out.println("SUN");
			}
		}
	}

}
