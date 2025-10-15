import java.util.*;

class Solution {
    
    private int playTime;
    private int advTime;
    private long[] prefixSum;
    
    public String solution(String play_time, String adv_time, String[] logs) {
        playTime = convert(play_time);
        advTime = convert(adv_time);
        prefixSum = new long[playTime + 1];
       
        for (String log : logs) {
            String[] splited = log.split("-");
            int start = convert(splited[0]);
            int end = convert(splited[1]);
            prefixSum[start]++;
            prefixSum[end]--;
        }
        
        for (int i = 1; i < playTime + 1; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        for (int i = 1; i < playTime + 1; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
       
        int answer = 0;
        long count = prefixSum[advTime];
        
        for (int start = 1; start < playTime - advTime + 1; start++) {
            long result = count(start, start + advTime);
            if (count < result) {
                count = result;
                answer = start;
            }
        }
       
        return rollback(answer);
    }
    
    private long count(int start, int end) {
        return prefixSum[end - 1] - prefixSum[start - 1];
    }
    
    private int convert(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 3600 + Integer.parseInt(splited[1]) * 60 + Integer.parseInt(splited[2]);
    }
    
    private String rollback(int time) {
        String hour = String.format("%02d", time / 3600);
        time -= 3600 * (time / 3600);
        String min = String.format("%02d", time / 60);
        time -= 60 * (time / 60);
        String sec = String.format("%02d", time);
        return hour + ":" + min + ":" + sec;
    }
    
}