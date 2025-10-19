import java.util.*;

class Solution {
    
    private long roomCnt; // 방 갯수 (1~k)
    private long[] roomNumber; // 각 고객이 배정되길 원하는 방 번호
    private long[] answer; // 각 고객이 배정된 방 번호
    private Map<Long, Long> roomStatus;
    
    public long[] solution(long k, long[] room_number) {
        roomCnt = k;
        roomNumber = room_number;
        answer = new long[roomNumber.length];
        roomStatus = new HashMap<>();
        
        for (int i = 0; i < roomNumber.length; i++) {
            answer[i] = findEmptyRoom(roomNumber[i]);
        }
        
        return answer;
    }
    
    private long findEmptyRoom(long wanted) {
        if (!roomStatus.containsKey(wanted)) {
            roomStatus.put(wanted, wanted + 1);
            return wanted;
        }
        
        long emptyRoom = findEmptyRoom(roomStatus.get(wanted));
        roomStatus.put(wanted, emptyRoom);
        return emptyRoom;
    }
}