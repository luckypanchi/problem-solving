import sys
import heapq

input = sys.stdin.readline


n = int(input())

left = []
right = []

for i in range(n):
    num = int(input())

    if len(left) == len(right):
        heapq.heappush(left, -num)
    else:
        heapq.heappush(right, num)

    if 0 < len(left) and 0 < len(right) and right[0] < -left[0]:
        left_v = -heapq.heappop(left)
        right_v = heapq.heappop(right)

        heapq.heappush(left, -right_v)
        heapq.heappush(right, left_v)

    print(-left[0])