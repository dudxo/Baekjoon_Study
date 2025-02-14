import java.util.*;
import java.io.*;

class Solution {
    
    static HashMap<String, Integer> comMap = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        
        for(String str : completion) {
            if(comMap.containsKey(str)) {
                comMap.replace(str, comMap.get(str)+1);
                continue;
            }
            comMap.put(str, 1);
        }

        String st = "";
        for(String str : participant) {
            if(!comMap.containsKey(str)) {
                return str;
            }
            if(comMap.get(str) == 1) {
                comMap.remove(str);
                continue;
            }
            comMap.replace(str, comMap.get(str)-1);
            st = str;
        }
        
        return st;
        
    }
}