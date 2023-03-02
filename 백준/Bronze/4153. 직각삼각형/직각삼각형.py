import sys
import heapq

input = sys.stdin.readline


while True:
    a, b, c = map(int, input().split())
    if (a, b, c) == (0, 0, 0):
        break
    heap = [a, b, c]
    heapq.heapify(heap)
    a = heapq.heappop(heap)
    b = heapq.heappop(heap)
    m = heapq.heappop(heap)

    if a + b <= m:
        print("wrong")
    elif a**2 + b**2 != m**2:
        print("wrong")
    else:
        print("right")