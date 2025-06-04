import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static boolean[] visited;
    static StringBuilder sb;
    static String[] letters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        letters = new String[C];
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken();
        }
        sb = new StringBuilder();
        visited = new boolean[C];
        Arrays.sort(letters);
        dfs("", 0);
        System.out.println(sb);
    }

    public static void dfs(String str, int idx) {
        if (str.length() == L) {
            if (check(str)) {
                sb.append(str + "\n");
            }
            return;
        }

        for (int i = idx; i < letters.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + letters[i], i + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String str) {
        int v = 0;
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                v++;
            } else {
                c++;
            }
        }
        if (v > 0 && c > 1) {
            return true;
        }
        return false;
    }
}
