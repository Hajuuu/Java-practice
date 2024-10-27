import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1946 {

	static List<Score> applicants1;
	static List<Score> applicants2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			applicants1 = new ArrayList<>();
			applicants2 = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int ranking1 = Integer.parseInt(st.nextToken());
				int ranking2 = Integer.parseInt(st.nextToken());
				applicants1.add(new Score(ranking1, ranking2));
				applicants2.add(new Score(ranking1, ranking2));
			}
			Comparator<Score> doc = new Comparator<Score>() {
				public int compare(Score score1, Score score2) {
					return score1.ranking1 - score2.ranking1;
				}
			};
			Comparator<Score> interview = new Comparator<Score>() {
				public int compare(Score score1, Score score2) {
					return score1.ranking2 - score2.ranking2;
				}
			};
			Collections.sort(applicants1, doc);
			Collections.sort(applicants2, interview);
			
			int answer = 1;
			for(int i = 1; i < N; i++) {
				if(check(i - 1, i)) {
					answer++;
				}
			}
			
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
	
	public static boolean check(int a, int b) {
		
		return true;
	}
}

class Score {
	int ranking1;
	int ranking2;
	
	Score(int ranking1, int ranking2) {
		this.ranking1 = ranking1;
		this.ranking2 = ranking2;
	}
}
