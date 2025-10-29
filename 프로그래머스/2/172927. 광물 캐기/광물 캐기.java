import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        sol(0, 0, 0, 0, picks, minerals);
        
        return min;
    }
    
    private static void sol(int k, int t, int cnt, int pick, int[] picks, String[] minerals) {
        if(cnt >= 5) {
            cnt = 0;
        }
        
        if(k >= minerals.length || (cnt==0 && check(picks))) {
            min = Math.min(min, t);
            return;
        }
        
        // 새로운 곡괭이 선택
        if(cnt == 0) {
            // 다이아 곡괭이
            if(picks[0] != 0) {
                picks[0]--;
                sol(k+1, t + 1, cnt + 1, 1, picks, minerals);
                picks[0]++;
            }
            // 철 곡괭이
            if(picks[1] != 0) {
                picks[1]--;
                if(minerals[k].equals("diamond")) {
                    sol(k+1, t + 5, cnt + 1, 2, picks, minerals);
                }
                else {
                    sol(k+1, t + 1, cnt + 1, 2, picks, minerals);
                }
                picks[1]++;
            }
            // 돌 곡괭이
            if(picks[2] != 0) {
                picks[2]--;
                if(minerals[k].equals("diamond")) {
                    sol(k+1, t + 25, cnt + 1, 3, picks, minerals);
                }
                else if(minerals[k].equals("iron")) {
                    sol(k+1, t + 5, cnt + 1, 3, picks, minerals);
                }
                else {
                    sol(k+1, t + 1, cnt + 1, 3, picks, minerals);
                }
                picks[2]++;
            }
        }
        
        // 기존 곡괭이
        else {
            if(pick == 1) {
                sol(k+1, t + 1, cnt + 1, 1, picks, minerals);
            }
            else if(pick == 2) {
                if(minerals[k].equals("diamond")) {
                    sol(k+1, t + 5, cnt + 1, 2, picks, minerals);
                }
                else {
                    sol(k+1, t + 1, cnt + 1, 2, picks, minerals);
                }
            }
            else {
                if(minerals[k].equals("diamond")) {
                    sol(k+1, t + 25, cnt + 1, 3, picks, minerals);
                }
                else if(minerals[k].equals("iron")) {
                    sol(k+1, t + 5, cnt + 1, 3, picks, minerals);
                }
                else {
                    sol(k+1, t + 1, cnt + 1, 3, picks, minerals);
                }
            }
        }
        
    }
    
    private static boolean check(int[] picks) {
        for(int i : picks) {
            if(i > 0) return false;
        }
        
        return true;
    }
}