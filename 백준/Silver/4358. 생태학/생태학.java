import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> trees = new HashMap<>();
        int allCount = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (!trees.containsKey(str)) {
                trees.put(str, 1);
            } else {
                trees.put(str, trees.get(str) + 1);
            }
            allCount++;
        }
        Object[] keys = trees.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keys.length; i++) {
            int count = trees.get(keys[i]);
            double percent = ((double)count /(double) allCount) * 100;
            sb.append(keys[i] + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb.toString());

    }
}
