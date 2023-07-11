import sys
import heapq

input = sys.stdin.readline

INF = float("inf")


n, l = map(int, input().split())
numbers = list(map(int, input().split()))

heap = []

for i in range(n):
    heapq.heappush(heap, (numbers[i], i))

    while l <= len(heap) and heap[0][1] <= i - l:
        heapq.heappop(heap)

    print(heap[0][0], end=" ")