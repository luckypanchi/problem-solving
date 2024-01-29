import sys
import heapq

input = sys.stdin.readline


n = int(input())
array = [list(map(int, input().split())) for _ in range(n)]

array.sort(key=lambda x: x[0])
h = []

for deadline, ramyun in array:
    heapq.heappush(h, ramyun)
    if len(h) > deadline:
        heapq.heappop(h)

print(sum(h))