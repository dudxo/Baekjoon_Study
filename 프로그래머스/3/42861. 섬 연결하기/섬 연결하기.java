import java.util.*;

class Solution {
    
    static ArrayList<Node> graph;
    static ArrayList<int[]> mst;
    static int[] arr;
    
    static class Node implements Comparable<Node> {
        int u, v, w;
        
        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        graph = new ArrayList<>();
        mst = new ArrayList<>();
        arr = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            arr[i] = -1;
        }
        
        for(int i = 0; i < costs.length; i++) {
            int u = costs[i][0];
            int v = costs[i][1];
            int w = costs[i][2];
            
            graph.add(new Node(u, v, w));
        }
        
        Collections.sort(graph);
        
        for(Node node : graph) {
            if(mst.size() == n-1) {
                break;
            }
            
            sol(node);
        }
        
        for(int[] iArr : mst) {
            answer += iArr[2];
        }
        
        return answer;
    }
    
    private static void sol(Node node) {
        int u = node.u;
        int v = node.v;
        int w = node.w;
        
        if(find(u) == find(v)) {
            return;
        }
        
        if(union(u, v)) {
            mst.add(new int[] {u, v, w});
        }
    }
    
    private static int find(int u) {
        if(arr[u] < 0) {
            return u;
        }
        
        return arr[u] = find(arr[u]);
    }
    
    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if(u == v) {
            return false;
        }
        
        if(arr[v] < arr[u]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        
        if(arr[u] == arr[v]) {
            arr[u]--;
        }
        
        arr[v] = u;
        return true;
        
    }
}