import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] node;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());
        node = new ArrayList[n+1];
        check = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            node[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            node[u].add(v);
            node[v].add(u);
        }
        br.close();
        int count = 0;

        for(int i = 1; i < n+1; i++){
            if(!check[i]){
                count++;
                DFS(i);
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void DFS(int i){
        if(check[i]){
            return;
        }
        check[i] = true;
        for(int v : node[i]){
            if(check[v] == false){
                DFS(v);
            }
        }
    }

}