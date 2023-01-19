import sys
import heapq

input = sys.stdin.readline


n = int(input())
times = [list(map(int, input().split())) for _ in range(n)]

times.sort()

rooms = []
heapq.heappush(rooms, times[0][1])

for i in range(1, n):
    if rooms[0] <= times[i][0]:
        heapq.heappop(rooms)
    heapq.heappush(rooms, times[i][1])

print(len(rooms))
