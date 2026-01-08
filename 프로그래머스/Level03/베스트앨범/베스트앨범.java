import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreKey = new ArrayList<>(genreCount.keySet());
        genreKey.sort((o1, o2) -> genreCount.get(o2).compareTo(genreCount.get(o1)));
        
        Map<String, List<int[]>> playCount = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            List<int[]> song = playCount.getOrDefault(genres[i], new ArrayList<>());
            song.add(new int[] {i, plays[i]});
            playCount.put(genres[i], song);
        }
        
        List<String> playKey = new ArrayList<>(playCount.keySet());
        for(String play : playKey) {
            List<int[]> song = playCount.get(play);
            Collections.sort(song, (o1, o2) -> {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
            playCount.put(play, song);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(String genre : genreKey) {
            List<int[]> song = playCount.get(genre);
            if(song.size() < 2) {
                answer.add(song.get(0)[0]);
                continue;
            }
            answer.add(song.get(0)[0]);
            answer.add(song.get(1)[0]);
        }
        int[] nums = new int[answer.size()];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = answer.get(i);
        }
        
        return nums;
    }
}
