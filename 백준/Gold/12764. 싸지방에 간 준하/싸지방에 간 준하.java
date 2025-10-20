import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static List<UseTime> useTimeList;
  static PriorityQueue<RoomInformation> occupiedRooms;
  static PriorityQueue<Integer> candidateRooms;
  static int[] seatCount;

  public static void main(String[] args) throws IOException {
    setUp();

    int maxRoomNumber = 0;

    for (UseTime useTime : useTimeList) {
      while (!occupiedRooms.isEmpty() && occupiedRooms.peek().end < useTime.start) {
        candidateRooms.offer(occupiedRooms.poll().number);
      }

      int selectRoomNumber = candidateRooms.isEmpty() ? maxRoomNumber++ : candidateRooms.poll();
      seatCount[selectRoomNumber]++;
      occupiedRooms.offer(new RoomInformation(selectRoomNumber, useTime.end));
    }

    sb.append(maxRoomNumber).append("\n");
    for (int i = 0; i < maxRoomNumber; i++) {
      sb.append(seatCount[i]).append(" ");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    useTimeList = new ArrayList<>();
    occupiedRooms = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
    candidateRooms = new PriorityQueue<>();
    seatCount = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      useTimeList.add(new UseTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    Collections.sort(useTimeList, (o1, o2) -> o1.start - o2.start);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class UseTime {

    int start, end;

    public UseTime(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  private static class RoomInformation {

    int number, end;

    public RoomInformation(int number, int end) {
      this.number = number;
      this.end = end;
    }
  }

}