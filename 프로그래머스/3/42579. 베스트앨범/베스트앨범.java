import java.util.*;

class Solution {
    
    static class Genre implements Comparable<Genre> {
        int play;
        List<Music> musics;
        
        Genre(int play) {
            this.play = play;
            this.musics = new ArrayList<>();
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.play - this.play;
        }
    }
    
    static class Music implements Comparable<Music> {
        int i, play;
        
        Music(int i, int play) {
            this.i = i;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            return o.play - this.play;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Genre> map = new HashMap<>();
        
        int len = genres.length;
        for(int i = 0; i < len; i++) {
            if(map.get(genres[i]) == null) {
                Genre genre = new Genre(plays[i]);
                genre.musics.add(new Music(i, plays[i]));
                map.put(genres[i], genre);
            }
            else {
                Genre genre = map.get(genres[i]);
                genre.play += plays[i];
                genre.musics.add(new Music(i, plays[i]));
                map.put(genres[i], genre);
            }
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String key : map.keySet()) {
            pq.add(map.get(key));
        }
        
        while(!pq.isEmpty()) {
            Genre genre = pq.poll();
            Collections.sort(genre.musics);
            
            int min = Math.min(2, genre.musics.size());
            
            for(int i = 0; i < min; i++) {
                answer.add(genre.musics.get(i).i);
            }
        }
        
        return answer;
    }
}