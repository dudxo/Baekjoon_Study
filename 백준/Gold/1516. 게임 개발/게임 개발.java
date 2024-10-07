import java.util.*;
public class Main {

    private static ArrayList<Integer>[] arr;
    private static int[] time, indegree;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N+1];
        time = new int[N+1];
        indegree = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 1 ; i <= N; i++) {
            time[i] = sc.nextInt();
            while(true) {
                int num = sc.nextInt();
                if(num == -1) {
                    break;
                }
                arr[num].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[N+1];
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : arr[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}


