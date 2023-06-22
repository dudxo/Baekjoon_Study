package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 백준 16916문제
 * 메모리 초과
 */
public class Baekjoon16916_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder s1 = new StringBuilder(br.readLine());
        StringBuilder s2 = new StringBuilder(br.readLine());
        StringBuilder sol = new StringBuilder("0");

        int s1Size = s1.length(), s2Size = s2.length();
        ArrayList<String> ar = new ArrayList<String>(s1Size);
        String s2Info = s2.toString();

        for(int i =0; i< s1Size; i++) {
            if (s1Size >= i + s2Size) {
                ar.add(s1.substring(i, s2Size + i));
            }
        }

        for(String s : ar){     // String s가 계속 메모리 할당되어 메모리 초과가 일어난다고 생각된다.
            if(s.equals(s2Info)){
                sol.setLength(0);
                sol.append(1);
                break;
            }
        }

        System.out.print(sol);
        br.close();
    }
}
