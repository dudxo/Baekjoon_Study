import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static TreeMap<String, Integer> tree = new TreeMap<>();
    static TreeMap<String, List<String>> family = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        while(str.hasMoreTokens()) {
            tree.put(str.nextToken(), 0); // 모든 구성원(이름, 계층(최상위 조상은 0 계층)
        }

        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            str = new StringTokenizer(br.readLine());
            String son = str.nextToken();
            String parent = str.nextToken();

            tree.put(son, tree.getOrDefault(son, 0) + 1); // 각 구성원의 계층을 변경

            if(family.containsKey(parent)) {  // 족보가 있다면 자식 추가
                List<String> list = family.get(parent);
                list.add(son);
                family.replace(parent, list);
                continue;
            }

            family.put(parent, new ArrayList<>(List.of(son))); // 새 족보 생성
        }

        Set<String> keys = family.keySet();

        for(String key : keys) {
            List<String> sons = family.get(key);

            int pIndex = tree.get(key);
            Iterator<String> iterator = sons.iterator();
            while(iterator.hasNext()) {
                String son = iterator.next();
                int sIndex = tree.get(son);

                if(pIndex + 1 != sIndex)
                    iterator.remove();
            }
         }

        Set<String> treeKeys = tree.keySet();
        for(String key : treeKeys) {
            if(!family.containsKey(key)) {
                family.put(key, new ArrayList<>());
            }
        }


        print(sb);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void print(StringBuilder sb) {
        Set<String> treeKeys = tree.keySet();

        int first = 0;
        for(String key : treeKeys) {
            if(tree.get(key) == 0) {
                first += 1;
                sb.append(key).append(" ");
            }
        }

        sb.insert(0, first).insert(1, "\n");
        sb.append("\n");

        Set<String> familyKeys = family.keySet();
        for(String key : familyKeys) {
            List<String> sons = family.get(key);
            sb.append(key).append(" ").append(sons.size()).append(" ");
            Collections.sort(sons);
            for(String son : sons) {
                sb.append(son).append(" ");
            }
            sb.append("\n");
        }

    }

}