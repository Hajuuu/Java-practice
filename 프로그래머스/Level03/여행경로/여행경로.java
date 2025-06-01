import java.util.*;

class Solution {
    ArrayList<String> answer;
    boolean[] used;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        used = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        dfs(tickets, "ICN", "ICN", 0);
        return answer.get(0).split(" ");
    }

    public void dfs(String[][] tickets, String path, String cur, int count) {
        if (count == tickets.length) {
            answer.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true;
                dfs(tickets, path + " " + tickets[i][1], tickets[i][1], count + 1);
                used[i] = false;
            }
        }
    }
}
