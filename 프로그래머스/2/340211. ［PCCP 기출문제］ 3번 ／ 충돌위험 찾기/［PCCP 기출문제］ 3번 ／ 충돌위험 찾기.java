import java.util.*;

class Solution {
    
    static int r = 0, c = 0;
    static int[][] map;
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    static class Node {
        int x, y, rx, ry;
        ArrayList<Integer> next;
        
        Node(int x, int y, int rx, int ry, ArrayList<Integer> next) {
            this.x = x;
            this.y = y;
            this.rx = rx;
            this.ry = ry;
            this.next = next;
        }
        
        public void down() {
            this.x += 1;
        }
        
        public void up() {
            this.x += -1;
        }
        
        public void left() {
            this.y += -1;
        }
        
        public void right() {
            this.y += 1;
        }
        
        public void updateDest(int rx, int ry) {
            this.rx = rx;
            this.ry =  ry;
        }
    }
    
    static class Node2 {
        int x, y;
        
        Node2(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Node2 o2 = (Node2) o;    
            return this.x == o2.x && this.y == o2.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        for(int[] arr : points) {
            r = Math.max(r, arr[0]);
            c = Math.max(c, arr[1]);
        }
        
        map = new int[r+1][c+1];
        
        // 로봇 초기화
        for(int[] arr : routes) {
            int[] now = points[arr[0] - 1];
            int[] dest = points[arr[1] - 1];
            
            ArrayList<Integer> next = new ArrayList<>();
            if(arr.length >= 3) {
                for(int i = 2; i < arr.length; i++) {
                    next.add(arr[i]);
                }
            }
            
            Node node = new Node(now[0], now[1], dest[0], dest[1], next);
            dq.add(node);
        }
        
        while(!dq.isEmpty()) {
            answer += findDanger();
            
            // 목표지점 도달했는지 검증
            isGoal(points);
            
            // 새롭게 이동
            move();
        }
        
        return answer;
    }
    
    private static int findDanger() {
        HashMap<Node2, Integer> map = new HashMap<>();
        
        int size = dq.size();
        int count = 0;
        
        while(size-- > 0) {
            Node node = dq.remove();
            
            Node2 n2 = new Node2(node.x, node.y);
            map.put(n2, map.getOrDefault(n2, 0) + 1);
            
            dq.addLast(node);
        }
        // System.out.println("===========충돌 확인 시작=========");

        for(Node2 key : map.keySet()) {
            int value = map.get(key);
            // System.out.printf("[%d, %d] = %d\n", key.x, key.y, value);
            if(value > 1) {
                count += 1;
            }
        }
        // System.out.println("===========충돌 확인 종료=========");
        
        return count;
    }
    
    private static void isGoal(int[][] points) {
        int size = dq.size();
        // System.out.println("===========목표지점 확인 시작=========");
        while(size-- > 0) {
            Node node = dq.remove();
            
            // System.out.printf("[%d, %d] 위치, [%d,  %d] 목표지점\n", node.x, node.y, node.rx, node.ry);
            
            // 목표 지점 도달하면 지우기
            if(node.x == node.rx && node.y == node.ry && node.next.size() == 0) continue;
            
            if(node.x == node.rx && node.y == node.ry) {
                int next = node.next.remove(0);
                int rx = points[next - 1][0];
                int ry = points[next - 1][1];
                node.updateDest(rx, ry);
            }
            
            dq.addLast(node);
        }
        // System.out.println("===========목표지점 확인 종료=========");
    }
    
    private static void move() {
        int size = dq.size();
        // System.out.println("===========좌표 이동 시작=========");
        while(size-- > 0) {
            Node node = dq.remove();
            // System.out.printf("[%d, %d] 로봇", node.x, node.y);

            // r좌표 먼저 이동
            if(node.x != node.rx) {
                // System.out.printf(", r좌표 이동!!");
                if(node.x < node.rx) {
                    // System.out.printf(", r좌표 다운!!");
                    node.down();
                    // System.out.printf("\t r좌표 다운 결과 = [%d, %d]\n", node.x, node.y);
                } else {
                    // System.out.printf(", r좌표 업!!");
                    node.up();
                    // System.out.printf("\t r좌표 업 결과 = [%d, %d]\n", node.x, node.y);
                }
            }
            
            // c좌표 이동
            else {
                // System.out.printf(", c좌표 이동!!");
                if(node.y < node.ry) {
                    // System.out.printf(", c좌표 우측 이동!!");
                    node.right();
                    // System.out.printf("\t c좌표 우측 이동 결과 = [%d, %d]\n", node.x, node.y);
                } else {
                    // System.out.printf(", c좌표 좌측 이동!!");
                    node.left();
                    // System.out.printf("\t c좌표 좌측 이동 결과 = [%d, %d]\n", node.x, node.y);
                }
            }
            
            dq.addLast(node);
        }
        // System.out.println("===========좌표 이동 종료=========");

    }
}