class Solution {
    int answer = 0;

    static boolean[] visited;
    static int[] infos;
    static int[][] nodes;
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        infos = info;
        nodes = edges;
        dfs(0, 0, 0);
        return answer;
    }

    private void dfs(int start, int sheep, int wolf) {

        visited[start] = true;
        if(infos[start] == 0) {
            sheep++;
            answer = Math.max(sheep, answer);
        } else {
            wolf++;
        }

        if(sheep <= wolf) {
            return;
        }

        for (int[] node : nodes) {
            if(visited[node[0]] && !visited[node[1]]) {
                visited[node[1]] = true;
                dfs(node[1], sheep, wolf);
                visited[node[1]] = false;
            }
        }
    }
}
