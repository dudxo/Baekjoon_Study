import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, truth;
    private static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        int t = sc.nextInt();
        truth = new int[t];
        if(t != 0) {
            for (int i = 0; i < t; i++) {
                truth[i] = sc.nextInt();
            }
        }

        party = new ArrayList[M];
        for(int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>();
            int party_size = sc.nextInt();
            for(int j = 0; j < party_size; j++) {
                party[i].add(sc.nextInt());
            }
        }

        for(int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for(int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j = 0; j < truth.length; j++) {
                if(find(cur) == find(truth[j])) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            arr[b] = a;
        }
    }

    private static int find(int i) {
        if(i == arr[i]) {
            return i;
        } else {
         return arr[i] = find(arr[i]);
        }
    }
}


