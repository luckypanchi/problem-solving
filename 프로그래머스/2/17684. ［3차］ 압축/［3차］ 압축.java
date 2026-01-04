import java.util.*;

class Solution {
    
    private static Map<String, Integer> map = new HashMap<>();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(ALPHABET.charAt(i)), i + 1);
        }
        
        int start = 0;
        while (start < msg.length()) {
            int end = findEnd(msg, start);
            
            String w = msg.substring(start, end + 1);
            answer.add(map.get(w));
           	
            if (end + 1 < msg.length()) {
                put(msg.substring(start, end + 2));
            }
            
            start = end + 1;
        }
       
        return toArray(answer);
    }
    
    private int findEnd(String msg, int start) {
        for (int end = start; end < msg.length(); end++) {
        	String curr = msg.substring(start, end + 1);
            if (!map.containsKey(curr)) {
               	return end - 1; 
            }
        }
        return msg.length() - 1;
    }
    
    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    private void put(String ns) {
        map.put(ns, map.size() + 1);
    }
}