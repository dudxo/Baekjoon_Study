import java.util.*;

class Solution {
    
    static int count = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // 백트레킹으로 진행하면서 숫자 5개 뽑아짐 -> 1개 카운트
        // 1~n으로 백트레킹하면서 숫자 5개를 뽑았을 때 q, ans를 검증하기?
        
        sol(0, new int[5], 1, n, q, ans);
        
        return count;
    }
    
    private static void sol(int k, int[] arr, int m, int n, int[][] q, int[] ans) {
        if(k == 5) {
            if(check(arr, q, ans)) {
                // print(arr);
                count += 1;
            }
            
            return;
        }
        
        if(m > n) {
            return ;
        }
        
        // 현재 숫자가 비밀코드
        arr[k] = m;
        sol(k+1, arr, m+1, n, q, ans);
        arr[k] = 0;
        
        // 현재 숫자가 비밀코드가 아님
        sol(k, arr, m+1, n, q, ans);
    }
    
    private static void print(int[] arr) {
        System.out.printf("비밀 코드 조합 = {");
        for(int i : arr) {
            System.out.printf("%d, ", i);
        }
        System.out.printf("}\n");
    }
    
    private static boolean check(int[] arr, int[][] q, int[] ans) {
        // print(arr);
        for(int i = 0; i < q.length; i++) {
            int num = 0;
            
            int[] tmp = q[i];
            List<Integer> list = new ArrayList<>();
            for(int j : tmp) {
                list.add(j);
            }
            
            for(int j : arr) {
                if(list.contains(j)) num++;
            }
            
            if(ans[i] != num) {
                return false;
            }
        }
        
        
        return true;
    }
    
// 비밀 코드 조합 = {1, 2, 8, 12, 13, }
// 비밀 코드 조합 = {1, 2, 9, 10, 13, }
// 비밀 코드 조합 = {1, 3, 8, 10, 13, }
// 비밀 코드 조합 = {1, 3, 9, 10, 12, }
}