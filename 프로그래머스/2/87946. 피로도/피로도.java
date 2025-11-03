class Solution {
    
    static int s, max;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        s = dungeons.length;
        max = Integer.MIN_VALUE;
        visited = new boolean[dungeons.length];
        
        sol(0, k, 0, dungeons);
        
        return max;
    }
    
    private static void sol(int d, int hp, int cnt, int[][] dungeons) {
        if(d >= dungeons.length) {
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                if(dungeons[i][0] <= hp) {
                    sol(d+1, hp - dungeons[i][1], cnt+1, dungeons);
                } else {
                    sol(d+1, hp, cnt, dungeons);
                }
                
                visited[i] = false;
            }
        }
        
        return;
        
    }
}