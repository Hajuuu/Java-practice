import java.util.*;
class Solution {
    String[] userIds;
    String[] bannedIds;
    HashSet<HashSet<String>> result = new HashSet<>();
    class Node {
        int bannedIdx;
        HashSet<String> set = new HashSet<>();
        
        Node(int bannedIdx, HashSet<String> set) {
            this.bannedIdx = bannedIdx;
            this.set = set;
        }
    }
    Queue<Node> queue = new ArrayDeque<>();
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        bfs();
        return result.size();
    }
    public void bfs() {
        queue.offer(new Node(0, new HashSet<>()));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.bannedIdx == bannedIds.length) {
                result.add(node.set);
                continue;
            }
            
            for(int i = 0; i < userIds.length; i++) {
                if(node.set.contains(userIds[i])) {
                    continue;
                }
                
                if(check(userIds[i], bannedIds[node.bannedIdx])) {
                    node.set.add(userIds[i]);
                    queue.offer(new Node(node.bannedIdx + 1, new HashSet<>(node.set)));
                    node.set.remove(userIds[i]);
                }
            }
        }
    }
    
    public boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) {
            return false;
        }
        
        for(int i = 0; i < userId.length(); i++) {
            if(bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
