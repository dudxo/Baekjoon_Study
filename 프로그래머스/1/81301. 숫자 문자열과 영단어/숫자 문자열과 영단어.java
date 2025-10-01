import java.util.*;

class Solution {
    
    static StringBuilder sb1, sb2;
    
    public int solution(String s) {
        int answer = 0;
        
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        
        return Integer.parseInt(s);
        
//         sb1 = new StringBuilder();
//         sb2 = new StringBuilder();
        
//         for(char c : s.toCharArray()) {
//             if(c >= '1' && c <= '9') {
//                 if(sb2.length() > 0) {
//                     System.out.println(sb2.length());
//                     sol();
//                 }
//                 sb1.append(c);
                
//                 continue;
//             }
            
//             sb2.append(c);
//             sol();
            
//         }
        
//         return Integer.parseInt(sb1.toString());
    }
    
    private static void sol() {
        switch(sb2.toString()) {
            case "one":
                sb1.append("1");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "two":
                sb1.append("2");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "three":
                sb1.append("3");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "four":
                sb1.append("4");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "five":
                sb1.append("5");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "six":
                sb1.append("6");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "seven":
                sb1.append("7");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "eight":
                sb1.append("8");
                sb2 = sb2.delete(0, sb2.length());
                break;
            case "nine":
                sb1.append("9");
                sb2 = sb2.delete(0, sb2.length());
                break;
        }
    }
}