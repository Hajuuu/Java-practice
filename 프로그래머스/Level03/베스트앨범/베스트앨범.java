import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreToSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            if (!genreToSongs.containsKey(genre)) {
                genreToSongs.put(genre, new ArrayList<>());
            }
            genreToSongs.get(genre).add(new Song(i, play));

        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genreToSongs.get(genre);
            songs.sort((a, b) -> {
                if (a.play == b.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
class Song {
    int index;
    int play;

    Song(int index, int play) {
        this.index = index;
        this.play = play;
    }
}
