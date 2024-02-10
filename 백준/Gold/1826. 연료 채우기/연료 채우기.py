import sys
import heapq

input = sys.stdin.readline


n = int(input())
oilList = [list(map(int, input().split())) for _ in range(n)]
oilList.sort(key=lambda x: x[0])

l, p = map(int, input().split())
answer = 0
heap = []

while p < l:
    while oilList and oilList[0][0] <= p:
        a, b = heapq.heappop(oilList)
        heapq.heappush(heap, [-b, a])

    if not heap:
        answer = -1
        break

    b, a = heapq.heappop(heap)
    p += -b
    answer += 1

print(answer)